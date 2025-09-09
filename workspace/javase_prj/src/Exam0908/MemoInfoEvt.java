package Exam0908;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MemoInfoEvt extends WindowAdapter implements ActionListener{
	private JavaMemo jm;
	private MemoFont mf;
	private MemoInfo mi;
	
	public MemoInfoEvt(MemoInfo mi) {
		this.mi = mi;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mi.getJbtnConfirm()) { // 확인버튼이 눌렸을 때
			mi.dispose();
		}
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		mi.dispose();
	}
}
