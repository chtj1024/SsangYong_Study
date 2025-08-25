package day0822;

/**
 * Parent의 클래스는 Child와 Child, CHild2만 자식으로 가질 수 있도록
 * 자식클래스의 파일이 없으면 error가 발생한다.
 */
public sealed class Parent permits Child, Child2 /*Child4*/{
	public Parent() {
		System.out.println("부모의 기본 생성자");
	}
}
