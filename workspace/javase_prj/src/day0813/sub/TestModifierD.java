package day0813.sub;

import day0813.TestModifierA;
//import day0813.TestModifierB; // 패키지 접근 지정자(class앞에 public이 없는)를
// 가진 접근 지정자는 외부 패키지에서 접근 불가

/**
 * 다른 패키지에 존재하는 클래스 사용.
 */
public class TestModifierD {

	public static void main(String[] args) {
		TestModifierA tma = new TestModifierA();
		System.out.println("tma객체의 public : " + tma.a);
//		System.out.println("tma객체의 protected : " + tma.b);
//		System.out.println("tma객체의 default : " + tma.c);
//		System.out.println("tma객체의 private : " + tma.d);
	}

}