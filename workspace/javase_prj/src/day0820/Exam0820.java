package day0820;

/**
 * 문제
 * 1. "test@test.com, kim@sist.co.kr, lee12@naver.com, parktest.com, kim123@com,
 *  test1234@gmail.com"
 *  CSV데이터를 배열로 만들고, 2번 method에 배열 값을 넣어서 반환되는 메세지를
 *  console에 출력
 *  
 * 2. 이메일의 유효성 검증하여 결과를 문자열로 반환하는 method 작성
 * 유효성 :
 *  글자수가 5자 이하면 - 메일의 글자 수가 충분하지 못합니다.
 *  @ 없으면 - 메일에 @이 없습니다.
 *  . 없으면 - 메일에 '.'이 없습니다.
 *  @.의 순서가 바뀌었다면 - @과 .의 순서가 맞지 않습니다.
 *  
 *  모든 유효성을 만족하면 "유효한 메일"을 반환.
 *  
 * 3. 1번 메일 주소에서 유효한 메일 주소의 개수를 출력 (4개)
 * 
 * 4. 유효한 메일 중에 gTLD(com)의 개수 출력
 */
class email {
	int validEmailCnt;
	int validGTLDCnt;
	
	public String emailCheck(String email) {
		String outStr = "";
		if (email.length() <= 5) {
			outStr = "메일의 글자수가 충분하지 못합니다.";
		} else if (!email.contains("@")) {
			outStr = "메일에 @이 없습니다.";
		} else if (!email.contains(".")) {
			outStr = "메일에 .이 없습니다.";
		} else if (email.indexOf("@") > email.indexOf(".")) {
			outStr = "@과 .의 순서가 맞지 않습니다";
		} else {
			outStr = "유효한 메일";
			validEmailCnt++;
			if (email.contains("com")) validGTLDCnt++;
		}
		return outStr;
	}
}

public class Exam0820 {
	
	public static void main(String[] args) {
		String email = "test@test.com,kim@sist.co.kr,lee12@naver.com,parktest.com,kim123@com,test1234@gmail.com";
		String[] emailArr = email.split(",");
		
		email e = new email();
		for (String element : emailArr) {
			System.out.println(e.emailCheck(element));
		}
		System.out.println("----------");
		System.out.println("유효한 메일 주소 개수 : " + e.validEmailCnt);
		System.out.println("유효한 메일 중 gTLD의 개수 : " + e.validGTLDCnt);
		
	}
}
