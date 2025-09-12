package day0911;

import java.io.Serializable;

/**
 * 사용자의 중요한 정보를 가진 클래스
 * 객체는 Stream을 타고 나갈 수 없다.
 * 객체가 Stream을 타고 나가려면 java.io.Serializable 인터페이스를 구현해야 한다.
 * java.io.Serializable - 객체를 검증할 목적으로 사용하는 인터페이스 (상수, abstract method가 없음)
 */
public class UserData implements Serializable{
	/**
	 * serialVersionUID : 키가 변경되면 현재 JVM에서 내보낸 객체가 아닌것.
	 */
	private static final long serialVersionUID = 8351933247536407985L;
	//중요한 정보가 있다면 trasient로 막는다.
	private String name; // 직렬화 가능
	private double height; // 직렬화 가능
	private transient double weight; //직렬화 불가능
	
	public UserData() {
	}

	public UserData(String name, double height, double weight) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "UserData [name=" + name + ", height=" + height + ", weight=" + weight + "]";
	}
	
}
