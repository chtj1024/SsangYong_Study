package day1020;

import java.awt.CardLayout;import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class UseJTabbedPane extends JFrame implements ActionListener{
	
	private JPanel jpCenter, jpA, jpB, jpC;
	
	public UseJTabbedPane() {
		super("카드레이아웃");
		
		jpCenter = new JPanel();
		
		jpA = new JPanel();
		jpA.add(new JLabel("패널A"));
		jpA.add(new JButton("클릭"));
		
		jpB = new JPanel();
		jpB.setLayout(new GridLayout(3, 1));
		jpB.add(new JTextField("이름"));
		jpB.add(new JTextField("나이"));
		jpB.add(new JButton("클릭"));
		
		jpC = new JPanel();
		jpC.add(new JLabel("이름"));
		jpC.add(new JTextField(10));
		jpC.add(new JButton("입력"));
		
		jpA.setBorder(new TitledBorder("입력A"));
		jpA.setBorder(new TitledBorder("입력B"));
		jpA.setBorder(new TitledBorder("입력C"));
		
		//탭을 제공하는 컴포넌트를 생성
		JTabbedPane jtp = new JTabbedPane();
		
		//탭에 패널 등록
		jtp.add("개인회원정보" , jpA);
		jtp.add("기업회원정보" , jpB);
		jtp.add("외국인회원정보" , jpC);
		
//		jpCenter.add(jtp); // 여러개의 패널을 가진 JTab을 배치
		
		//처음 보여줄 패널 설정
		add("Center", jtp);
		
		
		setBounds(100, 100, 500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}
	
	public static void main(String[] args) {
		new UseJTabbedPane();
	}
}
