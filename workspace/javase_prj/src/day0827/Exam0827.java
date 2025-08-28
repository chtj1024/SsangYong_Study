package day0827;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * 문제
 * 1. 0, 1, 2, 3을 입력 받는 method를 작성하고, 문자열로 날짜형식을 반환하는 method 작성
 * 반환되는 날짜형식은 : "월-일-년 오전|오후 요일 시:분:초" 의 형식
 * 
 * 입력값이 0-한국, 1-독일, 2-미국, 3-일본 날짜형식이 반환되어야 한다.
 * 입력값이 0,1,2,3이 아니면 한국의 날짜 형식으로 반환.
 * 
 * - method를 호출하여 날짜를 출력하는 Method
 * 
 * 2. 파일명을 매개변수로 받는 method 만들고 입력된 파일명에 백업 파일명을 반환하는 반환하는 일
 * method
 * 
 * 예) "Abc.java"가 arguments로 입력되면 반환되는 백업파일명은 "Abc_bak.java"의
 * 형식으로 리턴되게
 */
public class Exam0827 {
	
	public String getNowDate(int num) {
		LocalDateTime ldt = LocalDateTime.now();
		
		Locale selectedLocale = Locale.KOREA;
		
		switch (num) {
		case 1 : selectedLocale = Locale.GERMAN; break;
		case 2 : selectedLocale = Locale.US; break;
		case 3 : selectedLocale = Locale.JAPAN; break;
		}	
//		Locale[] selectedLocaleArr = new Locale[] {Locale.KOREA, Locale.GERMAN, Locale.US, Locale.JAPAN};
//		Locale selectedLocale;
//		if (num <= 0 && num > 3) {
//			selectedLocale = Locale.KOREA;
//		} else {
//			selectedLocale = selectedLocaleArr[num];
//		}
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd a EEEE HH:mm:ss", selectedLocale);
		
		return ldt.format(dtf);
	}
	
	public void printDate(String str) {
		System.out.println(str);
	}
	
	public String getFileName(String fileName) {
		int dotIdx = fileName.indexOf(".");
		String name = fileName.substring(0, dotIdx);
		String extension = fileName.substring(dotIdx);
		
		return name + "_bak" + extension;
	}
	
	public static void main(String[] args) {
		Exam0827 e0827 = new Exam0827();
		
		String str = e0827.getNowDate(0);
		e0827.printDate(str);
		
		String backupName = e0827.getFileName("Abc.java");
		System.out.println(backupName);
	}
}
