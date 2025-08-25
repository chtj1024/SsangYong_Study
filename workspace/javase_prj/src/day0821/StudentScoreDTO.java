package day0821;

/**
 * 학생의 정보와 시험 정보를 저장하고 전달하기 위한 객체
 */
public class StudentScoreDTO {
	private int num;
	private String name;
	private int java;
	private int oracle;
	private int jdbc;
	
	public StudentScoreDTO() {
		
	}
	
	public StudentScoreDTO(int num, String name, int java, int oracle, int jdbc) {
		this.num = num;
		this.name = name;
		this.java = java;
		this.oracle = oracle;
		this.jdbc = jdbc;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setJava(int java) {
		this.java = java;
	}
	public int getJava() {
		return java;
	}
	
	public void setOracle(int oracle) {
		this.oracle = oracle;
	}
	public int getOracle() {
		return oracle;
	}
	
	public void setJdbc(int jdbc) {
		this.jdbc = jdbc;
	}
	public int getJdbc() {
		return jdbc;
	}
}
