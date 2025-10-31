package emp.DTO;

import java.sql.Date;

public class VacInfoDTO {
	private int use_id, emp_id, vt_code;
	private String reason;
	private Date start_date, end_date;
	private char approve;
	
	public VacInfoDTO() {}
	public VacInfoDTO(int use_id, int emp_id, int vt_code, String reason, Date start_date, Date end_date,
			char approve) {
		this.use_id = use_id;
		this.emp_id = emp_id;
		this.vt_code = vt_code;
		this.reason = reason;
		this.start_date = start_date;
		this.end_date = end_date;
		this.approve = approve;
	}
	
	public int getUse_id() { return use_id; }
	public void setUse_id(int use_id) { this.use_id = use_id; }
	
	public int getEmp_id() { return emp_id; }
	public void setEmp_id(int emp_id) { this.emp_id = emp_id; }
	
	public int getVt_code() { return vt_code; }
	public void setVt_code(int vt_code) { this.vt_code = vt_code; }
	
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
		return "VacInfoDTO [use_id=" + use_id + ", emp_id=" + emp_id + ", vt_code=" + vt_code + ", reason=" + reason
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", approve=" + approve + "]";
	}
}
