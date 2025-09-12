package day0911;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UseDataStream {
	
	private File fileName;
	public UseDataStream() {
		fileName = new File("c:/dev/temp/data.txt");
	}
	/**
	 * 기본형 데이터형을 파일로 저장
	 */
	public void dataOutput() {
		//1.스트림 연결
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))){
			int data = 65;
			//2. 스트림 데이터 기록
			dos.writeInt(data);
			dos.writeBoolean(false);
			dos.writeDouble(2025.0911);
			dos.writeUTF(null);
			//3. 스트림의 내용을 분출
			dos.flush();
			
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
	
	/**
	 * 파일에 저장된 기본형 데이터형 읽기.
	 */
	public void dataInput() {
		//1. 스트림연결
		try(DataInputStream dis = new DataInputStream(new FileInputStream(fileName))){
			//2. 파일의 내용을 int로 읽기
			int data = dis.readInt();
			boolean data2 = dis.readBoolean();
			double data3 = dis.readDouble();
//			data4 = dis.readUTF();
			System.out.println(data + " / " + data2 + " / " + data3);
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UseDataStream uds = new UseDataStream();
		System.out.println("기본형 데이터형 읽기");
		uds.dataOutput();
		System.out.println("기본형 데이터형 쓰기");
		uds.dataInput();
	}
}
