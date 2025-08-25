package day0821;

public class ObjectArray {
	
	public void processScore(StudentScoreDTO[] ssArr) {
		// 일괄처리
		StudentScoreDTO ssDTO = null;
		
		for(int i = 0; i < ssArr.length; i++) {
			ssDTO = ssArr[i];
			int totalScore = ssDTO.getJava() +ssDTO.getOracle() + ssDTO.getJdbc();
			double scoreAvg = totalScore / 3.0;
			System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\n", ssDTO.getNum(),
					ssDTO.getName(), ssDTO.getJava(), ssDTO.getOracle(), ssDTO.getJdbc(),
					totalScore, scoreAvg);
		}
	}
	
	public static void main(String[] args) {
		StudentScoreDTO[] ssArr = new StudentScoreDTO[4];
		
		ssArr[0] = new StudentScoreDTO(3, "루피", 67, 75, 83);
		ssArr[1] = new StudentScoreDTO(4, "샹디", 77, 85, 73);
		ssArr[2] = new StudentScoreDTO(25, "쵸파", 98, 100, 100);
		ssArr[3] = new StudentScoreDTO(6, "나미", 88, 89, 83);
		
		ObjectArray oa = new ObjectArray();
		oa.processScore(ssArr);
	}
}
