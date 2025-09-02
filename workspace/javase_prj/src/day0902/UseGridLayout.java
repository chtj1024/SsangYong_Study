package day0902;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * 
 */
public class UseGridLayout extends JFrame {
	
	public UseGridLayout() {
		super("그리드 레이아웃");
		
		// 2. 컴포넌트 생성
		JCheckBox jcb = new JCheckBox("체크박스1");
		JCheckBox jcb2 = new JCheckBox("체크박스2");
		JCheckBox jcb3 = new JCheckBox("체크박스3");
		
		JButton jbtn = new JButton("버튼1");
		JButton jbtn2 = new JButton("버튼2");
		JButton jbtn3 = new JButton("버튼3");
		
		JComboBox<String> jcombo = new JComboBox<String>();
		jcombo.addItem("이것이 자바다");
		jcombo.addItem("저것은 자반가?");
		jcombo.addItem("오라클");
		JComboBox<String> jcombo2 = new JComboBox<String>();
		jcombo2.addItem("자바");
		jcombo2.addItem("오라클");
		jcombo2.addItem("JDBC");
		JComboBox<String> jcombo3 = new JComboBox<String>();
		jcombo3.addItem("010");
		jcombo3.addItem("011");
		jcombo3.addItem("016");
		
		// 3. 배치관리자 설정
		setLayout(new GridLayout(2, 3));
		
		// 4. 배치
		add(jcb);
		add(jcb2);
		add(jcb3);
		add(jbtn);
		add(jbtn2);
		add(jbtn3);
		add(jcombo);
		add(jcombo2);
		add(jcombo3);
		
		// 5. 윈도우 크기 설정
		setSize(300, 200);
		
		// 6. 가시화
		setVisible(true);
		
		// 7. 윈도우 종료 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new UseGridLayout();
	}
}
