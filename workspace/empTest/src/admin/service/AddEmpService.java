package admin.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.dao.AddEmpDAO;
import admin.dto.AddEmpDTO;

public class AddEmpService {
	public AddEmpService() {}
	
	public boolean addEmp(AddEmpDTO aed, String dname, String pname, int sal) {
		boolean flag = false;
		
		AddEmpDAO aDAO = AddEmpDAO.getInstance();
		
		try {
			aed.setDept_code(aDAO.selectDept(dname));
			aed.setPos_code(aDAO.selectPos(pname));
			aed.setSal_code(aDAO.selectSal(sal));
			
			flag = 1 == aDAO.insertEmp(aed);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public List<String> callAllDept() {
		List<String> result = new ArrayList<String>();
		
		AddEmpDAO aed = AddEmpDAO.getInstance();
		try {
			result = aed.selectAllDept();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<String> callAllPos() {
		List<String> result = new ArrayList<String>();
		
		AddEmpDAO aed = AddEmpDAO.getInstance();
		
		try {
			result = aed.selectAllPosition();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<String> callAllSal() {
		List<String> result = new ArrayList<String>();
		
		AddEmpDAO aed = AddEmpDAO.getInstance();
		
		try {
			result = aed.selectAllSal();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
