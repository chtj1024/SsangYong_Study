package emp.DTO;

import java.sql.Date;

public class VacInfoResponseDTO {
	private int emp_id, use_id;
	private String ename, vtname, reason;
	private Date start_date, end_date;
	private char approve;
	
	public VacInfoResponseDTO() {}
	public VacInfoResponseDTO(int emp_id, int use_id, String ename, String vtname,
			String reason, Date start_date, Date end_date, char approve) {
		this.emp_id = emp_id;
		this.use_id = use_id;
		this.ename = ename;
		this.vtname = vtname;
		this.reason = reason;
		this.start_date = start_date;
		this.end_date = end_date;
		this.approve = approve;
	}
	
	public int getEmp_id() { return emp_id; }
	public void setEmp_id(int emp_id) { this.emp_id = emp_id; }
	
	public int getUse_id() { return use_id; }
	public void setUse_id(int use_id) { this.use_id = use_id; }
	
	public String getEname() { return ename; }
	public void setEname(String ename) { this.ename = ename; }
	
	public String getVtname() { return vtname; }
	public void setVtname(String vtname) { this.vtname = vtname; }
	
	public String getReason() { return reason; }
	public void setReason(String reason) { this.reason = reason; }
	
	public Date getStart_date() { return start_date; }
	public void setStart_date(Date start_date) { this.start_date = start_date; }
	
	public Date getEnd_date() { return end_date; }
	public void setEnd_date(Date end_date) { this.end_date = end_date; }
	
	public char getApprove() { return approve; }
	public void setApprove(char approve) { this.approve = approve; }
	
	@Override
	public String toString() {
		return "VacInfoResponseDTO [emp_id=" + emp_id + ", use_id=" + use_id + ", ename=" + ename +
				", vtname=" + vtname + ", reason=" + reason + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", approve=" + approve + "]";
	}
}
