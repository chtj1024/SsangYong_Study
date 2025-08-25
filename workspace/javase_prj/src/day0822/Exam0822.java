package day0822;

/**
 * 문제
 * 1. 자신을 생각해보고 차별점을 뽑고, Person클래스를 상속받는 자신 클래스를 만들고
 * 차별점을 method로 작성하여 사용해보기.
 * 
 * 2. 다음을 대상으로 클래스를 만들고 사용해보세요 (치와와, 시베리안허스키, 시츄)
 * 
 */

class WhoAmI extends Person{
	// skill은 게임 실력을 말하며 1~10까지 있다.
	private int skill;
	private int win;
	private int lose;
	
	public WhoAmI () {
		skill = 9;
	}
	
	@Override
	public String eat() {
		return getName() + "이 지각해서 밥을 허겁지겁 먹는다.";
	}
	
	// 게임 경기가 치루어짐
	public void gaming(int enemySkill) {
		if (skill > enemySkill) {
			win++;
			System.out.println("승리했습니다");
		} else {
			System.out.println("패배했습니다");
			lose++;
		}
	}
	
	public int getWin() {
		return win;
	}
	public int getLose() {
		return lose;
	}
}

class Enemy extends Person{
	private int skill;
	private int win;
	private int lose;
	
	public Enemy(int skill) {
		this.skill = skill;
	}
	
	public int getSkill() {
		return skill;
	}
}

class Dog {
	private String name;
	public String bark;
	
	public Dog () {
		this.bark = "왈왈";
	}
	
	public void eat() {
		System.out.println(name + "이가 밥을 먹습니다.");
	}
	
	public void bark() {
		System.out.println(name + "이가 " + bark + "짖습니다.");
	}
	
	public void running() {
		System.out.println(name + "이가 달립니다.");
	}
	
	public void bite() {
		System.out.println(name + "이가 뭅니다.");
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

class Chiwawa extends Dog {

	public Chiwawa () {
		super.bark = "멍멍";
	}
	
}

class Husky extends Dog {
	
	public Husky () {
		setName("허스키");
		running();
	}
}

class ShihTzu extends Dog {
	
	public ShihTzu () {
		setName("시츄");
		bite();
	}
}

public class Exam0822 {
	public static void main(String[] args) {
		WhoAmI wai = new WhoAmI();
		wai.setName("최태준");
		System.out.println(wai.eat());
		
		Enemy em = new Enemy(5);
		wai.gaming(em.getSkill());
		
		Enemy god = new Enemy(10);
		wai.gaming(god.getSkill());
		
		System.out.println("승리횟수는 " + wai.getWin() + "입니다.");
		System.out.println("패배횟수는 " + wai.getLose() + "입니다.");
		System.out.println("======================================");
		
		Chiwawa cw = new Chiwawa();
		cw.setName("Chiwawa");
		cw.bark();
		
		Dog husky = new Husky();
		husky.bark();
		
		ShihTzu st = new ShihTzu();
	}
}
