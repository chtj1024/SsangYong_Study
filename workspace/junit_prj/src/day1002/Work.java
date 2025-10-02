package day1002;

import java.util.Random;

/**
 * 업무를 구현하는 클래스
 */
public class Work {
	
	/**
	 * 0~11사이의 수 중 하나를 난수로 발생.
	 * @return 발생된 난수
	 */
	public int randomNumber() {
		int randomNum = 0;
		// 0 ~ 10사이의 
		randomNum = new Random().nextInt(11);
		
		return randomNum;
	}
	
	/**
	 * 입력된 글자에서 10글자만 잘라내 반환하는 일.
	 * @param msg
	 * @return
	 * @throws Exception 
	 */
	public String sub(String msg) throws Exception {
		String subedStr = "";
		try {
			subedStr = msg.substring(0, 10) + "...";			
		} catch(IndexOutOfBoundsException ioobe) {
			throw new Exception("10글자 이내의 문자열은 자를 수 없습니다.");
		}
		
		return subedStr;
	}
}
