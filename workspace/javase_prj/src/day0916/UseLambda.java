package day0916;

import java.util.Random;

import day0901.StudentDTO;

public class UseLambda{
	
	public UseLambda() {
		MethodType mt = () -> {
			Random ran = new Random();
			int num = ran.nextInt(10);
			System.out.println(num);
		};
		
		//호출
		mt.typeA();
		System.out.println("---반환형 없고 매개변수 있는 형---");
		//데이터 형부터 기술할때에는 매개변수명이 달라도 된다.
		//데이터 형은 생략가능
//		MethodType2 mt2 = (StudentDTO s, Name n) -> {
		MethodType2 mt2 = (s, n) -> {
			System.out.println("DTO객체 : " + s.getName() + ", " + s.getAge());
			System.out.println("단일형 : " + n);
		};
		
		//호출
		StudentDTO sDTO = new StudentDTO("신용권", 20);
		
		mt2.typeB(sDTO, "테스트");
		
		System.out.println("---반환형 있고 매개변수 없는 형---");
		
		MethodType3 mt3 = () -> {
			StudentDTO sDTO2 = new StudentDTO("루피", 21);
			return sDTO2;
		};
		
		StudentDTO sDTO3 = mt3.typeC();
		System.out.println(sDTO3);
		
		System.out.println("---반환형 있고 매개변수 있는 형---");
		MethodType4 mt4 = (double d) -> {
			return (int)d;
		};
		
		int i = mt4.typeD(2025.09);
		System.out.println(i);
		
		//Thread로 1~100까지 옆으로 출력하는 코드를 Lambda식으로 구현.
//		Runnable run = () -> {
//			for(int i2 = 1; i2 <= 100; i2++) {
//				System.out.printf("%d ", i2);
//			}
//		};
		
//		Thread t = new Thread(run);
//		t.start();
//		Thread t2 = new Thread(run);
//		t2.start();
		
		Thread t = new Thread(() -> {
			for(int i2 = 1; i2 < 100; i2++) {
				System.out.print(i2 + " ");
			}
		});
		t.start();
		
		System.out.println("\n------------------------\n");
		new Thread( () -> {
			for(int i2 = 1; i2 <= 100; i2++) {
				System.out.printf("%d ", i2);
			}
		}).start();
	}
	
	
	public static void main(String[] args) {
		 new UseLambda();
	}

}
