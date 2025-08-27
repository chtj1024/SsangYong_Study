package day0825;

/**
	Person 클래스의 자식클래스<br>
 * 사람의 공통 특징은 부모클래스에서 가져다 사용( 코드의 재사용 )하고
 * 자식클래스는 자신만의 특징(힘이 쎄다.)을 정의.<br>
 * 08-25-2025 : Clark class가 Fly interface를 구현하여 나는 기능을 가지게된다.
 * 사용법)<br>
 * Clark 객체명=new Clark();<br>
 * 객체명.자신method();<br>
 * 객체명.부모method(); // 코드의 재사용성 
 */
public final class Clark extends Person implements Fly{
	public int power;
	
	/**
	 * 힘레벨은 1~10까지 존재하며 일반인은 2정도의 힘레벨을 가지고
	 * 클락은 9정도의 레벨을 가진다.
	 */
	public Clark() {
		power=9;
	}//Clark
	
	/**
	 * 돌에 따라 힘이 변하는 일.
	 * 크립토나이트 -힘 1, 다이아몬드 - 9힘, 짱돌 - 12힘 
	 * @param stone 던져진 돌의 종류
	 * @return 결과
	 */
	public String power(String stone) {
		String result="";
		
		if( stone.equals("크립토나이트")) {//힘빠짐
			result="~(_-_)~ ";
			power=1;
		}else if(stone.equals("다이아몬드")) {//ㄳ
			result="o(^^O)(O^^)o";
			power=9;			
		}else {//힘상승
			result="ㅡㅡ+;;";
			power=12;			
		}//end else 
		
		return result;
	}//power
	
	@Override
	public String eat() {
		return  getName()+"가 집에서 \"빵\"을 먹는다.";
	}//eat
	
	@Override
	public String eat(String menu,int price) {
		return String.format("%s가 \"레스토랑\"에서 %s 인 음식을 %d$로 사먹는다.", 
				getName(),menu,price );
	}//eat

	@Override
	public String[] language() {
		String[] lang="영어,외계어,한국어".split(",");
		return lang;
	}//language

	@Override
	public String lift() {
		return "망토";
	}//lift

	@Override
	public String thrust() {
		return "무릎을 꿇어서";
	}//thrust
	
}//class






