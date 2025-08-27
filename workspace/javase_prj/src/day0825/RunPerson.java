package day0825;

/**
 * 홍길동 클래스와 클락 클래스를 사용하는 일
 */
public class RunPerson {

	public void usePerson() {
		//객체 생성 
		HongGilDong hgd=new HongGilDong();
		//부모 method호출 : 코드의 재 사용성
		hgd.setName("홍길동");
		System.out.printf("%s은 눈 %d, 코 %d 입 %d를 가진 객체 입니다.\n",
				hgd.getName(), hgd.getEye(), hgd.getNose(), hgd.getMouth());
		System.out.println( hgd.eat() );
		System.out.println( hgd.eat("국밥",10) );//식당 > 주막 ,10원 > 10문 => 안맞음.
		//자신 method 호출
		System.out.printf("%s의 싸움 결과 \"%s\"이고 싸움레벨 %d 입니다. \n",
					hgd.getName(), hgd.fight(5), hgd.getLevel());// 6 -> 7
		
		System.out.printf("%s의 싸움 결과 \"%s\"이고 싸움레벨 %d 입니다. \n",
				hgd.getName(), hgd.fight(6), hgd.getLevel());// 7 -> 8
		
		System.out.printf("%s의 싸움 결과 \"%s\"이고 싸움레벨 %d 입니다. \n",
				hgd.getName(), hgd.fight(8), hgd.getLevel());// 8
		
		System.out.printf("%s의 싸움 결과 \"%s\"이고 싸움레벨 %d 입니다. \n",
				hgd.getName(), hgd.fight(9), hgd.getLevel());// 8 -> 7
		
		
		Clark superman=new Clark();
		//부모 클래스의 method 사용
		superman.setName("클락 켄트");
		System.out.printf("%s는 눈 %d, 코 %d 입 %d를 가진 객체 입니다.\n",
				superman.getName(), superman.getEye(), superman.getNose(),
				superman.getMouth());
		
		System.out.println( superman.eat() );// 집에서 빵먹는 일. => 안맞는다.
		System.out.println( superman.eat("스테이크",10) );//레스토랑 스테이크 10$ => 안맞음.
		
		//자신의 method
		System.out.printf("%s에게 돌을 던진결과 \"%s\"이고 힘레벨 %d 입니다. \n",
				superman.getName(), superman.power("짱돌"), superman.power);
		
		System.out.printf("%s에게 돌을 던진결과 \"%s\"이고 힘레벨 %d 입니다. \n",
				superman.getName(), superman.power("다이아몬드"), superman.power);
		
		System.out.printf("%s에게 돌을 던진결과 \"%s\"이고 힘레벨 %d 입니다. \n",
				superman.getName(), superman.power("크립토나이트"), superman.power);
		
		System.out.println("----------------------------");
		String[] hongLang=hgd.language();
		String[] clarkLang=superman.language();
		
		for(int i= 0 ; i < hongLang.length ; i++) {
			System.out.println( hongLang[i]);
		}//end for
		System.out.println("----------------------------");
		//개선된 for로 clark이 구사할 수 있는 언어를 모두 출력해보세요.
		for( String lang : clarkLang) {
			System.out.println(lang);
		}//end for
	
		System.out.println("---interface를 구현한 method 호출--");
		System.out.println(superman.getName()+"은 양력을 "+ superman.lift()
		+"로 얻고, 날기위한 추진력을 " + superman.thrust()+"로 얻는다.");
		
	}//usePerson
	
	public static void main(String[] args) {
		new RunPerson().usePerson();
	}//main

}//class
