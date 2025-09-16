package day0916;


/**
 * running(cpu사용) <-> block (cpu비사용) method 사용
 */
public class UseSleep implements Runnable{
	
	@Override
	public void run() {
		//동시에 처리해야하는 코드 작성.
		System.out.print("loading");
		for(int i = 0; i < 15; i++) {
			System.out.print(".");
			try {
				Thread.sleep((long)(Math.random() * 10)* 300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("finish");
	}
	
	public static void main(String[] args) {
		//Runnable을 구현한 클래스를 객체화
		UseSleep us = new UseSleep();
		//Thread와 has a를 설정
		Thread t = new Thread(us);
		//Thread의 Start()
		t.start();
	}

}
