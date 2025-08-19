package day0818;

public class ThisMethod {
	
	int i;
	
	public ThisMethod() {
		System.out.println("기본 생성자 "+ this);
		//생성자안에서 다른 생성자를 호출하기위해 객체화를 하면 객체가 다른 주소로
		//하나 더 만들어진다. => 다른 객체에 값이 들어가므로 값이 밖에서 사용될 수 없다.
		//=> this();을 사용한다. 
		ThisMethod tm=new ThisMethod(2025);
		System.out.println("생성자에서 생성된 객체의 주소 "+ tm);
	}//ThisMethod
	
	public ThisMethod(int i) {
		this.i=i;
		System.out.println("Overloading 생성자 "+ this.i+" / "+this);
	}//ThisMethod
	
	public int getI() {
		return this.i;
	}//getI

	public static void main(String[] args) {
		ThisMethod tm=new ThisMethod();//기본생성자 호출 //객체 생성
		System.out.println("tm객체 주소 "+ tm);
		System.out.println( tm.getI() +" / "+ tm.i);
		
	}//main

}//class
