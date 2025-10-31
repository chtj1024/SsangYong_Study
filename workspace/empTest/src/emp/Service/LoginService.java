package emp.Service;

import java.io.IOException;
import java.sql.SQLException;

import emp.DAO.LoginDAO;
import emp.DTO.LoginDTO;

public class LoginService {
	
	private static LoginService lService;	
	private LoginDAO lDAO;
	
	private LoginService() {
		this.lDAO = LoginDAO.getInstance();
	}//LoginService
	
	public static LoginService getInstance() {
		if( lService == null ) {
			lService = new LoginService();
		}
		return lService;
	}//getInstance
	
	public LoginDTO login(LoginDTO inputDTO) throws SQLException, IOException{
		LoginDTO resultDTO = null;
		resultDTO =lDAO.selectOneEmp(inputDTO);
		
		return resultDTO;
	}//login
	
}//class
