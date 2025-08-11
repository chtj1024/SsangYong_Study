package day0808;

/**
 * 대입연산자
 */
public class Operator7 {
	
	public static void main(String[] args) {
		
		int i = 8;
		char c = 'A';
		String msg = "오늘은 금요일";		
		i = 5;
		
		i += 2;
		i -= 3;
		i *= 2;
		i /= 3;
		i %= 2;
		
//		double d = 8;
//		d /= 3;
		i = 6;
		i <<= 3;
		i >>= 2;
		i >>>= 1;
		
		i &= 12;
		i |= 9;
		
		
		
		double d = 0.0D;
		d = (double)8 / 3;
		System.out.println(i);
		System.out.println(d);
		
		
	}
}
