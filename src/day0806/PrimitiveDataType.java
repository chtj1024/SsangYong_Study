/**
�⺻�� �������� : ������ ���� �����ϴ� ������ ��
*/

class PrimitiveDataType {
	public static void main(String[] args) {
		byte b=127;
		System.out.println("byte : " + b);
		short s = 6;
		System.out.println("short : " + s);
		
		long deposit = 3000000000L;
		System.out.println(deposit);
		
		System.out.println("--���� ����� ������ �� �ִ� ������ ������--");
		char c = 65; // �����ڵ尪 ���� �Ҵ�
		char c2 = 48;
		char c3 = 44032;
		
		System.out.println(c + "/" + c2 + "/" + c3);
		
		System.out.println("--�Ǽ� ����� ������ �� �ִ� �Ǽ��� ��������--");
		// float f = 8.6; // �Ǽ� literal�� 8byte�� �⺻ũ���̰� float�� 4byte�� ũ�� �̹Ƿ�
		// �׳� �Ҵ��ϸ� ũ�Ⱑ �ٸ��Ƿ� ������ �߻��Ѵ�. => F, f�� ����� �ؾ� ��.
		float f = 8.6F; // ����� �ʼ�
		double d = 8.6; // ����� ���� ����
		
		System.out.println("float : " + f);
		System.out.println("double : " + d);

	}
}
