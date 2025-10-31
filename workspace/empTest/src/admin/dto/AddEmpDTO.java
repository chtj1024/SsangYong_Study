package admin.dto;

import java.sql.Date;

public class AddEmpDTO {
	private int emp_id, dept_code, pos_code, sal_code, auth_type, vac_days;
	private String name, addr, tel, email, pwd;
	private Date hire_date, retire_date;
	
	public AddEmpDTO() {}
	public AddEmpDTO(int emp_id, int dept_code, int pos_code, int sal_code, int auth_type, int vac_days, String name,
			String addr, String tel, String email, String pwd, Date hire_date, Date retire_date) {
		this.emp_id = emp_id;
		this.dept_code = dept_code;
		this.pos_code = pos_code;
		this.sal_code = sal_code;
		this.auth_type = auth_type;
		this.vac_days = vac_days;
		this.name = name;
		this.addr = addr;
		this.tel = tel;
		this.email = email;
		this.pwd = pwd;
		this.hire_date = hire_date;
		this.retire_date = retire_date;
	}

	public int getEmp_id() { return emp_id; }
	public void setEmp_id(int emp_id) { this.emp_id = emp_id; }

	public int getDept_code() { return dept_code; }
	public void setDept_code(int dept_code) { this.dept_code = dept_code; }

	public int getPos_code() { return pos_code; }
	public void setPos_code(int pos_code) { this.pos_code = pos_code; }

	public int getSal_code() { return sal_code; }
	public void setSal_code(int sal_code) { this.sal_code = sal_code; }

	public int getAuth_type() { return auth_type; }
	public void setAuth_type(int auth_type) { this.auth_type = auth_type; }

	public int getVac_days() { return vac_days; }
	public void setVac_days(int vac_days) { this.vac_days = vac_days; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getAddr() { return addr; }
	public void setAddr(String addr) { this.addr = addr; }

	public String getTel() { return tel; }
	public void setTel(String tel) { this.tel = tel; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getPwd() { return pwd; }
	public void setPwd(String pwd) { this.pwd = pwd; }

	public Date getHire_date() { return hire_date; }
	public void setHire_date(Date hire_date) { this.hire_date = hire_date; }

	public Date getRetire_date() { return retire_date; }
	public void setRetire_date(Date retire_date) { this.retire_date = retire_date; }
	
	@Override
	public String toString() {
		return "AddEmpDTO [emp_id=" + emp_id + ", dept_code=" + dept_code + ", pos_code=" + pos_code + ", sal_code="
				+ sal_code + ", auth_type=" + auth_type + ", vac_days=" + vac_days + ", name=" + name + ", addr=" + addr
				+ ", tel=" + tel + ", email=" + email + ", pwd=" + pwd + ", hire_date=" + hire_date + ", retire_date="
				+ retire_date + "]";
	}
}
