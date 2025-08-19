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

	public static void main(String[] args) {
//		UseString us = new UseString();
//		us.useString();

		new UseString().useString(); // 객체화 후 바로 method 하나 호출 가능
	}
}
