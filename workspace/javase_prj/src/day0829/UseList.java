package day0829;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * java.util.List의 사용
 * 검색의 기능이 있으며, 입력되는 값은 순차적으로 처리된다. 중복값 저장.
 */
public class UseList {
	
	public void useArrayList() {
		List<String> list = new ArrayList<String>(); // 동시 사용 가능
		list.add("안녕하세요");
		list.add("오늘은");
		list.add("금요일");
		list.add("내일도");
		list.add("금요일");
		
		
		//리스트의 모든 방의 값 얻기
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		// Iterator를 사용할 수 있다.
		System.out.println("--Iterator사용--");
		Iterator<String> ita = list.iterator();
		while(ita.hasNext()) {
			System.out.println(ita.next());
		}
		
		for(String ele : list) {
			System.out.println(ele);
		}
		
		// 배열로 복사
		String[] strArr = new String[list.size()];
		list.toArray(strArr);
		
		//리스트의 방의 값 삭제
		list.remove(1);
		// 중복 값이 있다면 L -> R 처음 일치하는 값만 삭제
		list.remove("금요일");
		list.clear();
		
		System.out.println(list.size() + " / " + list);
		System.out.println(strArr + " / " + Arrays.toString(strArr));
		
//		List<int> list2 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<Integer>();
		Integer i = Integer.valueOf(2025);
		System.out.println(i.hashCode()); // toString() Override 
		int j = 8;
//		System.out.println(j.hashCode()); // 기본형은 method를 호출할 수 없다.
		System.out.println(j);
		
		list2.add(i); // Integer 매개변수 선언 => Integer
		list2.add(j); // Integer 매개변수 선언 => int? autoboxing
		list2.add(Integer.valueOf(i));
		
		Integer i2 = list2.get(0);
		int j2 = list2.get(0);
		
		int j3 = list2.get(0).intValue();
		System.out.println(list2);
		System.out.println(i2 + " / " + j2 + " / " + j3);
	}
	
	public void useVector() {
		List<String> list = new Vector<String>(); // 동시접속 차단
		list.add("안녕하세요");
		list.add("오늘은");
		list.add("금요일");
		list.add("내일도");
		list.add("금요일");
		
		
		//리스트의 모든 방의 값 얻기
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		for(String ele : list) {
			System.out.println(ele);
		}
		
		// 배열로 복사
		String[] strArr = new String[list.size()];
		list.toArray(strArr);
		
		//리스트의 방의 값 삭제
		list.remove(1);
		// 중복 값이 있다면 L -> R 처음 일치하는 값만 삭제
		list.remove("금요일");
		list.clear();
		
		System.out.println(list.size() + " / " + list);
		System.out.println(strArr + " / " + Arrays.toString(strArr));
	}
	
	public void useLinkedList() {
		// 추가되는 데이터가 기존에 데이터 사이에 추가되는 일이 빈번하게 발생할 때
		List<String> list = new LinkedList<String>();
		list.add("java");
		list.add("oracle");
		list.add("JDBC");
		list.add("HTML");
		
//		list.add(1, "CSS");
		
		
		//리스트의 모든 방의 값 얻기
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		for(String ele : list) {
			System.out.println(ele);
		}
		
		// 배열로 복사
		String[] strArr = new String[list.size()];
		list.toArray(strArr);
		
		//리스트의 방의 값 삭제
		list.remove(1);
		// 중복 값이 있다면 L -> R 처음 일치하는 값만 삭제
		list.remove("금요일");
		list.clear();
		
		System.out.println(list.size() + " / " + list);
		System.out.println(strArr + " / " + Arrays.toString(strArr));
	}
	
	public static void main(String[] args) {
		UseList ul = new UseList();
		System.out.println("--ArrayList");
		ul.useArrayList();
		System.out.println("--Vector");
		ul.useVector();
		System.out.println("--LinekdList");
		ul.useLinkedList();
	}
}
