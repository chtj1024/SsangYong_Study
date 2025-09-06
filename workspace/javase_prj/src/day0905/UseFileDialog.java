package day0905;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class UseFileDialog extends JFrame implements ActionListener{
	
	private JButton jbtnOpen, jbtnSave, jbtnOpenFileChoose, jbtnSaveFileChoose;
	
	public UseFileDialog() {
		super("파일 다이얼로그 연습");
		
		jbtnOpen = new JButton("열기");
		jbtnSave = new JButton("저장");
		jbtnOpenFileChoose = new JButton("열기");
		jbtnSaveFileChoose = new JButton("저장");
		
		JPanel jpCenter = new JPanel();
		jpCenter.setBorder(new TitledBorder("파일다이얼로그"));
		
		jpCenter.add(jbtnOpen);
		jpCenter.add(jbtnSave);
		jpCenter.add(jbtnOpenFileChoose);
		jpCenter.add(jbtnSaveFileChoose);
		
		add("Center", jpCenter);
		
		jbtnOpen.addActionListener(this);
		jbtnSave.addActionListener(this);
		jbtnOpenFileChoose.addActionListener(this);
		jbtnSaveFileChoose.addActionListener(this);
		
		setBounds(100, 100, 400, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
//		System.out.println(ae.getActionCommand());
		
//		ae.getActionCommand() // 이벤트를 발생시킨 대상의 Label
		if(ae.getSource() == jbtnOpen) {
			openFileDialog();
		}
		if(ae.getSource() == jbtnSave) {
			saveFileDialog();
		}
		if(ae.getSource() == jbtnOpenFileChoose) {
			openFileChooser();
		}
		if(ae.getSource() == jbtnSaveFileChoose) {
			saveFileChooser();
		}
	}
	
	public void openFileDialog() {
		FileDialog fdOpen = new FileDialog(this, "자바 파일 열기");
		fdOpen.setVisible(true);
		
		String dir = fdOpen.getDirectory();
		String file = fdOpen.getFile();
		//파일을 선택한 경우에만 타이틀바에 설정.
		
		if (file != null) {
			setTitle("저장 : " + dir + file);
		}
		
	}
	public void saveFileDialog() {
		
	}
	public void openFileChooser() {
		JFileChooser jfcOpen = new JFileChooser();
		
		jfcOpen.showOpenDialog(this);
		
		File file = jfcOpen.getSelectedFile();
		setTitle("jfc 열기" + file.getAbsolutePath());
	}
	public void saveFileChooser() {
		JFileChooser jfcSave = new JFileChooser();
		
		jfcSave.showOpenDialog(this);		
	}
	
	public static void main(String[] args) {
		new UseFileDialog();
	}
}
