package authLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import input_output.Design_7;
import input_output.Work_7;

/**
 * 로그인 화면에서 발생하는 이벤트들을 관리함<br>
 * 로그인 프로세스 종료 후 로그인 창 닫기와 취소 버튼을 눌렀을 때 창 닫기 이벤트 관리
 */
public class LoginEvent implements ActionListener, KeyListener {
	private LoginDesign ld;
	private LoginProcess lp;
	private String id, pwd;

	public LoginEvent(LoginDesign ld) {
		this.ld = ld;
		lp = new LoginProcess();
	}// LoginEvent

	@Override
	public void keyTyped(KeyEvent e) {
	}// keyTyped

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			id = ld.getJtfId().getText().trim();
			pwd = ld.getJtfPwd().getText().trim();

			if (lp.chkNull(id, pwd, ld)) {
				if (lp.login(id, pwd)) {
					System.out.println("로그인 성공");
					// 로그인 성공 시 LoginProcess 객체(lp)를 Design_7으로 전달
					new Design_7(ld, new Work_7(), lp);
					ld.dispose();
					return;
				} // end if
			} // end if
		} // end if
	}// keyPressed

	/**
	 * 엔터를 눌렀을 때 로그인을 실행하게끔 하기 위함
	 */
	@Override
	public void keyReleased(KeyEvent e) {

	}// keyReleades

	/**
	 * 버튼을 눌렀을 때 로그인을 실행하게끔 하기 위함
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ld.getJbtnConfirm()) {
			id = ld.getJtfId().getText().trim();
			pwd = ld.getJtfPwd().getText().trim();

			if (lp.chkNull(id, pwd, ld)) {
				if (lp.login(id, pwd)) {
					System.out.println("로그인 성공");
					// 로그인 성공 시 LoginProcess 객체(lp)를 Design_7으로 전달
					new Design_7(ld, new Work_7(), lp);
					ld.dispose();
					return;
				}
			} // end if

			System.out.println("로그인 실패");
		} else if (e.getSource() == ld.getJbtnDeny()) {
			ld.dispose();
		} // end if
	}// actionPerformed
}// class
