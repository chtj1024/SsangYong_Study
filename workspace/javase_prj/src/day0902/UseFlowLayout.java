package day0902;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * 흐름레이아웃의 사용.
 */

//1. 윈도우 컴포넌트 상속
public class UseFlowLayout extends JFrame{
	
	public UseFlowLayout() {
		super("FlowLayout 사용");
		//2. 컴포넌트를 생성.
		JLabel jlblName = new JLabel("이름");
		JTextField jtfName = new JTextField(10);
		JRadioButton jrbMale = new JRadioButton("남자");
		JRadioButton jrbFemale = new JRadioButton("여자");
		JButton jbtnInput = new JButton("입력");
		
		// 라디오버튼은 여러개 중 하나만 선택되어야 한다.
		// 버튼그룹 생성
		ButtonGroup bg = new ButtonGroup();
		// 버튼그룹에 포함.
		bg.add(jrbMale);
		bg.add(jrbFemale);
		
		//3. 레이아웃매니저 설정. (BorderLayout => FlowLayout)
//		setLayout(new FlowLayout());
//		setLayout(new FlowLayout(FlowLayout.LEFT));
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		//4. 배치 (L -> R 순서대로 배치)
		add(jlblName);
		add(jtfName);
		add(jrbMale);
		add(jrbFemale);
		add(jbtnInput);
		
		//5. 윈도우의 크기 설정
		setSize(500, 300);
		
		//6. 가시화
		setVisible(true);
		
		//7. 종료 이벤트 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new UseFlowLayout();
	}
}
