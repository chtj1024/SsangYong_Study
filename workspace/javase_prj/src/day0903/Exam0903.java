package day0903;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 문제
 * 그림 설명이 적합해서 OneNote에 복붙함
 */
public class Exam0903 extends JFrame implements ListSelectionListener{
	private DefaultListModel<String> dlm;
	private JList<String> jl;
	
	public Exam0903() {
		super("윈도우 컴포넌트");
		JLabel[] jlblInfo = new JLabel[4];
		JTextField[] jtfInfo = new JTextField[4];
		
		JPanel jpInfo = new JPanel();
		
		jlblInfo[0] = new JLabel("번호");
		jlblInfo[1] = new JLabel("이름");
		jlblInfo[2] = new JLabel("나이");
		jlblInfo[3] = new JLabel("전화번호");
		
		// JTextField 초기화
		for(int i = 0; i < jtfInfo.length; i ++) {
			jtfInfo[i] = new JTextField("");
		}
		
		// 표시할 정보들 구분
		jpInfo.setLayout(new GridLayout(4, 2));
		
		for(int i = 0; i < jlblInfo.length; i++) {
			jpInfo.add(jlblInfo[i]);
			jpInfo.add(jtfInfo[i]);
		}
		
		// JList의 Model, View 생성
		dlm = new DefaultListModel<String>();
		jl = new JList<String>(dlm);
		
		//JList 값 추가
		dlm.addElement("1,루피,20,010-1234-5678");
		
		//JList 스크롤 생성
		JScrollPane jsp = new JScrollPane(jl);
		
		setLayout(new BorderLayout());
		JPanel showInfo = new JPanel(new GridLayout(1, 2));
		showInfo.add(jpInfo);
		showInfo.add(jsp);
		
		// 버튼 생성 및 컨테이너 컴포넌트에 삽입
		JButton jbtn = new JButton("입력");
		JButton jbtn2 = new JButton("삭제");
		JButton jbtn3 = new JButton("변경");
		JButton jbtn4 = new JButton("종료");
		JPanel jbtns = new JPanel(new GridLayout(1, 4));
		jbtns.add(jbtn);
		jbtns.add(jbtn2);
		jbtns.add(jbtn3);
		jbtns.add(jbtn4);
		
		add(showInfo, BorderLayout.CENTER);
		add(jbtns, BorderLayout.SOUTH);
		
		jl.addListSelectionListener(this);
		
		setBounds(100, 100, 600, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Exam0903();
	}

	public void inputText() {
		
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
	}
}
