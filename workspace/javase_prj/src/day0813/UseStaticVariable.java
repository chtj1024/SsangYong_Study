package day0813;

/**
 * static (class) 변수
 * - 공용변수, class field선언, 자동초기화, 외부클래스에서도 사용가능 
 */
public class UseStaticVariable {
	
	// 기본형
	public static int i; // 자동초기화 : 정수 0
	public static char c; // '\u0000'
	public static double d; // 0.0
	public static boolean b; // false
	
	// 참조형
	public static UseStaticVariable usv; // 참조형 : null
	public static String s;
	public static int[] arr;
	
	public static void main(String[] args) {
		UseStaticVariable.i = 13;
		
		System.out.println("정수 변수 : " + i);
		System.out.println("문자 변수 : " + c);
		System.out.println("실수 변수 : " + d);
		System.out.println("불린 변수 : " + b);
		System.out.println("참조형 class : " + usv);
		System.out.println("문자 String : " + s);
		System.out.println("문자 array : " + arr);
		
		// 객체 생성
		UseStaticVariable usv2 = new UseStaticVariable();
		usv2.i = 2025;
		UseStaticVariable usv3 = new UseStaticVariable();
		System.out.println(usv2 + " static 변수 " + usv2.i); // static을 객체로 사용하려해서 warning 뜨는 것
		System.out.println(usv3 + " static 변수 " + usv3.i);
	}
}
