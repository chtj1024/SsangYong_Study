package day0812;

/**
 * do~while : 처음에는 무조건 실행시키는 반복문
 */
public class TestDoWhile {
	
	public static void main(String[] args) {
		
		int i = 0;
		do {
			System.out.println(i);
			i++;
			break;
		} while(i < 10);
	}
}
