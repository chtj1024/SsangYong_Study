package day0822;

/**
 * Person 클래스의 자식클래스
 * 사람의 공통 특징은 부모클래스에서 가져다 사용 (코드의 재사용)하고
 * 자식클래스는 자신만의 특징을 정의.
 */
public class HongGilDong extends Person {
	private int level;
	
	
	/**
	 * 싸움레벨은 1~10까지 존재하며 일반인은 3정도의 싸움레벨을 가지고
	 * 홍길동은 6정도의 레벨을 가진다.
	 */
	public HongGilDong() {
		level = 6;
	}
	
	public int getLevel() {
		return level;
	}
	
	/**
	 * 싸움을 하는 일, 이기면 레벨 상승, 지면 레벨 하락, 비기면 레벨변화 없음
	 * @param yourLevel 상대방의 레벨
	 * @return 결과
	 */
	public String fight(int yourLevel) {
		String result = "";
		
		if(level < yourLevel) { // 진 경우
			result = "OTL 졌다.";
			level--;
			if (level <= 0) {
				level = 1;
			}
		} else if(level > yourLevel) { // 이긴 경우
			result = "s('. ^)V 이겼다.";
			level++;
			if (level > 10) {
				level = 10;
			}
		} else { // 비긴 경우
			result = "ㅡㅡ+ 비겼습니다.";
		}
		
		return result;
	}
	
	@Override
	public String eat(String menu, int price) {
		return getName() + "이 \"주막\"에서" + menu + "인 음식을 " + price
				+ "문을 지불하여 사먹는다.";
	}
}
