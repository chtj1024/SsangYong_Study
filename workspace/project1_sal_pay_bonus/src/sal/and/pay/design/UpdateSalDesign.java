package sal.and.pay.design;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sal.and.pay.event.UpdateSalEvt;

public class UpdateSalDesign extends JDialog{
	
	private JLabel lblSalInfo;
	private JTextField jtfSal;
	private DefaultTableModel dtmSal;
	private JTable jtSal;
	
	private JButton jbtnUpdateSal;
	
	private int emp_id;
	private String name;
	
	public UpdateSalDesign(JFrame parent, int emp_id, String name) {
		super(parent, "연봉 수정", true);
		this.emp_id = emp_id;
		this.name = name;
		
		UpdateSalEvt use = new UpdateSalEvt(this);
		
		// 상단패널 : 선택한 사번, 이름 출력 및 연봉 수정란과 수정버튼
		JPanel jpTop = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
		
		lblSalInfo = new JLabel("[" + emp_id + "]번 사원 [" + name + "]의 연봉을");
		jtfSal = new JTextField(10);
		jtfSal.setEditable(false); // 연봉 직접입력 방지
		JLabel lblWon = new JLabel("원으로");
		
		jbtnUpdateSal = new JButton("수정");
		
		jpTop.add(lblSalInfo);
		jpTop.add(jtfSal);
		jpTop.add(lblWon);
		jpTop.add(jbtnUpdateSal);
		
		// 하단패널 : 연봉들이 나열 된 테이블
		JPanel jpBottom = new JPanel(new BorderLayout());
		String[] column = {"코드", "연봉"};
		Object[][] data = use.loadSalInfo();
		
		dtmSal = new DefaultTableModel(data, column);
		jtSal = new JTable(dtmSal);
		JScrollPane jspSal = new JScrollPane(jtSal);
		jpBottom.add(jspSal, BorderLayout.CENTER);
		
		
		add(jpTop, BorderLayout.NORTH);
		add(jpBottom, BorderLayout.CENTER);
		addWindowListener(use);
		// 행을 클릭했을 때 발생하는 이벤트 연동
		jtSal.getSelectionModel().addListSelectionListener(use);
		// 수정버튼과 이벤트 연동
		jbtnUpdateSal.addActionListener(use);
		
		setBounds(200, 200, 500, 400);
		setVisible(true);
	}

	public void UpdateSalConfirmDesign() {
		
	}

	public JLabel getLblSalInfo() {
		return lblSalInfo;
	}

	public JTextField getJtfSal() {
		return jtfSal;
	}

	public DefaultTableModel getDtmSal() {
		return dtmSal;
	}

	public JTable getJtSal() {
		return jtSal;
	}

	public JButton getJbtnUpdateSal() {
		return jbtnUpdateSal;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public String getName() {
		return name;
	}
	
	
	
}
