package day0811;

/**
 * else if(다중 if) : 연관된 여러 조건을 비교할 때 사용.
 */
public class TestElseIf {
	
	public static void main(String[] args) {
		
		int score = Integer.parseInt(args[0]);
		System.out.print( score + "점은 ");
		// 점수에 대한 유효성 검증
		if(score < 0) {
			System.out.println("0 보다 작아서 실패");
		} else if (score > 100) {
			System.out.println("100 보다 커서 실패");
		} else {
			System.out.println("유효점수");
		}
		
		// 0-원숭이, 1-닭, 2-개, 3-돼지, 4-쥐, 5-소, 6-호랑이,
		// 7-토끼, 8-용, 9-뱀, 10-말, 11-양
				
		// 태어난해를 저장하는 변수를 만들고, args[1]의 값을 할당하고
		// 태어난 해에 대한 띠를 콘솔에 출력하는 코드를 작성.
				
		int twelve = Integer.parseInt(args[1]);
		String result = "";
//		if (twelve % 12 == 0) result = "양";
//		else if (twelve % 11 == 0) result = "말";
//		else if (twelve % 10 == 0) result = "뱀";
//		else if (twelve % 9 == 0) result = "용";
//		else if (twelve % 8 == 0) result = "토끼";
//		else if (twelve % 7 == 0) result = "호랑이";
//		else if (twelve % 6 == 0) result = "소";
//		else if (twelve % 5 == 0) result = "쥐";
//		else if (twelve % 4 == 0) result = "돼지";
//		else if (twelve % 3 == 0) result = "개";
//		else if (twelve % 2 == 0) result = "닭";
//		else if (twelve % 1 == 0) result = "원숭이";
		
		if (twelve % 12 == 0) result = "양";
		else if (twelve % 12 == 11) result = "말";
		else if (twelve % 12 == 10) result = "뱀";
		else if (twelve % 12 == 9) result = "용";
		else if (twelve % 12 == 8) result = "토끼";
		else if (twelve % 12 == 7) result = "호랑이";
		else if (twelve % 12 == 6) result = "소";
		else if (twelve % 12 == 5) result = "쥐";
		else if (twelve % 12 == 4) result = "돼지";
		else if (twelve % 12 == 3) result = "개";
		else if (twelve % 12 == 2) result = "닭";
		else if (twelve % 12 == 1) result = "원숭이";
		
		System.out.println(result);
	}
}
