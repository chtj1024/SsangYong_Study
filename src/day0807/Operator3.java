/**
 ����Ʈ ������ : ��Ʈ �б� ���� 
*/

class Operator3 {
	public static void main(String[] args) {
		int i = 25;
		
		System.out.println(i + " << 3 = " + (i << 3));
		// 25�� �������� 0001 1001(2) �� �� �������� �и�
		// 1100 1000 == 200(10) �� ����
		System.out.println(Integer.toBinaryString(35 >> 2));
		
		i = 40;
		System.out.println(i + " >> 2 = " + (i >> 2));
		
		i = 50;
		System.out.println( i + " >>> 2 = " + (i >> 2));
		
		i = 1;
		System.out.println( i << 32);
		
		i = -1; //
		System.out.println( i >> 100);
		
		System.out.println( i >>> 1);
		
		// 255�� �ǵ��� i�� �о��
		System.out.println( i >>> 24);
		
		System.out.println(Integer.toBinaryString(-(Integer.MAX_VALUE)));


	}
}
