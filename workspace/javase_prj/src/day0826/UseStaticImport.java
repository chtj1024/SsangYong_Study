package day0826;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.MAX_VALUE;
//import static java.lang.Byte.MAX_VALUE;

/**
 * static import : 다른 클래스트의 static 변수, static method를 현재 클래스에 있는 것처럼
 * 클래스명 없이 사용할 때.
 */
public class UseStaticImport {
	
	public void test() {
		String str = "2025";
		String str2 = "8";
		String str3 = "26";
		
		int i = parseInt(str);
		int j = parseInt(str2);
		int k = parseInt(str3);
		
		System.out.println(MAX_VALUE);
		System.out.println(i + " / " + j + " / " + k);
		
	}
	
	public static void main(String[] args) {
		UseStaticImport usi = new UseStaticImport();
		usi.test();
		
	}
}
