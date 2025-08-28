package day0828;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Generic을 사용하지 않는 List (권장하지 않는다.)
 */
public class UseList {
	
	public UseList() {
		
		List list = new ArrayList();
		
		list.add(2);
		list.add('A');
		list.add("안녕하세요?");
		list.add(2025.08);
		list.add(true);
		list.add(new Date());
		System.out.println(list.size());
		
//		int i = (int) list.get(1);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)); // Overloaing된 method이므로 에러가 발생하지 않는다.
		}
		
	}
	
	public static void main(String[] args) {
		new UseList();
	}
}
