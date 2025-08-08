/**
 char의 Wrapper class인 Character class의 사용.
*/

class Test {
	public static void main(String[] args) {
		// char minValue = Character.MIN_VALUE;
		// char maxValue = Character.MAX_VALUE;
		char minValue = '\u0000';
		char maxValue = '\uFFFF';
		System.out.println("문자 : [" + (int)minValue + "][" + (int)maxValue + "]"); // unicode값 65에 대응되는 문자를 출력;
	}
}
