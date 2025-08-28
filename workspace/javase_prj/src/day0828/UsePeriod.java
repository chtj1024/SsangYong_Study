package day0828;

import java.time.LocalDate;
import java.time.Period;

/**
 * 
 */
public class UsePeriod {
	
	public UsePeriod() {
		LocalDate ld = LocalDate.now();
		LocalDate ld2 = LocalDate.now();
//		LocalDate ld2 = LocalDate.of(2026,9,30);
		ld2 = ld2.plusYears(1); // 메서드를 사용하는 게 값을 가져오는 거지 할당하려면 원래 객체에 더해줘야 함.
		ld2 = ld2.plusMonths(1);
		ld2 = ld2.plusDays(3); // 현재 월에 없는 날이 입력되면 다음 날에 반영된다.
		
		System.out.println("ld : " + ld);
		System.out.println("ld2 : " + ld2);
		
		// 2. 날짜 객체를 연산할 수 있는 has a관계를 설정하여 객체 얻기
		Period p = Period.between(ld,  ld2);
		System.out.println("년도 차 : " + p.getYears());
		System.out.println("월 차 : " + p.getMonths());
		System.out.println("일 차 : " + p.getDays());
	}
	
	public static void main(String[] args) {
		new UsePeriod();
	}
}
