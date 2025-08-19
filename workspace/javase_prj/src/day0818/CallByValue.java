package day0818;

/**
 * method 매개변수가 기본형 데이터형을 parameter로 정의하면 값은 "복사"되어 전달된다. 
 * 원본 변수의 값에는 영향을 주지 않는다. 
 */
public class CallByValue {

	/**
	 * 매개변수로 입력된 값을 변경하는일
	 * @param i
	 * @param j
	 */
	public void swap( int i,int j ) {
		int temp=0;
		
		temp=i;
		i=j;
		j=temp;
		System.out.println("swap method안 i = " + i+", j = "+j);//8, 2025
		
	}//swap
	
	public static void main(String[] args) {
		CallByValue cbv=new CallByValue();
		int i=2025;
		int j=8;
		System.out.println("swap method 호출 전 i = " + i+", j = "+j);//2025, 8
		cbv.swap(i, j);
		System.out.println("swap method 호출 후 i = " + i+", j = "+j);//2025, 8
	}//main

}//class
