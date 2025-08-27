package day0827;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * IsO 8601 표준을 준수하여 만들어진 날짜 클래스.
 */
public class UseTimePackage {
	
	public UseTimePackage() {
		// 1. 객체 얻기
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		LocalDateTime ldt = LocalDateTime.now();
		
		System.out.println(ld);
		System.out.println(lt);
		System.out.println(ldt);
		//다른 날짜 정보를 설정
		LocalDate ld2 = LocalDate.of(2025,8,28);
		LocalTime lt2 = LocalTime.of(17,0);
		LocalDateTime ldt2 = LocalDateTime.of(ld2, lt2);
		
		System.out.println("---------");
		System.out.println(ld2);
		System.out.println(lt2);
		System.out.println(ldt2);
		
		StringBuilder ldFormat = new StringBuilder();
		ldFormat.append(ld.getYear()).append("-")
		.append(ld.getMonthValue()).append("-")
		.append(ld.getDayOfMonth()).append(" ")
		.append(ld.getMonth()).append(" ")
		.append(ld.getDayOfWeek())
		.append("일,월,화,수,목,금,토".split(",")[ld.getDayOfWeek().getValue()]);
		
		System.out.println(ldFormat);
		
		StringBuilder ltFormat = new StringBuilder();
		ltFormat.append(lt.getHour()).append(":")
		.append(lt.getMinute()).append(":")
		.append(lt.getSecond()).append(" ")
		.append(lt.getNano());
		
		System.out.println(ltFormat);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:HH,kk,KK:mm:ss EEEE", Locale.US);
		System.out.println(ldt.format(dtf));
	}
	
	public static void main(String[] args) {
		new UseTimePackage();
	}
}
