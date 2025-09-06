package day0905;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginProcess {
	private Map<String, String> mapLoginData;
	private LoginForm lf;
	
	public LoginProcess(LoginForm lf) {
		this.lf = lf;
		mapLoginData = new HashMap<String, String>();
		mapLoginData.put("kim", "1234");
		mapLoginData.put("kim2", "Lee1234");
		mapLoginData.put("park", "q1w2e3r4");
	}
	
	public void chkNull() {
		boolean flag = false;
		JTextField jtfId = lf.getJtfId();
		JPasswordField jpfPass = lf.getJtPassword();
		JLabel jlblResult = lf.getJlblResult();
		
		String id = jtfId.getText().trim();
		
		if("".equals(id)) { //아이디가 없다면
			jtfId.requestFocus();
			return;
		}
		
		String pass = new String(jpfPass.getPassword());
		
		if("".equals(pass)) {
			jpfPass.requestFocus();
			return;
		}
		
		String resultMsg = "<html>로그인 실패 -<br> 아이디나 비번을 확인하세요.</html>";
		if(login(id, pass)) {
			resultMsg = "로그인 성공!!!";
		}
		
		jlblResult.setText(resultMsg);
	}
	
	private boolean login(String id, String pass) {
		boolean flag = false;
		
		if(mapLoginData.containsKey(id)) {
			flag = mapLoginData.get(id).equals(pass); // 비밀번호가 맞으면 true.
		}
		
		return flag;
	}
}
