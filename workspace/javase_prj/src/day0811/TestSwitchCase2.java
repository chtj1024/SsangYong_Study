package day0811;

import kr.co.sist.util.zodiac;

/**
 * 점수를 받아 학점을 구하는 것을 switch case로 만들기
 * (if가 더 적합하긴 한데)
 */
public class TestSwitchCase2 {
	
	public static final int GRADE_A_PLUS = 10;
	public static final int GRADE_A = 9;
	public static final int GRADE_B = 8;
	public static final int GRADE_C = 7;
	public static final int GRADE_D = 6;
	
	public static void main(String[] args) {
		
//		int score = 89;
//		char grade = 'F';
//		
//		switch(score / 10) {
//		case GRADE_A_PLUS:
//		case GRADE_A : grade='A'; break;
//		case GRADE_B : grade='B'; break;
//		case GRADE_C : grade='C'; break;
//		case GRADE_D : grade='D'; break;
//		default : grade='F';
//		}
		int score = 75;
		char grade = 64;
		
		switch(score / 10) {
		case GRADE_D : grade++;
		case GRADE_C : grade++;
		case GRADE_B : grade++;
		case GRADE_A :
		case GRADE_A_PLUS: grade++; break;
		default : grade += 6;
		}
		
		System.out.println(score + "점의 학점은" + grade );
		
		int birthYear = 2025;
		System.out.print(birthYear + "년 생의 띠는 ");
		// zodiac 클래스를 활용
		int zodiacFlag = birthYear % 12;
		switch (zodiacFlag) {
		case zodiac.MONKEY : System.out.println("원숭이"); break;
		case zodiac.ROOSTER : System.out.println("닭"); break;
		case zodiac.DOG : System.out.println("개"); break;
		case zodiac.PIG : System.out.println("돼지"); break;
		case zodiac.MOUSE : System.out.println("쥐"); break;
		case zodiac.COW : System.out.println("소"); break;
		case zodiac.TIGER : System.out.println("호랑이"); break;
		case zodiac.RABBIT : System.out.println("토끼"); break;
		case zodiac.DRAGON : System.out.println("용"); break;
		case zodiac.SNAKE : System.out.println("뱀"); break;
		case zodiac.HORSE : System.out.println("말"); break;
		default : System.out.println("양"); break;
		}
		
//		public static final int MONKEY = 0; 
//		public static final int ROOSTER = 0; 
//		public static final int DOG = 0; 
//		public static final int PIG = 0; 
//		public static final int MOUSE = 0; 
//		public static final int COW = 0; 
//		public static final int TIGER = 0; 
//		public static final int RABBIT = 0; 
//		public static final int DRAGON = 0; 
//		public static final int SNAKE = 0; 
//		public static final int HORSE = 0; 
//		public static final int SHEEP = 0; 
	}
}
