package day0808;



public class Exam0808 {
	public static void main(String[] args) {
		int arg1 = Integer.parseInt(args[0]);
		int arg2 = Integer.parseInt(args[1]);
		
		System.out.println(arg1 > arg2 ? arg1 : arg2);
		
		int num1 = 3;
		int num2 = 8;
		int num3 = -2;
		int minNum = num1 < num2 ? num1 : num2;
		
		System.out.println(minNum < num3 ? minNum : num3);
		
		int temp = 10;
		int temp2 = 20;
		
		System.out.println(++temp + temp2--);
		// temp는 먼저 계산되어 11이 되고, temp2는 20이 더해지고 31이 출력되며
		// temp2는 이후 계산되어 19가 된다. 
		System.out.println("temp: " + temp + ",temp2: " + temp2);
		
		System.out.println(Integer.MAX_VALUE >> 15);
	}
}
