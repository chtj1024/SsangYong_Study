package day0814;

/**
 * 마카펜을 객체모델링(추상화)하여 구현한 클래스
 * 명사적특징 : 뚜껑, 몸체, 색
 * 동사적인 특징 : 쓰는 일
 * 일반 클래스로 객체화를 하여 사용한다.
 * MarkerPen 객체명 = new MarkerPen();
 */
public class MarkerPen {
	private int cap;
	private int body;
	private String color;
	
	/**
	 * 생성된 마카펜 객체에 뚜껑의 수를 설정하는 일.
	 * @param cap 설정할 뚜껑의 수
	 */
	public void setCap(int cap) {
		if(cap > 10) {
			cap = 10;
		}
		this.cap = cap;
	}
	
	public void setBody(int body) {
		this.body = body;
	}

	public void setColor(String color) {
		//유효성 검증. 마카펜은 검은, 파란, 빨강으로만 설정할 수 있다.
		if(!(color.equals("검은") || color.equals("파란") || color.equals("빨간"))) {
			color = "검은";
		}
		this.color = color;
	}
	
	/**
	 * 생성된 마카펜 객체의 뚜껑 개수를 반환하는 일
	 * @return
	 */
	public int getCap() {
		return cap; // 중복된 변수가 없어서 그냥 cap만 사용해도 됨
	}
	
	public int getBody() {
		return body;
	}
	
	public String getColor() {
		return color;
	}
	
	/**
	 * 마카펜의 동사적인 특징은 쓰는 일을 구현한 method
	 * 입력받은 메세지를 칠판에 쓰는 일.
	 * @param msg 칠판에 쓸 메세지
	 * @return 쓰는 행동
	 */
	public String write(String msg) {
		return color + "색인 마카펜으로 칠판에 \"" + msg + "\"를 쓴다.";
	}
}
