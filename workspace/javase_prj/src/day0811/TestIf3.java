package day0811;

/**
 * 문자열 비교. (==말고 .equals()를 사용해야 함)
 */
public class TestIf3 {
	
	public static void main(String[] args) {
		
		System.out.println(args[0].equals("자바"));
		System.out.println(!args[0].equals("자바"));
		
		if (args[0].equals("자바")) {
			System.out.println("WORA, 완벽한 OOP언어");
		} 
		if (!args[0].equals("자바")) {
			System.out.println("좋은 언어");
		} 
		
		// main method에 두번째 arguments에 임의의 숫자를 입력하고
		// 해당 숫자가 0~100 사이일때만 "유효점수"를 콘솔에 출력합니다.
		
		int num = Integer.parseInt(args[1]);
		System.out.print(num + " ");
		if (0 <= num && num <= 100 ) {
			System.out.println("유효점수");
		}
	}	
}
