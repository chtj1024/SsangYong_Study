package day0909;

import java.awt.Font;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Exam0909 {
	
	JTextArea jta;
	
	public Exam0909() {
		String dirStr = JOptionPane.showInputDialog("디렉토리를 입력해주세요.");
		File dir = new File(dirStr);
		
		jta = new JTextArea(10, 70);
		//칸을 맞추기위해 고정폭글꼴 설정
		jta.setFont(new Font("Monospaced", Font.PLAIN, 14));
		jta.setEditable(false);//수정 못하게
		jta.setLineWrap(true); //줄바꿈 허용
		jta.setWrapStyleWord(true);
		
		getAllFileInfo(dir);
	}
	
	public void getAllFileInfo(File dir) {
		if (dir.isDirectory()) {
			
			File[] files = dir.listFiles();
			
			if (files != null) {
				Date date;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
				
				jta.append("이름\t\t수정한날짜\t\t\t유형\t크기\n");
				for (File file : files) {
					date = new Date(file.lastModified());
					String formattedDate = sdf.format(date);
					String chkFileType = "";
					
					if (file.isFile()) {
						chkFileType = "파일";
					} else {
						chkFileType = "폴더";
					}
					
					jta.append(file.getName() + "\t" +
					formattedDate + "\t" +
					chkFileType + "\t" +
					file.length() + "byte\n" );
				}
				JOptionPane.showMessageDialog(null, jta, "메세지", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public static void main(String[] args) {
		new Exam0909();
	}
}
