package day0822;

public class SuperSub extends SuperParent{
	
	int i; // 부모클래스와 같은 이름의 변수
	int k;
	
	@Override
	public String toString() {
		return super.toString() + " 안녕하세요 " + hashCode()
		+ " / " + Integer.toHexString(hashCode()) + " / " + getClass();
	}
	
	
	public void printVariable() {
		System.out.println("오늘은 금요일");
		super.printVariable(); // super 빼버리면 무한반복 됨
	}
	
	public void test() {
		System.out.println(this);
//		System.out.println(super)); // 부모객체의 주소를 가지고 있는데 출력되지는 않는다.
		i = 100; // 부모와 자식에 같은 이름에 변수가 있다면 자신의 변수를 먼저 사용한다.
		super.i = 52;
		System.out.printf("test method i : %d, k : %d\n", i, k);
		System.out.printf("부모변수 i : %d, j : %d\n", super.i, j);
	}
	
	public static void main(String[] args) {
		SuperSub ss = new SuperSub();
		ss.test();
		ss.printVariable();
		
		System.out.println(ss);
	}
}
