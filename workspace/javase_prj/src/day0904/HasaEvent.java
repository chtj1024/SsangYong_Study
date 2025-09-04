package day0904;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// 1. Event 처리 리스너를 상속, 구현
// 자식은 부모의 메서드를 다 사용 가능하다.
public class HasaEvent implements ActionListener{
	//2. 생성자에서 사용자에게 제공할 Component를 생성
	private HasaDesign hd;
	
	public HasaEvent(HasaDesign hd) {
		this.hd = hd;
	}

	//3. 인터페이스의 이벤트 발생시 호출되는 method를 Override
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("이벤트 객체 + " + e);
		//이벤트가 발생했을 때 사용자에게 제공할 코드.
		JOptionPane.showMessageDialog(hd, "버튼이 눌렸습니다.!!!");
	}
}
