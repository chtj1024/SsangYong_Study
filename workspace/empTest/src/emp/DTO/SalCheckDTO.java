package emp.DTO;

import java.sql.Date;

public class SalCheckDTO {
	private String empName,empJob;
	private int yearlySal,monthlySal,bonus,searchYear;
	private Date hiredate;
	private int emp_id;
	
	//급여명세 테이블용 추가필드
	private Date payDate;        // 급여 지급일
    private int totalPay;        // 지급액
    private int bonusPay;        // 보너스 지급액
    private int tax;             // 세금 합계
    private int realPay;   		//실지급액
	
	
    
	public SalCheckDTO() {

	}


	public SalCheckDTO(String empName, String empJob, int yearlySal, int monthlySal, int bonus, int emp_id,
			int searchYear, Date hiredate, Date payDate, int totalPay, int bonusPay, int tax, int realPay) {
		super();
		this.empName = empName;
		this.empJob = empJob;
		this.yearlySal = yearlySal;
		this.monthlySal = monthlySal;
		this.bonus = bonus;
		this.emp_id = emp_id;
		this.searchYear = searchYear;
		this.hiredate = hiredate;
		this.payDate = payDate;
		this.totalPay = totalPay;
		this.bonusPay = bonusPay;
		this.tax = tax;
		this.realPay = realPay;
	}


	public String getEmpName() {
		return empName;
	}


	public String getEmpJob() {
		return empJob;
	}


	public int getYearlySal() {
		return yearlySal;
	}


	public int getMonthlySal() {
		return monthlySal;
	}


	public int getBonus() {
		return bonus;
	}


	public int getEmp_id() {
		return emp_id;
	}


	public int getSearchYear() {
		return searchYear;
	}


	public Date getHiredate() {
		return hiredate;
	}


	public Date getPayDate() {
		return payDate;
	}


	public int getTotalPay() {
		return totalPay;
	}


	public int getBonusPay() {
		return bonusPay;
	}


	public int getTax() {
		return tax;
	}


	public int getRealPay() {
		return realPay;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}


	public void setYearlySal(int yearlySal) {
		this.yearlySal = yearlySal;
	}


	public void setMonthlySal(int monthlySal) {
		this.monthlySal = monthlySal;
	}


	public void setBonus(int bonus) {
		this.bonus = bonus;
	}


	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}


	public void setSearchYear(int searchYear) {
		this.searchYear = searchYear;
	}


	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}


	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}


	public void setTotalPay(int totalPay) {
		this.totalPay = totalPay;
	}


	public void setBonusPay(int bonusPay) {
		this.bonusPay = bonusPay;
	}


	public void setTax(int tax) {
		this.tax = tax;
	}


	public void setRealPay(int realPay) {
		this.realPay = realPay;
	}


	@Override
	public String toString() {
		return "SalCheckDTO [empName=" + empName + ", empJob=" + empJob + ", yearlySal=" + yearlySal + ", monthlySal="
				+ monthlySal + ", bonus=" + bonus + ", emp_id=" + emp_id + ", searchYear=" + searchYear + ", hiredate="
				+ hiredate + ", payDate=" + payDate + ", totalPay=" + totalPay + ", bonusPay=" + bonusPay + ", tax="
				+ tax + ", realPay=" + realPay + "]";
	}




	
}
