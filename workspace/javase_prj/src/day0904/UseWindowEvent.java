package day0904;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * WindowListener의 abstract method를 미리 구현해 놓은 WindowAdapter 클래스 사용.
 * 하위클래스에서는 필요한 method만 Override 하면 된다.
 */
public class UseWindowEvent extends WindowAdapter {
	private UseWindowEventDesign uwed;
	
	public UseWindowEvent(UseWindowEventDesign uwed) {
		this.uwed = uwed;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		uwed.dispose();
	}
	
}
