package admin.design;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

import admin.dto.DeptSelectDTO;
import admin.dto.PositionDTO;
import admin.event.EmpDetailsInfoEvent;

public class EmpDetailsInfoDesign extends JFrame {

	private JTextField jtfEmpNo, jtfName, jtfAddress, jtfSal, jtfHireDate, jtfQuitDate, jtfVacationDays;
	private JTextField jtfEmail; 
	
	// --- [수정] 전화번호 컴포넌트 변경 ---
	private JComboBox<String> jcbTel1; // 010, 02 등
	private DefaultComboBoxModel<String> dcbmTel1;
	private JTextField jtfTel2; // 중간 4자리
	private JTextField jtfTel3; // 마지막 4자리
	// --- 여기까지 ---
	
	private JComboBox<DeptSelectDTO> jcbDept;
	private DefaultComboBoxModel<DeptSelectDTO> dcbmDept;
	private JComboBox<PositionDTO> jcbPosition;
	private DefaultComboBoxModel<PositionDTO> dcbmPosition;
	
	private JComboBox<String> jcbAuth;
	private DefaultComboBoxModel<String> dcbmAuth;
	private JButton jbtnSave, jbtnCancel, jbtnQuit, jbtnResetPwd; 
	private int empNo; 

	public EmpDetailsInfoDesign(int empNo) {
		super("사원 상세 정보");
		this.empNo = empNo; 
		setLayout(null);
		Font font = new Font("맑은고딕", Font.BOLD, 18); // 기본 폰트 18pt

		JLabel jlbDept = new JLabel("부서");
		jlbDept.setBounds(25, 30, 90, 35);
		jlbDept.setFont(font);
		add(jlbDept);

		dcbmDept = new DefaultComboBoxModel<>(); 
		jcbDept = new JComboBox<>(dcbmDept);
		jcbDept.setBounds(120, 30, 150, 35);
		jcbDept.setFont(font);
		add(jcbDept);
		
		JLabel jlbName = new JLabel("이름");
		jlbName.setBounds(400, 30, 50, 35); 
		jlbName.setFont(font);
		add(jlbName);

		jtfName = new JTextField();
		jtfName.setBounds(470, 30, 230, 35); 
		jtfName.setFont(font);
		add(jtfName);
		jtfName.setEditable(false);
		
		JLabel jlbEmpNo = new JLabel("사원번호");
		jlbEmpNo.setBounds(25, 80, 90, 35);
		jlbEmpNo.setFont(font);
		add(jlbEmpNo);

		jtfEmpNo = new JTextField();
		jtfEmpNo.setBounds(120, 80, 150, 35);
		jtfEmpNo.setFont(font);
		add(jtfEmpNo);
		jtfEmpNo.setEditable(false);

		// 직급 
		JLabel jlbPosition = new JLabel("직급");
		jlbPosition.setBounds(400, 80, 60, 35); 
		jlbPosition.setFont(font);
		add(jlbPosition);

		dcbmPosition = new DefaultComboBoxModel<>(); 
		jcbPosition = new JComboBox<>(dcbmPosition);
		jcbPosition.setBounds(470, 80, 230, 35); 
		jcbPosition.setFont(font);
		add(jcbPosition);

		// --- [수정] 전화번호 UI 변경 ---
		JLabel jlbTel = new JLabel("전화");
		jlbTel.setBounds(25, 130, 90, 35);
		jlbTel.setFont(font);
		add(jlbTel);
		
		// 콤보박스 모델 생성 및 아이템 추가
		dcbmTel1 = new DefaultComboBoxModel<>();
		String[] telPrefixes = {"010", "011", "016", "017", "018", "019", "02", "031", "032", "033", "041", "042", "043", "044", "051", "052", "053", "054", "055", "061", "062", "063", "064", "070"};
		for (String prefix : telPrefixes) {
			dcbmTel1.addElement(prefix);
		}
		
		jcbTel1 = new JComboBox<>(dcbmTel1);
		jcbTel1.setBounds(120, 130, 120, 35); // W: 120
		jcbTel1.setFont(font);
		add(jcbTel1);
		
		JLabel jlbHyphen1 = new JLabel("-");
		jlbHyphen1.setBounds(245, 130, 25, 35); // W: 25, X: 120+120+5
		jlbHyphen1.setFont(font);
		jlbHyphen1.setHorizontalAlignment(SwingConstants.CENTER);
		add(jlbHyphen1);

		jtfTel2 = new JTextField();
		jtfTel2.setBounds(275, 130, 120, 35); // W: 200, X: 245+25+5
		jtfTel2.setFont(font);
		add(jtfTel2);
		
		JLabel jlbHyphen2 = new JLabel("-");
		jlbHyphen2.setBounds(400, 130, 25, 35); // W: 25, X: 275+200+5
		jlbHyphen2.setFont(font);
		jlbHyphen2.setHorizontalAlignment(SwingConstants.CENTER);
		add(jlbHyphen2);

		jtfTel3 = new JTextField();
		jtfTel3.setBounds(430, 130, 120, 35); // W: 190, X: 480+25+5
		jtfTel3.setFont(font);
		add(jtfTel3);
		// --- 여기까지 수정 ---

		// 이메일 (Y좌표 180)
		JLabel jlbEmail = new JLabel("이메일");
		jlbEmail.setBounds(25, 180, 90, 35); 
		jlbEmail.setFont(font);
		add(jlbEmail);

		jtfEmail = new JTextField();
		jtfEmail.setBounds(120, 180, 580, 35); 
		jtfEmail.setFont(font);
		add(jtfEmail);
		jtfEmail.setEditable(false); 

		// 주소 (Y좌표 230)
		JLabel jlbAddress = new JLabel("주소");
		jlbAddress.setBounds(25, 230, 90, 35); 
		jlbAddress.setFont(font);
		add(jlbAddress);

		jtfAddress = new JTextField();
		jtfAddress.setBounds(120, 230, 580, 35); 
		jtfAddress.setFont(font);
		add(jtfAddress);
		jtfAddress.setEditable(true);

		// 권한 (Y좌표 280)
		JLabel jlbAuth = new JLabel("권한");
		jlbAuth.setBounds(25, 280, 90, 35); 
		jlbAuth.setFont(font);
		add(jlbAuth);

		dcbmAuth = new DefaultComboBoxModel<>();
		dcbmAuth.addElement("일반 직원");
		dcbmAuth.addElement("관리자");
		jcbAuth = new JComboBox<>(dcbmAuth);
		jcbAuth.setBounds(120, 280, 150, 35); 
		jcbAuth.setFont(font);
		add(jcbAuth);

		// 연봉 (Y좌표 280)
		JLabel jlbSal = new JLabel("연봉");
		jlbSal.setBounds(400, 280, 60, 35); 
		jlbSal.setFont(font);
		add(jlbSal);
		
		jtfSal = new JTextField();
		jtfSal.setBounds(470, 280, 230, 35); 
		jtfSal.setFont(font);
		add(jtfSal);
		jtfSal.setEditable(false);

		// 입사일 (Y좌표 330)
		JLabel jlbHireDate = new JLabel("입사일");
		jlbHireDate.setBounds(25, 330, 90, 35); 
		jlbHireDate.setFont(font);
		add(jlbHireDate);
		
		jtfHireDate = new JTextField();
		jtfHireDate.setBounds(120, 330, 150, 35); 
		jtfHireDate.setFont(font);
		add(jtfHireDate);
		jtfHireDate.setEditable(false);

		// 퇴사일 (Y좌표 330)
		JLabel jlbQuitDate = new JLabel("퇴사일");
		jlbQuitDate.setBounds(400, 330, 60, 35); 
		jlbQuitDate.setFont(font);
		add(jlbQuitDate);
		
		jtfQuitDate = new JTextField();
		jtfQuitDate.setBounds(470, 330, 230, 35); 
		jtfQuitDate.setFont(font);
		add(jtfQuitDate);
		jtfQuitDate.setEditable(false);
		
		// 보유휴가 (Y좌표 380)
		JLabel jlbVacationDays = new JLabel("보유휴가");
		jlbVacationDays.setBounds(25, 380, 90, 35); 
		jlbVacationDays.setFont(font);
		add(jlbVacationDays);
		
		jtfVacationDays = new JTextField();
		jtfVacationDays.setBounds(120, 380, 50, 35); 
		jtfVacationDays.setFont(font);
		add(jtfVacationDays);
		jtfVacationDays.setEditable(true); // 수정 가능
		
		JLabel jlbDays = new JLabel("일");
		jlbDays.setBounds(175, 380, 150, 35); 
		jlbDays.setFont(font);
		add(jlbDays);

		
		// 버튼 (Y좌표 440)
		jbtnResetPwd = new JButton("비밀번호 초기화");
		jbtnResetPwd.setBounds(45, 440, 180, 50); 
		jbtnResetPwd.setFont(font); 
		jbtnResetPwd.setBackground(new Color(150, 150, 150)); 
		jbtnResetPwd.setForeground(Color.WHITE);
		add(jbtnResetPwd);

		jbtnQuit = new JButton("퇴사처리");
		jbtnQuit.setBounds(240, 440, 145, 50); 
		jbtnQuit.setFont(font); 
		jbtnQuit.setBackground(Color.RED);
		jbtnQuit.setForeground(Color.WHITE);
		add(jbtnQuit);

		jbtnSave = new JButton("저장");
		jbtnSave.setBounds(400, 440, 145, 50); 
		jbtnSave.setFont(font); 
		jbtnSave.setBackground(new Color(100, 180, 250));
		jbtnSave.setForeground(Color.WHITE);
		add(jbtnSave);

		jbtnCancel = new JButton("취소");
		jbtnCancel.setBounds(560, 440, 145, 50); 
		jbtnCancel.setFont(font); 
		jbtnCancel.setBackground(new Color(255, 130, 70));
		jbtnCancel.setForeground(Color.WHITE);
		add(jbtnCancel);

		
		EmpDetailsInfoEvent edie = new EmpDetailsInfoEvent(this);
		
		jbtnResetPwd.addActionListener(edie); 
		jbtnSave.addActionListener(edie);
		jbtnCancel.addActionListener(edie);
		jbtnQuit.addActionListener(edie);
		addWindowListener(edie); 

		setBounds(200, 200, 750, 550); // 너비 750, 높이 550
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		setVisible(true); 
	}

