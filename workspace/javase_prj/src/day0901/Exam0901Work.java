package day0901;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class Exam0901Work {
	public static int keyCounter = 1;
	private Map<Integer, Exam0901DTO> mapStu;
	
	private static final String ADD_STUDENT = "1";
	private static final String SEARCH_STUDENT = "2";
	private static final String REMOVE_INFO = "3";
	private static final String EXIT_PROGRAMING = "4";
	
	private static final int NAME = 0;
	private static final int JAVA_POINT = 1;
	private static final int ORACLE_POINT = 2;
	
	public Exam0901Work() {
		mapStu = new HashMap<Integer, Exam0901DTO>();
	}
	
	public void menu() {
		boolean exitFlag = false;
		String inputMenu = "";
		do {
			inputMenu = JOptionPane.showInputDialog("아래의 메뉴를 입력 해주세요.\n1.입력 2.출력 3. 삭제 4.종료");
			// 취소나, x, 아무것도 입력하지 않고 "확인"을 누르면 일을하지 않는다.
			if( inputMenu != null && !"".equals(inputMenu)) {
				switch (inputMenu) {
				case ADD_STUDENT: addStudent(); break;
				case SEARCH_STUDENT:
					printSearchStudent(searchAllStudent()); break;
				case REMOVE_INFO : removeStudent(); break;
				case EXIT_PROGRAMING:
					System.out.println("사용해주셔서 감사합니다.");
					exitFlag = true; break;
				default: JOptionPane.showMessageDialog(null, "입력은 1,2,3,4 으로만 해주세요.");
				}
			} 
		} while(!exitFlag);
	}
	
	public void addStudent() {
		String inputData = JOptionPane.showInputDialog
				("이름과 점수를 csv 형식으로 입력해주세요.\n입력 예)이름, 자바점수, 오라클점수");
		
		if (inputData != null && !"".equals(inputData)) {
			String[] dataArr = inputData.split(",");
			if (dataArr.length == 3) { //입력이 csv형식이라면 업무 처리
				// 이름과 나이를 DTO에 저장
				
				int java = 0;
				int oracle = 0;
				try { // 정수 숫자만 점수에 등록되게 처리
				java = Integer.parseInt(dataArr[JAVA_POINT].trim());
				oracle = Integer.parseInt(dataArr[ORACLE_POINT].trim());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "정수 숫자만 입력해주세요");
					return;
				}
				int totalPoint = java + oracle;
				
				// 번호는 map의 keyCounter로 처리되므로 index 0번은 name으로 시작
				Exam0901DTO stuDTO = new Exam0901DTO(dataArr[NAME].trim(), java, oracle);
				
				// 입력된 여러 학생의 데이터를 관리하기위해서 Map추가
				mapStu.put(keyCounter++, stuDTO);
				JOptionPane.showMessageDialog(null, "학생의 정보가 추가되었습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "학생의 정보를 ,로 구분하여 입력해주세요.");
			}
		}
	}
	
	public String searchAllStudent() {
		StringBuilder outData = new StringBuilder();
		
		
		if (mapStu.size() != 0) {
			outData.append("번호\t이름\t자바점수\t오라클점수\t총점\n")
			.append("===================================\n");
			
			Exam0901DTO sDTO = null;
			for (Integer key : mapStu.keySet()) {
				
				sDTO = mapStu.get(key);
				

				int totalPoint = sDTO.getJavaPoint() + sDTO.getOraclePoint();

				// map의 키를 가져와야 하는데 흠..
				outData.append(key).append("\t")
				.append(sDTO.getName()).append("\t")
				.append(sDTO.getJavaPoint()).append("\t")
				.append(sDTO.getOraclePoint()).append("\t")
				.append(totalPoint).append("\n");
			}
			
		} else {
			outData.append("학생의 정보가 없습니다.\n");			
		}
		return outData.toString();
	}
	
	public void removeStudent() {
		String inputData = JOptionPane.showInputDialog
				("삭제할 학생의 번호를 입력해주세요");
		int num = Integer.parseInt(inputData);
		if (mapStu.containsKey(num)) {
			mapStu.remove(num);
			System.out.println("해당 학생의 정보가 삭제되었습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "학생의 정보가 없습니다.");
		}
	}
	
	private void printSearchStudent(String outData) {
		System.out.println(outData);
	}
}
