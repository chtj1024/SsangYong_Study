/*
빨강 : 변수
파랑 : 연산
초록 : constant(상수)
*/
package day0807;

class Exam0807 {
	
	static final int monthM = 200000;
	static final int giveM = 20;
		
	public static void main(String[] args) {
		System.out.println("한달 용돈 " + monthM + " 원 하루 용돈 " + giveM + "일 기준 " + (monthM / giveM) + "원 입니다.");
		
		int oneGo = 3500;
		int lunch = 7500;
		System.out.println("하루 지출 내역은 편도 교통비 " + oneGo + "원, 왕복 교통비 "
			+ (oneGo * 2) + "원, 점심식대 " + lunch + "원으로");
		System.out.println("한달이 지났을 때의 잔액은 " + (((oneGo * 2) + lunch) * giveM)
			+ "원 입니다.");
		
		System.out.println("int의 최소값 " + Integer.MIN_VALUE
			+ " ~ 최대값 " + Integer.MAX_VALUE);
		
		System.out.println("byte의 최소값 " + Byte.MIN_VALUE
			+ " ~ 최대값 " + Byte.MAX_VALUE);
	}
}
