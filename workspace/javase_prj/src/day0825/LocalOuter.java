package day0825;

/**
 * Local Class : 클래스를 지역변수처럼 사용할때
 * 외부 클래스의 다른 method에서는 local class를 사용할 수 없다. 
 * method안에서만 객체화하고 사용할 수 있다.<br>
 * 안쪽클래스에서는 외부클래스의 인스턴스 변수나, method를 사용할 수 있다.<br>
 * 안쪽클래스에서는 지역변수나 parameter를 final이 붙어있는 것만 사용가능.
 *  JDK1.8에서는 final붙어있는 것으로 간주하고 사용한다. ( 값할당시에만 에러가 발생 ) 
 */
public class LocalOuter {
	int outI;
	
	public LocalOuter() {
		System.out.println("바깥 클래스의 생성자");
	}//LocalOuter 
	
	public void outMethod() {
		System.out.println("바깥 클래스의 method");
	}//outMethod
	
	public void method(int paramI, final int  paramJ) {
		
		int i=2025;
		int j=8;
		
		///지역 클래스 시작////////////////////////
		class Local{
			int locI;
			
			public Local() {
				System.out.println("Local의 생성자");
			}//Local
			
			public void locMethod() {
				System.out.println("locMethod");
				//바깥 클래스의 instance variable, method는 호출 가능
				outI=32;
				System.out.println(outI);
				outMethod();
				//지역변수는 final이 선언된 변수만 사용할 수 있다.
//				i=20;//값 할당은 할 수 없다.
				System.out.println("paramI : "+ paramI +", paramJ : "+ paramJ);
				System.out.println("i : "+ i +", paramJ : "+ j);
				
			}//locMethod
			
		}//class
		///지역 클래스 끝////////////////////////
		Local loc=new Local();
		System.out.println( loc.locI );
		loc.locMethod();
		
		System.out.println("method");
	}//method
	
	public static void main(String[] args) {
		LocalOuter lo=new LocalOuter();
		lo.method(5, 28);
	}//main

}//class
