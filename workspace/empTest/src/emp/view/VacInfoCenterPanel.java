package emp.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import emp.event.VacInfoEvt;

public class VacInfoCenterPanel extends JPanel {
	private DefaultComboBoxModel<String> dcbmVacayType, dcbmStartYear, dcbmStartMonth, dcbmStartDay, dcbmEndYear, dcbmEndMonth, dcbmEndDay;
	private JComboBox<String> jcVacayType, jcStartYear, jcStartMonth, jcStartDay, jcEndYear, jcEndMonth, jcEndDay;
	private JTextField jtfReason;
	private JButton jbtnApply;
	private VacInfoEvt vie;
	
	public VacInfoCenterPanel() {
		setLayout(new BorderLayout(0, 5));
		
		JPanel jpNorth = new JPanel();
		JPanel jpSouth = new JPanel();
		
		dcbmVacayType = new DefaultComboBoxModel<String>();
		jcVacayType = new JComboBox<String>(dcbmVacayType);
		
		JLabel jlStartDate = new JLabel("시작일");
		dcbmStartYear = new DefaultComboBoxModel<String>();
		jcStartYear = new JComboBox<String>(dcbmStartYear);
		
		dcbmStartMonth = new DefaultComboBoxModel<String>();
		jcStartMonth = new JComboBox<String>(dcbmStartMonth);
		
		dcbmStartDay = new DefaultComboBoxModel<String>();
		jcStartDay = new JComboBox<String>(dcbmStartDay);
		
		JLabel jlEndDate = new JLabel("종료일");
		dcbmEndYear = new DefaultComboBoxModel<String>();
		jcEndYear = new JComboBox<String>(dcbmEndYear);
		
		dcbmEndMonth = new DefaultComboBoxModel<String>();
		jcEndMonth = new JComboBox<String>(dcbmEndMonth);
		
		dcbmEndDay = new DefaultComboBoxModel<String>();
		jcEndDay = new JComboBox<String>(dcbmEndDay);
		
		JTextField jtfVacaySayu = new JTextField("휴가사유");
		jtfVacaySayu.setEditable(false);
		
		jtfReason = new JTextField(25);
		jtfReason.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		
		jbtnApply = new JButton("신청");
		
		jpNorth.add(jcVacayType);
		jpNorth.add(jlStartDate);
		jpNorth.add(jcStartYear);
		jpNorth.add(jcStartMonth);
		jpNorth.add(jcStartDay);
		jpNorth.add(jlEndDate);
		jpNorth.add(jcEndYear);
		jpNorth.add(jcEndMonth);
		jpNorth.add(jcEndDay);
		jpSouth.add(jtfVacaySayu);
		jpSouth.add(jtfReason);
		jpSouth.add(jbtnApply);
		
		add("North", jpNorth);
		add("South", jpSouth);
	}
	
	public void setEvent(VacInfoEvt vie) {
		this.vie = vie;
		addEvent();
	}
	
	public void addEvent() {
		if(vie != null) {
			jbtnApply.addActionListener(vie);
			jtfReason.addKeyListener(vie);
			
			vie.inputDcbm();
		}
	}

	public DefaultComboBoxModel<String> getDcbmVacayType() { return dcbmVacayType; }
	public DefaultComboBoxModel<String> getDcbmStartYear() { return dcbmStartYear; }
	public DefaultComboBoxModel<String> getDcbmStartMonth() { return dcbmStartMonth; }
	public DefaultComboBoxModel<String> getDcbmStartDay() { return dcbmStartDay; }
	public DefaultComboBoxModel<String> getDcbmEndYear() { return dcbmEndYear; }
	public DefaultComboBoxModel<String> getDcbmEndMonth() { return dcbmEndMonth; }
	public DefaultComboBoxModel<String> getDcbmEndDay() { return dcbmEndDay; }
	public JComboBox<String> getJcVacayType() { return jcVacayType; }
	public JComboBox<String> getJcStartYear() { return jcStartYear; }
	public JComboBox<String> getJcStartMonth() { return jcStartMonth; }
	public JComboBox<String> getJcStartDay() { return jcStartDay; }
	public JComboBox<String> getJcEndYear() { return jcEndYear; }
	public JComboBox<String> getJcEndMonth() { return jcEndMonth; }
	public JComboBox<String> getJcEndDay() { return jcEndDay; }
	public JTextField getJtfReason() { return jtfReason; }
	public JButton getJbtnApply() { return jbtnApply; }
	
}
