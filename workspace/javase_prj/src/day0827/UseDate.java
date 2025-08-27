package day0827;

import java.util.Calendar;
import java.util.Date;

/**
 * 시스템의 날짜 정보를 얻기 위해 java.util.Date 클래스를 사용.
 */
public class UseDate {
	
	public UseDate() {
		// java에서 유일하게 시간을 알고 있는 클래스의 method는 System.currentTimeMillis()
		long currentTime = System.currentTimeMillis();
		System.out.println(currentTime);
		
		Date date = new Date(); // 시스템의 현재 정보날짜를 얻을 수 있다.
		
		System.out.println(date);
		
		// int의 연산 값을 넘어 가버리기 때문에 L을 붙여줘야 한다.
		Date date2 = new Date(System.currentTimeMillis() + (1000L*60*60*24*30*12));
		
		System.out.println(date2);
		
	}
	
	public void useSet() {
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal);
		
//		cal.set(Calendar.YEAR, 2026);
//		cal.set(Calendar.MONTH, 6 - 1);
		
		cal.set(2026, 6 - 1, 1);
		
		StringBuilder calFormat = new StringBuilder();
		calFormat.append(cal.get(Calendar.YEAR)).append("-")
		.append(cal.get(Calendar.MONTH) + 1).append("-")
		.append(cal.get(Calendar.DAY_OF_MONTH)).append(" ")
		.append(",일,월,화,수,목,금,토".split(",")[cal.get(Calendar.DAY_OF_WEEK)]).append(" ")
		.append(cal.get(Calendar.DAY_OF_YEAR)).append("번째 날");
		
		
		System.out.println(calFormat);
	}
	
	public static void main(String[] args) {
		new UseDate().useSet();
	}
}
