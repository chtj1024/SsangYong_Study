package day0902;

import java.awt.GridLayout;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * swing활용해서 현 월의 날짜를 출력하며
 * 이전 월, 다음 월의 날짜는 출력하지 않는다.
 * JButton으로 출력한다.
 * Calendar나 LocalDate를 사용해야 한다.
 */
public class Exam0902 extends JFrame {
	LocalDate date = LocalDate.of(2025, 9, 1);
	int lastDay = date.lengthOfMonth();
	
	public Exam0902() {
		super("9월의 캘린더");
		JButton[] jbtnDays = new JButton[lastDay + 1];
		JPanel jpDays = new JPanel();
		// 컨테이너에 날짜의 공백을 넣기 위한 jbutton 배열 객체 생성
		JButton[] jbtnSpace = new JButton[35 - lastDay];
		
		// 빈자리들을 채우기 위해 JButton의 객체 배열인 jbtnSpace를 공백들로 초기화
		// Swing의 Component는 하나의 부모(Container Component)만 가질 수 있ek.
		// 그렇기에 이미 어떤 컨테이너에 들어간 컴포넌트를 다른 컨테이너에 넣으면 이전 위치에서 자동으로 제거되고 새로운 위치에만 남기 때문
		for(int i = 0; i < jbtnSpace.length; i++) {
			jbtnSpace[i] = new JButton("");
		}
		
		jpDays.add(jbtnSpace[0]);
		
		String tempStr = "";
		for(int i = 1; i <= lastDay; i++) {
			tempStr = Integer.toString(i);
			jbtnDays[i] = new JButton(tempStr);
			jpDays.add(jbtnDays[i]);
		}
		
		for(int i = 1; i <= 4; i++) {
			jpDays.add(jbtnSpace[i]);
		}
		
		jpDays.setLayout(new GridLayout(5, 7));
		
		add("Center", jpDays);
		
		setSize(400, 300);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Exam0902();

	}
}
