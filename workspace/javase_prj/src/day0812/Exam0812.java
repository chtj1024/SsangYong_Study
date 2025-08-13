package day0812;
/* 
 * 1. 구구단 전체단을 출력하는 코드.
 *  2 x 1 = 2  3 x 1 = 3  4 x 1 = 4 이런식으로나와야 함
 *  .
 *  .
 *  2 x 9 = 18  3 x 9 = 27
 *  
 *  
 * 2. 아래와 같은 형태로 출력 될 수 있또록 for문 구성
 *   0
 *    1
 *     2
 *      3
 *      
 * 3. 1 ~ 100 수 중 3의 배수를 누적합 한 결과를 출력
 * 
 * 4. 8월 달 달력을 콘솔에 출력 (일수 만)
 */


public class Exam0812 {
	
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.print(j + " x " + i + " = " + (j * i) + "\t");
			}
			System.out.println();
		}
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			System.out.println(i);
		}
		
		int sum = 0;
		for (int i = 3; i <= 100; i += 3) {
			sum += i;
		}
		System.out.println(sum);
		
		System.out.println("\t\t\t8월");
		System.out.print("\t\t\t\t\t");
		for (int i = 1; i <= 31; i++) {
			System.out.print(i + "\t");
			if ((i - 2) % 7 == 0) {
				System.out.println();
			}
		}
	}
}
