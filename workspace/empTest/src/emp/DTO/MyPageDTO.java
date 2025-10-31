package emp.DTO;

public class MyPageDTO {
	private String empJob,deptName,empName,pass,email,addr,tel;
	private int emp_id;
		
	public MyPageDTO() {
		super();
	}

	
	
	public MyPageDTO(String empJob, String deptName, String empName, String pass, String email, String addr, String tel,
			int emp_id) {
		super();
		this.empJob = empJob;
		this.deptName = deptName;
		this.empName = empName;
		this.pass = pass;
		this.email = email;
		this.addr = addr;
		this.tel = tel;
		this.emp_id = emp_id;
	}

	

	@Override
	public String toString() {
		return "MyPageDTO [empJob=" + empJob + ", deptName=" + deptName + ", empName=" + empName + ", pass=" + pass
				+ ", email=" + email + ", addr=" + addr + ", tel=" + tel + ", emp_id=" + emp_id + "]";
	}



	public String getEmpJob() {
		return empJob;
	}

	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}





	
}
