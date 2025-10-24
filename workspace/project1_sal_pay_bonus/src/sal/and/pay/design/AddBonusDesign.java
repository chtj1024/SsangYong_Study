package sal.and.pay.design;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import sal.and.pay.event.AddBonusEvt;
import sal.and.pay.event.SalAndPayEvt;

public class AddBonusDesign extends JDialog{
	
	private int emp_id;
	private String name;
	private JLabel jlbTitle;
	private JTextField jtfBonus, jtfReason;
	private JButton jbtnAddBonus;
	private DefaultTableModel dtmBonus;
	private JTable jtBonus;
	
	public AddBonusDesign(SalAndPayDesign sapd, int emp_id, String name) {
		super(sapd, "보너스 내역", true);
		this.emp_id = emp_id;
		this.name = name;
		
		// 부모(SalAndPayDesign)의 이벤트 가져오기
		SalAndPayEvt mainEvt = ((SalAndPayDesign)sapd).getSape();
		AddBonusEvt abe = new AddBonusEvt(this, mainEvt);
		
		setLayout(new BorderLayout(10, 10));
		setBounds(200, 200, 600, 400);
		
		//상단 타이틀
		jlbTitle = new JLabel(
				"사번 [" + emp_id + "]번의 [" + name + "]님의 보너스 기록입니다.",
				SwingConstants.CENTER
		);
		jlbTitle.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		add(jlbTitle, BorderLayout.NORTH);
		
		// 중간 입력 패널
		JPanel jpMiddle = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JLabel jlbBonus = new JLabel("보너스 지급 금액");
		jtfBonus = new JTextField(10);
		JLabel jlbReason = new JLabel("사유");
		jtfReason = new JTextField(15);
		jbtnAddBonus = new JButton("보너스추가");
		
		jpMiddle.add(jlbBonus);
		jpMiddle.add(jtfBonus);
		jpMiddle.add(jlbReason);
		jpMiddle.add(jtfReason);
		jpMiddle.add(jbtnAddBonus);
		
		
		// 하단 해당 사원의 보너스 기록 테이블
		String[] columns = {"보너스 지급 기록", "날짜", "사유"};
		Object[][] data = abe.loadEmpBonus();
		dtmBonus = new DefaultTableModel(data, columns) {
			//셀 수정 불가 처리
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jtBonus = new JTable(dtmBonus);
		
		// 중간 입력 패널, 하단 테이블을 합치는 패널 -> JScrollPane이 Center가 아닐 때 다른 Center와 JScrollpane영역 모두 안보이는 현상 때문에 합침.
		JPanel jpBottom = new JPanel(new BorderLayout(10, 10));
		jpBottom.add(jpMiddle, BorderLayout.NORTH);
		jpBottom.add(new JScrollPane(jtBonus), BorderLayout.CENTER);
		add(jpBottom, BorderLayout.CENTER);
		jbtnAddBonus.addActionListener(abe);
		
		addWindowListener(abe);
		setVisible(true);
	}

	public int getEmp_id() {
		return emp_id;
	}

	public String getName() {
		return name;
	}

	public JLabel getJlbTitle() {
		return jlbTitle;
	}

	public JTextField getJtfBonus() {
		return jtfBonus;
	}

	public JTextField getJtfReason() {
		return jtfReason;
	}

	public JButton getJbtnAddBonus() {
		return jbtnAddBonus;
	}

	public DefaultTableModel getDtmBonus() {
		return dtmBonus;
	}

	public JTable getJtBonus() {
		return jtBonus;
	}
	
	
}
