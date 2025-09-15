package day0912;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {
	
	public SimpleClient() throws UnknownHostException, IOException {
		//소켓 생성) 설정한 ip와 port 사용하여 서버 컴퓨터에 접속을 시도.
		Socket client = new Socket("192.168.10.92", 65520);
		System.out.println("client 서버에 접속하였습니다.");
	}
	
	public static void main(String[] args) {
		try {
			new SimpleClient();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
