package authLogin;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 화면이나 이벤트가 아닌, java 소스코드로 작동하는 동작들 관리
 */
public class LoginProcess {
	private Map<String, String> userLoginInfo;
	private String loginUserId;
	
	/**
	 * 객체 생성 시 자동으로 Map에 로그인 가능한 사용자 등록
	 */
	public LoginProcess() {
		inputUser();
	}//LoginProcess
	
	/**
	 * 아이디와 비밀번호의 Null 체크<br>
	 * 아이디나 비밀번호가 비었을 경우 requestFocus가 동작하는 구역이 다르므로<br>
	 * 이 곳에서 requestFocus 이벤트를 처리함
	 * @param id 사용자가 입력한 아이디
	 * @param pwd 사용자가 입력한 비밀번호
	 * @param ld Login 창을 처리하는 화면(requestFocus를 처리하기 위함)
	 * @return Null 유무에 따른 true/false
	 */
	public boolean chkNull(String id, String pwd, LoginDesign ld) {
		boolean flag = false;
		
		if("".equals(id)) {
			new LoginFalse("아이디나 비밀번호를 입력하지 않았습니다 다시 확인해주세요");
			ld.getJtfId().requestFocus();
			return flag;
		}//end if
		
		if("".equals(pwd)) {
			new LoginFalse("아이디나 비밀번호를 입력하지 않았습니다 다시 확인해주세요");
			ld.getJtfPwd().requestFocus();
			return flag;
		}//end if
		
		flag = true;
		
		return flag;
	}//chkNull
	
	/**
	 * 로그인 가능한 사용자 등록
	 */
	public void inputUser() {
		userLoginInfo = new HashMap<String, String>();
		
		userLoginInfo.put("admin", "1234");
		userLoginInfo.put("root", "1111");
		userLoginInfo.put("administrator", "12345");
	}//inpuUser
	
	/**
	 * inputUser()에 등록되지 않은 사용자를 가려냄<br>
	 * 등록되지 않으면 경고창 띄운 후 false return<br>
	 * 등록되었으면 로그인한 id를 변수에 저장한 후 true return
	 * @param id 사용자가 입력한 아이디
	 * @param pwd 사용자가 입력한 비밀번호
	 * @return 로그인에 성공한다면 true, 실패한다면 false
	 */
	public boolean login(String id, String pwd) {
		boolean flag = false;
		Set<String> keys = userLoginInfo.keySet();
		
		for(String key : keys) {
			if(id.equals(key)) {
				if(pwd.equals(userLoginInfo.get(key))) {
					loginUserId = id;
					flag = true;
					//다음 메소드 부르기
				}//end if
			}//end if
		}//end for
		
		if(!flag) {
			new LoginFalse("아이디나 비밀번호가 일치하지 않습니다.");
		}//end if
		
		return flag;
	}//login
	
	/**
	 * 사용자가 로그인한 아이디를 불러냄
	 * @return 로그인한 사용자의 아이디
	 */
	public String getLoginUserId() {
		return loginUserId;
	}
}//class
