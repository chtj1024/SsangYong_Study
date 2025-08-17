package day0814;

/**
 * Variable Arguments가 도입된 method 사용
 */
public class UsePrintf {

	public static void main(String[] args) {
		
		int year = 2025, month = 8, day = 14;
		System.out.println("오늘은 " + year + "년 " + month + "월" + day + "일 입니다.");
		System.out.printf("오늘은 %d년 %d월%d일 입니다.", year, month, day+1);
		System.out.println("정수출력");
		System.out.printf("[%d][%7d][%-7d]\n", year, year, year);
		
		System.out.printf("[%c][%3c][%-3c]\n", 'A', 'B', 'C');
		
		double d = 2025.08;
		System.out.printf("실수출력[%f][%10.2f][%.2f]\n", d, d, d);
		
		boolean b = true, b2 = false;
		System.out.printf("불린출력[%b][%7b][%-7b]\n", b, b, b);
		
		String msg = "java";
		
		System.out.printf("문자열 [%s][%10s][%-10s]\n", msg, msg, msg);
		
		String name = "신용권";
		int age = 25;
		double height = 180.4;
		System.out.format("이름 %s, 나이 %d, 키 %.1f", name, age, height);
	}

}
