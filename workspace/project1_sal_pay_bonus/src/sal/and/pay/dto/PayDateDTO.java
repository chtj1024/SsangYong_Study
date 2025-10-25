package sal.and.pay.dto;

import java.sql.Date;

public class PayDateDTO {
	private int emp_id, pay_id, pay, duty, bonus, realPay;
	private String name;
	private Date pay_date;
	
	private void PyaDateDTO() {

	}

	public PayDateDTO(int emp_id, int pay_id, int pay, int duty, int bonus, int realPay, String name, Date pay_date) {
		super();
		this.emp_id = emp_id;
		this.pay_id = pay_id;
		this.pay = pay;
		this.duty = duty;
		this.bonus = bonus;
		this.realPay = realPay;
		this.name = name;
		this.pay_date = pay_date;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public int getPay_id() {
		return pay_id;
	}

	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getDuty() {
		return duty;
	}

	public void setDuty(int duty) {
		this.duty = duty;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getRealPay() {
		return realPay;
	}

	public void setRealPay(int realPay) {
		this.realPay = realPay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPay_date() {
		return pay_date;
	}

	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}

	@Override
	public String toString() {
		return "PayDateDTO [emp_id=" + emp_id + ", pay_id=" + pay_id + ", pay=" + pay + ", duty=" + duty + ", bonus="
				+ bonus + ", realPay=" + realPay + ", name=" + name + ", pay_date=" + pay_date + "]";
	}

}
