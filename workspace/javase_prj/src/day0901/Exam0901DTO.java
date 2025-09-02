package day0901;

/**
 * 어제한 과제에 List대신 Map을 추가해서 할 것.
 * 번호, 이름, 자바점수, 오라클점수, 총점을 DTO에 저장하고, DTO를 Map에 저장한다.
 * 1. 입력 2. 출력 3. 삭제 4. 종료
 * 점수가 정상적일 때만 총점이 보이도록
 * 
 * 3번이 입력되면 "삭제할 학생의 번호를 입력해주세요" InputDialog에 출력하고, 학생의 번호가 입력되면
 * Map에서 해당 데이터를 삭제하고, 콘솔에 학생의 정보가 삭제되었습니다. 출력.
 * 
 * 클래스 간의 관계는 DTO, Work, Run 형태의 클래스 처럼 생기면됨.
 */
public class Exam0901DTO {
	private String name;
	private int javaPoint;
	private int oraclePoint;
	
	public Exam0901DTO(String name, int javaPoint, int oraclePoint) {
		super();
		this.name = name;
		this.javaPoint = javaPoint;
		this.oraclePoint = oraclePoint;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getJavaPoint() {
		return javaPoint;
	}

	public void setJavaPoint(int javaPoint) {
		this.javaPoint = javaPoint;
	}

	public int getOraclePoint() {
		return oraclePoint;
	}

	public void setOraclePoint(int oraclePoint) {
		this.oraclePoint = oraclePoint;
	}

	
}
