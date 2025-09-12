package day0911;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FileCopy extends JFrame implements ActionListener{
	
	/**
	 * serialVersionUID : 현재 JVM에서 내보낸 객체인지 검증할 때 사용하는 ID
	 */
	private static final long serialVersionUID = 4248101895823334311L;

	public FileCopy() {
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
			FileInputStream fis = null;
			FileOutputStream fos = null;
			

			
			//복사할 파일과 읽기 스트림으로 연결 
			
			try {
				fis = new FileInputStream(selectedFile);

				
				//복사할 파일명 생성 : 선택한 파일명에 확장자 .앞에 _copy라는 이름을 넣어 생성
				//a.txt -> a_copy.txt
				StringBuilder copyFileName = new StringBuilder(selectedFile.getAbsolutePath());
				
				copyFileName.insert(copyFileName.lastIndexOf("."), "_copy");
				File copyFile = new File(copyFileName.toString());
				
				
				fos = new FileOutputStream(copyFile); // 복사할 파일과 연결 : 파일 생성
				
//				int readData = 0;
//				int cnt = 0;
//				while((readData = fis.read()) != -1) {
//					cnt++;
//					fos.write(readData);
//				}
//				System.out.println("HDD" + cnt + "번 회전");	
				
				//HDD의 특성을 고려한 코드
				byte[] readData = new byte[512];
				int readSize = 0;
				int cnt = 0;
				while((readSize = fis.read(readData)) != -1) {
					cnt++;
					fos.write(readData, 0, readSize);
				}
				
				System.out.println("HDD" + cnt + "번 회전");	
				
				fos.flush();
				
				JOptionPane.showMessageDialog(this, copyFile.getName()+"으로 복사되었습니다.");
				
			} finally {
				if(fos != null) {fos.close();}
				if(fis != null) {fis.close();}
			}
		}
	}
	
	public static void main(String[] args) {
		new FileCopy();
	}


}
