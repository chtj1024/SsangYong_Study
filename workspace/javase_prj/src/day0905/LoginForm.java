package day0905;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class LoginForm extends JFrame {

	private JTextField jtfId;
	private JPasswordField jtPassword;
	private JLabel jlblResult;
	
	public LoginForm() {
		super("윈도우 컴포넌트");
		jtfId = new JTextField();
		jtPassword = new JPasswordField();
		jlblResult = new JLabel();
		
		jtfId.setBorder(new TitledBorder("아이디"));
		jtPassword.setBorder(new TitledBorder("비밀번호"));
		jlblResult.setBorder(new TitledBorder("결과"));
		
		setLayout(new GridLayout(3,1));
		add(jtfId);
		add(jtPassword);
		add(jlblResult);
		
		//디자인 클래스와 이벤트 클래스를 has a관계로 객체화
		LoginFormEvent lfe = new LoginFormEvent(this);
		//키보드이벤트 등록
		jtfId.addKeyListener(lfe);
		jtPassword.addKeyListener(lfe);
		//윈도우이벤트 등록
		addWindowListener(lfe);
		
		setSize(300, 400);
		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JTextField getJtfId() {
		return jtfId;
	}
	public JPasswordField getJtPassword() {
		return jtPassword;
	}
	public JLabel getJlblResult() {
		return jlblResult;
	}

}// class
