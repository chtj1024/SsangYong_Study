package day0822;

/**
 * 홍길동 클래스와 클락 클래스를 사용하는 일
 */
public class RunPerson {
	
	public void usePerson() {
		HongGilDong hgd = new HongGilDong();
		hgd.setName("홍길동");
		System.out.printf("%s은 눈 %d, 코 %d 입 %d를 가진 객체입니다.\n"
				, hgd.getName(), hgd.getEye(), hgd.getNose(), hgd.getMouth());
		System.out.println(hgd.eat());
		System.out.println(hgd.eat("국밥", 10));
		
		System.out.printf("%s의 싸움 결과 \"%s\"이고 싸움레벨 %d 입니다. \n"
				, hgd.getName(), hgd.fight(5), hgd.getLevel());
		System.out.printf("%s의 싸움 결과 \"%s\"이고 싸움레벨 %d 입니다. \n"
				, hgd.getName(), hgd.fight(6), hgd.getLevel());
		System.out.printf("%s의 싸움 결과 \"%s\"이고 싸움레벨 %d 입니다. \n"
				, hgd.getName(), hgd.fight(8), hgd.getLevel());
		System.out.printf("%s의 싸움 결과 \"%s\"이고 싸움레벨 %d 입니다. \n"
				, hgd.getName(), hgd.fight(9), hgd.getLevel());
		
		Clark superman = new Clark();
		// 부모 클래스의 method 사용
		superman.setName("클락 켄트");
		System.out.printf("%s은 눈 %d, 코 %d 입 %d를 가진 객체입니다.\n"
				, superman.getName(), superman.getEye(), superman.getNose(), superman.getMouth());
		System.out.println(superman.eat()); // 집에서 빵을 먹어야 함.
		System.out.println(superman.eat("스테이크", 10));
		
		System.out.printf("%s에게 돌을 던진결과 \"%s\"이고 힘레벨 %d 입니다. \n"
				, superman.getName(), superman.power("짱돌"), superman.power);
		System.out.printf("%s에게 돌을 던진결과 \"%s\"이고 힘레벨 %d 입니다. \n"
				, superman.getName(), superman.power("다이아몬드"), superman.power);
		System.out.printf("%s에게 돌을 던진결과 \"%s\"이고 힘레벨 %d 입니다. \n"
				, superman.getName(), superman.power("크립토나이트"), superman.power);
	}
	
	public static void main(String[] args) {
		RunPerson rp = new RunPerson();
		rp.usePerson();
	}
}
