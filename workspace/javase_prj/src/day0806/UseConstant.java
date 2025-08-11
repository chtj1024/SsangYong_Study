package day0806;
/**
 외부 클래스에 존재하는 constant 사용.
 클래스명.constant명
*/

class UseConstant {
	public static void main(String[] args) {
		System.out.println(Constant.MAX_SCORE);
		
		// Java에서 제공하는 Wrapper class의 constant를 사용.
		System.out.println(Byte.MAX_VALUE);
		
		byte b = Byte.MIN_VALUE;
		System.out.println(b);
	}
}
