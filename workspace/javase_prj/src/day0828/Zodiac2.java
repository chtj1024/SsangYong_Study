package day0828;

/**
 * 띠를 저장하는 enum, 다른 이름과 값을 사용하고 싶다.
 */
public enum Zodiac2 {
	//요소(생성자를 사용)
	// 얘네는 기본생성자를 사용함.
	// MONKEY,ROOSTER,DOG,PIG,RAT,COW,TIGER,RABBIT,DRAGON,SNAKE,HORSE,SHEEP;
	
	// 매개변수 있는 생성자를 사용하는 요소 
	 MONKEY("원숭이", 0),ROOSTER("닭", 200),DOG("개", 300)
	 ,PIG("돼지", 400),RAT("쥐", 5000),COW("소",5001),TIGER("호랑이",6)
	 ,RABBIT("토끼",7),DRAGON("용",8),SNAKE("뱀",900),HORSE("말",10)
	 ,SHEEP("양", 12);
	//요소마다 저장할 값을 저장할 변수
	private final String name;
	private final int value;
	
	//생성자
	private Zodiac2(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	//getter method
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
}
