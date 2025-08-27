package day0825;

public class TestSuper {
	int i;
	int j;
	
	public TestSuper() {
		this(25); //2.
//		super(); //1.
		System.out.println("부모클래스 기본생성자");
		i=25;
	}//TestSuper
	
	public TestSuper(int i) {
		super(); // 2.
//		this(); //1.
		this.i=i;
		System.out.println("부모클래스 매개변수 있는 생성자 : "+ i);
	}//TestSuper
}//class
