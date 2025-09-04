package day0903;

import java.util.Calendar;

import day0828.Exam0828;

public class Work0902Model {
	public String makeCalendar(String year, String month) {
		String[][] calArr;
		
		int yearInt = Integer.parseInt(year);
		int monthInt = Integer.parseInt(month);
		
		StringBuilder sb = new StringBuilder();
		
		Calendar cal = Calendar.getInstance();
		
		String[] weekDays = {"", "일", "월", "화", "수", "목", "금", "토"};

		if (monthInt < 1 || monthInt > 12 || yearInt < 0) {
			cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
		} else {
			cal.set(yearInt, monthInt - 1, 1);
		}
		
		sb.append("\t\t    ").append(cal.get(Calendar.YEAR)).append("년 ")
		.append(cal.get(Calendar.MONTH) + 1).append("월 \n");
		for(int i = 1; i < weekDays.length; i++) {
			sb.append(weekDays[i]).append("\t");
		}
		sb.append("\n");
			
		for(int i = 1; i < cal.get(Calendar.DAY_OF_WEEK); i++) {
			sb.append("\t");
		}
		
		int nowWeek = cal.get(Calendar.DAY_OF_WEEK);
		for(int i = 1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			
			sb.append(i + "\t");
			if (nowWeek % 7 == 0) {
				sb.append("\n");
			}
			nowWeek++;
		}
		
		int weekCnt = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
		calArr = new String[weekCnt][Calendar.SATURDAY];
		
		
		
		return sb.toString();
	}
	
	public void printCalendar(String year, String month) {
		String calendar = makeCalendar(year, month);
		System.out.println(calendar);
	}
	
}