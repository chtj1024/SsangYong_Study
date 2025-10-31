package admin.design;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import admin.event.AddEmpEvt;

public class AddEmpDesign extends JDialog {
	private JTextField jtfName, jtfEmail, jtfTel, jtfAddr;
	private JComboBox<String> jcbDept, jcbPos, jcbSal;
	private DefaultComboBoxModel<String> dcbmDept, dcbmPos, dcbmSal;
	private JButton jbtnConfirm, jbtnDeny;
	
	public AddEmpDesign(EmpMgmDesign emd) {
		super(emd, "신규 사원 추가",true);
		
		JPanel jpLeft = new JPanel();
		JPanel jpRight = new JPanel();
		JPanel jpCenter = new JPanel();
		JPanel jpSouth = new JPanel();
		
		JLabel jlName = new JLabel("이름");
		jtfName = new JTextField(9);
		
		JLabel jlDept = new JLabel("부서");
		dcbmDept = new DefaultComboBoxModel<String>();
		jcbDept = new JComboBox<String>(dcbmDept);
		
		JLabel jlPos = new JLabel("직급");
		dcbmPos = new DefaultComboBoxModel<String>();
		jcbPos = new JComboBox<String>(dcbmPos);
		
		JLabel jlSal = new JLabel("연봉");
		dcbmSal = new DefaultComboBoxModel<String>();
		jcbSal = new JComboBox<String>(dcbmSal);
		
		JLabel jlEmail = new JLabel("이메일");
		jtfEmail = new JTextField(8);
		
		JLabel jlTel = new JLabel("연락처");
		jtfTel = new JTextField(8);
		
		JLabel jlAddr = new JLabel("주소");
		jtfAddr = new JTextField(8);
		
		jbtnConfirm = new JButton("확인");
		jbtnDeny = new JButton("취소");
		
		jpLeft.add(jlName);
		jpLeft.add(jtfName);
		jpRight.add(jlEmail);
		jpRight.add(jtfEmail);
		jpLeft.add(jlDept);
		jpLeft.add(jcbDept);
		jpRight.add(jlTel);
		jpRight.add(jtfTel);
		jpLeft.add(jlPos);
		jpLeft.add(jcbPos);
		jpLeft.add(new JLabel("         "));
		jpRight.add(jlAddr);
		jpRight.add(new JLabel("  "));
		jpRight.add(jtfAddr);
		jpLeft.add(jlSal);
		jpLeft.add(jcbSal);
		
		jpLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
		jpRight.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		jpCenter.setLayout(new GridLayout(1,2));
		
		jpCenter.add(jpLeft);
		jpCenter.add(jpRight);
		
//		jpCenter.setLayout(new GridLayout(4, 1, 0, 80));
		
		jpSouth.add(jbtnConfirm);
		jpSouth.add(jbtnDeny);
		
		add("Center", jpCenter);
		add("South", jpSouth);
		
		AddEmpEvt aee = new AddEmpEvt(this);
		aee.inputJcb();
		
		jbtnConfirm.addActionListener(aee);
		jbtnDeny.addActionListener(aee);
		
		jtfAddr.addKeyListener(aee);
		jtfEmail.addKeyListener(aee);
		jtfName.addKeyListener(aee);
		jtfTel.addKeyListener(aee);
		
		setBounds(100, 100, 300, 220);
		setVisible(true);
	}

	public JTextField getJtfName() { return jtfName; }
	public JTextField getJtfEmail() { return jtfEmail; }
	public JTextField getJtfTel() { return jtfTel; }
	public JTextField getJtfAddr() { return jtfAddr; }
	public JComboBox<String> getJcbDept() { return jcbDept; }
	public JComboBox<String> getJcbPos() { return jcbPos; }
	public JComboBox<String> getJcbSal() { return jcbSal; }
	public DefaultComboBoxModel<String> getDcbmDept() { return dcbmDept; }
	public DefaultComboBoxModel<String> getDcbmPos() { return dcbmPos; }
	public DefaultComboBoxModel<String> getDcbmSal() { return dcbmSal; }
	public JButton getJbtnConfirm() { return jbtnConfirm; }
	public JButton getJbtnDeny() { return jbtnDeny; }
}
