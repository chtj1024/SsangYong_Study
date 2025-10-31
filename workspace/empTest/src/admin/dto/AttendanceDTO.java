package admin.dto; 

public class AttendanceDTO {

    private int empNo;              
    private String empName;         
    private String deptName;        
    private String position;        
    private String attendanceStatus;  
    private String attDate; 
    private String checkInTime; 
    private String checkOutTime;

    public AttendanceDTO() {}

    public AttendanceDTO(int empNo, String empName, String deptName, String position, String attendanceStatus) {
        this.empNo = empNo;
        this.empName = empName;
        this.deptName = deptName;
        this.position = position;
        this.attendanceStatus = attendanceStatus;
    }
    
    public AttendanceDTO(String attDate, int empNo, String empName, String deptName, String position, String checkInTime, String checkOutTime, String attendanceStatus) {
        this.attDate = attDate;
        this.empNo = empNo;
        this.empName = empName;
        this.deptName = deptName;
        this.position = position;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.attendanceStatus = attendanceStatus;
    }

    public void getter() {} 

    public int getEmpNo() { return empNo; }
    public String getEmpName() { return empName; }
    public String getDeptName() { return deptName; }
    public String getPosition() { return position; }
    public String getAttendanceStatus() { return attendanceStatus; }
    public String getAttDate() { return attDate; }
    public String getCheckInTime() { return checkInTime; }
    public String getCheckOutTime() { return checkOutTime; }

    public void setEmpNo(int empNo) { this.empNo = empNo; }
    public void setEmpName(String empName) { this.empName = empName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }
    public void setPosition(String position) { this.position = position; }
    public void setAttendanceStatus(String attendanceStatus) { this.attendanceStatus = attendanceStatus; }
    public void setAttDate(String attDate) { this.attDate = attDate; }
    public void setCheckInTime(String checkInTime) { this.checkInTime = checkInTime; }
    public void setCheckOutTime(String checkOutTime) { this.checkOutTime = checkOutTime; }

    public Object[] toObjectArray() {
        return new Object[] {
            attDate,
            empNo, 
            empName, 
            deptName, 
            position, 
            checkInTime, 
            checkOutTime, 
            attendanceStatus
        };
    }
}