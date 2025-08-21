package day0820;

/**
 * 일차원 배열의 사용
 */
public class UseArray2 {
	
	public UseArray2() {
		//char의 배열의 배열명을 출력하면 문자열로 출력된다.
		char[] arr = {'a','b','c','d','e','f'};
		for(char temp : arr) {
			System.out.print(temp);
		}
		System.out.println();
		//char데이터 형으로 배열을 만들고 배열명을 출력하면 주소가 아닌 문자열로 출력이된다.
		System.out.println(arr);
		
		int[] score = {50, 69, 91, 99, 84, 77};
		//배열의 방의 값 중에 가장 큰 값을 출력해보세요.
		int scoreMax = 0;
		for (int e : score) {
			scoreMax = Math.max(scoreMax, e);
		}
		System.out.println(scoreMax);
	}
	
	public static void main(String[] args) {
		UseArray2 ua2 = new UseArray2();
	}
}
