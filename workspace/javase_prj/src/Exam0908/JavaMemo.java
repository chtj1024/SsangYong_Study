package Exam0908;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 문제
 * 아래의 기능을 구현하세요.
 * 그림으로 문제 보는 게 편해서 OneNote에 정리
 */
public class JavaMemo extends JFrame{
	
	private JMenuItem jmiNew;
	private JMenuItem jmiOpen;
	private JMenuItem jmiSave;
	private JMenuItem jmiEnd;
	
	private JMenuItem jmiFont;
	
	private JMenuItem jmiInfo;
	
	private JTextArea jtaMemo;
	
	public JavaMemo() {
		super("자바 메모장");
		
		JMenuBar menuBar = new JMenuBar();
		
		// 파일 메뉴 세팅
		JMenu fileMenu = new JMenu("파일");
		
		jmiNew = new JMenuItem("새글");
		jmiOpen = new JMenuItem("열기");
		jmiSave = new JMenuItem("저장");
		jmiEnd = new JMenuItem("종료");
		
		fileMenu.add(jmiNew);
		fileMenu.addSeparator();
		fileMenu.add(jmiOpen);
		fileMenu.add(jmiSave);
		fileMenu.addSeparator();
		fileMenu.add(jmiEnd);
		
		menuBar.add(fileMenu);
		
		// 서식 메뉴 세팅
		JMenu formatMenu = new JMenu("서식");
		jmiFont = new JMenuItem("글꼴");
		
		formatMenu.add(jmiFont);
		menuBar.add(formatMenu);
		
		// 도움말 메뉴 세팅
		JMenu helpMenu = new JMenu("도움말");
		jmiInfo = new JMenuItem("메모장정보");
		
		helpMenu.add(jmiInfo);
		menuBar.add(helpMenu);
		
		// 프레임에 메뉴바 세팅
		setJMenuBar(menuBar);
		
		jtaMemo = new JTextArea();
		JScrollPane jsp = new JScrollPane(jtaMemo);
		add(jsp);
		
		JavaMemoEvt jme = new JavaMemoEvt(this);
		
		jmiNew.addActionListener(jme);
		jmiOpen.addActionListener(jme);
		jmiSave.addActionListener(jme);
		jmiEnd.addActionListener(jme);
		addWindowListener(jme); // x창 눌러서 종료를 위해
		
		jmiFont.addActionListener(jme);
		jmiInfo.addActionListener(jme);
		
		setBounds(100, 100, 500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public JMenuItem getJmiNew() {
		return jmiNew;
	}

	public JMenuItem getJmiOpen() {
		return jmiOpen;
	}

	public JMenuItem getJmiSave() {
		return jmiSave;
	}

	public JMenuItem getJmiEnd() {
		return jmiEnd;
	}

	public JMenuItem getJmiFont() {
		return jmiFont;
	}

	public JMenuItem getJmiInfo() {
		return jmiInfo;
	}
	public JTextArea getJtaMemo() {
		return jtaMemo;
	}
	
	
}
