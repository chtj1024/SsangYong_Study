package day0811;

/**
 * 단일 if : 조건에 맞을 때에만 코드를 실행해야 할 때
 */
public class TestIf {
	
	public static void main(String[] args) {
		
		// 절대값을 구하는 코드.
		
		int tempNum = -11;
		int abs = tempNum;
		
//		abs = -tempNum; // 양수값이 들어올 때 문제 발생
		if (abs > 0) {
			abs = -abs;
		}
			
		System.out.println(tempNum + "의 절대값은 " + abs + "입니다.");
		
	}
}
