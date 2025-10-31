package emp.DTO;

public class WorkRecordSearchDTO {
	private int empId;
	private String startDate;
	private String endDate;
	
	public WorkRecordSearchDTO() {
	}

	public WorkRecordSearchDTO(int empId, String startDate, String endDate) {
		this.empId = empId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "WorkRecordSearchDTO [empId=" + empId + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
	
}
