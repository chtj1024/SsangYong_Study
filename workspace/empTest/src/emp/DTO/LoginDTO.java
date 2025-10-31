package emp.DTO;

public class LoginDTO {
	private int empId, authType;
	private String pwd, name;

	public LoginDTO() {
	}

	public LoginDTO(int empId, int authType, String pwd, String name) {
		this.empId = empId;
		this.authType = authType;
		this.pwd = pwd;
		this.name = name;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getAuthType() {
		return authType;
	}

	public void setAuthType(int authType) {
		this.authType = authType;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "LoginDTO [empId=" + empId + ", authType=" + authType + ", pwd=" + pwd + ", name=" + name + "]";
	}
	
	
	
}
