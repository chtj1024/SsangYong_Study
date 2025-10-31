package admin.dto;

public class VacationMgmDTO {
	private int emp_id;
	private int use_id;
	private String eName;
	private String dName;
	private String pName;
	private String vtName; 
	private String reason;
	private String startDate;
	private String endDate;
	private String approve; 

	public VacationMgmDTO() {
	}

	public VacationMgmDTO(int emp_id, int use_id, String eName, String dName, String pName, String vtName,
			String reason, String startDate, String endDate, String approve) {
		this.emp_id = emp_id;
		this.use_id = use_id;
		this.eName = eName;
		this.dName = dName;
		this.pName = pName;
		this.vtName = vtName; 
		this.reason = reason;
		this.startDate = startDate;
		this.endDate = endDate;
		this.approve = approve;
	}

	// Getters
	public int getEmp_id() {
		return emp_id;
	}
	public int getUse_id() {
		return use_id;
	}
	public String geteName() {
		return eName;
	}
	public String getdName() {
		return dName;
	}
	public String getpName() {
		return pName;
	}
	public String getVtName() { 
		return vtName;
	}
	public String getReason() {
		return reason;
	}
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public String getApprove() {
		return approve;
	}

	// Setters
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public void setUse_id(int use_id) {
		this.use_id = use_id;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public void setVtName(String vtName) { 
		this.vtName = vtName;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public void setApprove(String approve) {
		this.approve = approve;
	}

	@Override
	public String toString() {
		return "VacationMgmDTO [emp_id=" + emp_id + ", use_id=" + use_id + ", eName=" + eName + ", dName=" + dName
				+ ", pName=" + pName + ", vtName=" + vtName + ", reason=" + reason + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", approve=" + approve + "]";
	}
}