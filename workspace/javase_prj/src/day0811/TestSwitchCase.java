package day0811;

/**
 *	switch~case : 일치하는 정수를 비교하기위해 만들어진 조건문
 */
public class TestSwitchCase {
	
	public static final int ADD_EMP = 0;
	public static final int MODIFY_EMP = 1;
	public static final int SEARCH_EMP = 2;
	
	public static void main(String[] args) {
//		char i = 'B';
//		switch(i) {
//			case 'A' : System.out.println("영");
//			case 66 : System.out.println("일");
//			case 2 : System.out.println("이");
//		default : System.out.println("해당 case 없음");
//		}
		
		//JDK1.7에서부터는 Switch가 문자열을 비교할 수 있게 기능이 추가되었다.
		String i = "자바";
		switch(i) {
		case "자바" : System.out.println("영");
		case "C" : System.out.println("일");
		case "Python" : System.out.println("이");
		default : System.out.println("해당 case 없음");
		}
		
		System.out.println("--------------------");
		
		int ind = 2;
		switch(ind) {
		case ADD_EMP : add(); break;
		case MODIFY_EMP : modify(); break;
		case SEARCH_EMP : search(); break;
		default : System.out.println("해당 case 없음");
		}
	}
	
	public static void add() {
		System.out.println("추가");
	}
	public static void modify() {
		System.out.println("수정");
	}
	public static void search() {
		System.out.println("검색");
	}
	
}
