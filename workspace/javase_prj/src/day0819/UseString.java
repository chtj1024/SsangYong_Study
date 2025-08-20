package day0819;

/**
 * 문자열(String)의 시작 주소를 저장 할 수 있는 데이터 형인 java.lang.String 클래스를 사용. 문자열은 문자열
 * 저장소(String literal)에 유일하게 저장 된다.
 */
public class UseString {

	public void useString() {
		// 기본형 형식 사용. String str = "문자열";
		String str = "abc";
		// 참조형 형식 사용 String str = new String("문자열");
		String str2 = new String("abc");

		// 관계연산자 ==을 사용하여 비교하면 기본형과 참조형이 다른 결과가 나온다.
		System.out.println("기본형 형식 " + str + " / " + (str == "abc"));
		System.out.println("기본형 형식 " + str2 + " / " + (str2 == "abc"));
		System.out.println("--------------------");
		// equals method를 사용하면 기본형, 참조형 같은 결과가 나온다.
		System.out.println("기본형 형식 " + str + " / " + (str.equals("abc")));
		System.out.println("기본형 형식 " + str2 + " / " + (str2.equals("abc")));

		String temp = "abcDeFg";
		String email = new String("chlqnftkwh@naver.com");
		System.out.println(temp);
		System.out.println(email);

		System.out.println("\"안녕하세요?\"" + " 의 글자수 : " + "안녕하세요?".length());
		System.out.println(temp + " 의 글자수 : " + temp.length());
		System.out.println(email + " 의 글자수 : " + email.length());

		System.out.println(temp + "를 모두 대문자로 " + temp.toUpperCase());
		System.out.println(email + "를 모두 대문자로 " + email.toUpperCase());

		System.out.println(temp + "에서 3번째 인덱스에 해당하는 문자 : " + temp.charAt(3));
		System.out.println(email + "에서 11번째 인덱스에 해당하는 문자 : " + email.charAt(11));
		
		System.out.println(temp + "에서 \"e\"에 해당하는 인덱스 : " + temp.indexOf("e"));
		System.out.println(temp + "에서 \"e\"에 해당하는 인덱스 : " + temp.indexOf("DeF"));
		System.out.println(temp + "에서 \"e\"에 해당하는 인덱스 : " + temp.indexOf("K"));
		
		temp = "java oracle";
		
		System.out.println(temp + "에서 뒤에서 문자열 \"a\"에 해당하는 인덱스 : " + temp.lastIndexOf("a"));
		
	}

	/**
	 * 입력되는 email의 유효성 검증을 수행하고 유효하면 true반환, 무효하면 false 반환하는
	 * 일을 코드로 작성
	 * 유효성 : 이메일의 길이는 5자 이상이어야하고, 이메일 @, '.'이 포함되어 있어야 한다.
	 *  "@"먼저 나와야하고, "."은 나중에 나와야한다. 만족 true, 불만족 false 반환
	 * @param email 유효성 검증할 이메일
	 * @return 결과
	 */
	public boolean validateEmail(String email) {
		
//		boolean check = false;
//		
//		if (email.length() >= 5) {
//			if (email.contains("@") && email.contains(".")) {
//				if (email.indexOf("@") < email.indexOf(".")) {
//					check = true;
//				}
//			}
//		}
//		return check;
		
		return email.length() >= 5
		        && email.contains("@")
		        && email.contains(".")
		        && email.indexOf("@") < email.indexOf(".");
	}
	
