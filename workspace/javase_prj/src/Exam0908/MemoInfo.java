package Exam0908;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class MemoInfo extends JDialog{
	private JavaMemo jm;
	private JButton jbtnConfirm;
	
	public MemoInfo(JavaMemo jm) {
		super(jm, "메모장정보", true);
		this.jm = jm;
		
		JLabel jlblInfo = new JLabel("<html>Java 메모장 Version 1.0<br>이 메모장은 PL(Public License로)<br>아무나 자유롭게 배포, 수정이<br>가능합니다.<br>편하게 사용해주세요</html>");		
		jbtnConfirm = new JButton("확인");
		
		add(jlblInfo, BorderLayout.CENTER);
		add(jbtnConfirm, BorderLayout.SOUTH);
		
		MemoInfoEvt mie = new MemoInfoEvt(this);
		jbtnConfirm.addActionListener(mie);
		
		setBounds(150, 150, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	public JButton getJbtnConfirm() {
		return jbtnConfirm;
	}
	
}
