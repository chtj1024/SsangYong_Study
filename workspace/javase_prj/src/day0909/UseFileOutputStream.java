package day0909;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class UseFileOutputStream {
	
	public void useFileOutputStream() throws IOException {
		//0. 디렉토리가 존재하나?
		// 디렉토리가 존재하지 않으면 디렉토리 생성하고, 존재하면 생성작업은 실행하지 않는다.
		File dir = new File("c:/dev/temp");
		if (dir.exists()) {
			System.out.println("디렉토리가 없어 생성.");
			dir.mkdirs();
		}
		
		boolean createFlag = false; //코드 블럭을 제어하기위한 목적으로 생성하는 변수 : Flag변수
		//1. 파일이 존재하나?
		//덮어쓸것인지 여부를 confirmDialog로 물어본후 "확인"이면 덮어쓰고, "아니요"/"취소"라면
		//덮어쓰지않는다.
		File file = new File(dir.getAbsolutePath()+File.separator+"java_write.txt");
		if(file.exists()) {
			int selectedBtn = JOptionPane.showConfirmDialog(null, file.getName()+"파일이 존재합니다. 덮어쓰시겠습니까?");
			switch(selectedBtn) {
					case JOptionPane.OK_OPTION : createFlag = false; break;
					case JOptionPane.NO_OPTION : createFlag = true; break;
					case JOptionPane.CANCEL_OPTION : createFlag = true; break;
			}
		}
		
		if(createFlag) {
			//2. 목적지파일에 스트림을 연결한다.) 파일이 없으면 생성하고, 있으면 덮어 쓴다. 
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(file);
				int writeData = 65;
				//3.스트림에 데이터를 기록
				fos.write(writeData);// 65가 fos에 기록
				//4.스트림에 기록된 데이터를 목적지로 분출.
				fos.flush();
				System.out.println("목적지 파일에 데이터를 기록하였습니다.");
				
			}finally {
				if(fos != null) {
					fos.close();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		UseFileOutputStream ufos = new UseFileOutputStream();
		try {
			ufos.useFileOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JOptionPane.showInputDialog("디렉토리를 입력해주세요");
	}
}
