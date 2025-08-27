package day0827;

/**
 * 업무를 제공하는 클래스
 */
public class Work0827 {
	
	/**
	 * 영문자 대문자, 소문자, 숫자로 구성된 8글자의 임시비밀번호를 생성하여 반환하는 일
	 * @return 생성된 임시 비밀번호
	 */
	public String createTempPassword() {
		//긴 문자열( +연산 포함된 문자열)
		StringBuilder tempPass = new StringBuilder();
		
		String passwordChar = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		int randomInd = 0;
		for(int i = 0; i < 8; i++) {
			randomInd = (int)(Math.random() * passwordChar.length());
			tempPass.append(passwordChar.charAt(randomInd));
		}
		
		return tempPass.toString();
	}
	
	/** 
	 * 로또 번호 6개를 생성하고, 오름차순 정렬하여 반환하는 일.
	 * @return
	 */
	public int[] creatLotto() {
		int[] tempLotto = new int[6];
		
		return tempLotto;
	}
	

}
