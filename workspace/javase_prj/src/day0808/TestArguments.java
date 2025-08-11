package day0808;

/**
 * main method의 argumetns 받기.
 */
public class TestArguments {
	
	public static void main(String[] args) {
		
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
			
		System.out.println(args[0] + args[1]);
		
		int i = Integer.parseInt(args[0]);
		int j = Integer.parseInt(args[1]);
		System.out.println(i + j);
		
//		int k = Integer.valueOf(args[0]); // unboxing
	}
}
