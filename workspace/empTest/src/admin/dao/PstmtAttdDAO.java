package admin.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;

import admin.dto.AttendanceDTO;

import java.io.FileInputStream;
import java.io.IOException;

public class PstmtAttdDAO {
    
    private static PstmtAttdDAO pmAttdDAO;
    private static Properties dbProps = new Properties();

    // 1. 드라이버 로드 및 Properties 파일 로드
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("드라이버 로드 실패", e);
        }
        
        try (FileInputStream fis = new FileInputStream("src/properties/database.properties")) {
            dbProps.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("DB 설정 파일(database.properties)을 찾을 수 없습니다.", e);
        }
    }
    
    // 2. 생성자 및 싱글톤 메서드
    private PstmtAttdDAO() {
    }
    
    public static PstmtAttdDAO getInstance() {
        if (pmAttdDAO == null) {
            pmAttdDAO = new PstmtAttdDAO();
        }
        return pmAttdDAO;
    }
    
    // 3. JDBC 유틸리티 메서드
    private Connection getConnection() throws SQLException {
        String url = dbProps.getProperty("url");
        String id = dbProps.getProperty("id");
        String pass = dbProps.getProperty("pass");
        
        return DriverManager.getConnection(url, id, pass);
    }
    
    private void closeResources(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
        }
    }

    // 4. DB 접근 메서드
    public List<AttendanceDTO> selectAttendanceByDateAndDept(String deptName, String targetDate) {
        List<AttendanceDTO> attdList = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        String sql = 
            "SELECT " +
            "    TO_CHAR(TO_DATE(?, 'YYYY-MM-DD'), 'YYYY-MM-DD') AS ATT_DATE, " + // ?1: 조회 일자
            "    e.emp_id AS EMP_NO, " +
            "    e.name AS EMP_NAME, " +
            "    d.dname AS DEPT_NAME, " +
            "    p.pname AS POSITION, " +
            "    TO_CHAR(a.check_in, 'HH24:MI:SS') AS CHECK_IN_TIME, " +
            "    TO_CHAR(a.check_out, 'HH24:MI:SS') AS CHECK_OUT_TIME, " +
            "    COALESCE( " +
            "        s_att.asname, " + 
            "        CASE WHEN v.emp_id IS NOT NULL THEN '휴가' ELSE '미등록' END " + 
            "    ) AS ATTENDANCE_STATUS " +
            "FROM employee e " +
            "JOIN department d ON e.dept_code = d.dept_code " +
            "JOIN position p ON e.pos_code = p.pos_code " +
            
            "LEFT JOIN ( " +
            "    SELECT att.emp_id, att.check_in, att.check_out, att.as_code FROM attendance att " +
            "    WHERE TRUNC(att.check_in) = TO_DATE(?, 'YYYY-MM-DD') " + // ?2: 당일 출퇴근 기록 조회 조건
            "    AND att.att_id = (SELECT MAX(att_id) FROM attendance WHERE emp_id = att.emp_id AND TRUNC(check_in) = TRUNC(att.check_in)) " +
            ") a ON e.emp_id = a.emp_id " +
            "LEFT JOIN att_status s_att ON a.as_code = s_att.as_code " +
            
            "LEFT JOIN ( " +
            "    SELECT emp_id FROM vacation_use " +
            "    WHERE TO_DATE(?, 'YYYY-MM-DD') BETWEEN start_date AND end_date AND approve = 'Y' " + // ?3: 당일 휴가 기록 조회 조건
            ") v ON e.emp_id = v.emp_id " + 
            
            "WHERE e.retire_date IS NULL "; 
            
        boolean isFilterByDept = (deptName != null && !"전체".equals(deptName));
        if (isFilterByDept) {
            sql += "AND d.dname = ? "; // ?4: 부서명 조건 (4번째 파라미터)
        }
        
        sql += "ORDER BY d.dname ASC, e.emp_id ASC";
        
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, targetDate); // 1. ATT_DATE (반환 컬럼)
            pstmt.setString(2, targetDate); // 2. 당일 출퇴근 기록 조회 조건
            pstmt.setString(3, targetDate); // 3. 당일 휴가 기록 조회 조건
            
            int paramIndex = 4;
            // 부서 필터링 조건이 있을 때만 4번째 파라미터를 바인딩합니다.
            if (isFilterByDept) {
                pstmt.setString(paramIndex++, deptName); // 부서 필터링 조건
            }
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                AttendanceDTO dto = new AttendanceDTO(
                    rs.getString("ATT_DATE"),
                    rs.getInt("EMP_NO"),
                    rs.getString("EMP_NAME"),
                    rs.getString("DEPT_NAME"),
                    rs.getString("POSITION"),
                    rs.getString("CHECK_IN_TIME"),
                    rs.getString("CHECK_OUT_TIME"),
                    rs.getString("ATTENDANCE_STATUS")
                );
                attdList.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(con, pstmt, rs);
        }
        return attdList; 
    }

    public int updateAttendanceStatus(int empNo, String newStatus) {
        int result = 0;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int asCode = 0; 

        try {
            con = getConnection();
            // JDBC 기본 설정인 AutoCommit(true)를 유지합니다.
            
            String getCodeSql = "SELECT as_code FROM att_status WHERE asname = ?";
            pstmt = con.prepareStatement(getCodeSql);
            pstmt.setString(1, newStatus);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                asCode = rs.getInt("as_code");
            } else {
                return 0;
            }
            closeResources(null, pstmt, rs); 

            // 근태 테이블 업데이트
            // AutoCommit 모드이므로 executeUpdate() 성공 시 자동 커밋됩니다.
            String updateSql = "UPDATE attendance SET as_code = ? WHERE emp_id = ? AND check_in = ("
                    + "    SELECT MAX(check_in) FROM attendance WHERE emp_id = ?"
                    + ")";
            pstmt = con.prepareStatement(updateSql);
            pstmt.setInt(1, asCode); 
            pstmt.setInt(2, empNo); 
            pstmt.setInt(3, empNo);
            
            result = pstmt.executeUpdate(); 
            
            // 자동 커밋 모드이므로 명시적인 con.commit()이 필요 없습니다.
            
        } catch (SQLException e) {
            e.printStackTrace();
            // AutoCommit 모드에서는 rollback()이 의미가 없거나 제한적일 수 있지만, 
            // 안전을 위해 예외 발생 시 시도합니다.
            try { if (con != null) con.rollback(); } catch (SQLException rollbackE) { rollbackE.printStackTrace(); }
        } finally {
            closeResources(con, pstmt, null);
        }
        return result;
    }

    public List<String> selectAllDepartments() {
        List<String> deptList = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        String sql = "SELECT dname FROM department WHERE delete_yn = 0 ORDER BY dname";
        
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                deptList.add(rs.getString("dname"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(con, pstmt, rs);
        }
        
        return deptList;
    }
    
    public List<String> selectAllAttendanceStatus() {
        List<String> statusList = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT asname FROM att_status ORDER BY as_code";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                statusList.add(rs.getString("asname"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(con, pstmt, rs);
        }
        return statusList;
    }
}