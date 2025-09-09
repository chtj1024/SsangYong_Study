package day0909;

import java.awt.FileDialog;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class UseFile {
	
	public void fileInfo() {
		//1. 생성
		
		File file = new File("C:/dev/temp/java_read.txt");
		System.out.println(file);
		
		if(file.exists()) {
			System.out.println("파일의 크기 : " + file.length() + "byte");
			System.out.println("디렉토리?" + file.isDirectory());
			System.out.println("파일?" + file.isFile());
			System.out.println("읽기권한이 있는지?" + file.canRead());
			System.out.println("쓰기권한이 있는지?" + file.canWrite());
			System.out.println("실행권한이 있는지?" + file.canExecute());
			System.out.println("절대경로?" + file.getAbsolutePath()); //여러개 경로로 사용 가능
			try {
				System.out.println("규범경로?" + file.getCanonicalPath());;// 하나의 경로로 사용.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void createDirectory() {
		//1. 생성할 디렉토리명을 저장할 파일 생성
		File file = new File("C:/dev/temp/chtj");
		//2. 생성
//		System.out.println("디렉토리 생성 : " + file.mkdir());
		//부모 디렉토리가 존재하지 않으면 하위 디렉토리를 생성하지 않는다.
		System.out.println("디렉토리 생성 : " + file.mkdirs());
	}
	
	public void deleteFile() {
		//1. 삭제할 파일명을 가진 파일 생성
		File file = new File("c:/dev/temp/java_read2.txt");
		//2. 삭제
		if(file.exists()
				&& JOptionPane.showConfirmDialog(null, "파일을 삭제하시겠습니까?") == JOptionPane.OK_OPTION) {
			System.out.println("파일삭제 : " + file.delete());
		}
	}
	
	public static void main(String[] args) {
		UseFile uf = new UseFile();
//		uf.fileInfo();
//		uf.createDirectory();
		uf.deleteFile();
	}
}
