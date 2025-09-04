package day0904;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// 1. Window Component 상속 : TestWindow클래스가 Window Component가 된다. (is a 관계)
// 자식은 부모의 메서드를 다 사용 가능하다.
public class HasaDesign extends JFrame{
	//2. 생성자에서 사용자에게 제공할 Component를 생성
	public HasaDesign() {
		super("has a 관계로 이벤트 처리"); // JFrame의 생성자는 title bar에 메세지를 보여줄 수 있다.
		
		JButton jbtn = new JButton("스윙의 버튼");
		
		HasaEvent he = new HasaEvent(this);
		//2-1. 컴포넌트가 이벤트를 발생시킬 수 있도록 리스너에 등록
		jbtn.addActionListener(he);
		
		JPanel jp = new JPanel(); // Container Component : 일반컴포넌트를 배치
		jp.add(jbtn); // has a 관계
		
		//3. 컴포넌트 배치 (일반컴포넌트를 배치한 Container Component 배치)
		add(jp); // 코드의 재사용성
		
		//4. 윈도우의 크기 설정
		setSize(400, 300);
		
		//5. 사용자에게 보여주기
		setVisible(true);
		
		//6. 윈도우 종료 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 코드의 재사용성
	}
	
	public static void main(String[] args) {
		new HasaDesign();
	}

}
