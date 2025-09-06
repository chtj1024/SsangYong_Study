package day0904;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * 문제 (has a 관계로 처리) UseKeyEvent 형식 UI로 할 것.
 * map에 
 * id - kim, password - 1234
 * id - kim2, password - Lee1234
 * id - park, password - q1w2e3r4
 * 아이디에서 엔터가 눌려지면 값이 있을 때에는 비밀번호로 커서를 이동하고
 * 값이 없을때에는 아이디에 커서가 존재.
 * 
 * 비밀번호에서 엔터가 눌려지면 아이디에 값이 있는지 판단하고, 값이 있을 떄에는
 * 비밀번호로 커서를 이동하고
 * 값이없을 때에는 비밀번호에 커서가 존재
 * 값이 있다면 아이디와 비밀번호를 가지고 Map에 존재하는 값인지 판단하고
 * 비밀번호가 일치하면
 * 
 * 결과창에 "로그인 성공"을 보여준다.
 * 일치하지 않으면 "로그인 실패"를 보여준다.
 * 
 * 0904에 한 login 파일들이 정답이다.
 */
public class Exam0904Design extends JFrame {
	
	private JTextField jtfID;
	private JPasswordField jtPassword;
	private JLabel jlblResult;
	
	private Map<String, String> dataMap;
	
	public Exam0904Design() {
		super("윈도우 컴포넌트");
		jtfID = new JTextField();
		jtPassword = new JPasswordField();
		jlblResult = new JLabel();
		
		Exam0904Event e0904e = new Exam0904Event(this);
		
		jtfID.setBorder(new TitledBorder("아이디"));
		jtPassword.setBorder(new TitledBorder("비밀번호"));
		jlblResult.setBorder(new TitledBorder("결과"));
		
		dataMap = new HashMap<String, String>();
		
		dataMap.put("1234", "kim");
		dataMap.put("Lee1234", "kim2");
		dataMap.put("q1w2e3r4", "park");
		
		setLayout(new GridLayout(3,1));
		add(jtfID);
		add(jtPassword);
		add(jlblResult);
		
		jtfID.addKeyListener(e0904e);
		jtPassword.addKeyListener(e0904e);
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Exam0904Design();
	}
	
	
	public JTextField getJtfID() {
		return jtfID;
	}
	public JPasswordField getJtPassword() {
		return jtPassword;
	}
	public JLabel getJlblResult() {
		return jlblResult;
	}

	public Map<String, String> getDataMap() {
		return dataMap;
	}	
}
