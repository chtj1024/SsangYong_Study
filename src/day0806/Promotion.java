/**
자동 형 변환
*/

class Promotion  {
	public static void main(String[] args) {
		byte b = 10; // 4byte의 literal이 1byte로 축소되어 할당. demtion
		byte b2 = 20;
		int result = 0;
		result = b + b2; // int의 하위 데이터 형이 연산되면 결과는 int로 발생하기 때문.
		System.out.println(b + "+"+ b2 + "=" + result);
	}
}
