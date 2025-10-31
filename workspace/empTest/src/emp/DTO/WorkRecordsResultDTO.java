package emp.DTO;

import java.util.Date;

public class WorkRecordsResultDTO implements Comparable<WorkRecordsResultDTO>{
	
	private Date recordDate,checkIn,checkOut;
	private String workDate, clockInTime, clockOutTime, workHours, asName;
	
	public WorkRecordsResultDTO() {
	}
	
	public WorkRecordsResultDTO(Date recordDate, Date checkIn, Date checkOut, String workDate, String clockInTime,
			String clockOutTime, String workHours, String asName) {
		this.recordDate = recordDate;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.workDate = workDate;
		this.clockInTime = clockInTime;
		this.clockOutTime = clockOutTime;
		this.workHours = workHours;
		this.asName = asName;
	}

	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public String getClockInTime() {
		return clockInTime;
	}
	public void setClockInTime(String clockInTime) {
		this.clockInTime = clockInTime;
	}
	public String getClockOutTime() {
		return clockOutTime;
	}
	public void setClockOutTime(String clockOutTime) {
		this.clockOutTime = clockOutTime;
	}
	public String getWorkHours() {
		return workHours;
	}
	public void setWorkHours(String workHours) {
		this.workHours = workHours;
	}
	public String getAsName() {
		return asName;
	}
	public void setAsName(String asName) {
		this.asName = asName;
	}
	@Override
	public int compareTo(WorkRecordsResultDTO other) {
		if (this.recordDate == null && other.recordDate == null) return 0;
		if (this.recordDate == null) return 1;
		if (other.recordDate == null) return -1;

		return other.recordDate.compareTo(this.recordDate);
	}
	@Override
	public String toString() {
		return "WorkRecordsResultDTO [recordDate=" + recordDate + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", workDate=" + workDate + ", clockInTime=" + clockInTime + ", clockOutTime=" + clockOutTime
				+ ", workHours=" + workHours + ", asName=" + asName + "]";
	}
}//class
