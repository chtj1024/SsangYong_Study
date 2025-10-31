package admin.dto;

public class EmpMgmDTO {
	private int emp_id;
	private String dname, name, pname;
	
	public EmpMgmDTO() {}
	public EmpMgmDTO(int emp_id, String name, String dname, String pname) {
		this.emp_id = emp_id;
		this.name = name;
		this.dname = dname;
		this.pname = pname;
	}

	public int getEmp_id() { return emp_id; }
	public void setEmp_id(int emp_id) { this.emp_id = emp_id; }
	
	public String getDname() { return dname; }
	public void setDname(String dname) { this.dname = dname; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getPname() { return pname; }
	public void setPname(String pname) { this.pname = pname; }
	
	@Override
	public String toString() {
		return "EmpMgmDTO [emp_id=" + emp_id + ", dname=" + dname + ", name=" + name + ", pname=" + pname + "]";
	}
}
