package day0825;

/**
 *  Inner class ( 안긴 클래스 ) 
 */
public class Outer {
	
	int outI;
	
	public Outer() {
		System.out.println("바깥 클래스의 생성자");
	}//Outer

	public void outMethod() {
		System.out.println("바깥 클래스 method");
		//안쪽 클래스의 자원을 직접 사용할 수 없다.
		//System.out.println( inI ); //error
		//안쪽클래스의 자원을 사용하기위해서 객체화
//		System.out.println( this );
		
		//instance 영역 ( this 위에 동작하는 하는 영역 )
		// 객체명.new를  this.new로 기술할 수 있고, this위에서 method가 동작하기
		// 때문에 this를 생략하고 new를 직접 사용할 수 있다.
		Inner in=new Inner();
		System.out.println(in.inI);
//		in.inMethod();//지금상태는 재귀호출되어 에러발생.
		
	}//outMethod
	
	////////// Inner class 시작//////////////////////////////
	public class Inner{
		int inI;
		
		public Inner() {
			System.out.println("안쪽 클래스의 생성자");
		}//Inner
		
		public void inMethod() {
			System.out.println("안쪽 클래스의 method inI = "+ inI);
			//바깥 클래스의 자원. 
			//안쪽클래스에서는 바깥클래스의 자원을 마음대로 사용할 수 있다.
			System.out.println("outI : "+ outI );
			outMethod();
		}//inMethod
		 
	}//class
	////////// Inner class 끝//////////////////////////////
	
	public static void main(String[] args) {
		//1.바깥 클래스를 객체화. ( 바깥클래스명 객체명=new 바깥클래스생성자(); )
		Outer out = new Outer();
		System.out.println("------"+out);
//		out.inMethod(); //바깥 클래스의 객체명으로는 안쪽 클래스의 자원을 사용할 수 없다.
		
		//2.안쪽 클래스를 객체화.
		//바깥클래스명.안쪽클래스명 객체명=바깥클래스객체명.new 안쪽클래스생성자();
//		Outer.Inner in=out.new Inner();
		Inner in = out.new Inner(); //바깥클래스명은 생략 가능.
		in.inI=2025; //안쪽클래스의 변수
		in.inMethod(); //안쪽클래스의 method
		
	}//main
	
}//class
