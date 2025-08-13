package day0812;

/**
 * 다중 for 사용
 */
public class TestFor2 {
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.println("i = " + i + ", j = " + j);
			}
			System.out.println("-------------");
		}
		
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + " x " + j + " = " + (i*j));
			}
			System.out.println("-------------");
		}
		
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(i + " " + j + " ");
			}
			System.out.println();
		}
		System.out.println("----------");
		
		for (int i = 0; i <= 3; i++) {
			for (int j = i + 1; j <= 4; j++) {
				System.out.print(i + " " + j + " ");
			}
			System.out.println();
		}
	}
}
