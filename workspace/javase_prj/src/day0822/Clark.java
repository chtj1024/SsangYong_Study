package day0822;

public class Clark extends Person {
	public int power;
	
	public Clark() {
		power = 9;
	}
	
	/** 돌에 따라 힘이 변하는 일
	 * 크립노타이트 - 힘 1, 다이아몬드 - 9힘, 짱돌 - 12힘
	 * @param stone 던져진 돌의 종류
	 * @return
	 */
	public String power(String stone) {
		String result = "";
		
		if(stone.equals("크립토나이트")) { // 힘빠짐
			result = "~(_-_)~";
			power = 1;
		} else if(stone.equals("다이아몬드")) { // ㄳ 
			result = "o(^^0)(0^^)o";
			power = 9;
		} else {// 힘상승
			result = "ㅡㅡ+;;";
			power = 12;
		}

		return result;
	}
	
	@Override
	public String eat() {
		return getName() + "가 집에서 \"빵\"을 먹는다.";
	}
	
	@Override
	public String eat(String menu, int price) {
		return getName() + "가 \"레스토랑에서\" " + menu
				+ "인 음식을 " + price + "$로 사먹는다.";
	}

}
