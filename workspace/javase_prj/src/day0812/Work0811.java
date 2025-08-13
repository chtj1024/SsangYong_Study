package day0812;

public class Work0811 {
	
	public static final int TOWN_BUS = 1200;
	public static final int BUS = 1500;
	public static final int SUBWAY = 1550;
	public static final int FLAG_MONTH = 20;
	
	public static void main(String[] args) {
		
		int distance = Integer.parseInt(args[1]);
		String curVehicle = args[0];
		
		if( curVehicle.equals("마을버스") || curVehicle.equals("버스") || curVehicle.equals("지하철")) {
			int defaultCharge = 0; // 기본 요금
			int extraCharge = 0; // 초과 요금
			int excessDistance = 5; // 초과된 거리
			
			if (curVehicle.equals("마을버스")) {
				defaultCharge = TOWN_BUS;
			} else if (curVehicle.equals("버스")) {
				defaultCharge = BUS;
			} else {
				defaultCharge = SUBWAY;
			}
			
			if(distance > 10) {
				extraCharge = ((distance - 10 + excessDistance - 1) / excessDistance) * 100;
			}
			System.out.println("입력하신 교통수단 [" + curVehicle + "] 이고, 이동거리는 ["
					+ distance + "km] 입니다.");
			System.out.println("교통수단의 기본 요금 [" + defaultCharge + "]원 입니다.");
			System.out.println("편도 요금 [" + (defaultCharge + extraCharge) + "]원 입니다.");
			System.out.println("왕복 요금 [" + ((defaultCharge +extraCharge) * 2) + "]원 입니다.");
			System.out.println("한달 [" + FLAG_MONTH + "일] 기준 총 교통 요금 ["
					+ ((defaultCharge + extraCharge) * 2)*FLAG_MONTH + "]원 입니다.");
			
		} else {
			System.out.println("대중교통이 아닙니다.");
		}
	}
}
