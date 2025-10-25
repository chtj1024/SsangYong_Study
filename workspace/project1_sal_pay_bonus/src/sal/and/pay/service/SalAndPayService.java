package sal.and.pay.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import sal.and.pay.dao.SalAndPayDAO;
import sal.and.pay.dto.PayDateDTO;
import sal.and.pay.dto.SalAndPayDTO;

public class SalAndPayService {
	
	private static SalAndPayDAO sDAO = SalAndPayDAO.getInstance();
	
	public SalAndPayService() {
		
	}
	
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
	
	/**
	 * 연봉 모달창의 수정버튼을 눌렀을 때 실행되는 메서드
	 * @return
	 */
	public int updateSal(SalAndPayDTO sDTO) {
		int flag = 0;
		
		try {
			flag = sDAO.updateSal(sDTO);
		} catch (SQLException e) {
			flag = 2; // 이건 왜하는건지 까먹음
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public List<PayDateDTO> selectPayDate() {
		List<PayDateDTO> list = null;
		
		try {
			list = sDAO.selectPayDate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<SalAndPayDTO> selectBonus(int emp_id) {
		List<SalAndPayDTO> list = null;
		
		try {
			list = sDAO.selectBonus(emp_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return list;
	}
	
	public boolean insertBonus(SalAndPayDTO sDTO) {
		boolean flag = false;
		
		try {
			flag = sDAO.insertBonus(sDTO) == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public List<PayDateDTO> selectPayRecords() {
		List<PayDateDTO> list = null;
		
		try {
			list = sDAO.selectPayRecords();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<PayDateDTO> conditonSelectPayRecords(String conditions) {
		List<PayDateDTO> list = null;
		
		try {
			list = sDAO.conditionSelectPayRecords(conditions);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
