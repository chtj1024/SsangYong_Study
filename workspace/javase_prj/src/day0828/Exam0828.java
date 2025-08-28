package day0828;

import java.util.Calendar;

/**문제
 * 1. 원하는 년도와 월은 String형 매개변수로 입력받아 해당 년, 월의 달력을 String으로 반환하는
 * method를 작성.
 * - Calendar 클래스를 사용하여 입력 된 년 월에 해당하는 달력을 StringBuilder에 저장하고
 * 반환한다.
 * - 만약에 년이나 월이 입력되지 않는 경우에는 현재 년, 월로 달력을 생성합니다.
 * 
 * 2. 위의 method를 호출하여 반환되는 달력의 문자열을 받아 콘솔에 출력하는 method 작성.
 * 
 * 출력 예)
 *  일 월 화 수 목 금 토
 *               1 2
 *  3  4 5 6  7  8 9
 *  이런식으로 1일을 출력하기 전에 공백 출력, 토요일이면 줄을 변경
 *  상수 : DAY_OF_WEEK, DAY_OF_MONTH
 *  메서드 : get, set
 *  제어문 : if, switch~case, for
 *  이것들 사용.
 * 
 */
public class Exam0828 {
	
	public String makeCalendar(String year, String month) {
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
		for(int i = 1; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH) + 1; i++) {
			
			sb.append(i + "\t");
			if (nowWeek % 7 == 0) {
				sb.append("\n");
			}
			nowWeek++;
		}
		
		return sb.toString();
	}
	
	public void printCalendar(String year, String month) {
		String calendar = makeCalendar(year, month);
		System.out.println(calendar);
	}
	
	public static void main(String[] args) {
		Exam0828 e0828 = new Exam0828();
		e0828.printCalendar("2025", "7");
	}
}
