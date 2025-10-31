package emp.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import admin.DAO.GetConnection;
import emp.DTO.VacInfoDTO;
import emp.DTO.VacInfoResponseDTO;
import getconnection.GetConnection;

/**
 * 필요
 *  신청내역 이번달것만 불러오는 항목
 */
public class VacInfoDAO {
	private static VacInfoDAO viDAO;
	
	private VacInfoDAO() {}
	
	public static VacInfoDAO getInstance() {
		if(viDAO == null) {
			viDAO = new VacInfoDAO();
		}
		
		return viDAO;
	}
	
	public String[] selectNameDept(int emp_id) throws SQLException, IOException {
		String[] result = new String[2];
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		GetConnection gc = GetConnection.getInstance();
		
		try {
			con = gc.getConn();
			
			String selectNameDept = "select e.name name, d.dname dname "
					+ "from employee e, department d "
					+ "where e.dept_code = d.dept_code and e.emp_id = ?";
			
			pstmt = con.prepareStatement(selectNameDept);
			
			pstmt.setInt(1, emp_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result[0] = rs.getString("name");
				result[1] = rs.getString("dname");
			}
		} finally {
			gc.dbClose(con, pstmt, rs);
		}
		
		return result;
	}
	
	public int selectVacDays(int emp_id) throws SQLException, IOException {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		GetConnection gs = GetConnection.getInstance();
		try {
			con = gs.getConn();
			
			String selectVacDays = "select vac_days "
					+ "from employee "
					+ "where emp_id = ?";
			
			pstmt = con.prepareStatement(selectVacDays);
			
			pstmt.setInt(1, emp_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("vac_days");
			}
			
		} finally {
			gs.dbClose(con, pstmt, rs);
		}
		return result;
	}
	
	public int selectCntOne(int emp_id) throws SQLException, IOException {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		GetConnection gc = GetConnection.getInstance();
		
		try {
			con = gc.getConn();
			
			String selectOneVac = "select count(use_id) as cnt "
					+ "from vacation_use "
					+ "where approve = 'Y' and emp_id = ? and not vt_code = 4 ";
			
			pstmt = con.prepareStatement(selectOneVac);
			
			pstmt.setInt(1, emp_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
			
		} finally {
			gc.dbClose(con, pstmt, rs);
		}
		
		return result;
	}
	
	public int selectHalf(int emp_id) throws SQLException, IOException {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		GetConnection gc = GetConnection.getInstance();
		
		try {
			con = gc.getConn();
			
			String selectHalfVac = "select count(use_id) as cnt "
					+ "from vacation_use "
					+ "where approve = 'Y' and emp_id = ? and vt_code = 4 ";
			
			pstmt = con.prepareStatement(selectHalfVac);
			
			pstmt.setInt(1, emp_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} finally {
			gc.dbClose(con, pstmt, rs);
		}
		
		return result;
	}
	
	public List<String> selectVacType() throws SQLException, IOException {
		List<String> result = new ArrayList<String>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		GetConnection gc = GetConnection.getInstance();
		
		try {
			con = gc.getConn();
			
			String selectVacationType = "select vtname from vacation_type order by vt_code";
			
			pstmt = con.prepareStatement(selectVacationType);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result.add(rs.getString("vtname"));
			}
		} finally {
			gc.dbClose(con, pstmt, rs);
		}
		
		return result;
	}
	
	public int selectOneVacCode(String vtName) throws SQLException, IOException {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		GetConnection gc = GetConnection.getInstance();
		
		try {
			con = gc.getConn();
			
			String selectVacationType = "select vt_code from vacation_type where vtname = ?";
			
			pstmt = con.prepareStatement(selectVacationType);
			
			pstmt.setString(1, vtName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("vt_code");
			}
		} finally {
			gc.dbClose(con, pstmt, rs);
		}
		
		return result;
	}
	
	public int insertVac(VacInfoDTO viDTO) throws SQLException, IOException {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		GetConnection gc = GetConnection.getInstance();
		
		try {
			con = gc.getConn();
			
			String insertVU = "insert into vacation_use(use_id,emp_id,vt_code,start_date,end_date,reason,approve) "
					+ "values(vuse_seq.nextval,?,?,?,?,?,'P')";
			
			pstmt = con.prepareStatement(insertVU);
			
			pstmt.setInt(1, viDTO.getEmp_id());
			pstmt.setInt(2, viDTO.getVt_code());
			pstmt.setDate(3, viDTO.getStart_date());
			pstmt.setDate(4, viDTO.getEnd_date());
			pstmt.setString(5, viDTO.getReason());
			
			result = pstmt.executeUpdate();
		} finally {
			gc.dbClose(con, pstmt, rs);
		}
		
		return result;
	}
	
	public List<VacInfoResponseDTO> selectMonthVac(int emp_id) throws SQLException, IOException {
		List<VacInfoResponseDTO> result = new ArrayList<VacInfoResponseDTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		GetConnection gc = GetConnection.getInstance();
		
		try {
			con = gc.getConn();
			
			String selectVac = "select e.emp_id emp_id, vu.use_id use_id, e.name name, vt.vtname vtname, "
					+ "vu.start_date start_date, vu.end_date end_date, vu.reason reason, vu.approve approve "
					+ "from vacation_use vu, vacation_type vt, employee e "
					+ "where vu.emp_id = e.emp_id and vu.vt_code = vt.vt_code and  (to_char(vu.start_date, 'yyyy-mm') >= to_char(sysdate, 'yyyy-mm')) and e.emp_id = ? "
					+ "order by vu.use_id";
			
			pstmt = con.prepareStatement(selectVac);
			pstmt.setInt(1, emp_id);
			rs = pstmt.executeQuery();
			
			int i_emp_id = 0;
			int use_id = 0;
			String ename = "";
			String vtname = "";
			String reason = "";
			Date start_Date = null;
			Date end_Date = null;
			char approve = ' ';
			
			VacInfoResponseDTO virDTO = null;
			
			while(rs.next()) {
				i_emp_id = rs.getInt("emp_id");
				use_id = rs.getInt("use_id");
				ename = rs.getString("name");
				vtname = rs.getString("vtname");
				reason = rs.getString("reason");
				start_Date = rs.getDate("start_date");
				end_Date = rs.getDate("end_date");
				approve = rs.getString("approve").charAt(0);
				
				virDTO = new VacInfoResponseDTO(i_emp_id, use_id, ename, vtname, reason, start_Date, end_Date, approve);
				
				result.add(virDTO);
			}
			
		} finally {
			gc.dbClose(con, pstmt, rs);
		}
		
		return result;
	}
}
