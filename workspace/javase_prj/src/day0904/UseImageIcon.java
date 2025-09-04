package day0904;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class UseImageIcon extends JFrame {
	
	public UseImageIcon() {
		super("이미지 연습");
		
		ImageIcon ii = new ImageIcon("C:\\dev\\workspace\\javase_prj\\src\\day0904\\images\\img_1.jpg");
		ImageIcon ii2 = new ImageIcon("C:\\dev\\workspace\\javase_prj\\src\\day0904\\images\\img_2.jpg");
		ImageIcon ii3 = new ImageIcon("C:\\dev\\workspace\\javase_prj\\src\\day0904\\images\\img_3.jpg");
		ImageIcon ii4 = new ImageIcon("C:\\dev\\workspace\\javase_prj\\src\\day0904\\images\\img_4.jpg");
		
		JButton jbtn = new JButton("페페-뭐지?", ii);
		JButton jbtn2 = new JButton("페페-몰루?", ii2);
		JButton jbtn3 = new JButton("페페-이건 못참지", ii3);
		
		//버튼의 Label위치 변경
		//수직 : TOP, MIDDEL, BOTTOM
		jbtn.setVerticalTextPosition(JButton.BOTTOM);
		//수평 : LEFT, CENTER, RIGHT
		jbtn2.setHorizontalTextPosition(JButton.RIGHT);
		
		
		jbtn3.setVerticalTextPosition(JButton.BOTTOM);
		jbtn3.setHorizontalTextPosition(JButton.LEFT);
		
		//Roll Over
		jbtn3.setRolloverIcon(ii4);
		
		setLayout(new GridLayout(1, 3));
		
		add(jbtn);
		add(jbtn2);
		add(jbtn3);
		
		setBounds(100, 100, 1400, 400);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new UseImageIcon();
	}
}
