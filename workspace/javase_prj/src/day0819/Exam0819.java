package day0819;

/**
 * - 아래의 작업을 instance method로 만들어서 사용하는 class를 작성하고,
 * 작업을 사용하는 class를 만들고 객체화하여 method를 호출하는 코드를 구현하세요 (클다도 그려보기)
 * 
 * 주민번호의 형식 xxxxxx-xxxxxxx 입니다
 * 
 * 1. 주민번호를 입력받아 instance variable에 저장하는 생성자를 생성.
 * 2. getter method, setter method도 생성.
 * 3. 인스턴스 변수에 저장된 주민번호의 글자수가 14자리 인지 체크하여 boolean으로 반환하는
 * 일을 하는 method를 작성하시오.
 * 4. 인스턴스 변수에 저장된 주민번호에 6번째의 인덱스의 문자가 '-'인지를 체크하여 boolean으로
 * 반환하는 일을 하는 method를 만들어주세요
 * 5. 인스턴스 변수에 저장된 주민번호에서 생년월일을 연산하여 문자열로 반환하는 일의 method 작성.
 * "1995년 01월 21일" 이런식으로 표기하고,
 * 뒤 문자가 1,2,5,6이면 1900년 대생, 3,4,7,8 2000년 대생, 0,9 1800년 대생
 * 6. 인스턴스 변수에 저장된 주민번호에서 나이를 구하여 정수로 반환하는 일 method 작성
 * 7. 인스턴스 변수에 저장된 주민번호에서 성별을 구하여 문자열로 반환하는 일을 하는 method 작성
 * 판단 기준 : 뒤 문자가 짝수면 여자, 홀수면 남자
 * 8. 인스턴스 변수에 저장된 주민번호에서 내국인인지 외국인인지 구하여 문자열로 반환하는 일을 하는 
 * method 작성
 * 판단 기준 : 뒤 문자가 0,1,2,3,4,9면 내국인, 5,6,7,8 외국인
 * 9. 인스턴스 변수에 저장된 주민번호에서 띠를 구하여 문자열로 반환하는 일을 하는 method 작성
 */
class ResidentNum {
	private String residentNumber;
	String birth;
	int years;
	
	public ResidentNum(String residentNumber) {
		this.residentNumber = residentNumber;
		
		// 몇세기에 태어났는지 설정
		birth = "";
		if (residentNumber.charAt(7) == '1'
				|| residentNumber.charAt(7) == '2'
				|| residentNumber.charAt(7) == '5'
				|| residentNumber.charAt(7) == '6') {
			birth += "19";
		} else if (residentNumber.charAt(7) == '3'
				|| residentNumber.charAt(7) == '4'
				|| residentNumber.charAt(7) == '7'
				|| residentNumber.charAt(7) == '8') {
			birth += "20";
		} else {
			birth += "18";
		}
		
		// 태어난 년도 4자리 설정
		years = Integer.parseInt( birth + residentNumber.substring(0, 2) );
	}
	
	public void setResidentNum(String residentNumber) {
		this.residentNumber = residentNumber;
	}
	
	public String getResidentNum() {
		return residentNumber;
	}
	
	public boolean residentNumberCheck14() {
		return residentNumber.length() == 14;
	}
	
	public boolean residentNumberCheckDash() {
		return residentNumber.charAt(6) == '-';
	}
	
	public String makeBirth() {
		String strBirth = birth;
		strBirth += residentNumber.substring(0, 2) + "년 " + residentNumber.substring(2, 4) + "월 " + residentNumber.substring(4, 6) + "일";
		return strBirth;
	}
	
	public int getAge() {		
		return 2025 - years;
	}
	
	public String getGender() {
		return (int)residentNumber.charAt(7) % 2 == 0 ? "여자" : "남자";
	}
	
	public String checkForeigner() {
		String check = "";
		
		if (residentNumber.charAt(7) == '0'
				|| residentNumber.charAt(7) == '1'
				|| residentNumber.charAt(7) == '2'
				|| residentNumber.charAt(7) == '3'
				|| residentNumber.charAt(7) == '4'
				|| residentNumber.charAt(7) == '9') {
			check = "내국인";
		} else if (residentNumber.charAt(7) == '5'
				|| residentNumber.charAt(7) == '6'
				|| residentNumber.charAt(7) == '7'
				|| residentNumber.charAt(7) == '8') {
			check = "외국인";
		}
		return check;
	}
	
	public String checkDdi() {
		String check = "";
		switch (years % 12) {
			case 1: check = "쥐"; break;
			case 2: check = "소"; break;
			case 3: check = "호랑이"; break;
			case 4: check = "토끼"; break;
			case 5: check = "용"; break;
			case 6: check = "뱀"; break;
			case 7: check = "말"; break;
			case 8: check = "양"; break;
			case 9: check = "원숭이"; break;
			case 10: check = "닭"; break;
			case 11: check = "개"; break;
			case 0: check = "돼지"; break;
		}
		return check;
	}
}

public class Exam0819 {
	public static void main(String[] args) {
		ResidentNum rn = new ResidentNum("951123-1423424");
		System.out.println(rn.getResidentNum());
		
		rn.setResidentNum("941224-2312456");
		System.out.println(rn.getResidentNum());
		System.out.println("주민번호가 14자리가 맞나요? : " + rn.residentNumberCheck14());
		
		System.out.println("6번째 자리에 '-'가 있나요? : " + rn.residentNumberCheckDash());
		
		System.out.println("생년월일 : " + rn.makeBirth());
		System.out.println("나이는 : " + rn.getAge() + "세");
		System.out.println("성별은 : " + rn.getGender());
		System.out.println("내국인 외국인 판별 : " + rn.checkForeigner());
		System.out.println("띠는 " + rn.checkDdi() + "띠 입니다.");
	}
}
