package day0825;

/**
 * Person 클래스의 자식클래스<br>
 * 사람의 공통 특징은 부모클래스에서 가져다 사용( 코드의 재사용 )하고
 * 자식클래스는 자신만의 특징(싸움을 잘한다.)을 정의.<br>
 * 사용법)<br>
 * HongGilDong 객체명=new HonGilDong();<br>
 * 객체명.자신method();<br>
 * 객체명.부모method(); // 코드의 재사용성
 */
public class HongGilDong extends Person {
	private int level;
	
	/**
	 * 싸움레벨은 1~10까지 존재하며 일반인은 3정도의 싸움레벨을 가지고
	 * 홍길동은 6정도의 레벨을 가진다.
	 */
	public HongGilDong() {
		level=6;
	}//HongGilDong
	
	public int getLevel() {
		return level;
	}//getLevel
	
	/**
	 * 싸움을 하는 일, 이기면 레벨이 상승, 지면 레벨 하락, 비기면 레벨변화 없음.
	 * @param yourLevel 상대방의 레벨 
	 * @return 결과
	 */
	public String fight(int yourLevel) {
		String result="";
		
		if( level < yourLevel) {//진경우
			result="OTL 졌다.";
			level--;
			if(level < 1) {
				level=1;
			}//end if
		}else if(level > yourLevel) {//이긴경우
			result ="s('. ^)V 이겼다.";
			level++;
			if( level > 10) {
				level=10;
			}//end if
		}else {//비긴경우
			result ="ㅡㅡ+ 비겼습니다.";
		}//end else
		
		return result;		
	}//fight
	
	/**
	 * Override : 부모클래스에서 제공되는 기능을 자식클래스에서 사용하는데 
	 *  자식클래스의 상황과 맞지 않으면 자식의 상황에 맞게 method를 재정의 한다. <br>
	 *  규칙: 접근지정자는 달라도되고, 반환형, method명 매개변수는 일치해야한다.
	 */
	@Override
	public String eat(String menu, int price) {
		return getName()+"이 \"주막\"에서 "+menu+"인 음식을 "+price+"문으로 사먹는다.";
	}//eat

	@Override
	public String eat() {
		return getName()+"이 집에서 밥을 먹는다.";
	}

	@Override
	public String[] language() {
		String[] lang= {"한국어"};
		
		return lang;
	}
	
	
}//class
