package day0908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UseKeyboardInput {
	
	public UseKeyboardInput() {
		try {
//			int readData = System.in.read(); // 사용자가 키를 누르고 엔터를 칠때까지 기다림.
//			System.out.println("입력값 : " + (char)readData );
			
			// 모든 입력 값을 읽어들일 수 있지만 한글은 읽어들일 수 없다.
//			int readData = 0;
//			while((readData = System.in.read()) != 10) {
////				System.out.println(readData);
//				System.out.print((char)readData);
//			}
			
			//입력 값을 적재하여 줄단위로 읽어 들이기.
			//한글이 깨지지 않도록 줄단위로 읽어 들이는 기능을 가진 스트림을 생성하고
			//키보드에서 입력된 값을 읽어들이기 위해 8bit스트림 연결을 한다.
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String msg = br.readLine();
			System.out.println("입력 값 : " + msg);
			
//			br.close(); // static인 stream은 JVM에서 하나의 스트림으로 존재하므로
			//연결을 끊으면 프로그램이 실행중인 상태에서는 절대로 연결되지 않는다.
			//in, out, err은 연결끊지 않는다.
			//그래서 try~with~resources를 사용하면 안된다.
			
			System.out.println("아무키나 누르삼");
			
			msg = br.readLine();
			System.out.println("두번째 입력 값 : " + msg);
			
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new UseKeyboardInput();
	}
}
