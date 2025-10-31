package admin.service;

import java.util.List;

import admin.dao.PstmtAttdDAO;
import admin.dto.AttendanceDTO;

public class AttdMgmService {
    
    private final PstmtAttdDAO attdDao; 

    public AttdMgmService() {
        this.attdDao = PstmtAttdDAO.getInstance(); 
    }

    public List<AttendanceDTO> searchAttendanceByDate(String deptName, String targetDate) {
        return attdDao.selectAttendanceByDateAndDept(deptName, targetDate); 
    }

    // public List<AttendanceDTO> selectAllAttendance() { return attdDao.selectAllAttendance(); }
    // public List<AttendanceDTO> selectOneAttendance(String deptName) { return attdDao.selectOneAttendance(deptName); }

    public int modifyAttdStatus(int empNo, String newStatus) {
        return attdDao.updateAttendanceStatus(empNo, newStatus); 
    }

    public List<String> selectAllDepartments() {
        return attdDao.selectAllDepartments(); 
    }

    public List<String> selectAllAttendanceStatus() {
        return attdDao.selectAllAttendanceStatus(); 
    }
}