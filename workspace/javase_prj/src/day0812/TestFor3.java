package day0812;

/**
 * for문의 다양한 형태
 */
public class TestFor3 {
	
	public static void main(String[] args) {
		
		//여러개의 초기값을 가지는 for
		for(int i = 0, j = 50, k = 10; i < 10; i++, j--, k*=2) {
			System.out.println("i = " + i + ", j = " + j + ", k = " + k);
		}
		
		// 무한 루프
		for (int i = 0 ; ; i++) {
			System.out.println(i);
			if (i == 10) {
				break;
			}
		}
		System.out.println("안녕");
		
		for ( ; ; ) {
			System.out.println("안녕");
			break;
		}
		
		// continue
		// 1에서 부터 100까지 짝수만 출력하는 코드 
		for (int i = 1; i <= 100; i++) {
			if (i % 2 != 0) {
				continue;
			}
			System.out.print(i + " ");
		}
		
	}
}
