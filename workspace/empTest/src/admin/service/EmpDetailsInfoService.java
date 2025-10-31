package admin.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import admin.dao.PstmtEmpDAO;
import admin.dto.DeptSelectDTO;
import admin.dto.EmpDetailDTO;
import admin.dto.PositionDTO;

public class EmpDetailsInfoService {

	private PstmtEmpDAO pemDAO;

	public EmpDetailsInfoService() {
		pemDAO = PstmtEmpDAO.getInstance();
	}

	/**
	 * DAO를 호출하여 모든 부서 목록을 조회
	 */
	public List<DeptSelectDTO> findAllDepartments() throws SQLException, IOException {
		List<DeptSelectDTO> list = pemDAO.selectAllDepartments();
		return list;
	}
	
	/**
	 * DAO를 호출하여 모든 직급 목록을 조회
	 */
	public List<PositionDTO> findAllPositions() throws SQLException, IOException {
		List<PositionDTO> list = pemDAO.selectAllPositions();
		return list;
	}

	public EmpDetailDTO loadEmployee(int empNo) throws SQLException, IOException {
		EmpDetailDTO eDTO = pemDAO.selectEmployee(empNo);
		return eDTO;
	}

	public int modifyEmployee(EmpDetailDTO eDTO) throws SQLException, IOException {
		int cnt = pemDAO.updateEmployee(eDTO);
		return cnt;
	}

	public int retireEmployee(int empNo) throws SQLException, IOException {
		int cnt = pemDAO.deleteEmployee(empNo);
		return cnt;
	}
	
	/**
	 * [신규] 비밀번호 초기화 서비스
	 */
	public int resetPassword(int empNo) throws SQLException, IOException {
		int cnt = pemDAO.resetPassword(empNo);
		return cnt;
	}
}// class