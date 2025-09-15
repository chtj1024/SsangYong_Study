package day0915;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class SimpleMsgClient {
	
	public SimpleMsgClient() throws UnknownHostException, IOException {
		//소켓 생성) 설정한 ip와 port 사용하여 서버 컴퓨터에 접속을 시도.
//		Socket client = new Socket("192.168.10.92", 54000);
		
		// 2. 소켓 생성 : 서버와 회선확립을 수행.
		Socket client = null; // 서버와 연결 소켓
		DataInputStream dis = null; // 서버의 데이터를 읽기 위한 스트림
		DataOutputStream dos = null; // 서버에 데이터를 보내기 위한 스트림
		
		try {
//			String ip = JOptionPane.showInputDialog("서버의 ip 입력(68~93)");
//			client = new Socket("192.168.0." + ip, 54000);
			client = new Socket("192.168.0.21", 54000);
			System.out.println("client가 서버에 접속하였습니다.");
			// 4. 서버에서 packet에서 실어서 보내온 데이터를 받기위해 소켓으로부터 스트림을 얻는다.
			dis = new DataInputStream(client.getInputStream());
			// 5. 서버에서 보내온 메세지 읽기
			String revMsg = dis.readUTF(); // (인코딩 된 데이터 %ED%DF%3D -> '가' decoding된 데이터로 변환)
//			System.out.println("서버에서 온 메세지 : " + revMsg);
			String sendMsg = JOptionPane.showInputDialog("서버에서 온 메세지 :\n" + revMsg);
			dos = new DataOutputStream(client.getOutputStream());
			//메세지를 스트림 기록
			dos.writeUTF(sendMsg);
			//스트림의 내용을 목적지(소켓)로 분출
			dos.flush();
			
		} finally {
			if(dis != null) { dis.close(); }
			if(client != null) { client.close(); }
		}
	}
	
	public static void main(String[] args) {
		try {
			new SimpleMsgClient();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
