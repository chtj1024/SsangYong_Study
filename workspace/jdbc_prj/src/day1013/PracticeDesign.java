package day1013;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PracticeDesign extends JFrame{
	
	private JTextField jtfNum;
	private JTextField jtfName;
	private JTextField jtfEmail;
	private JTextField jtfTel;
	
	private JTextField jtfIntroduce;
	
	private JLabel imageLabel;
	
	private JButton jbtnInsert;
	private JButton jbtnSearch;
	private JButton jbtnClose;
	
	public PracticeDesign() {
		super("설계 연습");
		
	    // 상단 좌측의 label과 jtextfield 선언
		JPanel panel = new JPanel(new GridLayout(4, 2));
	    panel.add(new JLabel("번호"));
	    jtfNum = new JTextField();
	    panel.add(jtfNum);
	    panel.add(new JLabel("이름"));
	    jtfName = new JTextField();
	    panel.add(jtfName);
	    panel.add(new JLabel("이메일"));
	    jtfEmail = new JTextField();
	    panel.add(jtfEmail);
	    panel.add(new JLabel("전화번호"));
	    jtfTel = new JTextField();
	    panel.add(jtfTel);
	    
	    // 상단 우측의 이미지 표시와 이미지 선택 버튼
	    JPanel panel2 = new JPanel(new BorderLayout());
	    imageLabel = new JLabel("이미지를 선택하세요", JLabel.CENTER);
	    imageLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
	    panel2.add(imageLabel, BorderLayout.CENTER);
	    
	    JButton selectButton = new JButton("이미지선택");
	    panel2.add(selectButton, BorderLayout.SOUTH);
	    
	    // 버튼 클릭 시 파일 선택 창 열기
	    selectButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chooseImage();
			}
		});
	    
	    // 상단 합치기
	    JPanel panelNorth = new JPanel(new GridLayout(1, 2));
	    panelNorth.add(panel);
	    panelNorth.add(panel2);
	    
	    // 중단. 소개label과 내용 jtextfield
	    JPanel panelMid = new JPanel(new BorderLayout());
	    panelMid.add(new JLabel("소개"), BorderLayout.WEST);
	    jtfIntroduce = new JTextField();
	    panelMid.add(jtfIntroduce, BorderLayout.CENTER);
	    
	    // 하단의 버튼 추가, 검색, 종료 버튼
	    JPanel panelBottom = new JPanel(new BorderLayout());
	    	// 하단의 공백을 없애고, 사이즈를 균등하게 가져가기 위해 패널 추가
	    JPanel buttonInner = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
	    jbtnInsert = new JButton("추가");
	    jbtnSearch = new JButton("검색");
	    jbtnClose = new JButton("종료");
	    buttonInner.add(jbtnInsert);
	    buttonInner.add(jbtnSearch);
	    buttonInner.add(jbtnClose);
	    panelBottom.add(buttonInner);
	    
	    
	    JPanel panelFull = new JPanel(new GridLayout(3, 1));
	    
	    panelFull.add(panelNorth);
	    panelFull.add(panelMid);
	    panelFull.add(panelBottom);
	    
	    add(panelFull, BorderLayout.CENTER);
	    
	    
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void chooseImage() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
				"이미지 파일 (*.jpg, *.png, *.gif)", "jpg", "jpeg", "png", "gif"));
		
		int result = chooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();
			String path = selectedFile.getAbsolutePath();
			
			//이미지 불러오기
			ImageIcon icon = new ImageIcon(path);
			
			//이미지 크기 조절 (라벨 크기에 맞게)
			Image img = icon.getImage();
			Image scaled = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon scaledIcon = new ImageIcon(scaled);
			
			// JLabel에 표시
			imageLabel.setText(null); // 기존 텍스트 제거
			imageLabel.setIcon(scaledIcon);
		}
	}
	
	public static void main(String[] args) {
		PracticeDesign pd = new PracticeDesign();
	}
}