	// --- [수정] Getter 메서드들 ---
	public int getEmpNo() { return this.empNo; }
	public JTextField getJtfEmpNo() { return jtfEmpNo; }
	public JTextField getJtfName() { return jtfName; }
	
	// jtfTel 관련 Getter 제거
	
	public JTextField getJtfEmail() { return jtfEmail; } 
	public JTextField getJtfAddress() { return jtfAddress; }
	public JTextField getJtfSal() { return jtfSal; }
	public JTextField getJtfHireDate() { return jtfHireDate; }
	public JTextField getJtfQuitDate() { return jtfQuitDate; }
	
	public JTextField getJtfVacationDays() { 
		return jtfVacationDays; 
	}
	
	public JComboBox<String> getJcbAuth() { return jcbAuth; }
	public JButton getJbtnSave() { return jbtnSave; }
	public JButton getJbtnCancel() { return jbtnCancel; }
	public JButton getJbtnQuit() { return jbtnQuit; }
	public JButton getJbtnResetPwd() { return jbtnResetPwd; } 
	
	public JComboBox<DeptSelectDTO> getJcbDept() {
		return jcbDept;
	}
	public DefaultComboBoxModel<DeptSelectDTO> getDcbmDept() {
		return dcbmDept;
	}
	public JComboBox<PositionDTO> getJcbPosition() {
		return jcbPosition;
	}
	public DefaultComboBoxModel<PositionDTO> getDcbmPosition() {
		return dcbmPosition;
	}

	// [신규] 전화번호 컴포넌트 Getter 3개 추가
	public JComboBox<String> getJcbTel1() {
		return jcbTel1;
	}
	public DefaultComboBoxModel<String> getDcbmTel1() {
		return dcbmTel1;
	}
	public JTextField getJtfTel2() {
		return jtfTel2;
	}
	public JTextField getJtfTel3() {
		return jtfTel3;
	}

}// class