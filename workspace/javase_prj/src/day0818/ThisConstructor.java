package day0818;

/**
 * this()를 사용한 생성자 호출
 */
public class ThisConstructor {
	
	public ThisConstructor() {
//		this();//기본생성자 호출 : 재귀호출 가능성이 있다면 error
		this(2025);//생성자의 첫번째 줄에서만 사용가능
		System.out.println("기본생성자");
	}//ThisConstructor
	
	public ThisConstructor(int i) {
//		this();
		System.out.println("인자있는 생성자");
	}//ThisConstructor

	public static void main(String[] args) {
		new ThisConstructor(10);
	}//main

}//class
