package day0902;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 */
//1. 윈도우 컴포넌트 상속
public class MultipleLayout extends JFrame {
	
	public MultipleLayout() {
		super("여러개의 Layout 사용");
		//2. 일반컴포넌트 생성
		JLabel jlblName = new JLabel("이름");
		JTextField jtfName = new JTextField(20);
		JButton jbtnInput = new JButton("입력");
		
		//BorderLayout에 Center에 들어갈 컴포넌트
		JTextArea jtaNameView = new JTextArea();
//		TextArea jtaNameView = new TextArea();
		JScrollPane jspJtaNameView = new JScrollPane(jtaNameView);
		
		//3. 컨테이너 컴포넌트를 생성
		JPanel jpNorth = new JPanel();
		
		//4. 배치관리자를 설정
		setLayout(new BorderLayout()); // Frame의 Layout
		jpNorth.setLayout(new FlowLayout()); // Panel의 Layout
		
		//5. 컴포넌트를 배치
		// 컨테이너 컴포넌트에 일반 컴포넌트를 배치
		jpNorth.add(jlblName);
		jpNorth.add(jtfName);
		jpNorth.add(jbtnInput);
		
		// 윈도우 컴포넌트에 컴포넌트를 배치
		add(BorderLayout.NORTH, jpNorth);
//		add(BorderLayout.CENTER, jtaNameView);
		add(BorderLayout.CENTER, jspJtaNameView); // has a 관계를 가진 JScrollPane을 배치
		
		//6. 윈도우의 크기를 설정
		setSize(450, 400);
		
		//7. 가시화
		setVisible(true);
		
		//8. 윈도우 종료 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MultipleLayout();
	}
}
