package day0911;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UseMarshallStream {
	private File file;
	
	public UseMarshallStream() {
		file = new File("c:/dev/temp/obj.txt");
	}
	
	public void objectOutput(UserData ud) {
		System.out.println("객체 쓰기 시작");
		//1.스트림 연결
		try(ObjectOutputStream oos = new ObjectOutputStream
				(new FileOutputStream(file))) {
			//2. 객체를 스트림에 기록
			oos.writeObject(ud);
			//3.스트림에 내용을 목적지로 분출
			oos.flush();
		} catch(NotSerializableException ne) {
			System.err.println("직렬화 문제발생");
			ne.printStackTrace();
		} catch(IOException ie) {
			System.err.println("입출력 문제발생");
			ie.printStackTrace();
		}
		System.out.println("객체 쓰기 끝");
	}
	
	public void objectInput() {
		//1.스트림 생성
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			//2.연결된 파일에서 객체를 읽어들인다.
			UserData ud = (UserData)ois.readObject();
			System.out.println("읽어들인 객체 : ");
			System.out.println(ud.getName()+ " / " + ud.getWeight() + " / " + ud.getHeight());
			
		}catch(ClassNotFoundException cnfe) {
			System.err.println("읽어들인 파일에 객체가 없음.");
			cnfe.printStackTrace();
		}catch(IOException ie) {
			System.err.println("입출력예외 객체가 없음.");
			ie.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UseMarshallStream ums = new UseMarshallStream();
//		UserData ud = new UserData("루피", 180.2, 63.1);
//		ums.objectOutput(ud);
		
		ums.objectInput();
	}
}
