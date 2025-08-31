package day0829;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 검색기능 x. 중복값 저장x, 값은 순서대로 입력되지 않는다.
 */
public class UseSet {
	
	public UseSet() {
		
		Set<String> set = new HashSet<String>();
		
		// 순서대로 저장 안됌
		set.add("Java");
		set.add("Oracle");
		set.add("JDBC");
		set.add("HTML");
		set.add("CSS");
		set.add("Java"); // 중복 값 저장 x 덮어쓰는 형식으로 저장안하는 것
		System.out.println(set.size() + " / " + set);
		
		Iterator<String> ita = set.iterator();
		String element = "";
		while (ita.hasNext()) {
			element = ita.next();
			System.out.println(element);
		}
		System.out.println("--개선된 for--");
		for(String temp : set) {
			System.out.println(temp);
		}
		
		String[] strArr = new String[set.size()];
		set.toArray(strArr);
		
		//삭제
		set.remove("JDBC");
		set.clear();
		
		System.out.println(set.size() + " / " + set);
		System.out.println(Arrays.toString(strArr));
	}
	
	public static void main(String[] args) {
		new UseSet();
	}
}
