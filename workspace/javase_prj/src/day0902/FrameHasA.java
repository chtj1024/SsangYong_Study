package day0902;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * has a 관계로 Window Component( JFrame )의 기능을 사용.
 */
public class FrameHasA {
	
	public FrameHasA(JFrame jfr) {
		//1. 컴포넌트 생성
		JButton jbtn = new JButton("버튼");
		//2. 컴포넌트를 윈도우 컴포넌트에 배치
		jfr.add(jbtn);
		//3. 윈도우 컴포넌트의 크기 설정
		jfr.setSize(300, 250);
		//4. 윈도우 컴포넌트를 가시화
		jfr.setVisible(true);
		//5. 윈도우 종료 처리
		jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// 1. 생성자에 주입할 클래스를 생성.
		JFrame jf = new JFrame("has a 관계");
		// 2. 생성된 객체를 주입 받을 클래스를 생성
		FrameHasA frameHasA = new FrameHasA(jf);
	}
}
