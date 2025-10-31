package emp.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import emp.DAO.WorkRecordsDAO;
import emp.DTO.RawDataDTO;
import emp.DTO.WorkRecordSearchDTO;
import emp.DTO.WorkRecordsResultDTO;

public class WorkRecordsService {
	private static WorkRecordsService wrService;
	private final SimpleDateFormat DATE_PARSER = new SimpleDateFormat("yyyy-MM-dd");
	private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd");
	private WorkRecordsDAO wrDAO;
	 
	private WorkRecordsService() {
		this.wrDAO = WorkRecordsDAO.getInstance();
	}//EmpMainService
	
	public static WorkRecordsService getInstance() {
		if(wrService == null) {
			wrService = new WorkRecordsService(); 
		}	return wrService;
	}//getInstance
	
	public List<WorkRecordsResultDTO> searchRecords (WorkRecordSearchDTO searchDTO) throws SQLException, IOException {

	List<RawDataDTO> attData = wrDAO.findAttendance(searchDTO);
	List<RawDataDTO> vacData = wrDAO.findVacations(searchDTO);

	List<WorkRecordsResultDTO> results = new ArrayList<>();
	try {
			// 2. Raw 데이터를 날짜별 Map으로 변환
			Map<String, RawDataDTO> dataMap = createRecordMap(attData, vacData);

			Calendar cal = Calendar.getInstance();
			Date start = DATE_PARSER.parse(searchDTO.getStartDate());
			Date end = DATE_PARSER.parse(searchDTO.getEndDate());

			cal.setTime(end);
			while (!cal.getTime().before(start)) {
				Date date = cal.getTime();
				int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

				// 주말 건너뛰기
				if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
					WorkRecordsResultDTO resultDTO = processDate(date, dataMap);
					results.add(resultDTO);
				}
				cal.add(Calendar.DATE, -1);
			}
			// 4. 최종 리스트 정렬
			Collections.sort(results);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return results;
	}//searchRecords

	private Map<String, RawDataDTO> createRecordMap(List<RawDataDTO> attData, List<RawDataDTO> vacData) {
		Map<String, RawDataDTO> dataMap = new HashMap<>();
		for (RawDataDTO raw : attData) {
			dataMap.put(DATE_PARSER.format(raw.getRecordDate()), raw);
		}//end for
		for (RawDataDTO raw : vacData) {
			dataMap.put(DATE_PARSER.format(raw.getRecordDate()), raw);
		}//end for
		return dataMap;
	}//createRecordMap
	
	private WorkRecordsResultDTO processDate(Date date, Map<String, RawDataDTO> dataMap) {
		WorkRecordsResultDTO displayDTO = new WorkRecordsResultDTO();
		displayDTO.setRecordDate(date);
		String dateStr = DATE_PARSER.format(date);

		RawDataDTO sourceData = dataMap.get(dateStr);

		if (sourceData != null) {
			// DAO가 가져온 displayDate ("MM/DD")를 그대로 사용
			displayDTO.setWorkDate(sourceData.getDisplayDate());

			if ("VACATION".equals(sourceData.getRecordType())) {
				displayDTO.setClockInTime(" - ");
				displayDTO.setClockOutTime(" - ");
				displayDTO.setWorkHours(" - ");
				displayDTO.setAsName(sourceData.getVtName());

			} else { // ATTENDANCE
				Date ci = sourceData.getCheckIn();
				Date co = sourceData.getCheckOut();

				displayDTO.setClockInTime(sourceData.getCheckInTime());
				displayDTO.setClockOutTime(sourceData.getCheckOutTime());

				if (co != null) {
					long diff = co.getTime() - ci.getTime();
					long hours = TimeUnit.MILLISECONDS.toHours(diff);
					long minutes = TimeUnit.MILLISECONDS.toMinutes(diff) % 60;
					displayDTO.setWorkHours(hours + "시간 " + minutes + "분");
				} else {
					displayDTO.setWorkHours(" - ");
				}//end if
				displayDTO.setAsName(sourceData.getAsName());
			}//end if
		} else { // 결근
			displayDTO.setWorkDate(DATE_FORMAT.format(date));
			displayDTO.setClockInTime(" - ");
			displayDTO.setClockOutTime(" - ");
			displayDTO.setWorkHours(" - ");
			displayDTO.setAsName("결근");
		}//end if
		return displayDTO;
	}//processDate
	
}//class
