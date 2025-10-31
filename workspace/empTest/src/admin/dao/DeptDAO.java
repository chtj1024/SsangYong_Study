package admin.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;

import admin.dto.DeptDTO;

import java.io.InputStream;
import java.io.IOException;

public class DeptDAO {
    
    private static DeptDAO dpDAO;
    private static Properties dbProps = new Properties();

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("드라이버 로드 실패", e);
        }
        
        try (InputStream is = DeptDAO.class.getClassLoader().getResourceAsStream("properties/database.properties")) {
            if (is == null) {
                throw new IOException("Classpath에서 properties/database.properties 리소스를 찾을 수 없습니다.");
            }
            dbProps.load(is);
        } catch (IOException e) {
            throw new RuntimeException("DB 설정 파일 로드 실패", e);
        }
    }
    
    private DeptDAO() {
    	
    }
    
    public static DeptDAO getInstance() {
        if (dpDAO == null) { dpDAO = new DeptDAO(); }
        return dpDAO;
    }
    
    private Connection getConnection() throws SQLException {
        String url = dbProps.getProperty("url").trim();
        String id = dbProps.getProperty("id").trim();
        String pass = dbProps.getProperty("pass").trim();
        
        if (url == null || id == null || pass == null) {
            throw new SQLException("Properties 파일에 DB 접속 정보가 누락되었습니다.");
        }
        
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

    ///////////////////////////// DB 접근 메서드 ////////////////////////////////
    private static final String BASE_DEPT_QUERY = 
        "WITH DeptHeadRank AS ( " +
        "    SELECT " +
        "        e.dept_code, " +
        "        e.name AS dept_head_name, " +
        "        ROW_NUMBER() OVER ( " +
        "            PARTITION BY e.dept_code " +
        "            ORDER BY e.pos_code DESC, e.hire_date ASC " + 
        "        ) AS rn " +
        "    FROM employee e " +
        "    WHERE e.retire_date IS NULL " +
        ") " +
        "SELECT " +
        "    d.dept_code AS DEPT_NO, " +
        "    d.dname AS DEPT_NAME, " +
        "    dhr.dept_head_name AS DEPT_HEAD, " + 
        "    d.delete_yn AS DELETE_YN " +
        "FROM department d " +
        "LEFT JOIN DeptHeadRank dhr ON d.dept_code = dhr.dept_code AND dhr.rn = 1 ";
        
    public List<DeptDTO> selectDept() { return selectDeptAll(); }
    public List<DeptDTO> selectDeptAll() {
        List<DeptDTO> deptList = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        String sql = BASE_DEPT_QUERY + " ORDER BY d.delete_yn ASC, d.dept_code ASC";
        
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                DeptDTO dto = new DeptDTO(
                    rs.getInt("DEPT_NO"),
                    rs.getString("DEPT_NAME"),
                    rs.getString("DEPT_HEAD"),
                    rs.getInt("DELETE_YN")
                );
                deptList.add(dto);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(con, pstmt, rs);
        }
        
        return deptList; 
    }

    public List<DeptDTO> selectDeptByNo(int deptno) { 
        List<DeptDTO> deptList = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        String sql = BASE_DEPT_QUERY + " WHERE d.dept_code = ? ";
        
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, deptno);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                DeptDTO dto = new DeptDTO(
                    rs.getInt("DEPT_NO"),
                    rs.getString("DEPT_NAME"),
                    rs.getString("DEPT_HEAD"),
                    rs.getInt("DELETE_YN")
                );
                deptList.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(con, pstmt, rs);
        }
        return deptList;
    }

    public List<DeptDTO> selectDeptByName(String deptName) { 
        List<DeptDTO> deptList = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        String sql = BASE_DEPT_QUERY + " WHERE d.dname = ? ";
        
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, deptName);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                DeptDTO dto = new DeptDTO(
                    rs.getInt("DEPT_NO"),
                    rs.getString("DEPT_NAME"),
                    rs.getString("DEPT_HEAD"),
                    rs.getInt("DELETE_YN")
                );
                deptList.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(con, pstmt, rs);
        }
        return deptList;
    }
    
    public int insertDept(DeptDTO dto) {
        int result = 0;
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "INSERT INTO department (dept_code, dname, delete_yn) VALUES (DEPT_SEQ.NEXTVAL, ?, 0)";
        
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dto.getDeptName());
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(con, pstmt, null);
        }
        return result;
    }

    public int updateDept(DeptDTO dto) {
        int result = 0;
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "UPDATE department SET dname = ? WHERE dept_code = ?";
        
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dto.getDeptName());
            pstmt.setInt(2, dto.getDeptNo());
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(con, pstmt, null);
        }
        return result;
    }

    public int deleteDept(int deptno) {
        int result = 0;
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "UPDATE department SET dname = dname || ' (삭제된 부서)', delete_yn = 1 WHERE dept_code = ?";
        
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, deptno);
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(con, pstmt, null);
        }
        return result;
    }
    
    public int restoreDept(int deptno) {
        int result = 0;
        Connection con = null;
        PreparedStatement pstmt = null;
        
        String sql = "UPDATE department SET dname = REPLACE(dname, ' (삭제된 부서)', ''), delete_yn = 0 WHERE dept_code = ?";
        
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, deptno);
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(con, pstmt, null);
        }
        return result;
    }


    public int selectEmployeeCountByDept(int deptCode) {
        int count = 0;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT COUNT(emp_id) FROM employee WHERE dept_code = ? AND retire_date IS NULL";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, deptCode);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(con, pstmt, rs);
        }
        return count;
    }

    public List<String[]> selectEmployeesByDept(int deptCode) {
        List<String[]> employeeList = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT e.emp_id, e.name, p.pname, TO_CHAR(e.hire_date, 'YYYY-MM-DD') AS hire_date " +
                     "FROM employee e JOIN position p ON e.pos_code = p.pos_code " +
                     "WHERE e.dept_code = ? AND e.retire_date IS NULL ORDER BY e.emp_id";

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, deptCode);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                employeeList.add(new String[]{
                    String.valueOf(rs.getInt("emp_id")),
                    rs.getString("name"),
                    rs.getString("pname"),
                    rs.getString("hire_date")
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(con, pstmt, rs);
        }
        return employeeList;
    }
}