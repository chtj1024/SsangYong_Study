package day0826;

import day0825.Clark;
import day0825.Fly;

public class Test {
	
	public void useFly(Fly fly) {
		System.out.println(fly.lift()+ " / " + fly.thrust());
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		FlyImpl fi = new FlyImpl();
		t.useFly(fi);
		
		Clark cl = new Clark();
		t.useFly(cl);
	}
}
