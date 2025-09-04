package day0903;

import java.awt.GridLayout;

import javax.swing.JFrame;

// 원래 했던 캘린더 파일 작성안해서 못만듬. 강사님께서 만드신파일로 해야할듯.
public class Work0902View extends JFrame {
	
	public Work0902View() {
		super("달력만들기");
		
		Work0902Model model = new Work0902Model();

//		String[][] arr2 = model.makeCalendar("2025", "8");
//		
//		for(Stirng[] arr : arr2) {
//			for(String value : arr) {
//				System.out.print(value + "\t");
//			}
//			System.out.println();
//		}
		
		setLayout(new GridLayout());
		
		setBounds(100, 100, 700, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Work0902View();
	}
}
