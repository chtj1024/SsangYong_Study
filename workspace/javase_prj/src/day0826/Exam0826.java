package day0826;

import java.util.Arrays;

/**
 * 1. 영문자 소문자, 영문자 대문자, 숫자로 이루어진 8자리의 비밀번호를 생성하여
 * StringBuilder에 저장하고 반환하는 일 method 생성.
 * 
 * 2. 
 *   - 로또 번호를 생성하여 int[]로 반환하는 일 method 생성.
 *     (1 ~ 45)까지의 수 중 중복되는 값 없이 6개의 세트
 *   - 생성된 로또 번호를 작은 수 부터 출력하는 일 method (오름차순 정렬)
 * 
 */
public class Exam0826 {
	
	public StringBuilder makePassword() {
		StringBuilder sb = new StringBuilder();
		char lower = (char)((Math.random() * 26) + 97);
		char upper = (char)((Math.random() * 26) + 65);
		char number = (char)((Math.random() * 10) + 48);
		
		sb.append((char)((Math.random() * 26) + 97))
			.append((char)((Math.random() * 26) + 97))
			.append((char)((Math.random() * 26) + 65))
			.append((char)((Math.random() * 26) + 65))
			.append((char)((Math.random() * 10) + 48))
			.append((char)((Math.random() * 10) + 48))
			.append((char)((Math.random() * 10) + 48))
			.append((char)((Math.random() * 10) + 48));
		
		return sb;
	}
	
	public String[] makeLotto() {
		String[] lotto = new String[6];
		for(int i = 0; i < lotto.length; i++) {
			
			int num = 0;
			 do {
				 lotto[i] = String.valueOf((char)((Math.random() * 10) + 48))
						 + String.valueOf((char)((Math.random() * 10) + 48));
				 num = Integer.parseInt(lotto[i]);
			 } while (num < 1 || num > 45);
			 
		}
		
		return lotto;
	}
	
	public void printLotto(String[] lotto) {
		Arrays.sort(lotto);
		
		for(String lo : lotto) {
			System.out.print(lo + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Exam0826 e = new Exam0826();
		StringBuilder sb = e.makePassword();
		System.out.println(sb);
		System.out.println("------------");
		
		String[] lotto = e.makeLotto();
		e.printLotto(lotto);
		
		
	}
}
