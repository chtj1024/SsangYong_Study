package day0811;

import java.io.*;
import java.util.*;

/**
 * if~else : 둘 중 하나의 코드를 실행해야 할 때
 */
public class TestIfElse {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String[] input = new String[3];
		for (int i = 0; i < input.length; i++) {
			input[i] = st.nextToken();
		}
		
		////////////입력된 수가 홀수, 짝수인지///////////
		int num = Integer.parseInt(input[0]);
		
		System.out.print(num + "은(는) " );
		
		if (num % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
		/////////////입력 된 문자열을 둘 중 하나로 비교 //////////////
		String str = input[1];
		if (str.equals("자바") || str.equals("java") || str.equals("Java")) { // 자바, java, Java 비교
			System.out.println("WORA, 완벽한 OOP언어");
		} else {
			System.out.println("좋은 언어");
		}
		
		//////////입력 된 점수가 유효 점수, 무효점수인지 /////////////
		int num2 = Integer.parseInt(input[2]);
		System.out.print(num2 + " ");
		if (0 <= num2 && num2 <= 100 ) {
			System.out.println("유효점수");
		} else {
			System.out.println("무효점수");
		}
		
	}
}
