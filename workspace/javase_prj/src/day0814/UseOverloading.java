package day0814;

/**
 * Overload
 * 하나의 클래스에서 같은 이름의 method를 여러개 만들기
 */
public class UseOverloading {
	
	/**
	 * 콘솔에 별을 하나 출력하는 일.
	 */
	public void printStar() {
		System.out.println("☆");
	}
	
	/**
	 * 입력되는 수만큼 콘솔에 별을 출력하는 일
	 * Overloading된 method
	 * @param cnt 출력 할 별의 개수
	 */
	public void printStar(int cnt) {
		for (int i = 0; i < cnt; i++) {
			System.out.print("★");			
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		UseOverloading uo = new UseOverloading();
//		uo.printStar();
//		uo.printStar(5);
		
		for (int i = 1; i <= 5; i++) {
			uo.printStar(i);
		}
	}
}
