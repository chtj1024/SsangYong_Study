package day0820;

/**
 * 정규식 사용.
 */
public class RegExp {
	
	public RegExp() {
		String msg = "hello!자바 내 전화번호는 010-1234-5678, 내 나이는 25살, 우리집 번지 20-1번지 ";
		msg += "친구 전화번호 010-4321-9876 입니다.";
		System.out.println("원본문자열 " + msg );
		
		System.out.println(msg.replaceAll("(\\d{3})-(\\d{4})-(\\d{4})", "xxx-xxxx-xxxx"));
		// ( )는 그룹이며 제일 왼쪽부터 1번이다
		System.out.println(msg.replaceAll("(\\d{3})-(\\d{4})-(\\d{4})", "$1-xxxx-$3"));
		// 하나만 가리고 싶을 때
		System.out.println(msg.replaceAll("(\\d{3})-(\\d{1})(\\d{3}-\\d{4})", "$1-x$3"));
		// 010-4321-x876 형식으로 출력해보기
		System.out.println(msg.replaceAll("(\\d{3}-\\d{4})-(\\d{1})(\\d{3})", "$1-x$3"));
		// 긍정형 전방탐색(?=문자열)
		System.out.println(msg.replaceAll("(\\d{2})(?=살)", "x"));
		System.out.println(msg.replaceAll("(\\d{2}-\\d{1})(?=번지)", "x"));
		//전방, 후방 탐색을 같이하면 정교해진다.
		System.out.println(msg.replaceAll("(?<=나이는 )(\\d{2})", "x"));
		
		msg = "hello-HELLO-12e3456-자바 ㄱ 힣";
		System.out.println("원본: " + msg);
		System.out.println(msg.replaceAll("[he]", "")); // 각각 글자 패턴매칭
		System.out.println(msg.replaceAll("[a-z]", ""));
		System.out.println(msg.replaceAll("[A-Z]", ""));
		System.out.println(msg.replaceAll("[0-9]", ""));
		System.out.println(msg.replaceAll("[ㄱ-힣]", ""));
		System.out.println(msg.replaceAll("[a-zA-Z0-9ㄱ-힣]", ""));
		System.out.println(msg.replaceAll("[a-zA-Z0-9ㄱ-힣-]", ""));
		msg = "안녕 29a 30b 20A 오늘은 20일 203a 2423b";
		System.out.println(msg.replaceAll("(\\d{2,})(?=[a-zA-Zㄱ-힣])", "x"));
		
		msg = "안녕 hello 오늘은 hell 내일은 heloo";
		System.out.println(msg);
		System.out.println(msg.replaceAll("\\bhello\\b", ""));
		
		msg = "hello 내 이메일은 test@sist.com 입니다.";
		System.out.println(msg);
		System.out.println(msg.replaceAll("\\b[A-Za-z0-9%_+-]+@[A-Za-z0-9.-]{2,}\\.[A-Za-z]{2,}", "xxx@xxx.xxx"));
	}
	
	public static void main(String[] args) {
		RegExp re = new RegExp();
	}
}
