package day0828;

import java.time.Month;

public class UseZodiac2 {
	
	public UseZodiac2() {
		//이름과 값을 가진 Enum을 사용.
		for(Zodiac2 z : Zodiac2.values()) {
			System.out.println("요소명 : " + z + ", 요소 인덱스 : " 
					+ z.ordinal() + ", 한글명 : " + z.getName()
					+ ", 요소 값 : " + z.getValue());
		}
		
		String zodiac = "MONKEY"; // 문자열과 enum은 형이 달라서 데이터 형이 달라서 비교할 수 없다.
		
		Zodiac2 zod2 = Zodiac2.valueOf(zodiac);
		switch(zod2) {
		case MONKEY: System.out.println(zod2.getName()); break;
		case ROOSTER: System.out.println(zod2.getName()); break;
		}
		
		for(Month month : Month.values()) {
			System.out.println(month  + " / " + month.ordinal() + " / " + month.getValue());
		}
	}
	
	public static void main(String[] args) {
		new UseZodiac2();
	}
}
