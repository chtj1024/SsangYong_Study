package admin.service;

import java.io.IOException;
import java.sql.SQLException;

import admin.dao.VacationAprDAO;

public class VacationAprService {

	private VacationAprDAO vDAO;

	public VacationAprService() {
		vDAO = VacationAprDAO.getInstance();
	}

	public boolean aprVacation(int useId, String approve) {
		boolean flag = false;
		try {
			int cnt = vDAO.updateVacation(useId, approve);
			if (cnt == 1) {
				flag = true;
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return flag;
	}
}