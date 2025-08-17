package day0813;

/**
 * 입력되는 
 */
public class TestStaticMethod {
	
	// 1. 업무를 구현할 method 정의.
	/**
	 * 두 정수를 입력받아서 console에 출력하는 일
	 * @param num
	 * @param num2
	 */
	public static void plus(int num, int num2) {
		int result = 0;
		result = num + num2;
		 System.out.println(num + " + " + num2 + " = " + result);
	}
	
	/**
	 * java application
	 * @param args 외부값 , , ,
	 */
	public static void main(String[] args) {
		// 2. method 호출 : 매개변수의 데이터형, 개수 주의
		
		plus(8, 13);
//		TestStaticMethod.plus(8, 13); // 이렇게도 가능
		
		
		
	}
}
