package day0911;

import java.io.Serializable;

import javax.swing.JFrame;

import day0825.Clark;
import day0825.Fly;
import day0825.HongGilDong;
import day0825.Person;

/**
 * 객체가 해당 클래스나 인터페이스로 부터 생성되었는지 비교하는 연산자
 */
public class UseInstanceof {
	
	public void test(Object p) {
		System.out.println(p + "객체는 Person의 객체인가?" + (p instanceof Person));
		System.out.println(p + "객체는 Fly의 객체인가?" + (p instanceof Fly));
		
	}
	
	public void test2(Object obj) {
		if(obj instanceof Serializable) {
			System.out.println(obj+"는 객체직렬화가 가능");
		} else {
			System.out.println(obj+"는 객체직렬화가 불가능");			
		}
	}
	
	public static void main(String[] args) {
		UseInstanceof ui = new UseInstanceof();
		Clark clark = new Clark();
		HongGilDong hgd = new HongGilDong();
		day0822.HongGilDong hgd0822 = new day0822.HongGilDong();
		ui.test(clark);
		ui.test(hgd);
		ui.test(hgd0822);
		
		System.out.println("---------------");
		String str ="안녕";
		ui.test2(str);
		
		ui.test2(ui);
		ui.test2(new JFrame());
		
	}
}
