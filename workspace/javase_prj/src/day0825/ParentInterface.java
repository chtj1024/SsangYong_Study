package day0825;

/**
 * 상수, abstract method, default method로 구성
 */
public interface ParentInterface {
//	int i; //인스턴스 변수 정의할 수 없다.
	public static final int MAX=100;
	
	//생성자를 가질 수 없다. => 객체화가 되지 않는다.
//	public ParentInterface() {
//	}
	
	//일반 method를 가질 수 없다. => 일을 할 수 없다. => default method ( JDK1.8추가 )
//	public void test() {
//	}
	
	
	/**
	 * abstract 접근 지정자를 정의해도 되고 
	 */
	public abstract void methodA();
	/**
	 * abstract 접근 지정자를 정의하지 않아도 된다.
	 */
	public String methodB(int ... va);
	
	/**
	 * default method
	 * @return
	 */
	public default String msg() {
		return "오늘은 월요일 입니다.";
	}//msg
	
}//class
