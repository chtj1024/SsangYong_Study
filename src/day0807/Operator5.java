/**
	�� �� ������
	 �Ϲ� �� : &&, ||
	 ��Ʈ �� : &, |, ^
*/
class Operator5 {
	public static void main(String[] args) {
		System.out.println( 8 > 7 || 7 < 8);
		
		boolean flag = true, flag2 = false, flag3 = true, flag4 = false;
		
		System.out.println(flag + "&&" + flag3 + "=" + (flag && flag3)); // true
		System.out.println(flag + "&&" + flag2 + "=" + (flag && flag2)); // false
		System.out.println(flag2 + "&&" + flag + "=" + (flag2 && flag)); // false
		System.out.println(flag2 + "&&" + flag4 + "=" + (flag2 && flag4)); // false
		
		System.out.println(flag + "||" + flag3 + "=" + (flag || flag3)); // true
		System.out.println(flag + "||" + flag2 + "=" + (flag || flag2)); // true
		System.out.println(flag2 + "||" + flag + "=" + (flag2 || flag)); // true
		System.out.println(flag2 + "||" + flag4 + "=" + (flag2 || flag4)); // false
		
		// &&�� ������ false�� ������ �������� �ʴ´�.
		flag = false;
		flag2 = false;
		boolean result = false;
		
		result = (flag = 3 < 2) && (flag2 = 4 < 5);
		
		System.out.println(flag + "&&" + flag2 + "=" + result);
		// ���� flag�� false�̱� ������ ����(flag2)�� �ƿ� ��� ���� �ʾƼ� false�� ���� �״�� �Ǵ� ��
		
		System.out.println("------------��Ʈ ��------------");
		
		int i = 19, j = 15;
		System.out.println(i + " & " + j + " = " + (i & j));
		
		i = 16;
		j = 19;
		System.out.println(i + " | " + j + " = " + (i | j));
		
		System.out.println(i + " ^ " + j + " = " + (i ^ j));

	}
}
