package day0811;

public class Exam0811 {
	
	static final int VIL_BUS = 1200;
	static final int BUS = 1500;
	static final int SUBWAY = 1550;
	
	public static void main(String[] args) {
		// 제시된 요금표를 사용하여 콘솔에 출력하는 코드를 작성
		// 대중교통수단과 이동거리를 main method arguments로 입력받아 처리하는 프로그램 제작
		
		// 대중교통수단은 args[0]으로, 이동거리는 args[1]으로 입력받음
		
		
		
		// 제약사항 : 입력한 대중 교통수단이 "마을버스", "버스", "지하철"인 경우에만 아래의 출력형식으로
		// 			출력하고 그렇지 않다면 "대중교통수단이 아닙니다 출력"
		
		// *기본 요금 10km까지 무료이며, 초과 시 5km마다 100원씩 추가 요금이 발생
		
		// 출력형식 : 입력하신 교통수단은 [ ]이고, 이동거리는 [ ]km 입니다.
		// 교통수단의 기본 요금 : [ ]원
		// 편도요금 : [ ]원
		// 한달 20일 기준 총 교통 요금 [ ]원 입니다.
		
		int distance = Integer.parseInt(args[1]);
		
		int pCharge = 0;
		if (distance - 10 > 0) { // 11 ~ 15km 100원 추가 이런 식
			pCharge += (((distance - 11) / 5) + 1) * 100;
			// distance에서 10만 빼면 15일 때 200원이 되버리므로 11을 뺌
		}
		
		if (!args[0].equals("VIL_BUS") && !args[0].equals("BUS") && !args[0].equals("SUBWAY")) {
			System.out.println("대중교통수단이 아닙니다.");
			return;
		}
		
		int nowVehicle = 0;
		
		if (args[0].equals("VIL_BUS")) {
			nowVehicle = VIL_BUS;
		} else if (args[0].equals("BUS")) {
			nowVehicle = BUS;	
		} else if (args[0].equals("SUBWAY")) {
			nowVehicle = SUBWAY;	
		} 
		
		int oneGo = nowVehicle + pCharge;
		
		System.out.println("입력하신 교통수단은 " + args[0] + "이고, 이동거리는 " + distance + "km 입니다.");
		System.out.println("교통수단의 기본 요금 : " + nowVehicle + "원");
		
		System.out.println("편도요금 : " + oneGo);
		System.out.println("한달 20일 기준 총 교통 요금 " + ((oneGo * 2) * 20) + "원 입니다.");
	}
}
