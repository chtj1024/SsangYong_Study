package day0905;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Exam0905Event extends MouseAdapter implements ListSelectionListener, ActionListener{

	private Exam0905Design e0905d;
	
	public Exam0905Event(Exam0905Design e0905d) {
		this.e0905d = e0905d;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == e0905d.getJbtn()) { //입력 버튼이 눌렸을 때
			if (e0905d.getJtfNumber().getText().trim().isEmpty()
					|| e0905d.getJtfName().getText().trim().isEmpty()
					|| e0905d.getJtfAge().getText().trim().isEmpty()
					|| e0905d.getJtfPhoneNum().getText().trim().isEmpty()) {
				System.out.println("빈칸 없이 입력해주세요.");
			} else { // JTextField에 빈칸이 없을 때 
				String tempStr = e0905d.getJtfNumber().getText().trim() + ","
						+ e0905d.getJtfName().getText().trim() + ","
						+ e0905d.getJtfAge().getText().trim() + ","
						+ e0905d.getJtfPhoneNum().getText().trim();
				e0905d.dlm.addElement(tempStr); // JList에 문자열 추가.
				
				// JTextField 초기화
				e0905d.getJtfNumber().setText("");
				e0905d.getJtfName().setText("");
				e0905d.getJtfAge().setText("");
				e0905d.getJtfPhoneNum().setText("");
				// 커서를 번호에 위치
				e0905d.getJtfNumber().requestFocus();
			}
		} else if (e.getSource() == e0905d.getJbtn2()) { // 삭제버튼이 눌렸을 때
			String strNum = e0905d.getJtfNumber().getText().trim();
			if (strNum.equals("")) {
				System.out.println("삭제하는 아이템을 클릭해주세요.");
			} else {
				boolean found = false; // 해당 번호가 없을 때 체크하기 위한
				
				for(int i = 0; i < e0905d.dlm.getSize(); i++) {
					String item = e0905d.dlm.getElementAt(i);
					String[] parts = item.split(",");
					
					if (parts[0].trim().equals(strNum)) {
						e0905d.dlm.remove(i);
						System.out.println("삭제 완료.");
						found = true;
						break;
					}
				}
				
				if(!found) {
					System.out.println("JList에 해당번호 \'" + strNum + "\'에 맞는 아이템은 없습니다.");
				}
			}
			
		} else if (e.getSource() == e0905d.getJbtn3()) { // 종료버튼을 눌렀을 때
			e0905d.dispose();
			System.out.println("종료되었습니다.");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 1) {
			//클릭했을 때 JList의 값을 문자열에 담음
			String selected = e0905d.jl.getSelectedValue();
			
			if (selected != null) { // 빈칸의 JList를 클릭하면 null이 반환되므로
				String[] infoArr = selected.split(",");
				
				// 그 문자열들을 JTextField에 보여줌.
				e0905d.getJtfNumber().setText(infoArr[0]);
				e0905d.getJtfName().setText(infoArr[1]);
				e0905d.getJtfAge().setText(infoArr[2]);
				e0905d.getJtfPhoneNum().setText(infoArr[3]);
			}
		}
	}

}
