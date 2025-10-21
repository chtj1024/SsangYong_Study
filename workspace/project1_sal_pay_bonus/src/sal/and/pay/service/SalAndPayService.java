package sal.and.pay.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import sal.and.pay.dao.SalAndPayDAO;
import sal.and.pay.dto.SalAndPayDTO;

public class SalAndPayService {
	
	private static SalAndPayDAO sDAO = SalAndPayDAO.getInstance();
	
	public SalAndPayService() {
		
	}
	
//	public List<SalAndPayDTO> searchAllEmp() {
//		List<SalAndPayDTO> list = null;
//		SalAndPayDAO sDAO = SalAndPayDAO.getInstance();
//		try {
//			list = sDAO.selectSalEmp();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		return list;
//	}
	
	public List<SalAndPayDTO> selectSalEmp() {
		List<SalAndPayDTO> list = null;
		try {
			list = sDAO.selectSalEmp();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<SalAndPayDTO> selectSalInfo() {
		List<SalAndPayDTO> list = null;
		
		try {
			list = sDAO.selectSalInfo();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
