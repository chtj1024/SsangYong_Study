package day0905;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class UseJOptionPane extends JFrame implements ActionListener {

	private JButton jbtnInput, jbtnMessage, jbtnConfirm;
	
	public UseJOptionPane() {
		super("JOptionPane에서 제공하는 dialog 사용");
		
		jbtnInput = new JButton("Input Dialog");
		jbtnMessage = new JButton("Message Dialog");
		jbtnConfirm = new JButton("Confirm Dialog");
		
		JPanel jpCenter = new JPanel();
		jpCenter.setBorder(new TitledBorder("JoptionPanel"));
		
		jpCenter.add(jbtnInput);
		jpCenter.add(jbtnMessage);
		jpCenter.add(jbtnConfirm);
		
		add("Center", jpCenter);
		
		jbtnInput.addActionListener(this);
		jbtnMessage.addActionListener(this);
		jbtnConfirm.addActionListener(this);
		
		setBounds(100, 100, 400, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jbtnInput) {
			useInputDialog();
		}
		if(ae.getSource() == jbtnMessage) {
			useMessageDialog();
		}
		if(ae.getSource() == jbtnConfirm) {
			useConfirmDialog();
		}
	}

	public void useInputDialog() {
//		String name = JOptionPane.showInputDialog("당신의 이름을 입력해주세요");
		String name = JOptionPane.showInputDialog(this, "당신의 이름을 입력해주세요", "이름이 궁금해요.", JOptionPane.WARNING_MESSAGE);
		if ("박상현".equals(name)) {
			new LoginForm();
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, name + "님 안녕하세요.");
		}
	}
	public void useMessageDialog() {
	SimpleDateFormat sdf = new SimpleDateFormat("오늘은 yyyy-MM-dd a EEEE 입니다.");
	JOptionPane.showMessageDialog(this, sdf.format(new Date()));
	}
	public void useConfirmDialog() {
		int selectedIdx = JOptionPane.showConfirmDialog(this, "9월10은 쉴까요?");
		String msg = "";		
		switch (selectedIdx) {
		case JOptionPane.OK_OPTION: msg = "그날 뭐하지? Nice~~~!"; break;
		case JOptionPane.NO_OPTION: msg = "안돼!!!"; break;
		case JOptionPane.CANCEL_OPTION: msg = "취소한다고오???"; break;
		}
		JOptionPane.showMessageDialog(this, msg);
	}
	
	public static void main(String[] args) {
		new UseJOptionPane();
		

	}
}
