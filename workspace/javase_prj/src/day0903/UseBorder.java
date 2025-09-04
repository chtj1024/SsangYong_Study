package day0903;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * 
 */
//1. 윈도우 컴포넌트 상속
public class UseBorder extends JFrame {
	
	public UseBorder() {
		super("여러개의 Layout 사용");
		//2. 일반컴포넌트 생성
		JLabel jlblName = new JLabel("이름");
		JTextField jtfName = new JTextField(20);
		JButton jbtnInput = new JButton("입력");
		
		//글꼴객체 생성
		Font font = new Font("휴먼편지체", Font.BOLD, 25);
		//컴포넌트에 글꼴을 적용.
		jlblName.setFont(font);
		jtfName.setFont(font);
		jbtnInput.setFont(font);
		
		//BorderLayout에 Center에 들어갈 컴포넌트
		JTextArea jtaNameView = new JTextArea();
//		TextArea jtaNameView = new TextArea();
		JScrollPane jspJtaNameView = new JScrollPane(jtaNameView);
		
		jtaNameView.setFont(new Font("굴림체", Font.ITALIC, 30));
		
		//Foreground color - (글자색 변경)
		jtfName.setForeground(Color.BLUE);
		jlblName.setForeground(new Color(0, 129, 0));
		jbtnInput.setForeground(new Color(0xFF0000));
		
		jtaNameView.setForeground(new Color(0xB87D0C));
		
		//Background color - 바닥색 변경
		jtfName.setBackground(Color.GRAY);
		jlblName.setOpaque(true); // 불투명도를 활성화 해야 바닥색 설정되어 보인다.
		
		jlblName.setBackground(new Color(0xB87D0C));
		jbtnInput.setBackground(new Color(0xE0E0E0));
		
		jtaNameView.setBackground(new Color(0xC7B571));
		
		//3. 컨테이너 컴포넌트를 생성
		JPanel jpNorth = new JPanel();
		
		//JScrollPane에 Border설정
//		jspJtaNameView.setBorder(new TitledBorder("이름 출력"));
		jspJtaNameView.setBorder(new LineBorder(Color.RED));
//		jpNorth.setBorder(new TitledBorder("이름 입력"));
		
		//4. 배치관리자를 설정
		setLayout(new BorderLayout()); // Frame의 Layout
		jpNorth.setLayout(new FlowLayout()); // Panel의 Layout
		
		//5. 컴포넌트를 배치
		// 컨테이너 컴포넌트에 일반 컴포넌트를 배치
		jpNorth.add(jlblName);
		jpNorth.add(jtfName);
		jpNorth.add(jbtnInput);
		
		// 윈도우 컴포넌트에 컴포넌트를 배치
		add(BorderLayout.NORTH, jpNorth);
//		add(BorderLayout.CENTER, jtaNameView);
		add(BorderLayout.CENTER, jspJtaNameView); // has a 관계를 가진 JScrollPane을 배치
		
		//6. 윈도우의 크기를 설정
		setSize(500, 400);
		
		//7. 가시화
		setVisible(true);
		
		//8. 윈도우 종료 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new UseBorder();
	}
}
