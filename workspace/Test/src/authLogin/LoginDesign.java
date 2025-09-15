package authLogin;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 로그인 화면<br>
 * 	- 아이디 비밀번호를 라벨로 사용자에게 구분하게 한 후 JTextField에 입력하게 함<br>
 * 	- 로그인하기 버튼을 누르면 로그인 실행, 취소 버튼을 누르면 창 닫기
 */
public class LoginDesign extends JFrame {
	private JTextField jtfId, jtfPwd;
	private JButton jbtnConfirm, jbtnDeny;
	
	public LoginDesign() {
		super("로그인");
		
		jtfId = new JTextField(7);
		jtfPwd = new JTextField(7);
		jbtnConfirm = new JButton("로그인하기");
		jbtnDeny = new JButton("취소");
		
		JLabel jlblId = new JLabel("아이디 ");
		JLabel jlblPwd = new JLabel("비밀번호");
		
		JPanel jpId = new JPanel();
		JPanel jpPwd = new JPanel();
		JPanel jpButton = new JPanel();
		
		jbtnConfirm.setSize(new Dimension(20, 10));
		
		jpId.add(jlblId);
		jpId.add(jtfId);
		
		jpPwd.add(jlblPwd);
		jpPwd.add(jtfPwd);
		
		jpButton.add(jbtnConfirm);
		jpButton.add(jbtnDeny);
		
		add("North", jpId);
		add("Center", jpPwd);
		add("South", jpButton);
		
		LoginEvent le = new LoginEvent(this);
		jtfId.addKeyListener(le);
		jtfPwd.addKeyListener(le);
		jbtnConfirm.addActionListener(le);
		jbtnDeny.addActionListener(le);
		
		setBounds(100, 100, 350, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//LoginDesign
	
	public JTextField getJtfId() {
		return jtfId;
	}//getJtfId
	
	public JTextField getJtfPwd() {
		return jtfPwd;
	}//getJtfPwd

	public JButton getJbtnConfirm() {
		return jbtnConfirm;
	}//getJbtnConfirm

	public JButton getJbtnDeny() {
		return jbtnDeny;
	}//getJbtnDeny

	public static void main(String[] args) {
		new LoginDesign();
	}//main
}
