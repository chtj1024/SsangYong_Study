package day1013;

public class UseSingleton {
	
	public static void main(String[] args) {
		
		// 생성자를 private으로 하면 클래스 외부에서 객체화 할 수 없다.
//		Singleton s = new UseSingleton();
//		Singleton s2 = new UseSingleton();
		
		// 객체를 반환하는 일을 하는 method를 호출하여 클래스외부에서 객체를 얻는다.
		Singleton s = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		System.out.println(s);
		System.out.println(s2);
	}
}
