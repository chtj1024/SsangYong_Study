package day0901;

/**
 * 학생의 이름과 나이를 저장하는 사용자 정의 데이터 형
 */
/**
 * 
 */
public class StudentDTO {
	private String name;
	private int age;
	
	public StudentDTO() {
		
	}

	public StudentDTO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentDTO [name=" + name + ", age=" + age + "]";
	}
	
}
