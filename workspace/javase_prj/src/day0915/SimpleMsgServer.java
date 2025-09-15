package day0915;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SimpleMsgServer extends JFrame{
	
	public SimpleMsgServer() throws IOException {
		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		
		add("Center", jsp);
		
		setBounds(100, 100, 500, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ServerSocket server = null; // 포트를 열고 접속자 소켓을 받기위한 서버소켓
		Socket client = null; // 접속자 소켓
		
		DataOutputStream dos = null; // 서버의 데이터를 소켓으로 내보내기위한 스트림
		DataInputStream dis = null; // 클라이언트 소켓에서 보내오는 메세지를 읽기 위한 스트림.
		
		try {
			// 1.서버소켓 생성 : PORT가 열림
			server = new ServerSocket(54000);
			jta.append("서버 가동중\n");
			String msg = "192.168.10.21의 서버에 접속하셨습니다. 이 편지는 영국에서부터 시작...";
			
			while(true) {
		
				//3.접속자소켓이 생성되어 접속하기를 기다림.
				client = server.accept();
				jta.append("접속자 있음 " + client + "\n");
		
				//4.메세지를 소켓에 쓰기 위한 스트림을 얻기
				dos = new DataOutputStream(client.getOutputStream());
				//5. 메세지를 스트림 기록 ( 가 => %ED%DF%3D UTF-8 인코딩)
				dos.writeUTF(msg);
				//6. 스트림에 기록된 내용을 소켓으로 분출
				//(소켓은 받은 데이터를 Packet에 실어서 접속자 컴퓨터로 보낸다.)
				dos.flush();
				jta.append("메세지 전송 완료\n");
				//소켓에서 스트림 연결
				dis = new DataInputStream(client.getInputStream());
				//스트림에 기록된 내용을 읽기
				String revMsg = dis.readUTF();
				jta.append("접속자의 메세지 : " + revMsg + "\n");
				
				//메세지가 출력되고 스크롤바의 위치가 아래로 내려가야하는데 내려가지지 않는데 그 때
				//1. 종 스크롤 바의 최고 값을 얻어서 종스크롤로 바에 설정한다.
//				System.out.println(jsp.getVerticalScrollBar().getMaximum());
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				
//				JOptionPane.showMessageDialog(null, dis.readUTF());
			}
		} finally {			
			if(dos != null) { dos.close(); }
			if(client != null) { client.close(); }
			if(server != null) { server.close(); }
		}
		
	}
	
	public static void main(String[] args) {
		try {
			new SimpleMsgServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
