/**
 산술 연산자 : +, -, *, /, % (나눈 나머지)
*/

class Operator2 {
	public static void main(String[] args) {
		int i = Integer.MAX_VALUE;
		System.out.println(i + "를 2로 나눈 나머지" + i % 2);
		
		int birthYear = 2025;
		System.out.println( birthYear + "년은 " + birthYear % 12);
	}
}
