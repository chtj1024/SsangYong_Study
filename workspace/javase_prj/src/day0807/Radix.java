package day0807;
/**
 코딩창에서 다양한 진수를 사용.
*/

class Radix {
	public static void main(String[] args) {
		int binary = 0b00001010; // 변수에 저장될 때는 전부 2진수로 저장
		int octal = 012;
		int decimal = 10;
		int hex = 0xa;
		
		System.out.println(binary);
		System.out.println(octal);
		System.out.println(decimal);
		System.out.println(hex);
		
		// 2진수를 받아서 10진수로 변환하여 console에 출력
		System.out.println(binary + octal + decimal + hex); // 계산은 2진수 끼리 되고 결과는 10진수로 나오는 것
		
		// int tel = 01012345678; //앞에 0이 붙으면 8진수고 8진수에는 8이 없기에.
		String tel = "01012345678";
		System.out.println(tel);
		
		decimal = 25;
		System.out.println(Integer.toBinaryString(decimal));
	}
}
