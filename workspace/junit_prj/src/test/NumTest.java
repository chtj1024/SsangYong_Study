package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import day1002.Work;

class NumTest {

	@Disabled
	@DisplayName("난수 발생 테스트 케이스")
	@Test
	void test() {
//		fail("Not yet implemented");
		//테스트 코드
		Work work = new Work();
		int num = work.randomNumber();
		System.out.println("발생한 번호 : " + num);
		//JUnit에서 제공하는 단정(assert) method 사용
//		assertEquals(num, 0); // 0이면 성공(G), 0이 아니면 실패(R)
		assertNotEquals(num, 0); // 0이 아니면 성공(G), 0이면 실패(R)
	}

	@DisplayName("예외처리 테스트")
	@Test
	void test2() {
//		fail("Not yet implemented");
		//테스트 코드
		Work work = new Work();
		//문자열이 10글자 이내라면 예외가 발생하게된다.
		String msg = "오늘은 연휴 전 목요일 입니다.";
		String msg2 = "오늘은 연휴";
		//예외가 발생하지않았을 때 테스트 성공
//		assertDoesNotThrow(() -> work.sub(msg2));
		//예외가 발생했을 때 테스트 성공
		assertThrows(Exception.class, ()-> work.sub(msg2));
	}
}
