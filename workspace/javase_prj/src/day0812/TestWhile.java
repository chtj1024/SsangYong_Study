package day0812;

/**
 * while : 시작과 끝을 모를 때 사용하는 반복문
 */
public class TestWhile {
	
	public static void main(String[] args) {
		
		int i = 10;
		while(i < 10) {
			System.out.println(i);
			i++;
		}
		
		// while을 사용하여 구구단 5단 출력
		
		int j = 1;
		while (j < 10) {
			System.out.println("5 x " + j + " = " + (5 * j));
			j++;
		}
	}
}
