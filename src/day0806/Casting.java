/**
	���� ����ȯ.
	�����ڰ� ���ϴ� ������ ������ �Ͻ����� ��ȯ
*/

class Casting {
	public static void main(String[] args) {
		float f = (float)8.06;
		System.out.println(f);
		
		int i = 0;
		
		i = (int) f; // �Ǽ� ���� �����
		System.out.println("int i=" + i + ", float f=" + f);
		
		byte b = 10, b2 = 20, result = 0;
		
		result = (byte)(b + b2);
		System.out.println(b + " + " + b2 + "=" + result);
		
		char c = 'A';
		System.out.println("unicode�� �ش�Ǵ� ���ڰ� ��� : " + c + ", code �� : "
			+ (int)c);
			
		// �⺻�� ������ �� <-> ������ ������ �� ���δ� ������ ��ȯ�� ���� �ʴ´�.
		String s = "8";
		int j = 0;
		
		// j = (int) s;
		// s = (String) j;
		
		// boolean���� �ٸ� ������ ������ ���� ����ȯ �� �� ����.
		boolean bl = true, bl2 = false;
		// j = (int)bl;
		
		// long l = (long)2147483648; // casting�� literal�� ũ�⸦ ��ȯ ��ų �� ����. 
	}
}
