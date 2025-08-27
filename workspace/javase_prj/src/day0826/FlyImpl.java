package day0826;

import day0825.Fly;

/**
 * Fly를 구현한 FlyImpl 클래스를 작성 (FlyImpl은 FLy이다. - 자식은 부모이다.)
 */
public class FlyImpl implements Fly {
	
	@Override
	public String lift() {
		return "양력";
	}
	
	@Override
	public String thrust() {
		return "추진력";
	}
}
