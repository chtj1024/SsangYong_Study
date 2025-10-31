 package emp.DTO;

import java.util.Date;

public class RawDataDTO {
	private Date recordDate,checkIn,checkOut;
	private String recordType,displayDate, checkInTime,checkOutTime,asName,vtName;
	
	public RawDataDTO () {
	}
	
	public RawDataDTO(Date recordDate, Date checkIn, Date checkOut, String recordType, String displayDate,
			String checkInTime, String checkOutTime, String asName, String vtName) {
		this.recordDate = recordDate;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.recordType = recordType;
		this.displayDate = displayDate;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.asName = asName;
		this.vtName = vtName;
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

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	public String getDisplayDate() {
		return displayDate;
	}

	public void setDisplayDate(String displayDate) {
		this.displayDate = displayDate;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public String getAsName() {
		return asName;
	}

	public void setAsName(String asName) {
		this.asName = asName;
	}

	public String getVtName() {
		return vtName;
	}

	public void setVtName(String vtName) {
		this.vtName = vtName;
	}

	@Override
	public String toString() {
		return "recordRawDTO [recordDate=" + recordDate + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", recordType=" + recordType + ", displayDate=" + displayDate + ", checkInTime=" + checkInTime
				+ ", checkOutTime=" + checkOutTime + ", asName=" + asName + ", vtName=" + vtName + "]";
	}
}
