/**
기본형 데이터형 : 변수에 값을 저장하는 데이터 형
*/

class PrimitiveDataType {
	public static void main(String[] args) {
		byte b=127;
		System.out.println("byte : " + b);
		short s = 6;
		System.out.println("short : " + s);
		
		long deposit = 3000000000L;
		System.out.println(deposit);
		
		System.out.println("--문자 상수를 저장할 수 있는 문자형 데이터--");
		char c = 65; // 유니코드값 직접 할당
		char c2 = 48;
		char c3 = 44032;
		
		System.out.println(c + "/" + c2 + "/" + c3);
		
		System.out.println("--실수 상수를 저장할 수 있는 실수형 데이터형--");
		// float f = 8.6; // 실수 literal은 8byte가 기본크기이고 float은 4byte의 크기 이므로
		// 그냥 할당하면 크기가 다르므로 에러가 발생한다. => F, f로 형명시 해야 함.
		float f = 8.6F; // 형명시 필수
		double d = 8.6; // 형명시 생략 가능
		
		System.out.println("float : " + f);
		System.out.println("double : " + d);

	}
}
