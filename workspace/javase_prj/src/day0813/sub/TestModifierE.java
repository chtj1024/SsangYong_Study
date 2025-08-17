package day0813.sub;

import day0813.TestModifierA;

/**
 * TestModifierA 클래스의 자식 클래스
 */
public class TestModifierE extends TestModifierA {

	public static void main(String[] args) {
		TestModifierE tme = new TestModifierE();
		System.out.println("tme public : " + tme.a);
		System.out.println("tme protected : " + tme.b);
//		System.out.println("tme default : " + tme.c);
//		System.out.println("tme private : " + tme.d);

	}
}
