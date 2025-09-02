package day0902;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame{
	
	public Calculator() {
		super("계산기");
		JTextField jtfName = new JTextField(20);
		
		JButton jbtn = new JButton("7");
		JButton jbtn2 = new JButton("8");
		JButton jbtn3 = new JButton("9");
		JButton jbtn4 = new JButton("4");
		JButton jbtn5 = new JButton("5");
		JButton jbtn6 = new JButton("6");
		JButton jbtn7 = new JButton("1");
		JButton jbtn8 = new JButton("2");
		JButton jbtn9 = new JButton("3");
		JButton jbtn10 = new JButton("+/-");
		JButton jbtn11 = new JButton("0");
		JButton jbtn12 = new JButton(".");
		
		JPanel jpSouth = new JPanel();
		
		
		
		setLayout(new BorderLayout());
		jpSouth.setLayout(new GridLayout(4, 3));
		
		add(BorderLayout.NORTH, jtfName);
		
		
		jpSouth.add(jbtn);		
		jpSouth.add(jbtn2);
		jpSouth.add(jbtn3);
		jpSouth.add(jbtn4);
		jpSouth.add(jbtn5);
		jpSouth.add(jbtn6);
		jpSouth.add(jbtn7);
		jpSouth.add(jbtn8);
		jpSouth.add(jbtn9);
		jpSouth.add(jbtn10);
		jpSouth.add(jbtn11);
		jpSouth.add(jbtn12);
		
		add(BorderLayout.CENTER, jpSouth);
		
		setSize(450, 400);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Calculator();
	}
}
