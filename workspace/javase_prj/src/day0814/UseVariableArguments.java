package day0814;

/**
 * 가변인수 (Variable Arguments )의 사용
 * method parameter는 하나인데, arguments을 여러 개 입력할 수 있는 기능.
 * 
 */
public class UseVariableArguments {
	
	/**
	 * 가변 인수형을 가진 method
	 * @param va
	 */
	public void methodA(int ... va) {
//		System.out.println(va);
		for (int i = 0; i < va.length; i++) {
			System.out.print(va[i] + " ");
		}
		System.out.println();
	}
	
	public void test(int i, char ... c) {
		System.out.println(i);
		for(int j = 0; j < c.length; j++) {
			System.out.println(c[j]);
		}
	}
	
	public static void main(String[] args) {
		UseVariableArguments uva = new UseVariableArguments();
		uva.methodA();
		uva.methodA(1);
		uva.methodA(2025, 8, 14, 10, 3);
		uva.test(1);
	}
}
