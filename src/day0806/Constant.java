class Constant {
	// constant�� class field���� ���� ����.
	public static final int MAX_SCORE = 100;
	public static final int MIN_SCORE = 0;
	
	public static void main(String[] args) {
		int myScore = 85;
		
		// constant �� ���.
		System.out.println("�ְ��� : " + MAX_SCORE + ", ������ : " + MIN_SCORE);
		
		//Constant.MAX_SCORE=101; // constant�� �� ���� �� �� ����.
		
		System.out.println("�ְ������� ȹ���� ������ �� : "
			+ (Constant.MAX_SCORE - myScore) + "��");
	}
}
