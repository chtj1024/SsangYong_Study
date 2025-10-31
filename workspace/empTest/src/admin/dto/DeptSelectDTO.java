package admin.dto;

public class DeptSelectDTO {
    private int deptCode;
    private String dName;

    public DeptSelectDTO(int deptCode, String dName) {
        this.deptCode = deptCode;
        this.dName = dName;
    }

    public int getDeptCode() {
        return deptCode;
    }

    public String getDName() {
        return dName;
    }

    @Override
    public String toString() {
        return dName; 
    }
}