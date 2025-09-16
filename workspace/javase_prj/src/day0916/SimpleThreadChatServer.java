package day0916;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SimpleThreadChatServer extends JFrame implements ActionListener, Runnable {
	
	private JTextArea jtaTalkDisplay;
	private JScrollPane jspJtaTalkDisplay;
	private JTextField jtfTalk;
	
	private ServerSocket server;
	private Socket client;
	private DataInputStream disReadStream;
	private DataOutputStream dosWriteStream;
	
	public SimpleThreadChatServer() {
		super(":::::::::채팅 서버:::::::::");
		
		jtaTalkDisplay=new JTextArea();
		jspJtaTalkDisplay=new JScrollPane(jtaTalkDisplay);
		jtfTalk=new JTextField();
		
		jtaTalkDisplay.setEditable(false);
		
		jspJtaTalkDisplay.setBorder(new TitledBorder("대화"));
		jtfTalk.setBorder(new TitledBorder("대화입력"));
		
		add("Center",jspJtaTalkDisplay);
		add("South", jtfTalk);
		
		
		setBounds(100, 100, 400, 600);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// 디자인 끝
		
		//서버가 실행
		try {
			openServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//이벤트 등록
		jtfTalk.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
					try {
						if(disReadStream != null) {disReadStream.close();}
						if(dosWriteStream != null) {dosWriteStream.close();}
						if(client != null) {client.close();}
						if(server != null) {server.close();}
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						System.exit(0);
					}
			}
			
		});
				
		jtfTalk.requestFocus();
		
	}//SimpleChatServer
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			sendMsg();
		} catch (IOException e1){
			e1.printStackTrace();
		}
	}//actionPerformed
	
	/**
	 * 서버소켓을 생성하여 포트를 열고, 접속자소켓이 들어오면 메세지를 무한루프로 읽어 들이는 코드.
	 */
	private void openServer() throws IOException{
		//1. 서버 소켓 생성
		server = new ServerSocket(50000);
		jtaTalkDisplay.setText("서버가 가동 중 입니다.\n 접속자 대기중...");
		//3. 접속자소켓을 받는다.
		client = server.accept();
		//4. 메세지를 보내고, 읽기 위한 스트림 소켓을 얻기.
		disReadStream = new DataInputStream(client.getInputStream());
		dosWriteStream = new DataOutputStream(client.getOutputStream());
		
//		revMsg();
		//thread로 메세지 읽기를 동시에 실행시켜야한다.
		//Thread와 has a 관계 설정
		Thread t = new Thread(this);
		//start() -> run()호출
		t.start();
		
	}
	
	/**
	 * 메시지 읽기
	 */
	@Override
	public void run() {
			try {
					while(true) {
					jtaTalkDisplay.append(disReadStream.readUTF() + "\n");
					scrollMove();
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "접속자가 접속을 종료하였습니다.");
				e.printStackTrace();
			}
		
	}//revMsg
	
	/**
	 * 메시지 보내기. J.T.F에서 이벤트가 발생하면 입력된 메세지를 내 대화창에 올리고, 접속자에게 보낸다.
	 * @throws IOException 
	 */
	public void sendMsg() throws IOException {
		String sendMsg = "[서버장]" + jtfTalk.getText();
		if(dosWriteStream != null) {			
			jtaTalkDisplay.append(sendMsg + "\n"); // 내 대화창에 메세지 올리고
			scrollMove();
			dosWriteStream.writeUTF(sendMsg); // 스트림에 대화 기록
			dosWriteStream.flush(); // 스트림에 남아있는 데이터를 소켓으로 분출
		}
		jtfTalk.setText(""); // 대화창을 초기화
	}//sendMsg
	
	private void scrollMove() {
		jspJtaTalkDisplay.getVerticalScrollBar().setValue(
				jspJtaTalkDisplay.getVerticalScrollBar().getMaximum());
	}//scrollMove

	public static void main(String[] args) {
		new SimpleThreadChatServer();
	}//main

	

}//class
