package day0822;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test extends Clark{
	
	@Override
	public String toString() {
		return "나는 주소가 싫어요";
	}
	
	/**
	 * work를 사용하시는 것보다 work2를 사용하는 게 좋을 것 같아요
	 */
	@Deprecated
	public void work() {
		System.out.println("처음에는 잘되었으나 추후 제대로 동작을 안할 수도 있다");
	}

	@SuppressWarnings({"unused", "rawtypes"})
	public static void main(String[] args) throws FileNotFoundException {
		
		Thread t2 = new Thread();
		
		int i2;
		int i3;
		
		List l = new ArrayList();
		
		Test t = new Test();
		String s = new String("good to see you");
		Integer i = new Integer(22);
		FileInputStream fis = new FileInputStream("c:/dev/env.bat");
		
		//t, s, i - 객체 (heap의 주소)
		System.out.println(t);
		System.out.println(s);
		System.out.println(i);
		System.out.println(fis);
		
		//매개변수로 Objecㅅ이 선언된 println method를 호출하면
		// println method안에서 toString()를 호출하여 객체의 주소를
		// day0822.Test@5ca881b5 "문자열"로 콘솔에 출력해준다.
		
		Object obj = new Test();
		System.out.println(obj.toString());
		
		Date date = new Date();
		System.out.println(date.getYear() + 1900);
		
		t.work();
	}
}
