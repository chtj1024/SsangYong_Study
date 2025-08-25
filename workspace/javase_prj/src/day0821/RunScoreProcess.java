package day0821;

/**
 * 
 */
public class RunScoreProcess {

	public static void main(String[] args) {
		String[] nameArr = {"루피", "샹디", "쵸파", "나미"};
		String[] subjectArr = {"번호", "이름", "java", "Oracle", "JDBC", "총점", "평균"};
		int[][] scoreArr = {{65,72,71}, {83,85,85}, {99,99,100}, {79,80,83}};
		
		ScoreProcess sp = new ScoreProcess("원피스고", nameArr, subjectArr, scoreArr);
		sp.scoreProcess();
		
//		String[] nameArr2 = {"에렌", "아르민", "리바이", "미카사", "엘빈"};
//		String[] subjectArr2 = {"번호", "이름", "거인학", "입체기동술", "벽", "청소기술", "총점", "평균"};
//		int[][] scoreArr2 = {{65,72,71,88}, {83,85,85,82}, {99,99,100,77}, {79,80,83,99}, {69,81,82,85}};
//		
//		ScoreProcess sp2 = new ScoreProcess("진격거고", nameArr2, subjectArr2, scoreArr2);
//		sp2.scoreProcess();
	}


}
