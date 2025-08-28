package day0828;

import java.time.Duration;
import java.time.LocalTime;

public class UseDuration {
	
	public UseDuration() {
		LocalTime lt = LocalTime.now();
		LocalTime lt2 = LocalTime.now(); // of(시, 분) of(시,분,초) 가능
		
		lt2 = lt2.plusHours(1);
		lt2 = lt2.plusMinutes(2);
		
		System.out.println(lt);
		System.out.println(lt2);
		
		Duration d = Duration.between(lt, lt2);
		System.out.println(d);
		
		System.out.println("시간 차 : " + d.toHours());
		System.out.println("분 차 : " + d.toMinutes());
		System.out.println("나노초 차 : " + d.toNanos());
	}
	
	public static void main(String[] args) {
		new UseDuration();
	}
}
