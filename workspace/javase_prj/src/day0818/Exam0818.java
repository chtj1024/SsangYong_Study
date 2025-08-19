package day0818;

/**
 * 너구리, 신라면, 안성탕면의 객체 모델링 후, 클래스 작성, 객체 생성, 제공하는 기능을 사용하기
 * 추상화 : 공통특징만 들어가야 한다.
 */
class Lamen {
	
	public String cook (int soup, int noodles, String name){
		
		return name + "의 요리가 완성되었습니다.";
	}
}

public class Exam0818 {
	public static void main(String[] args) {
		Lamen lm = new Lamen();
		
		String cook = lm.cook(1, 1, "Nuguri");
		System.out.println(cook);
	}
}
