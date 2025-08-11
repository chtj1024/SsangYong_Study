package day0807;
/**
 단항연산자 : unary operator
 ~, !, +, -, ++, --
*/

class Operator1 {
	
	public static final int NOW_YEAR=2025;
	
	public static void main(String[] args) {
		int i = 8, j = -7;
		System.out.println( "~" + i + "=" + ~i);
		System.out.println("~" + j + "=" + ~j);
		
		i = 8;
		j = 7;
		
		boolean result = i > j;
		System.out.println(result);
		
		j = -7;
		
		
		// - : 2의 보수 연산, 부호 바꾸는 연산
		System.out.println("-" + j + "=" + -j);
		
		// ~를 사용하여 i를 -8로 만들어서 출력하고, ~를 사용하여 j를 7로 만들어서 콘솔에 출력해보세요.
		System.out.println(~i + 1);
		System.out.println(~j + 1);
		
		++i;
		System.out.println("전위연산 후 " + i);
		i++;
		System.out.println("후위연산 후 " + i);
		i = i + 1;
		System.out.println("연산결과를 저장 후 " + i);
		
		i--;
		System.out.println("전위연산 후 " + i);
		i--;
		System.out.println("후위연산 후 " + i);
		
		// 전위 : 나먼저 계산
		int result2 = 0;
		result2 = ++i;
		System.out.println("전위 : result2 : " + result2 + ", i : " + i);
		
		result2 = 0;
		//후위 : 나는 제일 마지막에 계산
		result2 = i++;
		System.out.println("후위 : result2 : " + result2 + ", i : " + i);
		
		j = 7;
		temp(++i, j++);
	}
	public static void temp(int param, int param2) {
		System.out.println("temp method에서 받은 i 값 : " + param 
			+ "j 값" + param2);
	}
}
