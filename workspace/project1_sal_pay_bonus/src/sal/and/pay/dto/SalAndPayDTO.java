package sal.and.pay.dto;

import java.sql.Date;

public class SalAndPayDTO {
	private int emp_id, sal_code, sal, pay, pay_type, pay_id;
	private String name, dName, pName;
	private Date pay_date;
	
	public SalAndPayDTO() {
		
	}

	public SalAndPayDTO(int emp_id, int sal_code, int sal, int pay, int pay_type, int pay_id, String name, String dName,
			String pName, Date pay_date) {
		super();
		this.emp_id = emp_id;
		this.sal_code = sal_code;
		this.sal = sal;
		this.pay = pay;
		this.pay_type = pay_type;
		this.pay_id = pay_id;
		this.name = name;
		this.dName = dName;
		this.pName = pName;
		this.pay_date = pay_date;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public int getSal_code() {
		return sal_code;
	}

	public void setSal_code(int sal_code) {
		this.sal_code = sal_code;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getPay_type() {
		return pay_type;
	}

	public void setPay_type(int pay_type) {
		this.pay_type = pay_type;
	}

	public int getPay_id() {
		return pay_id;
	}

	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Date getPay_date() {
		return pay_date;
	}

	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}

	@Override
	public String toString() {
		return "SalAndPayDTO [emp_id=" + emp_id + ", sal_code=" + sal_code + ", sal=" + sal + ", pay=" + pay
				+ ", pay_type=" + pay_type + ", pay_id=" + pay_id + ", name=" + name + ", dName=" + dName + ", pName="
				+ pName + ", pay_date=" + pay_date + "]";
	}
	
}
