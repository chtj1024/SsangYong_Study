package day0904;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Exam0904Event implements KeyListener{

	private Exam0904Design e0904d;
	
	public Exam0904Event(Exam0904Design e0904d) {
		this.e0904d = e0904d;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {	
		if(e.getSource() == e0904d.getJtfID()) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				if(e0904d.getJtfID().getText().trim().isEmpty()) {
					e0904d.getJtfID().requestFocus();
				} else {
					e0904d.getJtPassword().requestFocus();
				}
			}
		} else if (e.getSource() == e0904d.getJtPassword()) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				// 비밀번호는 getpassword()를 사용하는데 이 것은 char[]형으로 반환한다.
				char[] tempStr = e0904d.getJtPassword().getPassword();
				//그렇기에 char 형의 배열의 값들을 String으로 변환해 비교할 것이다.
				String passwordStr = new String(tempStr);
				
				if(tempStr.equals("")) {
					e0904d.getJlblResult().setText("비밀번호를 입력하세요.");
				} else {
					e0904d.getJtPassword().requestFocus();
					// 입력된 패스워드가 map의 키들 중 일치한 게 있으면
					if(e0904d.getDataMap().containsKey(passwordStr)) {
						e0904d.getJlblResult().setText("로그인 성공");
					} else {
						e0904d.getJlblResult().setText("로그인 실패");						
					}
				}
				
			}
		}
	}

}
