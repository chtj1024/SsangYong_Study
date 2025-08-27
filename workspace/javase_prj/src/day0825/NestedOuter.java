package day0825;

public class NestedOuter {

	int outI;
	static int outJ;
	
	public void outInsMethod() {
		System.out.println("바깥클래스의 instance method");
	}//outInsMethod
	
	public static void outStaMethod() {
		System.out.println("바깥클래스의 static method");
		Inner.inI=200;
	}//outStaMethod
	
	/////////Nested class 시작////////////////////////////////////////
	static class Inner{
		//static 을 붙여서 static으로만 구성해야한다. 
		static int inI;
		
		public static void inStaMethod() {
			System.out.println("안쪽 클래스의 method");
			//static 영역에서는 instance영역을 사용할 수 없다.
			//outI=20;
//			outInsMethod();
			outJ=2025;
			outStaMethod();
			
		}//inStaMethod
	}//class
	/////////Nested class 끝////////////////////////////////////////
	
	public static void main(String[] args) {
		//안쪽클래스의 자원은 static 문법으로 사용가능.
		Inner.inI=2025;
		Inner.inStaMethod();
	
	}//main

}//class
