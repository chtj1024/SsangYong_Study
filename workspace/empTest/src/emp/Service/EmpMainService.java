package emp.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import emp.DAO.EmpMainDAO;
import emp.DTO.UserInfoDTO;
import emp.DTO.WorkRecordsResultDTO;

public class EmpMainService {
	private static EmpMainService eService;
	private EmpMainDAO emDAO;
	
	private EmpMainService() {
		this.emDAO = EmpMainDAO.getInstance();
	}//EmpMainService
	
	public static EmpMainService getInstance() {
		if(eService == null) {
			eService = new EmpMainService();
		}
		return eService;
	}//getInstance
	
	public UserInfoDTO searchEmpInfo(int empId) throws SQLException,IOException {
		return this.emDAO.selectEmpInfo(empId);
	}//searchEmpInfo

	public List<WorkRecordsResultDTO> searchRecentWork(int empId) throws SQLException,IOException {
		List<WorkRecordsResultDTO> resultList = this.emDAO.selectRecentWork(empId);

		Calendar todayCal = Calendar.getInstance();
		todayCal.set(Calendar.HOUR_OF_DAY, 0); todayCal.set(Calendar.MINUTE, 0);
		todayCal.set(Calendar.SECOND, 0); todayCal.set(Calendar.MILLISECOND, 0);
		Date today = todayCal.getTime();

		for (WorkRecordsResultDTO dto : resultList) {
			if (dto.getCheckOut() == null) { // 퇴근 안 찍었으면
				Calendar checkInCal = Calendar.getInstance();
				checkInCal.setTime(dto.getCheckIn());
				checkInCal.set(Calendar.HOUR_OF_DAY, 0); checkInCal.set(Calendar.MINUTE, 0);
				checkInCal.set(Calendar.SECOND, 0); checkInCal.set(Calendar.MILLISECOND, 0);
				Date checkInDate = checkInCal.getTime();

				if (checkInDate.equals(today)) { // 오늘 기록이면
					dto.setAsName("근무 중"); // '근무 중' 이름 사용 (DB 이름과 일치시키세요)
				}//end if
			}//end if
		}//end for
		return resultList;
	}//searchRecentWork

	public void recordClockIn(int empId) throws SQLException,IOException{
		this.emDAO.insertClockIn(empId);
	}//recordClockIn

	public boolean recordClockOut(int empId) throws SQLException,IOException {
		int rowCnt=this.emDAO.updateClockOut(empId);
		return rowCnt > 0;
	}//recordClockOut
}
