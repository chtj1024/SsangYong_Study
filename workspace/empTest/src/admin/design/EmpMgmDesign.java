package admin.design;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import admin.event.EmpMgmEvt;

public class EmpMgmDesign extends JFrame {
	private DefaultTableModel dtmEmp;
	private DefaultComboBoxModel<String> dcbm;
	private JTable jtEmp;
	private JButton jbtnAddEmp, jbtnEmpSearch;
	private JTextField jtfEmpSearch;
	private JComboBox<String> jcbSearchKeyword;
	private EmpMgmEvt eme;
	
	public EmpMgmDesign() {
		super("사원 관리");
		
//		jpNorth
		dcbm = new DefaultComboBoxModel<String>();
		
		jbtnAddEmp = new JButton("신규 사원 등록");
		jcbSearchKeyword = new JComboBox<String>(dcbm);
		jtfEmpSearch = new JTextField();
		jtfEmpSearch.setPreferredSize(new Dimension(200, 30));
		jbtnEmpSearch = new JButton("검색");
		
		dcbm.addElement("사번");
		dcbm.addElement("이름");
		dcbm.addElement("부서");
		dcbm.addElement("직급");
		
		//table
		String[] columnNames = {"사번", "이름", "부서", "직급", "상세보기"};
		
		dtmEmp = new DefaultTableModel(columnNames, 0);
		jtEmp = new JTable(dtmEmp);
		
		jtEmp.setRowHeight(20);
		
		JScrollPane jspEmp = new JScrollPane(jtEmp);
		
		JPanel jpNorth = new JPanel();
		
		jpNorth.add(jbtnAddEmp);
		jpNorth.add(new JLabel("                                  "));
		jpNorth.add(jcbSearchKeyword);
		jpNorth.add(jtfEmpSearch);
		jpNorth.add(jbtnEmpSearch);
		
		jpNorth.setLayout(new FlowLayout());
		setLayout(new BorderLayout());
		
		add("North", jpNorth);
		add("Center", jspEmp);
		
		EmpMgmEvt eme = new EmpMgmEvt(this);
		setInfo(eme);
		
		addWindowListener(eme);
		jbtnAddEmp.addActionListener(eme);
		jbtnEmpSearch.addActionListener(eme);
		jtfEmpSearch.addKeyListener(eme);

		setResizable(false);
		setBounds(100, 100, 600, 300);
		setVisible(true);
	}
	
	public void setInfo(EmpMgmEvt eme) {
		eme.infoEmp();
	}
	
	public DefaultTableModel getDtmEmp() { return dtmEmp; }
	public DefaultComboBoxModel<String> getDcbm() { return dcbm; }
	public JTable getJtEmp() { return jtEmp; }
	public JButton getJbtnAddEmp() { return jbtnAddEmp; }
	public JButton getJbtnEmpSearch() { return jbtnEmpSearch; }
	public JTextField getJtfEmpSearch() { return jtfEmpSearch; }
	public JComboBox<String> getJcbSearchKeyword() { return jcbSearchKeyword; }
	public EmpMgmEvt getEme() { return eme; }

//	public static void main(String[] args) {
//		new EmpMgmDesign();
//	}
}
