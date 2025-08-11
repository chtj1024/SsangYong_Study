package day0806;
/**
지역변수의 사용법을 알기위한 클래스.
*/

class UseLocalVariable {
	
	/**
	Java Application으로 클래스를 만들기 위해서 main method를 선언
	*/
	public static void main(String[] args) {
		//지역변수 사용.
		
		//1. 선언 : 데이터형 변수명; 자동초기화가 되지 않음.
		int myAge;
		myAge = 25;
		
		//String today;
		//2. 값 할당)
		//today = "25.08.06";
		String today = "25.08.06";
		today = "25.08.07";
		
		//3. 값 사용) : 출력, 연산, 재할당
		System.out.println("내 나이는" + myAge + "살");
		System.out.println(today);
		
		today = "25.08.08";
		System.out.println(today);
		
		//하나의 영역에서는 같은 이름의 변수를 선언할 수 없다.
		//int myAge;
		
		UseLocalVariable ulv = new UseLocalVariable();
		System.out.println(ulv);
	}
}
