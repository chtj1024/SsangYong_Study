package Exam0908;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MemoFont extends JDialog{
	public JavaMemo jm;
	
	private JTextField jtfFont, jtfStyle, jtfSize;
	
	private DefaultListModel<String> dlmFont, dlmStyle, dlmSize;
	
	private JList<String> jlFont, jlStyle, jlSize;
	
	private JLabel jlblFont, jlblStyle, jlblSize;
	private JLabel jlblPreview;
	
	private JButton jbtnConfirm, jbtnCancel;
	
	public MemoFont(JavaMemo jm) {
		super(jm, "글꼴", true); // jdialog 선언
		this.jm = jm;

		JPanel jp = new JPanel(new GridLayout(3, 3));
		
		jlblFont = new JLabel("글꼴");
		jlblStyle = new JLabel("글꼴 스타일");
		jlblSize = new JLabel("크기");
		
		jtfFont = new JTextField();
		jtfStyle = new JTextField();
		jtfSize = new JTextField();
		
		Font font = jm.getJtaMemo().getFont();
		jtfFont.setText(font.getName());
		String styleStr = "";
		switch(font.getStyle()) {
			case Font.PLAIN: styleStr = "보통"; break;
			case Font.BOLD: styleStr = "굵게"; break;
		}
		jtfStyle.setText(styleStr);
		jtfSize.setText(String.valueOf(font.getSize()));
		
		dlmFont = new DefaultListModel<String>();
		dlmStyle = new DefaultListModel<String>();
		dlmSize = new DefaultListModel<String>();
		
		jlFont = new JList<String>(dlmFont);
		jlStyle = new JList<String>(dlmStyle);
		jlSize = new JList<String>(dlmSize);
		
		JScrollPane jspFont = new JScrollPane(jlFont);
		JScrollPane jspStyle = new JScrollPane(jlStyle);
		JScrollPane jspSize = new JScrollPane(jlSize);
		
		dlmFont.addElement("고딕체");
		dlmFont.addElement("궁서체");
		dlmFont.addElement("Consolas");
		dlmFont.addElement("새굴림");
		dlmFont.addElement("맑은 고딕");
		
		dlmStyle.addElement("보통");
		dlmStyle.addElement("굵게");
		
		for(int i = 1; i <= 11; i++) {
			String str = String.valueOf(i);
			dlmSize.addElement(str);
		}
		for(int i = 12; i <= 80; i += 2) {
			String str = String.valueOf(i);
			dlmSize.addElement(str);
		}
		
		jlblPreview = new JLabel("AaBbYyZz");
		jlblPreview.setBorder(BorderFactory.createTitledBorder("보기"));
		font = jm.getJtaMemo().getFont();
		jlblPreview.setFont(font);
		
		jp.add(jlblFont);
		jp.add(jlblStyle);
		jp.add(jlblSize);
		jp.add(jtfFont);
		jp.add(jtfStyle);
		jp.add(jtfSize);
		jp.add(jspFont); // 스크롤로 넣음.
		jp.add(jspStyle);
		jp.add(jspSize);
		
		JPanel jbtns = new JPanel(new GridLayout(1, 2));
		jbtnConfirm = new JButton("확인");
		jbtnCancel = new JButton("취소");
		
		jbtns.setLayout(null); // 버튼 크기와 위치 조절을 위해
		jbtnConfirm.setBounds(250, 10, 100, 50);
		jbtnCancel.setBounds(350, 10, 100, 50);
		
		jbtns.add(jbtnConfirm);
		jbtns.add(jbtnCancel);
		
		JPanel jp2 = new JPanel(new GridLayout(3, 1));
		
		jp2.add(jp);
		jp2.add(jlblPreview);
		jp2.add(jbtns);
		
		add(jp2, BorderLayout.CENTER);
		
		MemoFontEvt mfe = new MemoFontEvt(jm, this);
		jlFont.addListSelectionListener(mfe);
		jlStyle.addListSelectionListener(mfe);
		jlSize.addListSelectionListener(mfe);
		
		jbtnConfirm.addActionListener(mfe);
		jbtnCancel.addActionListener(mfe);
		
		setBounds(150, 150, 500, 400);
//		jd.add(new JLabel("여기는 새로운창"));
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	public JavaMemo getJm() {
		return jm;
	}

	public JTextField getJtfFont() {
		return jtfFont;
	}

	public JTextField getJtfStyle() {
		return jtfStyle;
	}

	public JTextField getJtfSize() {
		return jtfSize;
	}

	public DefaultListModel<String> getDlmFont() {
		return dlmFont;
	}

	public DefaultListModel<String> getDlmStyle() {
		return dlmStyle;
	}

	public DefaultListModel<String> getDlmSize() {
		return dlmSize;
	}

	public JList<String> getJlFont() {
		return jlFont;
	}

	public JList<String> getJlStyle() {
		return jlStyle;
	}

	public JList<String> getJlSize() {
		return jlSize;
	}

	public JLabel getJlblFont() {
		return jlblFont;
	}

	public JLabel getJlblStyle() {
		return jlblStyle;
	}

	public JLabel getJlblSize() {
		return jlblSize;
	}

	public JLabel getJlblPreview() {
		return jlblPreview;
	}

	public JButton getJbtnConfirm() {
		return jbtnConfirm;
	}

	public JButton getJbtnCancel() {
		return jbtnCancel;
	}
	
	
}
