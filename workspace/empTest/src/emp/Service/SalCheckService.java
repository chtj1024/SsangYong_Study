package emp.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import emp.DAO.EmpDAO;
import emp.DTO.SalCheckDTO;

public class SalCheckService {
	private EmpDAO eDAO;

	public SalCheckService() {
		eDAO= EmpDAO.getInstance();
	}
	
	//로그인시 정보불러오기
	public SalCheckDTO getMySalInfo(int emp_id) {
			try {
				return eDAO.selectEmpInfo(emp_id);
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (IOException ie) {
				ie.printStackTrace();
			}
			return null;
		
	}
	
	//급여정보 연도별 조회 DTO의 정보를 LIST로
	public List<SalCheckDTO> SalaryInfo(int year, int emp_id) throws SQLException, IOException {
		List<SalCheckDTO> list=null;
		list = eDAO.selectSalaryByYear(year, emp_id);
		return list;
	}
	
	
}
