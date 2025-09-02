package day0902;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * is a 관계로 사용. (객체화 코드 수가 준다. 코드의 재사용성 )
 */

//1. Window Component 상속
public class FrameIsA extends JFrame{
	//2. 생성자에 필요한 컴포넌트 생성
	public FrameIsA() {
		super("frame is a 사용");
		// 컴포넌트 생성
		JButton jbtn = new JButton("나는 버튼!!!");
		//3. 배치
		add("North", jbtn); // 코드의 재사용성
		//4. 윈도우 크기 설정
		setSize(300, 250); // 코드의 재사용성
		//5. 윈도우 가시화
		setVisible(true); // 코드의 재사용성
		// 6. 윈도우 종료 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new FrameIsA(); // 부모클래스부터 생성
	}
}
