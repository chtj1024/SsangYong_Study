package admin.dto; 

public class DeptDTO {

    private int DeptNo;
    private String DeptName;
    private String DeptHead;
    private int deleteYn; 

    public DeptDTO() {
        
    }

    public DeptDTO(int DeptNo, String DeptName, String DeptHead) {
        this.DeptNo = DeptNo;
        this.DeptName = DeptName;
        this.DeptHead = DeptHead;
        this.deleteYn = 0;
    }

    public DeptDTO(int DeptNo, String DeptName, String DeptHead, int deleteYn) {
        this.DeptNo = DeptNo;
        this.DeptName = DeptName;
        this.DeptHead = DeptHead;
        this.deleteYn = deleteYn;
    }

    public void getter() {} 

    public int getDeptNo() { return DeptNo; }
    public String getDeptName() { return DeptName; }
    public String getDeptHead() { return DeptHead; }
    public int getDeleteYn() { return deleteYn; }

    public void setDeptNo(int DeptNo) { this.DeptNo = DeptNo; }
    public void setDeptName(String DeptName) { this.DeptName = DeptName; }
    public void setDeptHead(String DeptHead) { this.DeptHead = DeptHead; }
    public void setDeleteYn(int deleteYn) { this.deleteYn = deleteYn; }
    
    public Object[] toObjectArray() {
        return new Object[] {
            DeptNo, 
            DeptName, 
            deleteYn
        };
    }
}