package day0818;

/**
 * 생성자 연습<br>
 * 코드에서 생성자를 하나도 정의하지 않으면 compiler가 기본생성자를 만들어준다.<br>
 * overload 된다.( 매개변수만 다르게 작성 )<br>
 * 개발자가 생성자를 하나라도 정의하면 기본생성자를 compiler는 생성하지 않는다.<br>
 * method호출하는 문법으로 직접 호출할 수 없다.( new 에 의해서만 호출)
 * this(), super()로 생성자를 호출할 수 있다.
 */
public class TestConstuctor {

	public TestConstuctor() {
		System.out.println("default constructor");
		method();
	}//TestConstructor
	
	public TestConstuctor(int i) {
//		this();
		System.out.println("Overloading된 생성자 "+i);
		method();
//		TestConstuctor(); //직접호출 불가능
//		new TestConstuctor();
	}//TestConstructor
	
	public void method() {
		System.out.println("instance method");
	}
	
	public static void main(String[] args) {
		
		new TestConstuctor(8);	
		
	}//main
	
}//class
