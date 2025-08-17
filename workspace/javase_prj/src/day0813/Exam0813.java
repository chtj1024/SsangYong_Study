package day0813;

/*
 * 아래 일을 할 수 있는 instance method를 구현하고 호출해보세요.
 * 
 * 1. 자신의 이름을 콘솔에 출력하는 method. - 고정일
 *
 * 2. 자신의 "성씨"를 반환하는 method. - 고정값
 * 
 * 3. 점수를 입력받아서 점수의 판정을 콘솔에 출력하는 method. - 가변일
 * 점수는 0 ~ 100 사이일 때만 판정을 한다. 그렇지 않으면 "잘못된 점수"를 출력 (유효성 검증)
 * 0~39 점 : 과락, 40~59점 : "다른 과목 참조", 60~100 : "합격" 출력
 * Flow Chart도 그림
 * 
 * 4. 문자를 입력받아서 해당 문자가 "대문자"인지 "소문자"인지 "숫자"인지 판단하여 콘솔에
 * 출력하는 일 - 가변일 
 * 출력형식) 'A'가 입력되면 -> "A는 대문자" 형식으로 출력되게
 * 
 * 5. 태어난 해를 입력받아 나이를 반환하는 일 method - 가변 값 
 * 
 * 6. 정수로 월, 월의 끝일, 1일의 요일의 숫자를 입력받아서 달력을 콘솔에
 * 출력하는 일 method - 가변일
 * 
 * 예) printCalendar( 8, 31, 6 )
 *  일1, 월2, 화3, 수4, 목5, 금6, 토7 이면 8월은 금요일부터 1일이니까 6넣음.
 */


public class Exam0813 {
	
	public void myName() {
		System.out.println("제 이름은 최태준입니다.");
	}
	
	public String myLast() {
		return "최";
	}
	
	public void point(int num) {
		if (num >= 0 && num <= 39) {
			System.out.println("과락");
		} else if (num >= 40 && num <= 59) {
			System.out.println("다른 과목 참조");
		} else if (num >= 60 && num <= 100) {
			System.out.println("합격");
		} else {
			System.out.println("잘못된 점수");
		}
	}
	
	public void judgment(char what) {
		if (Character.isDigit(what)) {
			System.out.println(what + "은(는) 숫자");
		} else {
			if (Character.isUpperCase(what)) {
				System.out.println(what + "은(는) 대문자");
			} else {
				System.out.println(what + "은(는) 소문자");
			}
		}
	}
	
	public int myBirth(int num) {
		return 2025 - num;
	}
	
	public void calendar(int m, int start, int one) {
		System.out.println("\t\t\t" + m + "월");
		for (int i = 0; i < one - 1; i++) {
			System.out.print("\t");
		}
		for (int i = 1; i <= 31; i++) {
			System.out.print(i + "\t");
			if ((i - 2) % 7 == 0) {
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		Exam0813 exam = new Exam0813();
		exam.myName();
		System.out.println(exam.myLast());
		exam.point(132);
		exam.judgment('4');
		System.out.println("나이는 " + exam.myBirth(1996) + "입니다." );
		exam.calendar(8, 31, 6);
	}
}
