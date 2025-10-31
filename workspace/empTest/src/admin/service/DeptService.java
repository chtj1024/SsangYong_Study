package admin.service; 

import java.util.List;

import admin.dao.DeptDAO;
import admin.dto.DeptDTO;

public class DeptService {
    
    private final DeptDAO dpDAO; 

    public DeptService() {
        this.dpDAO = DeptDAO.getInstance(); 
    }

    public List<DeptDTO> searchDept(String deptName, int deptNo) {
        if (deptNo > 0) {
            return dpDAO.selectDeptByNo(deptNo);
        } else if (deptName != null && !deptName.trim().isEmpty()) {
            return dpDAO.selectDeptByName(deptName);
        } else {
            return dpDAO.selectDeptAll();
        }
    }

    public boolean addtDept(DeptDTO dto) {
        int result = dpDAO.insertDept(dto);
        return result > 0;
    }

    public boolean updateDept(DeptDTO dto) {
        int result = dpDAO.updateDept(dto);
        return result > 0;
    }

    public boolean removeDept(int deptno) {
        int result = dpDAO.deleteDept(deptno);
        return result > 0;
    }
    
    public boolean restoreDept(int deptno) {
        int result = dpDAO.restoreDept(deptno);
        return result > 0;
    }
    
    public int getEmployeeCount(int deptCode) {
        return dpDAO.selectEmployeeCountByDept(deptCode);
    }

    public List<String[]> getEmployeesList(int deptCode) {
        return dpDAO.selectEmployeesByDept(deptCode);
    }
}