package emp.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import emp.DTO.UserInfoDTO;
import emp.DTO.WorkRecordsResultDTO;
import getconnection.GetConnection;

public class EmpMainDAO {
	 
	private static EmpMainDAO emDAO;
	
	private EmpMainDAO() {
	}//EmpMainDAO
	
	public static EmpMainDAO getInstance() {
		if(emDAO == null) {
			emDAO = new EmpMainDAO();
		}//end if
		return emDAO;
	}//getInstance
	
	public UserInfoDTO selectEmpInfo (int empId) throws SQLException, IOException {
		
		UserInfoDTO uiDTO = null;
		GetConnection getCon = GetConnection.getInstance();
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
			conn = getCon.getConn();
			String selectEmpInfo =
					" select e.name, p.pname, d.dname, e.tel, e.email " +
			        " from employee e " +
			        " join position p on e.pos_code = p.pos_code " +    // position 테이블 join
			        " join department d on e.dept_code = d.dept_code " + // department 테이블 join
			        " where e.emp_id = ? ";
	        pstmt = conn.prepareStatement(selectEmpInfo);
	        pstmt.setInt(1, empId);
	        rs=pstmt.executeQuery();
	        
	        if(rs.next()) {
	        	uiDTO=new UserInfoDTO();
	        	uiDTO.setEmpId(empId);
	        	uiDTO.setName(rs.getString("name"));
	        	uiDTO.setPname(rs.getString("pname"));
	        	uiDTO.setDname(rs.getString("dname"));
	        	uiDTO.setTel(rs.getString("tel"));
	        	uiDTO.setEmail(rs.getString("email"));
	        }//end if
		}finally {
        	getCon.dbClose(conn, pstmt, rs);
        }//end finally
		return uiDTO;
	}//selectEmpInfo
	
	public List<WorkRecordsResultDTO> selectRecentWork (int empId) throws SQLException, IOException {
		List<WorkRecordsResultDTO> list=new ArrayList<>();
		GetConnection getCon = GetConnection.getInstance();
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

		try {
			conn = getCon.getConn();
			String selectRecentWork 
					= " select "
					+ " a.check_in,a.check_out, "
					+ " to_char(a.check_in, 'YYYY-MM-DD HH24:MI') check_in_str, "
					+ " NVL(TO_CHAR(a.check_out, 'YYYY-MM-DD HH24:MI'), ' - ') check_out_str, "
					+ " s.asname "
					+ " from attendance a "
					+ " join att_status s on a.as_code = s.as_code "
					+ " where a.emp_id = ? "
					+ " order by a.check_in desc ";
			pstmt = conn.prepareStatement(selectRecentWork);
			pstmt.setInt(1, empId);

	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            WorkRecordsResultDTO dto = new WorkRecordsResultDTO();
	            Timestamp checkInTs = rs.getTimestamp("check_in");
	            Timestamp checkOutTs = rs.getTimestamp("check_out");

	            dto.setRecordDate(checkInTs); // 정렬 기준
	            dto.setCheckIn(checkInTs);    
	            if(checkOutTs != null) {
	                dto.setCheckOut(checkOutTs);
	            }//end if

	            dto.setWorkDate(rs.getString("check_in_str"));
	            dto.setClockInTime(rs.getString("check_in_str")); 
	            dto.setClockOutTime(rs.getString("check_out_str"));
	            dto.setWorkHours(" - ");
	            dto.setAsName(rs.getString("asname"));

	            list.add(dto);
	        }//end while
        } finally {
    	getCon.dbClose(conn, pstmt, rs);
        }//end finally
        return list; // ★ List<WorkRecordsResultDTO> 반환
	}//selectRecentWork
	
	public int insertClockIn(int empId) throws SQLException, IOException{
		int rowCnt = 0;
		GetConnection getCon = GetConnection.getInstance();
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
        	conn = getCon.getConn();
        	String insertClockIn =
        	"insert into attendance (att_id, emp_id, check_in, as_code) "
        	+ " values (att_seq.nextval, ?, sysdate, 4)";
       
        	pstmt = conn.prepareStatement(insertClockIn);
            pstmt.setInt(1, empId);
            rowCnt = pstmt.executeUpdate();	
        
        } finally {
        	getCon.dbClose(conn, pstmt, rs);
        }//end finally
        return rowCnt;
	}//insertClockIn
	
	public int updateClockOut (int empId) throws SQLException,IOException {
		int rowCnt = 0;
		GetConnection getCon = GetConnection.getInstance();
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
		try {
			conn = getCon.getConn();
			String updateClockOut =
			"update attendance set "
			+ " check_out = sysdate, "
			+ " as_code = case "
			+ " when to_char(sysdate, 'hh24:mi:ss') < '18:00:00' then 3 "
			+ " when to_char(check_in, 'hh24:mi:ss') > '09:01:00' then 2 "
			+ " else 1 "
			+ " end "
			+ " where emp_id = ? and trunc(check_in) = trunc(sysdate)";

			pstmt = conn.prepareStatement(updateClockOut);
			pstmt.setInt(1, empId);
			rowCnt = pstmt.executeUpdate();

		} finally {
			getCon.dbClose(conn, pstmt, rs);
		}//end finally
		return rowCnt;
	}//insertClockIn
}//class
