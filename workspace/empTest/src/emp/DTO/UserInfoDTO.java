package emp.DTO;

public class UserInfoDTO {
	private int empId,authType;
	private String name, pname, dname, tel, email;
	
	public UserInfoDTO() {
	}

	public UserInfoDTO(int empId,int authType, String name, String pname, String dname, String tel, String email) {
		this.empId = empId;
		this.name = name;
		this.pname = pname;
		this.dname = dname;
		this.tel = tel;
		this.email = email;
		this.authType=authType;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserInfoDTO [empId=" + empId + ", authType=" + authType + ", name=" + name + ", pname=" + pname
				+ ", dname=" + dname + ", tel=" + tel + ", email=" + email + "]";
	}


	
	
}//class
