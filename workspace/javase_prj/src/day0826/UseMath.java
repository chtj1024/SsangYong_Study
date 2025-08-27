package day0826;

/**
 * 수학관련 클래스 : Math 사용.
 */

import static java.lang.Math.abs;

public class UseMath {
	
	private UseMath () {
//		Math m = new Math(); // 생성자가 보이지 않으므로 객체화 할 수 없다.
		int i = -8;
		double d = -2025.08;
		
		int absI = Math.abs(i);
		double absD = Math.abs(d);
		System.out.println(i + "의 절대값 " + absI);
		System.out.println(d + "의 절대값 " + absD);
		
		d = 2025.8;
		System.out.println(d + "를 반올림 : " + Math.round(d));
		d = 2025.4;
		System.out.println(d + "를 반올림 : " + Math.round(d));
		d = 2025.08;
		System.out.println(d + "를 반올림 : " + Math.round(d));
		
		d = 10.000001;
		System.out.println(d + "를 올림 " + Math.ceil(d));
		
		d = 10.9;
		System.out.println(d + "를 올림 " + Math.ceil(d));
		
		d = 2025.08;
		System.out.println(d + "를 올림 " + Math.ceil(d));
		
		d = Math.random();
		System.out.println("발생하 난수 : " + d);
		System.out.println("범위 난수 : " + d * 10);
		System.out.println("범위 난수 중 정수 : " + (int)(d * 10));
		
		//알파벳 대문자 중 하나를 얻기
		char upperCase = (char)((Math.random()*26)+65);
		System.out.println(upperCase);
		
	}
	
	public static void main(String[] args) {
		UseMath um = new UseMath();
	}
}
