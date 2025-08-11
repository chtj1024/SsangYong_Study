// 연습 문제
package day0806;

class Exam0806 {
	
	public static final int mGo = 20;
	
	public static void main(String[] args) {
		String first = "H";
		String second = "G";
		String third = "D";
		int birth = 1996;
		System.out.println("내 이름은 홍길동이고 이니셜은 " + first + second + third + " 입니다.");
		System.out.println("태어난 해 " + birth + "년 이고,");
		System.out.println("나이는" + (2025 - birth + 1) + "살 입니다.");
		System.out.println("---");
		
		double lEye = -1.0;
		double rEye = -1.0;
		
		System.out.println("왼눈 시력" + lEye + " 오른눈 시력"+
			rEye + "이고, 양안 시력" + ((lEye + rEye) / 2) + "입니다.");
		
		int goOne = 35;
		int goCross = 45;
		
		System.out.println("편도 차비" + goOne + "원, 왕복차비 " + goCross + "원, 한달 " + mGo 
			+ "일 출근하면 월 교통비는" + (goCross * mGo) + "원 입니다.");
		
		char daeA = 'A';
		System.out.println("대문자 " + daeA + "의 unicode값 65입니다." + daeA 
			+ "에 32를 더하면 소문자 " + (char)(daeA + 32) + "를 만들 수 있다.");

		
	}
}
