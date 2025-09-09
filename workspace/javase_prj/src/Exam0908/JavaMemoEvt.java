package Exam0908;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JavaMemoEvt extends WindowAdapter implements ActionListener{

	private JavaMemo jm;
	
	public JavaMemoEvt(JavaMemo jm) {
		this.jm = jm;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jm.getJmiNew()) { //새글 버튼 클릭
			newMemo();
		} else if (e.getSource() == jm.getJmiOpen()) { // 열기 클릭
			openMemo();
		} else if (e.getSource() == jm.getJmiSave()) { // 저장 클릭 (열기와 기능은 같음)
			saveMemo();
		} else if (e.getSource() == jm.getJmiEnd()) { // 종료 클릭
			closeWin();
		} else if (e.getSource() == jm.getJmiFont()) { // 글꼴 클릭
			setFont();
		} else if (e.getSource() == jm.getJmiInfo()) {
			memoInfo();
		}
	}
	
	public void newMemo() {
		jm.getJtaMemo().setText("");
	}
	
	public void openMemo() {
		FileDialog fd = new FileDialog(jm, "파일 열기", FileDialog.LOAD);
		fd.setVisible(true);
		
		String dir = fd.getDirectory();
		String file = fd.getFile();
		
		if (file != null) {
			jm.setTitle(dir + file);
		}
	}
	
	public void saveMemo() {
		FileDialog fd = new FileDialog(jm, "파일 저장", FileDialog.SAVE);
		fd.setVisible(true);
		
		String dir = fd.getDirectory();
		String file = fd.getFile();
		
		if (file != null) {
			jm.setTitle(dir + file);
		}
	}
	
	public void closeWin() {
		jm.dispose();
		System.out.println("종료합니다.");
	}
	
	public void setFont() {
		new MemoFont(jm);
	}
	
	public void memoInfo() {
		new MemoInfo(jm);
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		jm.dispose();
	}
}
