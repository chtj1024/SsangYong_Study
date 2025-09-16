package day0916;

public class UseTest {
	
	public void useTest(Test t) {
		t.temp(10);
	}
	
	public static void main(String[] args) {
		//anonymous
		UseTest ut = new UseTest();
		ut.useTest(new Test() {
			@Override
			public void temp(int i) {
				System.out.println("anonymous inner class가 구현 " + i);
			}			
		});
		
		//Lambda식 사용
		ut.useTest((int i ) -> {
			System.out.println("Labmda식으로 구현" + i);
		});
	}
}
