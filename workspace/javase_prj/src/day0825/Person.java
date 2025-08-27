package day0825;

/**
 * 사람을 대상으로 선정하여 객체모델링 후 제작한 클래스.<br>
 * 08-22-2025에 모든 사람의 공통특징을 정의한 부모클래스<br>
 * 08-25-2025에 추상클래스로 전환 ( 모든 사람이 집에 먹는 것이 밥이 아님 )<br>
 * 대상 명사적특징 : 눈,코,입,이름 <br>
 * 대상 동사적특징 : 먹는 일<br>
 * 사용법) - 일반적인 객체화를 하여 사용<br>
 * Person 객체명=new Person();<br>
 * 객체명으로 클래스에서 제공하는 기능을 사용.
 */
public abstract class Person {
	private int eye, nose, mouth; //눈,코,입의 개수를 저장할 인스턴스변수
	private String name; //이름을 저장할 인스턴스 변수
	
	/**
	 * 눈 2개, 코 1개, 입 1개인 사람 객체를 생성할 때 사용하는 생성자
	 */
	public Person() {
		this(2,1,1);//객체 생성 없이 내 클래스의 다른 생성자를 호출할때 
//		eye=2;
//		nose=1;
//		mouth=1;
	}//Person
	
	/**
	 *  눈 2개, 코 1개, 입 1개가 아닌 사람 객체를 생성할 때 사용하는 생성자.<br>
	 *  생성자 Overload
	 * @param eye 사람 객체에 설정할 눈의 개수
	 * @param nose 사람 객체에 설정할 코의 개수
	 * @param mouth 사람 객체에 설정할 입의 개수
	 */
	public Person(int eye, int nose, int mouth) {
		this.eye=eye;
		this.nose=nose;
		this.mouth=mouth;
	}//Person
	
	
	/**
	 * 생성된 사람 객체의 눈에 개수를 설정하는 일. 
	 * @param eye 눈의개수
	 */
	public void setEye(int eye) {
		this.eye=eye;
	}//setEye
	
	/**
	 * 생성된 사람 객체가 가지고 있는 눈의 개수를 반환하는 일.
	 * @return 눈의 개수
	 */
	public int getEye() {
		return eye;
	}//getEye
	
	/**
	 * 생성된 사람 객체에 코의 개수를 설정하는 일.
	 * @param nose 설정할 코의 개수
	 */
	public void setNose(int nose) {
		this.nose=nose;
	}//setNose
	
	/**
	 * 생성된 사람 객체가 가지고 있는 코의 개수를 반환하는 일.
	 * @return 코의 개수
	 */
	public int getNose() {
		return nose;
	}//getNose
	
	/**
	 * 생성된 사람 객체에 입의 개수를 설정하는 일.
	 * @param mouth 설정할 입의 개수
	 */
	public void setMouth(int mouth) {
		this.mouth=mouth;
	}//setMouth
	
	/**
	 * 생성된 사람 객체에 설정되어 있는 입의 개수를 반환하는 일.
	 * @return 객체가 가지고 있는 입의 개수
	 */
	public int getMouth() {
		return mouth;
	}//getMouth
	
	/**
	 * 생성된 사람객체에 이름을 설정하는 일.
	 * @param name 설정할 이름
	 */
	public void setName(String name) {
		this.name=name;
	}//setName
	
	/**
	 * 생성된 사람객체 설정된 이름을 반환하는 일
	 * @return 객체가 가진 이름
	 */
	public String getName() {
		return name;
	}//getName
	
	/**
	 * 생성된 사람 객체에서 제공하는 기능으로 집에서 먹는 일을 구현.
	 * @return
	 */
	public abstract String eat() ;
	
	/**
	 * 생성된 사람 객체에서 제공하는 기능으로 밖에서 음식을 사 먹는 일.
	 * @param menu 음식메뉴
	 * @param price 음식가격
	 * @return
	 */
	public abstract String eat(String menu, int price);
	
	/**
	 * 생성된 사람 객체가 구사할 수 있는 언어
	 * @return 언어의 종류
	 */
	public abstract String[] language();

	
}//class