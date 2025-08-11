package day0808;

public class Test {

	public static void main(String[] args) {
		long st = System.currentTimeMillis();
		
		int total = 0;
		for(int i = 0; i < 500; i++) {
			total += i;
			System.out.println("total = " + total + ", i = " + i);
		}
		System.out.println("결과값 : " + total);
		long et = System.currentTimeMillis();
		System.out.println((et - st) + "ms");
	}

}
