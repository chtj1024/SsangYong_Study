package day0828;

public class UseZodiacEnum {
	
	public static void main(String[] args) {
		for (Zodiac z : Zodiac.values()) {
			System.out.println(z + " / " + z.ordinal());
		}
		
		System.out.println("------------");
		
		System.out.println(Zodiac.HORSE);
		System.out.println(Zodiac.HORSE + "요소의 번호 : " + Zodiac.HORSE.ordinal());
		
	}
}