package day1002;

/**
 * 업무를 사용하는 클래스
 */
public class RunWork {
	
	public static void main(String[] args) {
		
		Work work = new Work();
		System.out.println("행운의 번호 : " + work.randomNumber());
		
		String msg = "이번 한가위 명절은 프로젝트와 함께";
		
		try {
			System.out.println(work.sub(msg));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
