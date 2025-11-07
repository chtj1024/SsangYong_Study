package emp.Service;

import java.io.IOException;
import java.sql.SQLException;

import emp.DAO.EmpDAO;
import emp.DTO.MyPageDTO;

public class MyPageService {
	private static EmpDAO eDAO;
	
	public MyPageService() {
		eDAO=EmpDAO.getInstance();
	}
	
	//내정보 불러오기
	public MyPageDTO getMyinfo(int emp_id) {
		try {
			return eDAO.getUserProfile(emp_id);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return null;
		
		
	}
	//내정보수정
	public boolean updateMyPage(MyPageDTO mDTO) {
		try {
			int result=eDAO.updateMyInfo(mDTO);
			return result >0;//변경성공

		}catch(SQLException | IOException e){
			e.printStackTrace();
			
			return false;
		}
	}//updateMyPage
		
	
	//기존비번확인
	public boolean checkCurrentPassword(int empno,String inputPass) {
		boolean temp=false;
		try {
			String CurrentPassword=eDAO.selectPassword(empno);
			
			if(CurrentPassword !=null && CurrentPassword.equals(inputPass.trim())) {
			temp=true;
			
		}
		
		}catch(SQLException|IOException e) {
		e.printStackTrace();
		}
		return temp;
	}

	//새비번확인(새 비번과 확인 비번이 같은지)
	public boolean checkNewPassword(String newPass, String confirmPass) {
	    return newPass != null && newPass.equals(confirmPass);
	}
		
	//비밀번호 변경
	public boolean updatePass(MyPageDTO mDTO) {
		boolean result=false;
		int updatePassword;
		try {
			updatePassword = eDAO.updatePassword(mDTO);
			if (updatePassword > 0) {
				result=true;
			
			}
		} catch (SQLException | IOException e) {			
			e.printStackTrace();
		
		
	}
		return result;
		
	}//updatePass
	
	
}//class
	
	
	
	
	
	
	
	

