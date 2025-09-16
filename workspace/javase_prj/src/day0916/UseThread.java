package day0916;

/**
 * Thread를 상속받아서 사용하는 클래스
 */
//1. Thread를 상속받는다.
public class UseThread extends Thread{
	//2. run method를 Override	
	@Override
	public void run() {
		//3. Thread로 동작해야하는 코드 정의
		for(int i = 0; i < 5000; i++) {
			System.out.println("run method i=========>" + i);
		}
	}
	
	public void work() {
		for(int i = 0; i < 5000; i++) {
			System.out.println("work method i --------------" + i);
		}
	}
	
	public static void main(String[] args) {
		//4. 자식클래스 객체화. ( 부모클래스로부터 생성 > 자식은 부모의 자원을 사용할 수 있다.)
		UseThread ut = new UseThread();
		//5. start() 호출하여 Thread로 코드가 실행되도록 한다.
		long st = System.currentTimeMillis();
		ut.start();
		ut.work();
		long et = System.currentTimeMillis();
		System.out.println(et-st + "ms");
	}

}
