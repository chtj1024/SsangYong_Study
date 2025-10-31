package admin.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import admin.dao.VacationMgmDAO;
import admin.dto.DeptSelectDTO;
import admin.dto.VacationMgmDTO;

public class VacationMgmService {

	private VacationMgmDAO vDAO;

	public VacationMgmService() {
		vDAO = VacationMgmDAO.getInstance();
	}
	
	public List<DeptSelectDTO> findAllDepartments() {
		List<DeptSelectDTO> list = Collections.emptyList();
		try {
			list = vDAO.selectAllDepartments();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<VacationMgmDTO> infoVacation() {
		List<VacationMgmDTO> list = Collections.emptyList();
		try {
			list = vDAO.selectAllVacation();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<VacationMgmDTO> searchVacation(String dName, String eName, String startDate, String endDate) {
		List<VacationMgmDTO> list = Collections.emptyList();
		try {
			list = vDAO.selectSearchVacation(dName, eName, startDate, endDate);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}