package day0826;

import day0825.Fly;

/**
 * 익명 클래스의 사용
 */
public class UseAnonymousInnerClass {
	
	public void useFly(Fly fly) {
		System.out.println(fly.lift() + " / " + fly.thrust());
	}
	
	public static void main(String[] args) {
		UseAnonymousInnerClass uaic = new UseAnonymousInnerClass();
		uaic.useFly(new Fly() {
			
			@Override
			public String thrust() {
				return "양력";
			}
			
			@Override
			public String lift() {
				return "추진력";
			}
		});
	}
}
