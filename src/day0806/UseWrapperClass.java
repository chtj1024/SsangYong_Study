/**
Wrapper Class 사용 : 기본형 데이터형과 같은 이름이거나 유사한 이름을 가진 Class들
 기본형 데이터형은 변수의 선언, 값할당, 사용의 일만 하는데
 Wrapper class는 객체가 제공하는 다양한 기능을 사용할 수 있다.
  byte b = 10;
  String s = b; // 할 수 없음
  Byte bObj = new Byte(b); // Byte bobj = Byte.valueOf(b);
  
  String s = bObj.toString();
*/

class UseWrapperClass {
	public static void main(String[] args) {
		float b = 8.6f;
		Float fObj = new Float(b); // Java SE8까지 생성자를 사용하여 객체를 생성.
		Float fObj2 = Float.valueOf(b);
		// Java SE9부터 생성자가 아닌 valueOf()를 사용하여 객체를 얻어 사용.
		
		//Wrapper class는 다양한 기능을 가진다.
		// int i = b; // error
		//wrapper class의 기능을 사용하여 다양한 일을 수행할 수 있다.
		int i = fObj.intValue();
		String s =fObj2.toString();
		
		System.out.println("i : " + i + ", s : " + s);
	}
}
