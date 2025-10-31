package admin.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import admin.dao.AddEmpDAO;
import admin.dao.EmpMgmDAO;
import admin.dto.EmpMgmDTO;

public class EmpMgmService {
	public EmpMgmService() {}
	
	public List<EmpMgmDTO> infoAllEmp(){
		List<EmpMgmDTO> list = null;
		
		try {
			EmpMgmDAO eDAO = EmpMgmDAO.getInstance();
			list = eDAO.selectAllEmp();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<EmpMgmDTO> searchEmp(String type, String keyword){
		List<EmpMgmDTO> list = new ArrayList<EmpMgmDTO>();
		int dept_code = 0;
		int pos_code = 0;
		
		try {
		
			EmpMgmDAO emd = EmpMgmDAO.getInstance();
			AddEmpDAO aed = AddEmpDAO.getInstance();
			
			switch (type) {
			case "사번":
				list = emd.selectIdEmp(Integer.parseInt(keyword));
				break;
			case "이름":
				list = emd.selectNameEmp(keyword);
				break;
			case "부서":
				dept_code = aed.selectDept(keyword);
				list = emd.selectDeptEmp(dept_code);
				break;
			case "직급":
				pos_code = aed.selectPos(keyword);
				list = emd.selectPosEmp(pos_code);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
