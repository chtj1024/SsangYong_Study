/**
 char�� Wrapper class�� Character class�� ���.
*/

class Test {
	public static void main(String[] args) {
		// char minValue = Character.MIN_VALUE;
		// char maxValue = Character.MAX_VALUE;
		char minValue = '\u0000';
		char maxValue = '\uFFFF';
		System.out.println("���� : [" + (int)minValue + "][" + (int)maxValue + "]"); // unicode�� 65�� �����Ǵ� ���ڸ� ���;
	}
}
