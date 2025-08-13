package day0812;

/**
 * 반복문 ( looping statement )
 * for문 : 시작과 끝을 알 때 사용하는 반복문
 */
public class TestFor {
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println("i : " + i);
		}
		
		// 1에서부터 100까지 1씩 증가하는 값을 옆으로 출력하는 반복문
		for (int i = 1; i <= 100; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		//1에서부터 100까지 홀수만 옆으로 출력하는 반복문
		int cnt = 0;
		for (int i = 1; i <= 100; i+=2) {
			System.out.print(i + " ");
			cnt++;
		}
		System.out.println("\n" + cnt + "번 반복");
		
		//1에서부터 100까지 짝수만 옆으로 출력하는 반복문

		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {				
				System.out.print(i + " ");
			}
		}
		System.out.println();
		// 1에서부터 9까지 1씩 증가하는 반복문을 만들기
		for (int i = 1; i < 10; i++) {
			System.out.println("2 x " + i + " = " +(i * 2));
		}
		
		// main method의 arguments로 구구단을 입력받아서
		// 입력 된 구구단이 2~9단인 경우 해당 단의 구구단을 콘솔에 출력하는 코드를 작성
		// 2~9단이 아니면 "입력하신 단은 업습니다." 출력
		System.out.println("---------------");
		
		int gugudan = Integer.parseInt(args[0]);
		if (gugudan < 2 || gugudan > 9) {
			System.out.println("입력하신 단은 없습니다.");
		} else {
			for(int i = 1; i <= 9; i++) {
				System.out.println(gugudan + " x " + i + " = " + (gugudan * i));
			}
		}
		
		int result = 0;
		for (int i = 1; i <= 100; i++) {
			result += i;
		}
		System.out.println(result);
	}
}
