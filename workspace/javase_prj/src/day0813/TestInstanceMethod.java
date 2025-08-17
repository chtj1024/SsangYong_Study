package day0813;

/**
 * instance method 사용
 */
public class TestInstanceMethod {
	
	int day;
	
	public void printDay() {
		System.out.println(day + "일");
	}
	
	public static void main(String[] args) {
		TestInstanceMethod tim = new TestInstanceMethod();
		
		tim.printDay();
		tim.day = 13;
		tim.printDay();
		tim.day++;
		tim.day++;
		tim.printDay();
		
		TestInstanceMethod tim2 = new TestInstanceMethod();
		tim2.printDay();
	}

}
