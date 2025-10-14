package day1013;

public class Singleton {
	private static Singleton single;
	
	private Singleton() {
		
	}
	
	/**
	 * 객체를 반환하는 일.
	 * @return
	 */
	public static Singleton getInstance() {
		if (single == null) { // 객체가 생성되어 있지 않다면
			single = new Singleton(); // 객체를 생성한다.
		}
		return single;
	}
}