	public static void main(String[] args) {
		UseString us = new UseString();
		us.useString();
//		new UseString().useString(); // 객체화 후 바로 method 하나 호출 가능
		System.out.println("--------------------");
		String temp = "test@test.com";
		String temp2 = "testtest.com";
		String temp3 = "test@testcom";
		String temp4 = "a@d.c";
		String temp5 = "test.test@com";
		// validateEmail을 호출하여 위에 이메일로 테스트 수행.
		
		System.out.println(temp + " / " + us.validateEmail(temp));
		System.out.println(temp2 + " / " + us.validateEmail(temp2));
		System.out.println(temp3 + " / " + us.validateEmail(temp3));
		System.out.println(temp4 + " / " + us.validateEmail(temp4));
		System.out.println(temp5 + " / " + us.validateEmail(temp5));
		
		temp = "반장 박상현님!";
		System.out.println(temp + "에서 3~5번째 인덱스에 해당하는 하위문자열 "
				+ temp.substring(3, 6));
		System.out.println("-----------------");
		// String email = new String("chlqnftkwh@naver.com");
		// email에서 내 메일주소, 도메인 주소를 잘라서 출력해보기
		String email = "chlqnftkwh@naver.com";
		System.out.println(email.substring(0, email.indexOf("@")));
		System.out.println(email.substring(email.indexOf("@") + 1));
		
		temp = ""; // empty로 초기화
		System.out.println("[" + temp + "] 는 비어있니? " + (temp.length() == 0));
		System.out.println("[" + temp + "] 는 비어있니? " + (temp.isEmpty()));
		
		temp = null; // 문자열 초기화 (null로 초기화)
		System.out.println("[" + temp +"] 는 객체로 생성되지 않았니?" + (temp == null));
		
		temp = "   A BC   ";
		
		System.out.println("[" + temp + "]의 앞, 뒤 공백을 제거 [" + temp.trim() + "]");
		temp = "abc";
		System.out.println(temp + "가 \"abc\"와 같니? [" + temp.equals("abc") + "]");
		
		temp = "서울시 강남구 역삼동";
		temp2 = "서울시 동대문구 동대문동";
		temp3 = "인천시 계양구 계양동";
		System.out.println(temp + "는 서울인가? " + temp.startsWith("서울시"));
		System.out.println(temp2 + "는 서울인가? " + temp2.startsWith("서울시"));
		System.out.println(temp3 + "는 서울인가? " + temp3.startsWith("서울시"));
		
		temp3 = "인천시 계양구 계양리";
		System.out.println(temp + "는 동인가? " + temp.endsWith("동"));
		System.out.println(temp2 + "는 동인가? " + temp2.endsWith("동"));
		System.out.println(temp3 + "는 동인가? " + temp3.endsWith("동"));
		
		temp3 = "인천시 강남구 계양동";
		System.out.println(temp + "는 \"강남구\"를 포함하고 있는가? " + temp.contains("강남구"));
		System.out.println(temp2 + "는 \"강남구\"를 포함하고 있는가? " + temp2.contains("강남구"));
		System.out.println(temp3 + "는 \"강남구\"를 포함하고 있는가? " + temp3.contains("강남구"));
		
		temp = "나 지금 피씨방이야 넌 어디니 씨방새야";
		if (temp.contains("씨방새")) {
			temp = "유저님 고운말을 써주세요.";
		}
		System.out.println(temp);
		
		temp = "Java Oracle";
		System.out.println(temp + "에서 'a'를 'A'로 변경" + temp.replace("a", "A"));
		System.out.println(temp + "에서 'a'를 'A'로 변경" + temp.replace("a", "AAA"));
		
		temp = "Java Oracle";
		System.out.println("[" + temp + "]에서 모든 공백 제거 [" + temp.replace(" ", "") + "]");
		
		temp = "나 지금 피씨방이야 넌 어디니 씨방새야";
		temp = temp.replace("씨", "*").replace("방", "*").replace("새", "*");

		System.out.println(temp);
		
		temp = "오늘은";
		temp2 = " 화요일 입니다.";
		temp3 = temp.concat(temp2);
		System.out.println(temp3);
		
		int year = 2025;
		int month = 8;
		int day = 19;
		
		String name = "최태준";
		double height = 171;
		String msg = String.format("오늘은 %d년 %d월 %d일 입니다. 내이름은 %s입니다. 키는 %.1fcm",
				year, month, day, name, height);
		System.out.println(msg);
		
		temp = String.valueOf(year);
		System.out.println(temp);
	}
}
