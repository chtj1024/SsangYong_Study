package day0813;

/**
 * package 접근지정자를 가진 클래스
 */
class TestModifierB {
	
	public int a;
	protected int b;
	int c; // default 접근지정자
	private int d;
	
	public static void main(String[] args) {
		TestModifierB tma = new TestModifierB();
		System.out.println("public " + tma.a);
		System.out.println("protected " + tma.b);
		System.out.println("default " + tma.c);
		System.out.println("private " + tma.d);
		
	}
}
