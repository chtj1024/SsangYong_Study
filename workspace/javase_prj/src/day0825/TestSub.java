package day0825;

public class TestSub extends TestSuper{

	int i;//부모와 같은 이름의 변수 선언
	
	public TestSub() {
		this(30); //2.
//		super(25);//1.
//		System.out.println(i+" super.j="+ super.j+", this.j = "+ this.j+ ", "+
//					super.i);
		System.out.println("자식클래스의 기본생성자");
	}//TestSub
	
	public TestSub(int i) {
//		this();//1.
		this.i=i;
		System.out.println("자식클래스의 매개변수 생성자 "+ i);
	}//TestSub
	
}//class
