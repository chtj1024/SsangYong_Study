package day0819;

/**
 * 학생 정보(하나의 데이터 형으로 저장할 수 없는 복합적인 정보)를 저장하는 데이터 형
 * 학생 정보는 번호, 이름, 나이, 키, 몸무게로 이루어져 있다.
 */
public class StudentInfo {
	private int num;
	private String name;
	private int age;
	private double height;
	private double weight;
	
	/**
	 * 입력된 값으로 객체를 생성하는 생성자.
	 * @param num 학생 번호
	 * @param name 이름
	 * @param age 나이
	 * @param height 키
	 * @param weight 몸무게
	 */
	public StudentInfo(int num, String name, int age, double height, double weight) {
		this.num = num;
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	/**
	 * 학생의 번호를 변경하는 method
	 * @param num
	 */
	public void setNum(int num) {
		this.num = num;
	}
	
	/**
	 * 학생의 번호를 반환하는 일
	 * @return
	 */
	public int getNum() {
		return num; // this.num과 같다
	}
	
	/**
	 * 학생의 이름을 변경하는 일
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 학생의 이름을 반환하는 일
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 학생의 나이를 변경하는 일
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * 학생의 나이를 반환하는 일
	 * @return
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * 학생의 키를 변경하는 일
	 * @param height
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * 학생의 키를 반환하는 일
	 * @return
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * 학생의 몸무게를 변경하는 일
	 * @param weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/**
	 * 학생의 몸무게를 반환하는 일
	 * @return
	 */
	public double getWeight() {
		return weight;
	}
}
