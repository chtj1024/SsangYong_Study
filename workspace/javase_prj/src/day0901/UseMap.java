package day0901;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UseMap {
	
	/**
	 * 동기화 x, 16개의 행 자동 생성
	 */
	public void useHashMap() {
		//1. 생성
		Map<String, String> map = new HashMap<String, String>();
		
		//2. 값 할당)- 입력값은 순서대로 추가되지 않음.
		map.put("java", "완벽한 OOP언어");
		map.put("Oracle", "대용량데이터를 처리하기 적합한 DBMS");
		map.put("JDBC", "Java와 DBMS를 연동하기 위한 저수준 API");
		map.put("HTML", "웹 프로그래밍 구조를 담당");
		
		//키를 입력하면 기존의 key에 값을 덮어 쓴다.
		map.put("java", "WORA- 한 번 작성에 어떤 oS환경에서든 소스코드 수정 없이 사용가능.");
		
		System.out.println("값 얻기");
		String key = "java";
		System.out.println(key + "가 존재하니?" + map.containsKey(key));
		String value = map.get(key);
		if (value != null) { // 키로 검색된 값이 존재하면
			System.out.println(key +"에 대한 값 : " + value);
		}
		
		key = "Java";
		System.out.println(key + "가 존재하니?" + map.containsKey(key));
		if (map.containsKey(key)) { // 키가 존재하면 map에서 값을 얻는다.
			value = map.get(key);
			System.out.println(key +"에 대한 값 : " + value);
		}
		System.out.println(map.size() + " / " + map);
		
		Set<String> keySet = map.keySet();
		System.out.println(keySet);
		Iterator<String> ita = keySet.iterator();
		// 맵의 모든 키와 값을 콘솔에 출력해보세요. 키 / 값
		while(ita.hasNext()) {
			// pointer에 관련 된 method는 한 번 호출하면 다음으로 이동하게 된다.
			key = ita.next(); // 포인터는 한 번만 이동시키고
			System.out.println(key +" / " + map.get(key)); // 값을 얻는다.
		}
//		System.out.println("--------------");
//		for (Map.Entry<String, String> entry : map.entrySet()) {
//			System.out.println(entry.getKey() + " / " + entry.getValue());
//		}
		
		System.out.println("삭제 전 : " + map.size() );
		map.remove("java");
		map.clear();
		System.out.println("삭제 후 : " + map.size() );
	}
	/**
	 * 동기화 O, 11개의 행 자동 생성
	 */
	public void useHashtable() {
		Map<String, String> map = new Hashtable<String, String>();
		
		//2. 값 할당)- 입력값은 순서대로 추가되지 않음.
		map.put("java", "완벽한 OOP언어");
		map.put("Oracle", "대용량데이터를 처리하기 적합한 DBMS");
		map.put("JDBC", "Java와 DBMS를 연동하기 위한 저수준 API");
		map.put("HTML", "웹 프로그래밍 구조를 담당");
				
		System.out.println(map);
	}
	
	public static void main(String[] args) {
		UseMap um = new UseMap();
		um.useHashMap();
		System.out.println("----------------------");
		um.useHashtable();
	}
}
