package day0905;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class ExceptionFlow {
	
	public static void main(String[] args) {
		boolean flag = false;
		String inputYear = "";
		LocalDate ld = LocalDate.now();
		int nowYear = ld.getYear();
		int age = 0;
		
		do {
		inputYear = JOptionPane.showInputDialog("태어난 해 입력\n예)2025");
		
		nowYear = ld.getYear();
		try {
		age = nowYear - Integer.parseInt(inputYear) + 1;
		System.out.println(inputYear + "년 생의 나이는" + age + "살입니다.");
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "숫자만 입력해주세요.");
		}
		flag = JOptionPane.showInputDialog("그만하시려면 'Y'|'Y'를 입력해주세요.")
				.toUpperCase().equals("Y");
		}while(flag);
	}
}
