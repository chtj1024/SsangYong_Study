package day0826;

/**
 * 긴 문자열을 다루는 클래스 사용. (StringBuffer, StringBuidler)
 */
public class UseString {
	
	public void useStringBuffer() {
		StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer(20);
		StringBuffer sb3 = new StringBuffer("오늘은 입니다.");
		
		System.out.println(sb);
		System.out.println(sb2);
		System.out.println(sb3);
		
		int day = 26;
//		sb.append(day);
		double weight = 8.26;
//		sb.append(weight);
		boolean flag = false;
//		sb.append(flag);
		
		char c = 'A';
//		sb.append(c);
		
		String str = "안녕 하세요? 오늘은 화요일입니다.";
		
		sb.append(day).append(weight).append(flag).append(c).append(str);
		
		System.out.println(sb + " / " + sb.capacity() + " / " + sb.length());
		sb3.insert(3, "화요일");
		System.out.println(sb3);
	}
	
	public void useStringBuilder() {
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		
		System.out.println(sb);
		System.out.println(sb2);
		System.out.println(sb3);
		
		int day = 26;
//		sb.append(day);
		double weight = 8.26;
//		sb.append(weight);
		boolean flag = false;
//		sb.append(flag);
		
		char c = 'A';
//		sb.append(c);
		
		String str = "안녕 하세요? 오늘은 화요일입니다.";
		
		sb.append(day).append(weight).append(flag).append(c).append(str);
		
		System.out.println(sb + " / " + sb.capacity() + " / " + sb.length());
	}
	
	public static void main(String[] args) {
		UseString us = new UseString();
		System.out.println("----------StringBuffer----------");
		us.useStringBuffer();
		System.out.println("----------StringBuilder----------");
		us.useStringBuilder();
	}
}
