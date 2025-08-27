package day0825;

/**
 * 추상클래스를 부모로하는 자식 클래스<br> 
 * 자식클래스에서 부모클래스의 정의된 모든 abstract method를 Override 해야한다.( 구현의 강제성)
 */
public class AbstractSub extends AbstractSuper{
	
//	public AbstractSub() {
//		System.out.println("자식 클래스의 생성자");
//	}//AbstractSub

	@Override
	public void methodA() {
		//부모 methodA 호출
//		super.methodA();// abstract는 super로 직접 호출할 수 없다.
		System.out.println("Override된 methodA");
	}//methodA
	
	@Override
	public int methodB(double d) {
		return (int)d;
	}//methodB
	
	public static void main(String[] args) {
		//추상 클래스는 직접 객체화되지 않는다. => 자식클래스가 생성될때에만 객체가 생성
		//AbstractSuper as=new AbstractSuper();
		AbstractSub as=new AbstractSub();
		as.methodA(); 
		System.out.println( as.methodB(8.25) ); 
		
		//is a 관계의 객체화 : 부모의 method를 자식이 override했다면 자식이
		//override 한 method가 최우선적으로 호출된다. ( 에러 방지) 
		AbstractSuper as2=new AbstractSub();
		as2.methodA(); 
		
	}//main


}//class
