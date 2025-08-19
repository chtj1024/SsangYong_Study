package day0818;

/**
 * 사람을 사용하기위해 사람을 대상으로 추상화를 해낸 클래스를 사용하는 클래스 
 */
public class UsePerson {

	/**
	 * java application
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println( args );
		
		Person ogong=new Person();//눈 2개,코 1개 입 1개인 손오공 객체생성
		Person jinban=new Person(3, 1, 1);//눈 3개,코 1개 입 1개인 천진반 객체생성
		ogong.setName("손오공");
		jinban.setName("천진반");
		
		//ogong 객체가 가진 눈,코,입의 개수와 이름을 콘솔 출력
		System.out.printf("눈 %d개, 코 %d개, 입 %d개 이름 %s\n", ogong.getEye(),
				ogong.getNose(), ogong.getMouth(), ogong.getName());
		//jinban 객체가 가진 눈,코,입의 개수와 이름을 콘솔 출력
		System.out.printf("눈 %d개, 코 %d개, 입 %d개 이름 %s\n", jinban.getEye(),
				jinban.getNose(), jinban.getMouth(), jinban.getName());

		//4.객체 생성 : 사람이 태어남. ( 눈,코,입 x )
		Person hongGilDong=new Person(); //인스턴스변수가 초기화
		Person clark=new Person();
		//5.객체 사용.( 객체가 제공하는 기능을 사용)
		
		//객체가 가지고 있어야할 기본 값을 설정.
		//태어난 이후에 눈,코,입을 설정
//		hongGilDong.setEye(2);
//		hongGilDong.setNose(1);
//		hongGilDong.setMouth(1);
		hongGilDong.setName("홍길동");
		
//		clark.setEye(2);
//		clark.setNose(1);
//		clark.setMouth(1);
		clark.setName("클락");
		
		System.out.println(hongGilDong.eat());
		System.out.println(clark.eat());
		
		System.out.println( hongGilDong.eat("국밥",1));
		System.out.println( clark.eat("스테이크",10));
		
		
	}//main

}//class
