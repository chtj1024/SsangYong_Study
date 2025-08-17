package day0813;

/**
 * method의 4가지 형태
 * 고정일, 가변일, 고정 값, 가변 값
 */
public class MethodType {
	
	/**
	 * 고정 일 : 반환형 없고, 매개변수 없는 형
	 */
	public void typeA() {
		System.out.println("오늘은 수요일 입니다.");
	}
	
	/**
	 * 가변 일
	 * @param i
	 */
	public void typeB(int i) {
		System.out.println("가변일 : i = " + i);
	}
	
	/**
	 * 고정 값
	 * @return
	 */
	public int typeC () {
		int day = 13;
		return day;
	}
	
	/**
	 * 가변 값 : 
	 * @param d
	 * @return
	 */
	public int typeD(double d) {
		return (int) d;
	}

	public static void main(String[] args) {
		MethodType mt = new MethodType();
		for (int i = 0; i < 5; i++) {			
			mt.typeA();
			mt.typeB(i);
		}
		
		System.out.println("고정값 : " + mt.typeC());
		System.out.println("가변 값 : " + mt.typeD(2025.08));
		
		Integer in = new Integer(10);
		
		byte b = in.byteValue();
		byte b2 = in.byteValue();
		byte b3 = in.byteValue();
		System.out.println(b + " " + b2 + " " + b3);
	}

}
