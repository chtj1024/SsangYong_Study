package day0813;

/**
 * package 접근지정자를 가진 클래스
 */
class TestModifierC {
	
	public static void main(String[] args) {
		// public 접근지정자를 가진 TstModifierA 클래스에 변수를 사용
		TestModifierA tma = new TestModifierA();
		System.out.println("tma 객체 public " + tma.a);
		System.out.println("tma 객체 protected " + tma.b);
		System.out.println("tma 객체 default " + tma.c);
//		System.out.println("tma 객체 private " + tma.d); // private은 자기 클래스에서만 사용 가능
		
		System.out.println("-------------");
		// package 접근지정자를 가진 TstModifierA 클래스에 변수를 사용
		TestModifierB tmb = new TestModifierB();
		System.out.println("tmb 객체 public " + tmb.a);
		System.out.println("tmb 객체 protected " + tmb.b);
		System.out.println("tmb 객체 default " + tmb.c);
//		System.out.println("tmb 객체 private " + tmb.d); // 매한가지
	}
}
