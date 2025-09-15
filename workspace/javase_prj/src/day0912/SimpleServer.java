package day0912;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	
	public SimpleServer() throws IOException {
		ServerSocket server = new ServerSocket(65520); //포트는 선점
		System.out.println("서버 가동중");
		Socket client = server.accept();
		System.out.println("접속자 있음 " + client);
		if(server != null) { server.close(); }
	}
	
	public static void main(String[] args) {
		try {
			new SimpleServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
