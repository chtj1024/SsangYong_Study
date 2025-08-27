package day0825;

/**
 * 추상클래스<br>
 * -추상 method를 가진다.<br>
 * -직접 객체화 할 수 없다. 
 */
public abstract class AbstractSuper {

	int i; //변수
	
//	public AbstractSuper() {//생성자
//		System.out.println("추상클래스의 기본 생성자");
//	}//AbstractSuper
	
	public void method() {//일반 method
		System.out.println("일반 method");
	}//method
	
	//추상method : method body가 없어서 직접 호출 불가, 구현의 강제성을 가진다.
	public abstract void methodA();
	public abstract int methodB(double d);
	
//	public static void main(String[] args) {
//		//추상클래스는 직접 객체화 될 수 없다.
//		AbstractSuper as=new AbstractSuper();
//	}
	
}//class
