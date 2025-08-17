package day0814;

/**
 * 마카펜 클래스를 객체화하여 사용하는 클래스.
 */
public class UseMarkerPen {
	
	/**
	 * 마카펜을 사용하는 method
	 */
	private void useMarker() {
		//검은색 마카펜 생성
		MarkerPen black = new MarkerPen();
		//검은색 마카펜 사용
		black.setColor("노랑"); // 값 설정, 유효성검증을 묶어서 처리할 수 있다.
		black.setCap(100);
		black.setBody(1);
		
		System.out.printf("마카펜 정보 : 색 %s색, 뚜껑 : %d개, 몸체 %d개\n",
				black.getColor(), black.getCap(), black.getBody());
		
		System.out.println(black.write("안녕 자바!"));
		
		MarkerPen blue = new MarkerPen();
		
		blue.setColor("파란");
		blue.setCap(1);
		blue.setBody(1);
		System.out.printf("마카펜 정보 : 색 %s색, 뚜껑 : %d개, 몸체 %d개\n",
				blue.getColor(), blue.getCap(), blue.getBody());
		
		System.out.println(blue.write("쉬었다가 하시겠습니다"));
		
	}
	
	public static void main(String[] args) {
		UseMarkerPen ump = new UseMarkerPen();
		ump.useMarker();

	}
}
