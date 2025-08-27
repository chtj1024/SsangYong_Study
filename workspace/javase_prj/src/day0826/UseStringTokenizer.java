package day0826;

import java.util.StringTokenizer;

public class UseStringTokenizer {
	
	public void useStringTokenizer() {
		String data = "자바 오라클 JDBC HTML CSS JavaScript";
		StringTokenizer st = new StringTokenizer(data);
		
		System.out.println("토큰의 수" + st.countTokens());
//		System.out.println(st.hasMoreTokens());
//		System.out.println(st.nextToken());
//		System.out.println("토큰의 수" + st.countTokens());
		
//		System.out.println(st.hasMoreTokens());
//		System.out.println(st.nextToken());
//		
//		System.out.println(st.hasMoreTokens());
//		System.out.println(st.nextToken());
//		
//		System.out.println(st.hasMoreTokens());
//		System.out.println(st.nextToken());
//		
//		System.out.println(st.hasMoreTokens());
//		System.out.println(st.nextToken());
	}
	
	public void useStringTokenizer2() {
		String data = "Java SE,Oracle DBMS,JDBC,HTML.CSS.JavaScript,Java EE,XML.JSON";
		StringTokenizer st = new StringTokenizer(data, ",.", true);
		System.out.println(st.countTokens());
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
	
	String data = "서울시 강남구 역삼동,서울시 동대문구 동대문동,인천시 부평구 부평동.개포동 강남구 서울시~서초구 서울시 서초동";
	//위의 데이터를 String 배열로 만들어서 반환하는 일을 하는 method를 작성하고
	// 호출하는 곳에서 배열을 받아서 모든 방의 값을 출력하고
	// 서울시의 개수를 출력하는 일.
	
	// method 2개가 만들어져야 함. 1. 배열로 반환한 일 2. 배열의 값과 서울시의 개수를 출력하는 일
	// main method에서 2번 method를 호출하여 출력
	
	public String[] returnArray(String data) {
		StringTokenizer st = new StringTokenizer(data, ",.~");
		String[] address = new String[st.countTokens()];
		for(int i = 0; i < address.length; i++) {
			address[i] = st.nextToken();
		}
		return address;
	}
	
	public void printSeoulCnt(String[] address) {
		int cnt = 0;
		for (String ele : address) {
			if (ele.contains("서울시")) {
				cnt++;
			}
		}
		System.out.println("서울시의 개수 : " + cnt);
		
	}
	
	
	public static void main(String[] args) {
		UseStringTokenizer ust = new UseStringTokenizer();
		ust.useStringTokenizer();
		System.out.println("--------------------");
		ust.useStringTokenizer2();
		System.out.println("--------------------");
		
		String[] address = ust.returnArray(ust.data);
		ust.printSeoulCnt(address);
		
	}
}
