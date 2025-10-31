package emp.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import emp.DAO.VacInfoDAO;
import emp.DTO.VacInfoDTO;
import emp.DTO.VacInfoResponseDTO;

public class VacInfoService {
	public VacInfoService() {}
	
	public String[] getNameDept(int empId) {
		String[] result = new String[2];
		
		VacInfoDAO viDAO = VacInfoDAO.getInstance();
		
		try {
			result = viDAO.selectNameDept(empId);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int getVacDays(int empId) {
		int result = 0;
		
		VacInfoDAO viDAO = VacInfoDAO.getInstance();
		
		try {
			result = viDAO.selectVacDays(empId);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int countOneVac(int empId) {
		int result = 0;
		
		VacInfoDAO viDAO = VacInfoDAO.getInstance();
		
		try {
			result = viDAO.selectCntOne(empId);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int countHalfVac(int empId) {
		int result = 0;
		
		VacInfoDAO viDAO = VacInfoDAO.getInstance();
		
		try {
			result = viDAO.selectHalf(empId);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<String> getVacType(){
		List<String> result = new ArrayList<String>();
		
		VacInfoDAO viDAO = VacInfoDAO.getInstance();
		
		try {
			result = viDAO.selectVacType();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int getVtCode(String vtname) {
		int result = 0;
		
		VacInfoDAO viDAO = VacInfoDAO.getInstance();
		
		try {
			result = viDAO.selectOneVacCode(vtname);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean resistVacUse(VacInfoDTO viDTO) {
		boolean result = false;
		
		VacInfoDAO viDAO = VacInfoDAO.getInstance();
		
		try {
			int cnt = viDAO.insertVac(viDTO);
			
			if(cnt == 1) {
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<VacInfoResponseDTO> callVacUse(int emp_id){
		List<VacInfoResponseDTO> result = new ArrayList<VacInfoResponseDTO>();
		
		VacInfoDAO viDAO = VacInfoDAO.getInstance();
		
		try {
			result = viDAO.selectMonthVac(emp_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
