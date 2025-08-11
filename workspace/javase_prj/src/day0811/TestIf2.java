package day0811;

/**
 * 입력되는 수가 홀수, 짝수인지를 판별
 */
public class TestIf2 {
	
	public static void main(String[] args) {
		
		int num = 0;
		num = Integer.parseInt(args[0]);
		
		System.out.println(num + "은(는)" );
		
		if (num % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
	}

}
