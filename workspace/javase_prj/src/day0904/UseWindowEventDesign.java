package day0904;

import java.awt.Frame;

//인터페이스를 구현하면, 추상 메서드를 모두 Override 해야한다.
public class UseWindowEventDesign extends Frame{
	
	public UseWindowEventDesign() {
		super("윈도우 이벤트 처리");
//		addWindowListener(this);
		UseWindowEvent uwe = new UseWindowEvent(this);
		addWindowListener(uwe);
		
		setBounds(100, 100, 500, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new UseWindowEventDesign();
	}
	
	/*
	public static void main(String[] args) {
		new UseWindowEventDesign();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
	}
	*/
}
