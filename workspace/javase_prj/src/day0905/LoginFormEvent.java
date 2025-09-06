package day0905;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFormEvent extends WindowAdapter implements KeyListener {

	private LoginForm lf;
	private LoginProcess lp;
	
	public LoginFormEvent(LoginForm lf) {
		this.lf = lf;
		lp = new LoginProcess(lf);
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		lf.dispose();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		//눌린 키의 값이 안나옴
//		System.out.println("keyTyped : " + e.getKeyCode() + ", " + lf.getJtfId().getText());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//눌린 키의 값이 나옴
//		System.out.println("keyTyped : " + e.getKeyCode() + ", " + lf.getJtfId().getText());
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		//눌린 키의 값이 나옴
//		System.out.println("keyTyped : " + e.getKeyCode() + ", " + lf.getJtfId().getText());
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_ENTER : lp.chkNull();
//		case
		}
	}

}
