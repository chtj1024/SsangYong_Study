package day0902;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MultipleLayout2 extends JFrame {
	
	public MultipleLayout2() {
		super("여러개의 Layout사용");
		
		//2. 일반 컴포넌트 생성.
		String[] btnLabelArr = "7,8,9,4,5,6,1,2,3,+/-,0,.".split(",");
		JButton[] jbtnNumberPad = new JButton[btnLabelArr.length];
		JTextField jtfNumberView = new JTextField();
		
		//3. 컨테이너 컴포넌트 (JPanel : GridLayout(4, 3))
		JPanel jpNumberPad = new JPanel();
		jpNumberPad.setLayout(new GridLayout(4, 3));
		
		//4. 일반컴포넌트를 컨테이너 컴포넌트에 배치
		Font fontNumPad = new Font("맑은 고딕", Font.PLAIN, 25); // 버튼 폰트 설정하기 위한 객체 생성
		for(int i = 0; i < jbtnNumberPad.length; i++) {
			jbtnNumberPad[i] = new JButton(btnLabelArr[i]);
			jbtnNumberPad[i].setFont(fontNumPad); // 버튼 폰트 설정
			//컨테이너 컴포넌트에 배치
			jpNumberPad.add(jbtnNumberPad[i]);
		}
		
		jtfNumberView.setFont(new Font("맑은 고딕", Font.BOLD, 30)); // 텍스트 필드 폰트 설정
		
		//5. 컴포넌트들을 윈도우 컴포넌트에 배치.
		add("North", jtfNumberView);
		add("Center", jpNumberPad);
		
		//6. 윈도우 크기 설정
		setSize(280, 340);
		
		//7. 윈도우 가시화
		setVisible(true);
		
		//8. 윈도우 종료 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MultipleLayout2();
	}
}
