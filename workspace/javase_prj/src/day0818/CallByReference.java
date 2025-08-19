package day0818;

/**
 * 값 전달. method 매개변수로 참조형 데이터형을 선언하면 주소는 유일하기 때문에
 *  그대로 전달된다. 
 */
public class CallByReference {
	int i;
	int j;
	
	public void swap(CallByReference cbr) {
		int temp=0;
		temp=cbr.i;
		cbr.i=cbr.j;
		cbr.j=temp;
		
		System.out.println("swap method 안 i = "+ cbr.i+ ", j = "+cbr.j);
	}//swap

	public static void main(String[] args) {
		CallByReference cbr=new CallByReference();
		cbr.i=2025;
		cbr.j=8;
		System.out.println("swap method 호출 전 i = "+ cbr.i+ ", j = "+cbr.j);
		cbr.swap(cbr);
		System.out.println("swap method 호출 후 i = "+ cbr.i+ ", j = "+cbr.j);
		
	}//main

}//class
