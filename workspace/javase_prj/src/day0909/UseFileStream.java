package day0909;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UseFileStream {
	
	public void useFileInputStream() throws IOException{
		File file = new File("c:/dev/temp/java_read.txt");
		if(!file.exists()) {
			System.out.println(file + "파일의 경로를 확인해주세요.");
			return;
		}
		
		FileInputStream fis = null;
		try {
			//1. 목적지 파일에 스트림을 연결
			fis = new FileInputStream(file); // FileNotFoundException 떨어지고
			//2. 연결된 파일의 내용 읽어 들이기.
			int readData = fis.read(); // 얘는 IOException이 떨어지고 얘가 FileNotFoundException의 부모기 때문에 IOException으로 catch
			System.out.println(readData);
		} finally {

				if(fis != null) {
					fis.close();
				}
		}
	}
	/**
	 * 8bit stream과 16bit stream연결하여 사용
	 */
	public void useBinaryStreamJoinStringStream() {
		File file = new File("c:/dev/temp/java_read.txt");
		if(!file.exists()) {
			return;
		}
		
		//읽어들인 값에 주민번호가 있으면 삭제한다.
		//1.스트림을 연결하여 확장한다.
		try (BufferedReader br = new BufferedReader(new InputStreamReader
				(new FileInputStream(file)))){
			
			String temp = "";
			
			System.out.println(br.readLine());
			
			while((temp = br.readLine()) != null) {
				temp.replaceAll("\\d{6}-\\d{7}", "");

				System.out.println(temp);
			}
			
		} catch(IOException ie) {
			ie.printStackTrace();
		}
	}
	
	public void useFileReader() {
		File file = new File("c:/dev/temp/java_read.txt");
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String readData = "";
			StringBuilder sbData = new StringBuilder();
			while((readData = br.readLine()) != null) {
				sbData.append(readData).append("\n");
			}
			
			JTextArea jta = new JTextArea(sbData.toString(), 10, 40);
//			jta.setEditable(false);
			jta.setLineWrap(true); // 행의 단어가 지정한 컬럼수와 같다면 자동 줄변경
			jta.setWrapStyleWord(true); // 단어를 보호 (단어별로 줄 변경 - 한글x)
			JScrollPane jsp = new JScrollPane(jta);
			
			JOptionPane.showMessageDialog(null, jsp);
			
			System.out.println(sbData);
			
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UseFileStream ufs = new UseFileStream();
		
		try {
			ufs.useFileInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("------------------------------");
		ufs.useBinaryStreamJoinStringStream();
		System.out.println("------------------------------");
		ufs.useFileReader();
		
		// msg dialog에 jtextarea를 넣고 출력하고싶다.
		
	}
}
