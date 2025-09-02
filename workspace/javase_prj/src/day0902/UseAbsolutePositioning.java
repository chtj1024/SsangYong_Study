package day0902;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

public class UseAbsolutePositioning extends JFrame {
	
	public UseAbsolutePositioning() {
		super("수동배치");
		
		//2. 컴포넌트를 생성
		JButton jbtn = new JButton("버튼");
		JComboBox<String> jcb = new JComboBox<String>();
		jcb.addItem("JButton - 눌러서 일을 할 수");
		jcb.addItem("JLable - 특정 컴포넌트의 이름표");
		jcb.addItem("JTextArea - 여러 줄의 입력을 받거나, 보여줄 때");
		jcb.addItem("JTextField - 한 줄의 입력을 받거나, 보여줄 때");
		jcb.addItem("JPasswordField - 비밀번호를 입력 받거나, 보여줄 때");
		JPasswordField jpf = new JPasswordField();
		JCheckBox jckbox = new JCheckBox("체크박스");
		
		//3. 배치관리자를 해제
		setLayout(null); // BorderLaout => 수동배치
		
		//4. 컴포넌트의 크기설정
		jbtn.setSize(80, 30);
		jcb.setSize(250, 35);
		jpf.setSize(120,35);
		
		//5. 컴포넌트의 배치 위치를 설정
		jbtn.setLocation(50, 60);
		jcb.setLocation(120,120);
//		jpf.setLocation(300, 350);
		jpf.setBounds(300, 350, 120, 35);
		jckbox.setBounds(100, 250, 100, 100);
		
		//6. 배치
		add(jbtn);
		add(jcb);
		add(jpf);
		add(jckbox);
		
		// 창을 늘리거나 줄여도 각 컴포넌트들의 크기가 바뀌지 않음.
		setResizable(true);
		
		//7.윈도우크기 설정
		setSize(500, 500);
		
		//8.윈도우 가시화
		setVisible(true);
		
		//9.윈도우 종료 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new UseAbsolutePositioning();
	}
}
