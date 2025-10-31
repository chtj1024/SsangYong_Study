package emp.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import emp.DTO.RawDataDTO;
import emp.DTO.WorkRecordSearchDTO;
import getconnection.GetConnection;

public class WorkRecordsDAO {
	
	private static WorkRecordsDAO wrDAO;
	
	private WorkRecordsDAO() {
	}//WorkRecordsDAO
	
	public static WorkRecordsDAO getInstance() {
		if(wrDAO == null) {
			wrDAO = new WorkRecordsDAO();
		}
		return wrDAO;
	}//getInstance
	
	public List<RawDataDTO> findAttendance(WorkRecordSearchDTO searchDTO) throws SQLException, IOException{
		List<RawDataDTO> list = new ArrayList<>();
		GetConnection getCon = GetConnection.getInstance();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		conn=getCon.getConn();
		String WorkRecords =
				" select "
				+ " a.check_in, "
				+ " a.check_out, "
				+ " to_char(a.check_in, 'mm/dd') displayDate, "
				+ " to_char(a.check_in, 'hh24:mi') checkInTime, "
				+ " nvl(to_char(a.check_out, 'hh24:mi'), ' - ') checkOutTime, "
				+ " s.asName "
				+ "	from attendance a "
				+ " join att_status s on a.as_code = s.as_code "
				+ " where a.emp_id = ? "
				+ " and a.check_in >= to_date(?, 'yyyy-mm-dd') "
				+ " and a.check_in < to_date(?, 'yyyy-mm-dd') + 1 ";
		
		pstmt = conn.prepareStatement(WorkRecords);
        pstmt.setInt(1, searchDTO.getEmpId());
        pstmt.setString(2, searchDTO.getStartDate());
        pstmt.setString(3, searchDTO.getEndDate());
		
        rs = pstmt.executeQuery();
        
        while(rs.next()) {
        	RawDataDTO rawDto = new RawDataDTO();
        	Timestamp checkInTs = rs.getTimestamp("check_in");
        	Timestamp checkOutTs = rs.getTimestamp("check_out");

        	rawDto.setRecordType("ATTENDANCE"); // String 사용
        	rawDto.setRecordDate(checkInTs);
        	rawDto.setCheckIn(checkInTs);
        	if (checkOutTs != null) {
        		rawDto.setCheckOut(checkOutTs);
        	}//end if
        	rawDto.setDisplayDate(rs.getString("displayDate")); // "MM/DD"
        	rawDto.setCheckInTime(rs.getString("checkInTime"));
        	rawDto.setCheckOutTime(rs.getString("checkOutTime"));
        	rawDto.setAsName(rs.getString("asName"));
        	list.add(rawDto);
        }//end while
        
	} finally {
		getCon.dbClose(conn, pstmt, rs);
    }//end finally
	
	return list;
}//findAttendance
	
	public List<RawDataDTO> findVacations (WorkRecordSearchDTO searchDTO) throws SQLException, IOException {

	List<RawDataDTO> list = new ArrayList<>();
	GetConnection getCon = GetConnection.getInstance();
	Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
		conn = getCon.getConn();
		// SQL: 요일(DY) 및 NLS 파라미터 제거
		String selectQuery =
			" select "
			+ "  vu.start_date, "
			+ "  to_char(vu.start_date, 'mm/dd') displayDate, "
			+ "  vt.vtname "
			+ "  from vacation_use vu "
			+ "  join vacation_type vt on vu.vt_code = vt.vt_code "
			+ "  where vu.emp_id = ? "
			+ "  and vu.approve = 'Y' "
			+ "  and vu.start_date between to_date(?, 'yyyy-mm-dd') and to_date(?, 'yyyy-mm-dd') ";

        pstmt = conn.prepareStatement(selectQuery);
        pstmt.setInt(1, searchDTO.getEmpId());
        pstmt.setString(2, searchDTO.getStartDate());
        pstmt.setString(3, searchDTO.getEndDate());

        rs = pstmt.executeQuery();

        while(rs.next()) {
        	RawDataDTO rawDto = new RawDataDTO();
        	Date startDate = rs.getDate("start_date");

        	rawDto.setRecordType("VACATION"); // String 사용
        	rawDto.setRecordDate(startDate);
        	rawDto.setDisplayDate(rs.getString("displayDate")); // "MM/DD"
        	rawDto.setVtName(rs.getString("vtname"));
        	list.add(rawDto);
        }//end while

	} finally {
    	getCon.dbClose(conn, pstmt, rs);
    }//end finally
	return list;
    
	}//findVacations
	
}//class
