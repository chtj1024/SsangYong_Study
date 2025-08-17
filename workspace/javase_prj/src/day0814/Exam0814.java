package day0814;

/*
 * 문제.
 * method는 instance method로 만들고,
 * 일을 제공하는 클래스와 제공하는 일을 사용하는 클래스 구분하여 코드를 작성 및 사용. (MarkerPen과 UseMarkerPen의 형태처럼)
 * 
 * 1. 정수를 입력받는 method를 만들고 입력값이 0이면 숫자를 0~9까지 콘솔 출력,
 * 입력값이 1이면 대문자 A~Z까지 출력,
 * 입력값이 2면 대문자 a-z까지 콘솔 출력하는 일을 하는 method.
 * 0, 1, 2가 아니면 숫자 0~9를 출력할 것.
 * 
 * 2. 단을 입력받아 구구단을 콘솔에 출력하는 method
 * 
 * 3. 구구단 전체단을 출력하는 method를 작성.
 * (2번 method와 Overload되도록 method명 설정)
 * 
 * 4. 알파벳 소문자 전체를 거꾸로 출력하는 method 작성
 */

// 제공하는 클래스
class Make {
	
	public void inputInt(int num) {
		if (num == 0) {
			for (int i = 0; i < 10; i++) {
				System.out.print(i + " ");
			}
			System.out.println();
		} else if (num == 1) {
			for (int i = 65; i <= 90; i++) {
				System.out.print((char)i + " ");
			}
			System.out.println();
		} else if (num == 2) {
			for (int i = 97; i <= 122; i++) {
				System.out.print((char)i + " ");
			}
			System.out.println();
		} else {
			for (int i = 0; i < 10; i++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public void gugudan(int num) {
		for (int i = 1; i <= 9; i++) {
			System.out.print(num + " x " + i + " = " + (num * i) + "|");
		}
		System.out.println();
	}
	
	public void gugudan() {
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.print(i + " x " + j + " = " + (i * j) + "|");
			}
			System.out.println();
		}
	}
	
	public void reverseA() {
		for (int i = 122; i >= 97; i--) {
			System.out.print((char)i + " ");
		}
		System.out.println();
	}
}
// 사용하는 클래스
public class Exam0814 {
	
	public static void main(String[] args) {
		Make m = new Make();
		m.inputInt(2);
		m.gugudan(2);
		System.out.println("-------------");
		m.gugudan();
		m.reverseA();
	}
}
