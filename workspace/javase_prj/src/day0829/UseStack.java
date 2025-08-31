package day0829;

import java.util.Stack;

/**
 * LIFO를 구현
 */
public class UseStack {
	
	public UseStack() {
		Stack<String> stack = new Stack<String>(); // Vector를 활용을 한다.
//		stack.add("헤헷");
//		stack.add("데헷");
//		stack.add("포항항"); // 부모의 method는 사용하지 않는다.
		
		stack.push("되세요.");
		stack.push("즐거운 주말");
		stack.push("오늘은 금요일");
		System.out.println(stack.empty());
		
		Stack<String> stk2 = new Stack<String>();
		String item = "";
		while(!stack.empty()) {
			item = stack.pop();
			stk2.push(item);
			System.out.println(item);
		}
		
		System.out.println(stack);
		System.out.println(stk2);
	}
	
	public static void main(String[] args) {
		new UseStack();
	}
}
