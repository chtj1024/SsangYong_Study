package emp.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import emp.event.VacInfoEvt;

public class VacInfoNorthPanel extends JPanel {
	private JTextField jtfTotalDate, jtfUseDate, jtfRemainDate;
	private JLabel jlName, jlDept;
	
	public VacInfoNorthPanel() {
		setLayout(new BorderLayout(0,2));
		
		JPanel jpNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel jpSouth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		jlName = new JLabel();
		jlName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		jlDept = new JLabel();
		jlDept.setFont(new Font("맑은 고딕", Font.PLAIN, 9));
		
		
		jtfTotalDate = new JTextField("총 휴가 일 수: ");
		jtfTotalDate.setEditable(false);
		jtfUseDate = new JTextField("사용한 휴가 일 수: ");
		jtfUseDate.setEditable(false);
		jtfRemainDate = new JTextField("남은 휴가 일 수: ");
		jtfRemainDate.setEditable(false);
		
		jpNorth.add(jlName);
		jpNorth.add(jlDept);
		jpNorth.setSize(50,50);
		jpSouth.add(jtfTotalDate);
		jpSouth.add(jtfUseDate);
		jpSouth.add(jtfRemainDate);
		
		add("North", jpNorth);
		add("South", jpSouth);
		
		setPreferredSize(new Dimension(560, 60));
	}
	
	public void setVacDay(VacInfoEvt vie) {
		vie.inputVacDays();
	}
	
	public JLabel getJlName() { return jlName; }
	public JLabel getJlDept() { return jlDept; }
	public JTextField getJtfTotalDate() { return jtfTotalDate; }
	public JTextField getJtfUseDate() { return jtfUseDate; }
	public JTextField getJtfRemainDate() { return jtfRemainDate; }

}
