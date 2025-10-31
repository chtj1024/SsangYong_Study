package emp.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import emp.DTO.LoginDTO;
import getconnection.GetConnection;

public class LoginDAO {

	private static LoginDAO lDAO;
	private LoginDAO () {
	}//LoginDAO
	
	public static LoginDAO getInstance() {
		if(lDAO == null) {
			lDAO = new LoginDAO();
		}//end if
		return lDAO;
	}//getInstance
	
	public LoginDTO selectOneEmp(LoginDTO inputDTO) throws SQLException, IOException {
		LoginDTO resultDTO = null;
		
		GetConnection getCon = GetConnection.getInstance();
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
			conn = getCon.getConn();
			String selectOneEmp 
			= "select emp_id, name, auth_type from employee where emp_id = ? and pwd = ? and retire_date is null" ;
			pstmt = conn.prepareStatement(selectOneEmp);
			pstmt.setInt(1, inputDTO.getEmpId());
            pstmt.setString(2, inputDTO.getPwd());
            
            rs = pstmt.executeQuery();
            
            if (rs.next()) { // 조회된 결과(행)가 있다면
                resultDTO = new LoginDTO();
                resultDTO.setEmpId(rs.getInt("emp_id"));
                resultDTO.setName(rs.getString("name"));
                resultDTO.setAuthType(rs.getInt("auth_type"));
            }
		} finally {
				getCon.dbClose(conn, pstmt, rs);
		}//end finally
        return resultDTO;
	}//selectOneEmp
	
	
}//class
