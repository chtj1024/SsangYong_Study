package day0819;

/**
 * 학생의 복합적인 정보를 저장할 수 있는 데이터 형인 StudentInfo를 사용하는 클래스
 */
public class UseStudentInfo {
	public static void main(String[] args) {
		StudentInfo sanghyun = new StudentInfo(1, "박상현", 25, 182.4, 69.3);
		StudentInfo gyeongwoon = new StudentInfo(2, "나경원", 27, 185.1, 71.2);
		
		//생성된 객체의 값이 변경되어야한다.
		sanghyun.setAge(27);
		System.out.printf("번호:%-3d, 이름:%-5s, 나이:%-3d, 키:%-8.1f, 몸무게:%-8.1f\n",
				sanghyun.getNum(), sanghyun.getName(), sanghyun.getAge(), sanghyun.getHeight(), sanghyun.getWeight());
		System.out.printf("번호:%-3d, 이름:%-5s, 나이:%-3d, 키:%-8.1f, 몸무게:%-8.1f\n",
				gyeongwoon.getNum(), gyeongwoon.getName(), gyeongwoon.getAge(), gyeongwoon.getHeight(), gyeongwoon.getWeight());
	}
}
