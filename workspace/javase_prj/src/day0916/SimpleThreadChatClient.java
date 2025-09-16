package day0916;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SimpleThreadChatClient extends JFrame implements ActionListener, Runnable{
	
	private JTextArea jtaTalkDisplay;
	private JScrollPane jspJtaTalkDisplay;
	private JTextField jtfTalk;
	
	private Socket client; // 서버에 접속하기 위한 소켓 : TCP/IP 사용
	private DataInputStream disReadStream; // 접속자의 메세지를 읽기 위한 스트림
	private DataOutputStream dosWriteStream;
	
	public SimpleThreadChatClient() {
		super(":::::::::채팅 클라이언트:::::::::");
		
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
		//디자인 종료
		
		//서버로 연결
		try {
			connectToServer();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		jtfTalk.addActionListener(this);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					if(disReadStream != null) {disReadStream.close();}
					if(dosWriteStream != null) {dosWriteStream.close();}
					if(client != null) {client.close();}
				} catch(IOException ie) {
					ie.printStackTrace();
				} finally {
					System.exit(0);
				}
			}
		});
		
		
		jtfTalk.requestFocus();
		
	}
	
	
	/**
	 * 소켓을 생성하여 서버에 연결하고, 대화를 읽거나 보내기 위한 스트림을 생성한다.
	 * 메세지를 무한루프로 읽어들이는 일.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public void connectToServer() throws UnknownHostException, IOException {
		String ip = JOptionPane.showInputDialog("서버 ip주소를 입력", "192.168.0.");
		client = new Socket(ip, 50000);
		disReadStream = new DataInputStream(client.getInputStream());
		dosWriteStream = new DataOutputStream(client.getOutputStream());
		jtaTalkDisplay.setText(ip + "서버에 접속하였습니다.");
		
//		revMsg(); // 메세지를 무한 루프로 읽어들임.
		//현재겍체와 Thread클래스를 has a 관계로 설정.
		Thread t = new Thread(this);
		//start() -> run()
		t.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			sendMsg();
		} catch (IOException e1) {
			jtaTalkDisplay.append("대화상대가 접속중이 아닙니다. \n");
			e1.printStackTrace();
		}
	}//actionPerformed
	
	/**
	 * 메시지 읽기 : 메세지를 계속 읽어들인다.
	 * @throws IOException 
	 */
	@Override
//	public void revMsg() throws IOException {
	public void run() {
			try {
					while(true){
					jtaTalkDisplay.append(disReadStream.readUTF()+"\n");
					scrollMove();
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "대화상대가 접속을 종료하였습니다.");
				e.printStackTrace();
			}
	}//revMsg
	
	/**
	 * 메시지 보내기
	 * @throws IOException 
	 */
	public void sendMsg() throws IOException {
		String msg = "[접속자] : " + jtfTalk.getText();
		if(dosWriteStream != null) {
			jtaTalkDisplay.append(msg + "\n");
			scrollMove();
			dosWriteStream.writeUTF(msg);
			dosWriteStream.flush();
		}
		jtfTalk.setText("");
	}//sendMsg
	
	private void scrollMove() {
		jspJtaTalkDisplay.getVerticalScrollBar().setValue(
				jspJtaTalkDisplay.getVerticalScrollBar().getMaximum());
	}//scrollMove

	public static void main(String[] args) {
		new SimpleThreadChatClient();
//		SimpleChatClient scc = new SimpleChatClient();
//		try {
//			scc.connectToServer();
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}//main

}//class
