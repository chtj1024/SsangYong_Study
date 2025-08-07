/**
	■ 논리 연산자
	 일반 논리 : &&, ||
	 비트 논리 : &, |, ^
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
		
		// &&는 전항이 false면 후항을 연산하지 않는다.
		flag = false;
		flag2 = false;
		boolean result = false;
		
		result = (flag = 3 < 2) && (flag2 = 4 < 5);
		
		System.out.println(flag + "&&" + flag2 + "=" + result);
		// 앞의 flag가 false이기 때문에 후항(flag2)이 아예 계산 되지 않아서 false인 상태 그대로 되는 것
		
		System.out.println("------------비트 논리------------");
		
		int i = 19, j = 15;
		System.out.println(i + " & " + j + " = " + (i & j));
		
		i = 16;
		j = 19;
		System.out.println(i + " | " + j + " = " + (i | j));
		
		System.out.println(i + " ^ " + j + " = " + (i ^ j));

	}
}
