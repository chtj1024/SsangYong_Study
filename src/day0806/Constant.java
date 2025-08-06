class Constant {
	// constant는 class field에만 선언 가능.
	public static final int MAX_SCORE = 100;
	public static final int MIN_SCORE = 0;
	
	public static void main(String[] args) {
		int myScore = 85;
		
		// constant 명만 사용.
		System.out.println("최고점 : " + MAX_SCORE + ", 최저점 : " + MIN_SCORE);
		
		//Constant.MAX_SCORE=101; // constant는 값 변경 할 수 없다.
		
		System.out.println("최고점에서 획득한 점수의 차 : "
			+ (Constant.MAX_SCORE - myScore) + "점");
	}
}
