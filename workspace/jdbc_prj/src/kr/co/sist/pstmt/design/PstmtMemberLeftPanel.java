package kr.co.sist.pstmt.design;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 사원정보를 입력하는 패널 
 */
public class PstmtMemberLeftPanel extends JPanel{
	private JTextField jtfNum, jtfName, jtfAge, jtfGender, jtfTel, jtfInputDate;
	
	public PstmtMemberLeftPanel() {
		Font font = new Font("맑은 고딕", Font.BOLD, 24);
		
		JLabel jlblNum = new JLabel("호갱번호");
		jtfNum = new JTextField();
		jtfNum.setEditable(false);
		jlblNum.setFont(font);
		jtfNum.setFont(font);
		
		JLabel jlblName = new JLabel("고객이름");
		jtfName = new JTextField();
		jlblName.setFont(font);
		jtfName.setFont(font);
		
		JLabel jlblAge = new JLabel("나이");
		jtfAge = new JTextField();
		jlblAge.setFont(font);
		jtfAge.setFont(font);
		
		JLabel jlblGender = new JLabel("성별");
		jtfGender = new JTextField();
		jlblGender.setFont(font);
		jtfGender.setFont(font);
		
		JLabel jlblTel = new JLabel("전화번호");
		jtfTel = new JTextField();
		jlblTel.setFont(font);
		jtfTel.setFont(font);
		
		JLabel jlblInputDate = new JLabel("입력일");
		jtfInputDate = new JTextField();
		jtfInputDate.setEditable(false);
		jlblInputDate.setFont(font);
		jtfInputDate.setFont(font);
		
		setLayout(new GridLayout(6, 2));
		
		add(jlblNum);
		add(jtfNum);
		add(jlblName);
		add(jtfName);
		add(jlblAge);
		add(jtfAge);
		add(jlblGender);
		add(jtfGender);
		add(jlblTel);
		add(jtfTel);
		add(jlblInputDate);
		add(jtfInputDate);
		
		setBorder(BorderFactory.createTitledBorder("고객관리"));
	}

	public JTextField getJtfNum() {
		return jtfNum;
	}

	public JTextField getJtfName() {
		return jtfName;
	}

	public JTextField getJtfAge() {
		return jtfAge;
	}

	public JTextField getJtfGender() {
		return jtfGender;
	}

	public JTextField getJtfTel() {
		return jtfTel;
	}

	public JTextField getJtfInputDate() {
		return jtfInputDate;
	}
	
}
