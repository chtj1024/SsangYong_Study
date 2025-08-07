/**
 쉬프트 연산자 : 비트 밀기 연산 
*/

class Operator3 {
	public static void main(String[] args) {
		int i = 25;
		
		System.out.println(i + " << 3 = " + (i << 3));
		// 25는 이진수로 0001 1001(2) 세 번 왼쪽으로 밀면
		// 1100 1000 == 200(10) 이 나옴
		System.out.println(Integer.toBinaryString(35 >> 2));
		
		i = 40;
		System.out.println(i + " >> 2 = " + (i >> 2));
		
		i = 50;
		System.out.println( i + " >>> 2 = " + (i >> 2));
		
		i = 1;
		System.out.println( i << 32);
		
		i = -1; //
		System.out.println( i >> 100);
		
		System.out.println( i >>> 1);
		
		// 255가 되도록 i를 밀어보기
		System.out.println( i >>> 24);
		
		System.out.println(Integer.toBinaryString(-(Integer.MAX_VALUE)));


	}
}
