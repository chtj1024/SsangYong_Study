package day0821;

import java.util.*;

/**
 * 
 */
public class ScoreProcess {
	
	private String school;
	private String[] nameArr;
	private String[] subjectArr;
	private int[][] scoreArr;
	
	/** 성적처리할 학교명, 학생명, 과목, 학생점수를 입력
	 * @param school 학교명
	 * @param nameArr 학생명
	 * @param subjectArr 과목명
	 * @param scoreArr 점수
	 */
	public ScoreProcess(String school, String[] nameArr, String[] subjectArr, int[][] scoreArr) {
		this.school = school;
		this.nameArr = nameArr;
		this.subjectArr = subjectArr;
		this.scoreArr = scoreArr;
	}
	
	public void scoreProcess() {
		
		
		System.out.printf("\t\t%s 성적처리\n", school);
		System.out.println("=====================================================");
		for(String subject : subjectArr) {
			System.out.printf("%s\t", subject);
		}
		System.out.println();
		System.out.println("=====================================================");
		int totalScore = 0;
		int maxJava = 0;
		int numberOne = 0; // 평균 1등 번호
		String numberOneName = ""; // 평균 1등 이름 
		double maxScoreAvg = 0.0;
		
		for (int i = 0; i < scoreArr.length; i++) {
			System.out.printf("%d\t%s\t", i + 1, nameArr[i]);
			int sum = 0;
			for (int j = 0; j < scoreArr[0].length; j++) {
				System.out.printf("%d\t", scoreArr[i][j]);
				sum += scoreArr[i][j];
				maxJava = Math.max(maxJava, scoreArr[i][0]);
			}
			
			totalScore += sum;
			double scoreAvg = (double)sum / scoreArr[0].length;
			if (maxScoreAvg < scoreAvg) {
				maxScoreAvg = scoreAvg;
				numberOne = i + 1;
				numberOneName = nameArr[i];
			}
			
			System.out.printf("%d\t", sum);
			System.out.printf("%.2f\n", scoreAvg);
		}
		System.out.println("=====================================================");
		// Exam0821 대체
		// 각 과목의 총점을 구하고, 전체 총점과, 전체 평균을 보여주세요
		System.out.printf("\t총점 %d", totalScore);
		System.out.println();
		System.out.printf("\t자바과목의 최고점 [%d]", maxJava);
		System.out.println();
		System.out.printf("\t1등학생의 번호[%d] 이름 [%s]", numberOne, numberOneName);
		System.out.println();
		System.out.printf("\t오라클점수의 오름차순 정렬 출력 ");
		
		int[] oracleNew = new int[scoreArr.length];
		for (int i = 0; i < scoreArr.length; i++) {
			oracleNew[i] = scoreArr[i][1];
		}
		Arrays.sort(oracleNew);
		for (int i = 0; i < scoreArr.length; i++) {
			System.out.print(oracleNew[i] + " ");
		}
		
		System.out.println();
		System.out.println("=====================================================");
		
		/*
		 * 문제
		 * 1. 학생점수 구하기 (위에 있음)
		 * 
		 * 2. 이차원 배열 아래와 같이 생성한 후 값을 넣고 출력하세요.
		 * 
		 * int[][] arr2 = new int[10][10];
		 * -> 1만 테두리를 둘러 싸고 안에가 0으로 채워진 것 처럼
		 */	
		
		int[][] arr2 = new int[10][10];
		for(int i = 0; i < arr2.length; i++) {
			for(int j = 0; j < arr2[i].length; j++) {
				if (i == 0 || i == 9 || j == 0 || j == 9) {
					arr2[i][j] = 1;
				} 
			}
		}
		
		for(int i = 0; i < arr2.length; i++) {
			for(int j = 0; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}	
	}
}
