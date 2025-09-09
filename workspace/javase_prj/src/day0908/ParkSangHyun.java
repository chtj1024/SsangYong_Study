package day0908;

import java.util.Random;

/**
 * 흡연자를 보고 참지 않는다.
 */
public class ParkSangHyun{
	
	public String walk() throws Exception {
		String result = "";
		String[] schoolGrade = "초딩,중딩,고딩".split(",");
		
		int gradeNum = new Random().nextInt(schoolGrade.length);
		
		if(gradeNum == 0) {
			//특정 조건에서 예외 강제로 발생 : throw new 예외처리클래스
//			try {
			throw new Exception("초딩님 지나친 흡연은 건강에 좋지 않습니다.");
//			} catch () {
//				
//			}
		}
		result = schoolGrade[gradeNum] + "님 흡연중 ('' )( '') 모른 척 지나간다.";
		
		return result;
	}
	
	/**
	 * 사용자 정의 예외처리 클래스를 사용하면 가독성이 향상된다.
	 * @return
	 * @throws TabaccoException
	 */
	public String walk2() throws TabaccoException {
		String result = "";
		String[] schoolGrade = "초딩,중딩,고딩".split(",");
		
		int gradeNum = new Random().nextInt(schoolGrade.length);
		
		if(gradeNum == 0) {
			//특정 조건에서 예외 강제로 발생 : throw new 예외처리클래스
			throw new TabaccoException();
		}
		result = schoolGrade[gradeNum] + "님 흡연중 ('' )( '') 모른 척 지나간다.";
		
		return result;
	}
	
	public static void main(String[] args) {
		ParkSangHyun psh = new ParkSangHyun();
		try {
			// method안에서 발생된 예외를 호출하는 곳에서 잡아서 처리한다.
			System.out.println(psh.walk());
		} catch (Exception e) { // 걷는데 문제가 발생 -> 어떤 문제인지 알 수 없다.
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("----------------------------");
		try {
			// method안에서 발생된 예외를 호출하는 곳에서 잡아서 처리한다.
			System.out.println(psh.walk2());
		} catch (TabaccoException e) { // 걷는데 담배에 대한 문제 발생
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
