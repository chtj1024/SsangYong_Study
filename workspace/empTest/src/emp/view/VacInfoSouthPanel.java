package emp.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import emp.event.VacInfoEvt;

public class VacInfoSouthPanel extends JPanel {
	private DefaultTableModel dtmApplyDetails;
	private JTable jtApplyDetails;
	
	public VacInfoSouthPanel() {
		setLayout(new BorderLayout(0, 5));
		
		JLabel jlApply = new JLabel("신청 내역");
		
		String[] columnNames = {"휴가 유형","휴가 기간","휴가 사유","상태"};
		
		dtmApplyDetails = new DefaultTableModel(columnNames, 0);
		jtApplyDetails = new JTable(dtmApplyDetails);
		
		jtApplyDetails.getColumn("휴가 유형").setPreferredWidth(10);
	    jtApplyDetails.getColumn("상태").setPreferredWidth(10);
	    
		JScrollPane jspApplyDetails = new JScrollPane(jtApplyDetails);
		
		add("North", jlApply);
		add(jspApplyDetails);
		
		setPreferredSize(new Dimension(560, 240));
	}
	
	public void setVacInfo(VacInfoEvt vie) {
		vie.callVacInfo();
	}

	public DefaultTableModel getDtmApplyDetails() { return dtmApplyDetails; }
	public JTable getJtApplyDetails() { return jtApplyDetails; }
	
}
