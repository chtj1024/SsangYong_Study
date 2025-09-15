package authLogin;

import javax.swing.JOptionPane;

/**
 * 경고창으로 사용하기 위함<br>
 * 에러 메시지를 입력한 후 부르면 경고 메시지를 띄움<br>
 * 로그인 관련 경고를 구분하기 쉽게 하기 위해 호출. 없애고 따로 입력해도 무방하나<br>
 * work 8번의 2 메뉴 호출 시 입력만 하면 띄울 수 있게끔 하기 위해 작성함
 */
public class LoginFalse {
	public LoginFalse(String errMsg) {
		JOptionPane.showMessageDialog(null, errMsg);
	}
}
