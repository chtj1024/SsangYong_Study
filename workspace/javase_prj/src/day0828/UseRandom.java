package day0828;

import java.util.Random;

/**
 * 난수를 얻기위한 클래스
 */
public class UseRandom {
	
	public UseRandom() {
		Random r = new Random();
		Random r2 = new Random(2023L); // 시드 랜덤
		
//		System.out.println(r.nextInt());
//		System.out.println(r.nextInt());
//		System.out.println(r.nextInt());
//		System.out.println(r.nextInt());
		System.out.println(r.nextInt()); // 다음 수 예측가능
		System.out.println(r2.nextInt());
		int i = r.nextInt();
		System.out.println("발생한 수 : " + i);
		System.out.println("범위 수 : " + i % 10);
		System.out.println("범위 수를 양수로 얻기 : " + Math.abs(i % 10));
		
		int j = r.nextInt(10);
		System.out.println("범위 수 얻기 : " + j);
		
		double d  = r.nextDouble();
		System.out.println("발생한 수 : " + d);
		System.out.println("발생한 수 > 범위 수: " + d*10);
		System.out.println("발생한 수 > 범위 수 > 정수 : " + (int)(d*10));
		
		boolean flag = r.nextBoolean();
		boolean flag2 = r.nextBoolean();
		System.out.println(flag);
		System.out.println(flag2);
	}
	
	public static void main(String[] args) {
		new UseRandom();
	}
}
