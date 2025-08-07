/**
Wrapper Class ��� : �⺻�� ���������� ���� �̸��̰ų� ������ �̸��� ���� Class��
 �⺻�� ���������� ������ ����, ���Ҵ�, ����� �ϸ� �ϴµ�
 Wrapper class�� ��ü�� �����ϴ� �پ��� ����� ����� �� �ִ�.
  byte b = 10;
  String s = b; // �� �� ����
  Byte bObj = new Byte(b); // Byte bobj = Byte.valueOf(b);
  
  String s = bObj.toString();
*/

class UseWrapperClass {
	public static void main(String[] args) {
		float b = 8.6f;
		Float fObj = new Float(b); // Java SE8���� �����ڸ� ����Ͽ� ��ü�� ����.
		Float fObj2 = Float.valueOf(b);
		// Java SE9���� �����ڰ� �ƴ� valueOf()�� ����Ͽ� ��ü�� ��� ���.
		
		//Wrapper class�� �پ��� ����� ������.
		// int i = b; // error
		//wrapper class�� ����� ����Ͽ� �پ��� ���� ������ �� �ִ�.
		int i = fObj.intValue();
		String s =fObj2.toString();
		
		System.out.println("i : " + i + ", s : " + s);
	}
}
