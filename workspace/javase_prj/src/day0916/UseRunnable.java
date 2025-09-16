package day0916;

/**
 * Runnable을 구현
 */
//1. Runnable interface를 구현
public class UseRunnable implements Runnable{
	
	//2.run() override
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
		// 4. Runnabl을 구현한 클래스를 객체화
		UseRunnable ur = new UseRunnable();
		Thread thread = new Thread(ur);
		thread.start(); // start( -> has a 관계의 객체가 구현한 run()호출
		ur.work();
		
		// 5. Thread 클래스를 has a 관계로 생성
		
		// 6. Thread클래스의 객체에서 제공하는 start() 호출
		
	}// run

}
