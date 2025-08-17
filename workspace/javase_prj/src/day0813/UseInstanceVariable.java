package day0813;

/**
 * instance (member) variable
 */
public class UseInstanceVariable {
	
	private int i;
	private char c;
	private double d;
	private boolean b;
	
	public static void main(String[] args) {
		// instance 변수는 직접 사용할 수 없다.
//		System.out.println( i );
		// 클래스 명으로도 사용할 수 없다.
//		System.out.println(UseInstanceVariable.i);
		UseInstanceVariable uiv = new UseInstanceVariable();
		UseInstanceVariable uiv2 = new UseInstanceVariable();
		
		uiv.i = 2025;
		
		System.out.println("uiv.i = " + uiv.i);
		System.out.println("uiv2.i = " + uiv2.i);
		
		System.out.println("uiv.c = " + uiv.c);
		System.out.println("uiv.d = " + uiv.d);
		
	
	}
}
