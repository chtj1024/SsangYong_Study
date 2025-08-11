package day0806;
/**
	강제 형변환.
	개발자가 원하는 데이터 형으로 일시적인 변환
*/

class Casting {
	public static void main(String[] args) {
		float f = (float)8.06;
		System.out.println(f);
		
		int i = 0;
		
		i = (int) f; // 실수 값이 사라짐
		System.out.println("int i=" + i + ", float f=" + f);
		
		byte b = 10, b2 = 20, result = 0;
		
		result = (byte)(b + b2);
		System.out.println(b + " + " + b2 + "=" + result);
		
		char c = 'A';
		System.out.println("unicode에 해당되는 문자가 출력 : " + c + ", code 값 : "
			+ (int)c);
			
		// 기본형 데이터 형 <-> 참조형 데이터 형 으로는 강제형 변환이 되지 않는다.
		String s = "8";
		int j = 0;
		
		// j = (int) s;
		// s = (String) j;
		
		// boolean형은 다른 데이터 형으로 강제 형변환 될 수 없다.
		boolean bl = true, bl2 = false;
		// j = (int)bl;
		
		// long l = (long)2147483648; // casting은 literal의 크기를 변환 시킬 수 없다. 
	}
}
