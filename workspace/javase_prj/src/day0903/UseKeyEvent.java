package day0903;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class UseKeyEvent extends JFrame implements KeyListener{

	private JTextField jtfID;
	private JPasswordField jtPassword;
	
	public UseKeyEvent() {
		super("윈도우 컴포넌트");
		jtfID = new JTextField();
		jtPassword = new JPasswordField();
		JLabel jlblResult = new JLabel();
		
		jtfID.setBorder(new TitledBorder("아이디"));
		jtPassword.setBorder(new TitledBorder("비밀번호"));
		jlblResult.setBorder(new TitledBorder("결과"));
		
		setLayout(new GridLayout(3,1));
		add(jtfID);
		add(jtPassword);
		add(jlblResult);
		
		jtfID.addKeyListener(this);
		jtPassword.addKeyListener(this);
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// Exam0903_2

	public static void main(String[] args) {
		new UseKeyEvent();
	}// main

	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("keyTyped : " + jtfID.getText()
//		+ " keyCode : " + e.getKeyCode() + ", KeyChar : " + e.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("keyPressed : " + jtfID.getText()
//		+ " keyCode : " + e.getKeyCode() + ", KeyChar : " + e.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//어떤 컴포넌트가 이벤트를 발생했는지 비교.
//		System.out.println(jtfID);
//		System.out.println("키가 눌렸음." + e.getSource());
		
		if(e.getSource() == jtfID) {
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE) { // KeyEvent.VK_ESCAPE는 27이다. ESC누르면 꺼짐
				dispose();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			jtPassword.requestFocus();
		}
		
//		System.out.println("keyReleased : " + jtfID.getText()
//		+ " keyCode : " + e.getKeyCode() + ", KeyChar : " + e.getKeyChar());
	}

}// class
