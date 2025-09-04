package day0904;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

/**
 * 메일주소(T) @ 도메인주소(T) 도메인선택(JCB)
 * 출력(JL)
 */
public class UseItemEvent extends MouseAdapter implements ActionListener, ItemListener {

	private UseItemDesign uid;
	
	public UseItemEvent(UseItemDesign uid) {
		this.uid = uid;
	}

	private boolean flag; // itemStateChange가 2번 실행되서 사용
	@Override
	public void itemStateChanged(ItemEvent e) {
		int idx = uid.getJcbTld().getSelectedIndex();
		if(idx != 0) {
		//JcomboBox가 선택되고, 0번 인덱스가 아니라면
		//선택한 인덱스(view) 번째 값(model)을 가져오고
			String selectedTld = uid.getDcbmTld().getElementAt(idx);
		//JTextField 설정
			uid.getJtfDomain().setText(selectedTld);
			//jTextField에 커서를 위치.
			uid.getJtfDomain().requestFocus();
			
		}
		flag = !flag;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//메일과 도메인을 얻어서
		JTextField jtfEmail = uid.getJtfEmail();
		JTextField jtfDomain = uid.getJtfDomain();
		
		String mail = uid.getJtfEmail().getText();
		String domain = uid.getJtfDomain().getText();
		
		if(!"".equals(mail)) {
			//JLabel의 \n으로 줄을 변경할 수 없다.
			// html 태그의 (<br>)를 사용하면 줄변경 가능.
			
			uid.getJlblOutput().setText("입력메일 : " + mail + "@" + domain);
			jtfEmail.setText("");
			jtfDomain.setText("");
			jtfEmail.requestFocus();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("wefefefwefef");
	}
	
	
}
