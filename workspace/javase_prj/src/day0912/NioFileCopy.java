package day0912;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NioFileCopy extends JFrame implements ActionListener{
	
	/**
	 * serialVersionUID : 현재 JVM에서 내보낸 객체인지 검증할 때 사용하는 ID
	 */
	private static final long serialVersionUID = 4248101895823334311L;

	public NioFileCopy() {
		super("파일복사");
		JButton jbtn = new JButton("파일을 선택해주세요.");
		
		
		JPanel jpCenter = new JPanel();
		jpCenter.add(jbtn);
		
		add("Center", jpCenter);
		
		jbtn.addActionListener(this);
		
		setBounds(100, 100, 400, 300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			fileCopy();
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(this, "파일이 복사되지 않았습니다.");
			ie.printStackTrace();
		}
	}
	
	public void fileCopy() throws IOException {
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(this);
		
		//선택한 파일을 받는다.
		File selectedFile = jfc.getSelectedFile();
		
		if(selectedFile != null) { //파일을 정상적으로 선택 했을 때
			//복사할 파일명 생성
			StringBuilder copyFileName = new StringBuilder(selectedFile.getAbsolutePath());
			
			copyFileName.insert(copyFileName.lastIndexOf("."), "_copy");
			File copyFile = new File(copyFileName.toString());
			
			//NIO를 사용한 파일 복사
			//1. 원본 Path 얻기
			Path originalPath = Path.of(selectedFile.getAbsolutePath());
			//2. 복사할 파일
			Path copyPath = Path.of(copyFile.getAbsolutePath());
			//3. 복사
			Files.copy(originalPath, copyPath, StandardCopyOption.COPY_ATTRIBUTES);
			
			JOptionPane.showMessageDialog(this, "복사되었습니다.");
				
		}
	}
	
	public static void main(String[] args) {
		new NioFileCopy();
	}


}
