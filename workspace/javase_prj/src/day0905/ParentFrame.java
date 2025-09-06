package day0905;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ParentFrame extends JFrame implements ActionListener {
	
	private JButton jbtnDialogOpen, jbtnDialogOpen2;
	
	
	public ParentFrame() {
		super("부모창");
		
		jbtnDialogOpen = new JButton("다이얼로그 - 모달");
		jbtnDialogOpen2 = new JButton("다이얼로그 - 비모달");
		
		JPanel jpCenter = new JPanel();
		jpCenter.setBorder(new TitledBorder("다이얼로그"));
		
		jpCenter.add(jbtnDialogOpen);
		jpCenter.add(jbtnDialogOpen2);
		
		add("Center", jpCenter);
		
		jbtnDialogOpen.addActionListener(this);
		jbtnDialogOpen2.addActionListener(this);
		
		setBounds(100, 100, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jbtnDialogOpen) {
			useModal();
		}
		if(ae.getSource() == jbtnDialogOpen2) {
			useNonModal();
		}
		
	}
	
	public void useModal() {
		new ChildDialog(this, true);
	}
	public void useNonModal() {
		new ChildDialog(this, false);
	}

	public static void main(String[] args) {
		new ParentFrame();
		
//		JOptionPane.showConfirmDialog(null, "50번을 글을 정말 삭제하시겠습니까?");
	}
	
}
