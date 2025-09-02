package day0902;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

//1. 윈도우 컴포넌트를 상속
public class UseBorderLayout extends JFrame {
	
	public UseBorderLayout() {
		super("BorderLayout");
		//2. 사용자에게 제공할 컴포넌트를 생성
		JButton jbtnNorth = new JButton("North");
		JButton jbtnWest = new JButton("West");
		
		JButton jlblEast = new JButton("East");
		JButton jlblSouth = new JButton("South");
		
		JTextArea jtaCenter = new JTextArea("Center");
		//3. 배치관리자 설정
		setLayout(new BorderLayout()); // 안해도 상관 없음.
		
		//4. 윈도우에 컴포넌트를 배치
		add("North", jbtnNorth);
//		add(BorderLayout.WEST, jbtnNorth);
		
		add(BorderLayout.CENTER, jtaCenter);
//		add("East", jlblEast);
//		add(BorderLayout.SOUTH, jlblSouth);
		
		//5. 윈도우에 크기 설정
		setSize(500, 500);
		
		//6. 윈도우 사용자에게 보여주기
		setVisible(true);
		
		//7. 윈도우 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new UseBorderLayout();
	}
}
