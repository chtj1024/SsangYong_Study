package day0911;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class UseFileOutputStream2 {
	
	public void useFileOutputStreamAndOutputStreamWriter() throws IOException{
		File file = new File("c:/dev/temp/java_write.txt");
		//파일이 있는지? Y(덮어쓸것) : N (파일 생성)
		//1.스트림 생성
//		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		
		try {
			osw = new OutputStreamWriter(new FileOutputStream(file));
		
		//2.스트림에 목적지 파일에 기록된 내용쓰기
			String msg = "오늘은 목요일 입니다. 예비군 시즌.";
			osw.write(msg);
			
		//3.스트림의 내용을 목적지 파일로 분출
//			osw.flush();
			
			//4.연결끊기
		}finally {
//			if(fos != null) {fos.close();}
			if(osw != null) {osw.close();}
		}
	}
	
	public void useFileWriter() {
		File file = new File("c:/dev/temp/java_write2.txt");
		//try~with~resources : 스트림의 연결이 자동으로 끊어진다.
		//1.파일에 스트림을 연결 : 파일이 없으면 생성하고, 있으면 덮어쓴다.
		try(FileWriter fw = new FileWriter(file)) {
			//2. 스트림에 기록
			String msg = "내일은 금요일 입니다.";
			fw.write(msg);
			//3.스트림의 내용을 목적지로 분출
//			fw.flush();
			System.out.println("파일에 기록 되었습니다.");
			
		} catch(IOException ie) {
			ie.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		UseFileOutputStream2 ufos2 = new UseFileOutputStream2();
		try {
			ufos2.useFileOutputStreamAndOutputStreamWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("--------------------------");
		ufos2.useFileWriter();
	}
}
