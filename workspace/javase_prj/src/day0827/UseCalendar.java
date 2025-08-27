package day0827;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Calendar 객체의 사용
 */
public class UseCalendar {
	
	public UseCalendar() {
		Calendar cal2 = new GregorianCalendar();
		
		System.out.println(cal2.get(1));
		System.out.println(Calendar.YEAR);
		System.out.println("------------");
		
		System.out.println(cal2.get(Calendar.YEAR));
		
		StringBuilder calFormat = new StringBuilder();
		calFormat.append(cal2.get(Calendar.YEAR)).append("-")
		.append(cal2.get(Calendar.MONTH) + 1).append("-")
		.append(cal2.get(Calendar.DAY_OF_MONTH)).append(" ");
//		.append(cal2.get(Calendar.AM_PM)).append(" ");
		switch(cal2.get(Calendar.AM_PM)) {
		case Calendar.AM : calFormat.append("오전").append(" "); break;
		case Calendar.PM : calFormat.append("오후").append(" "); break;
		}
		
		System.out.println(Calendar.AM_PM == Calendar.AM
				? "오전" : "오후");
		
		calFormat.append(cal2.get(Calendar.DAY_OF_YEAR)).append(" ")
		.append(cal2.get(Calendar.DAY_OF_WEEK)).append(" ");
		//요일을 문자열로 출력해보세요.
		
		String[] week = {"", "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
		calFormat.append(week[cal2.get(Calendar.DAY_OF_WEEK)]).append(" ")
		.append(cal2.get(Calendar.HOUR)).append("(")
		.append(cal2.get(Calendar.HOUR_OF_DAY)).append("):")
		.append(cal2.get(Calendar.MINUTE)).append(":")
		.append(cal2.get(Calendar.SECOND)).append("");
		System.out.println(calFormat);

	}
	
	public static void main(String[] args) {
		new UseCalendar();
	}
}
