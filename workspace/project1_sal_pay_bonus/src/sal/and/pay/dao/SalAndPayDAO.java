package sal.and.pay.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.GetConnection;
import sal.and.pay.dto.SalAndPayDTO;

public class SalAndPayDAO {
	
	private static SalAndPayDAO instance;
	
	public List<SalAndPayDTO> selectSalEmp() throws SQLException, IOException {
		List<SalAndPayDTO> list = new ArrayList<SalAndPayDTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		GetConnection gc = GetConnection.getInstance();
		
		try {
			con = gc.getConn();
			
			String selectEmp = "select	e.emp_id, name, dname, pname, s.sal "
					+ "from    employee e "
					+ "join    salary  s on e.sal_code = s.sal_code "
					+ "join    position po on e.pos_code = po.pos_code "
					+ "join    department d on d.dept_code = e.dept_code "
					+ "order by	e.emp_id ";
			
			pstmt = con.prepareStatement(selectEmp);
			
			rs = pstmt.executeQuery();
			
			int emp_id = 0;
			int sal = 0;
			String name = "";
			String dName = "";
			String pName = "";
			
			SalAndPayDTO sDTO = null;
			while(rs.next()) {
				emp_id = rs.getInt("emp_id");
				sal = rs.getInt("sal");
				name = rs.getString("name");
				dName = rs.getString("dname");
				pName = rs.getString("pname");
				
				sDTO = new SalAndPayDTO(emp_id, 0, sal, 0, 0,
						0, name, dName, pName, null);
				list.add(sDTO);
			}
			
			
		} finally {
			gc.dbClose(con, pstmt, rs);
		}
		
		// JTable은 2차원배열로 출력할 수 있기 때문에 2차원배열로 반환
		return list;
	}
	
	public List<SalAndPayDTO> selectSalInfo() throws SQLException, IOException {
		List<SalAndPayDTO> list = new ArrayList<SalAndPayDTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		GetConnection gc = GetConnection.getInstance();
		
		try {
			con = gc.getConn();
			
			String selectEmp = "select sal_code, sal "
					+ "from	salary ";
			
			pstmt = con.prepareStatement(selectEmp);
			
			rs = pstmt.executeQuery();
			
			int sal_code = 0;
			int sal = 0;
			
			SalAndPayDTO sDTO = null;
			while(rs.next()) {
				sal_code = rs.getInt("sal_code");
				sal = rs.getInt("sal");
				
				sDTO = new SalAndPayDTO(0, sal_code, sal, 0, 0,
						0, "", "", "", null);
				list.add(sDTO);
			}
			
			
		} finally {
			gc.dbClose(con, pstmt, rs);
		}
		
		// JTable은 2차원배열로 출력할 수 있기 때문에 2차원배열로 반환
		return list;
	}
	
	public int updateSal(SalAndPayDTO sDTO) throws SQLException, IOException {
		int flag = 0;
		
		GetConnection gc = GetConnection.getInstance();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = gc.getConn();
			
			StringBuilder updateSal = new StringBuilder();
			updateSal
			.append("update  employee e ")
			.append("set     e.sal_code = ? ")
			.append("where   e.emp_id = ? ")
			.append("and     exists ( ")
			.append("    select  1 ")
			.append("    from    salary s ")
			.append("where   s.sal_code = ?) ");
			
			pstmt = con.prepareStatement(updateSal.toString());
			
			pstmt.setInt(1, sDTO.getSal_code());
			pstmt.setInt(2, sDTO.getEmp_id());
			pstmt.setInt(3, sDTO.getSal_code());
			
			flag = pstmt.executeUpdate();
		} finally {
			gc.dbClose(con, pstmt, null);
		}
		
		return flag;
	}
	
	public static SalAndPayDAO getInstance() {
		if (instance == null) {
			instance = new SalAndPayDAO();
		}		
		return instance;
	}
}
