/**
���������� ������ �˱����� Ŭ����.
*/

class UseLocalVariable {
	
	/**
	Java Application���� Ŭ������ ����� ���ؼ� main method�� ����
	*/
	public static void main(String[] args) {
		//�������� ���.
		
		//1. ���� : �������� ������; �ڵ��ʱ�ȭ�� ���� ����.
		int myAge;
		myAge = 25;
		
		//String today;
		//2. �� �Ҵ�)
		//today = "25.08.06";
		String today = "25.08.06";
		today = "25.08.07";
		
		//3. �� ���) : ���, ����, ���Ҵ�
		System.out.println("�� ���̴�" + myAge + "��");
		System.out.println(today);
		
		today = "25.08.08";
		System.out.println(today);
		
		//�ϳ��� ���������� ���� �̸��� ������ ������ �� ����.
		//int myAge;
		
		UseLocalVariable ulv = new UseLocalVariable();
		System.out.println(ulv);
	}
}
