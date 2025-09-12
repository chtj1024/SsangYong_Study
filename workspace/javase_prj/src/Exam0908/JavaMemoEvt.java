package Exam0908;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

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
		jm.getJtaMemo().setText(""); // 초기화

	}
	
	public void openMemo() {
		
		FileDialog fd = new FileDialog(jm, "파일 열기", FileDialog.LOAD);
		fd.setVisible(true);
		
		String dir = fd.getDirectory();
		String file = fd.getFile();
		
		if (dir != null && file != null) {
			String filePath = dir + file;
			
			StringBuilder sb = new StringBuilder();
			try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
				String line;
				while((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			String fileContent = sb.toString();
			String jtaContent = jm.getJtaMemo().getText();
			
			
			if (jm.getJtaMemo().getText().trim().isEmpty()) {// JTA에 아무런 내용이 없다면	
				
			} else {
				if (fileContent.equals(jtaContent)) { // 연 파일의 내용과 JTA의 내용이 같다면
					//JTA에 그대로 뿌림 -> 파일열기
					try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
						jm.getJtaMemo().setText(""); // 이전 내용 지우기
						String line;
						while((line = br.readLine()) != null) {
							jm.getJtaMemo().append(line + "\n");
						}
						
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				} else { // 다를 때
					int choice = JOptionPane.showConfirmDialog(null,
							"파일 내용과 JTextArea의 내용이 다릅니다.\n" +
							"JTextArea 내용을 파일에 저장할까요?",
							"저장 확인",
							JOptionPane.YES_NO_OPTION);
					
					if(choice == JOptionPane.YES_OPTION) {
						try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
							bw.write(jm.getJtaMemo().getText());
							JOptionPane.showMessageDialog(null, "파일에 저장했습니다.");
						} catch(IOException ex) {
							ex.printStackTrace();
						}
					} else if (choice == JOptionPane.NO_OPTION) {
						jm.getJtaMemo().setText("");
					}
				}
			}
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
