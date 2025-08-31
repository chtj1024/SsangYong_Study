package day0829;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * 문제
 * 1. 아래의 입력을 받는 메뉴를 제공 JOptionPane.showInputDialog 사용
 *  1-입력 2-출력 3-종료
 * (취소와 x누르면 null 나옴)
 *  1을 입력하면 번호, 이름과 나이를 csv형태로 받는 InputDialog 제공하고 확인을 누르면
 *  이름과 나이를 DTO에 저장하고, DTO를 List(ArrayList)에 저장한다.
 *  
 *  2를 입력하면 List에 들어있는 모든 DTO을 꺼내와서 console에 출력을 한다.
 *  출력 예)
 *  번호 이름 나이
 *  1  홍길동 20
 *  2  루피  25
 *  ----------
 *  평균나이 xx살 (정수만 출력)
 *  
 *  3번을 입력하면 console에 "감사합니다."를 출력하고 프로그램이 종료됩니다.
 */



class InfoDTO{
	
	List<String> info = new ArrayList<String>();
	
	public void setInfo(String number, String name, String age) {
		 info.add(number + "," + name + "," + age);
		 
	}
	public List getInfo() {
		return info;
	}
}

public class Exam0829{
	
	public Exam0829() {
		String input = "";
		InfoDTO dto = new InfoDTO();
		
		do{
			input = JOptionPane.showInputDialog("아래의 메뉴를 입력해주세요.\n 1.입력 2.출력 3.종료");
			if (input == null) {
				System.out.println("강제종료하였습니다");
				break;
			}
			
			switch(input) {
			case "1": {
				String tempInfo = JOptionPane.showInputDialog("번호,이름,나이 형식으로 입력해주세요.");
				
				if (tempInfo == null) {
					System.out.println("종료하고 싶으시면 3을 입력해주세요.");
					break;
				}
				
				String[] str = tempInfo.split(",");
				dto.setInfo(str[0], str[1], str[2]);
				break;
			}
			case "2": {
				System.out.println("번호\t이름\t나이");
				
				int sum = 0;
				for(int i = 0; i < dto.info.size(); i++) {
					String[] str = dto.info.get(i).split(",");
					
					System.out.println(str[0] + "\t" + str[1] + "\t" + str[2]);
					sum += Integer.parseInt(str[2]);
				}
				System.out.println("------------------");
				System.out.println("평균 나이 : " + ((double)sum / dto.info.size()));
				break;
			}
			case "3": System.out.println("감사합니다"); break;
			}
		}while(!input.equals("3"));
	}
	
	public static void main(String[] args) {
		new Exam0829();
	}
}
