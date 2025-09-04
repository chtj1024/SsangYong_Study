package day0903;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * MVC Pattern이 도입된 클래스
 */
public class UseJComboBox extends JFrame implements ActionListener{
	private JLabel jlblOutput;
	private DefaultComboBoxModel<String> dcbm;
	private JComboBox<String> jcb;
	
	private UseJComboBox ujcb;
	
	public UseJComboBox() {
		super("콤보박스의 사용.");
		
		ujcb = this;
		
		jlblOutput = new JLabel("출력");
		//1. Model - 데이터를 관리(추가, 삭제, 검색, 변경)하는 클래스
		dcbm = new DefaultComboBoxModel<String>();
		
		//2. View 클래스 생성 (Model과 has a 관계)
		jcb = new JComboBox<String>(dcbm);
		jcb.addActionListener(this);
		
		JButton jbtnRemove = new JButton("삭제");
		jbtnRemove.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//View에서 선택한 아이템의 번호를 얻어와서
				int idx = jcb.getSelectedIndex();
				if(idx != 0) {
					switch(JOptionPane.showConfirmDialog(ujcb, dcbm.getElementAt(idx) + "아이템을 삭제하시겠습니까?")) {
					case JOptionPane.OK_OPTION:
						//Model에서 해당 아이템을 삭제.
						dcbm.removeElementAt(idx);
					}
				}
			}
		});
		
		//MVC Pattern을 도입한 클래스에서는 데이터(값)을 Model 클래스에서 관리.
		//값 추가
		dcbm.addElement("----과목선택----");
		dcbm.addElement("이것이 자바다");
		dcbm.addElement("데이터베이스 개론과 실습");
		dcbm.addElement("HTML5웹프로그래밍 입문");
		dcbm.addElement("JSP & Servlet");
		dcbm.addElement("스프링프레임워크");
		
		JPanel jpCenter = new JPanel();
		jpCenter.add(jcb);
		jpCenter.add(jbtnRemove);
		
		jlblOutput.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		add("Center", jpCenter);
		add("South", jlblOutput);
		
		setBounds(200, 100, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//View객체에 선택 된 아이템의 index를 얻어서
		//Model객체에 인덱스번째 방의 값을 얻기
		
		int idx = jcb.getSelectedIndex();
		if(idx != 0) { //선택한 아이템이 과목 선택이 아니면
			String str = dcbm.getElementAt(idx);
			jlblOutput.setText("출력 : " + str);
		}
		
//		System.out.println(jcb.getSelectedIndex());
	}
	
	public static void main(String[] args) {
		new UseJComboBox();
	}

}
