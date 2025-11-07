package admin.design;

import java.awt.Font;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import admin.dto.DeptSelectDTO;
import admin.event.VacationMgmEvt;
import util.StatusColumnCellRenderer; 

@SuppressWarnings("serial")
public class VacationMgmDesign extends JFrame {

	private JTextField jtfEmpName;
	private DefaultComboBoxModel<DeptSelectDTO> dcbmDept;
	private DefaultComboBoxModel<String> dcbmStartYear, dcbmStartMonth, dcbmStartDay, dcbmEndYear, dcbmEndMonth, dcbmEndDay;
	private JComboBox<DeptSelectDTO> jcDept;
	private JComboBox<String> jcStartYear, jcStartMonth, jcStartDay, jcEndYear, jcEndMonth, jcEndDay;
	private JButton jbtnSearch;
	private JTable jtVacation;
	private DefaultTableModel dtmVacation;

	public VacationMgmDesign() {
		super("휴가관리");
		setLayout(null);
		
		Font font = new Font("맑은 고딕", Font.PLAIN, 14);

		JLabel jlbDept = new JLabel("부서");
		jlbDept.setBounds(30, 20, 40, 30);
		jlbDept.setFont(font);
		add(jlbDept);
		
		dcbmDept = new DefaultComboBoxModel<>();
		jcDept = new JComboBox<>(dcbmDept);
		jcDept.setBounds(70, 20, 120, 30);
		jcDept.setFont(font);
		add(jcDept);

		JLabel jlbEmpName = new JLabel("사원명");
		jlbEmpName.setBounds(210, 20, 50, 30);
		jlbEmpName.setFont(font);
		add(jlbEmpName);

		jtfEmpName = new JTextField();
		jtfEmpName.setBounds(265, 20, 100, 30);
		jtfEmpName.setFont(font);
		add(jtfEmpName);

		JLabel jlbStartDate = new JLabel("시작일");
		jlbStartDate.setBounds(30, 70, 50, 30);
		jlbStartDate.setFont(font);
		add(jlbStartDate);

		dcbmStartYear = new DefaultComboBoxModel<>();
		jcStartYear = new JComboBox<>(dcbmStartYear);
		jcStartYear.setBounds(80, 70, 70, 30);
		jcStartYear.setFont(font);
		add(jcStartYear);

		dcbmStartMonth = new DefaultComboBoxModel<>();
		jcStartMonth = new JComboBox<>(dcbmStartMonth);
		jcStartMonth.setBounds(160, 70, 50, 30);
		jcStartMonth.setFont(font);
		add(jcStartMonth);

		dcbmStartDay = new DefaultComboBoxModel<>();
		jcStartDay = new JComboBox<>(dcbmStartDay);
		jcStartDay.setBounds(220, 70, 50, 30);
		jcStartDay.setFont(font);
		add(jcStartDay);

		JLabel jlbEndDate = new JLabel("종료일");
		jlbEndDate.setBounds(290, 70, 50, 30);
		jlbEndDate.setFont(font);
		add(jlbEndDate);

		dcbmEndYear = new DefaultComboBoxModel<>();
		jcEndYear = new JComboBox<>(dcbmEndYear);
		jcEndYear.setBounds(340, 70, 70, 30);
		jcEndYear.setFont(font);
		add(jcEndYear);

		dcbmEndMonth = new DefaultComboBoxModel<>();
		jcEndMonth = new JComboBox<>(dcbmEndMonth);
		jcEndMonth.setBounds(420, 70, 50, 30);
		jcEndMonth.setFont(font);
		add(jcEndMonth);

		dcbmEndDay = new DefaultComboBoxModel<>();
		jcEndDay = new JComboBox<>(dcbmEndDay);
		jcEndDay.setBounds(480, 70, 50, 30);
		jcEndDay.setFont(font);
		add(jcEndDay);
		
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for(int i = currentYear - 50; i < currentYear + 50; i++) {
			dcbmStartYear.addElement(String.valueOf(i));
			dcbmEndYear.addElement(String.valueOf(i));
		}
		for(int i = 1; i <= 12; i++) {
			dcbmStartMonth.addElement(String.format("%02d", i));
			dcbmEndMonth.addElement(String.format("%02d", i));
		}
		for(int i = 1; i <= 31; i++) {
			dcbmStartDay.addElement(String.format("%02d", i));
			dcbmEndDay.addElement(String.format("%02d", i));
		}
		jcStartYear.setSelectedItem(String.valueOf(currentYear));
		jcEndYear.setSelectedItem(String.valueOf(currentYear));

		jbtnSearch = new JButton("조회");
		jbtnSearch.setBounds(550, 70, 70, 30);
		jbtnSearch.setFont(font);
		add(jbtnSearch);
		
		String[] columnNames = {"신청ID", "사원번호", "사원명", "부서", "직급", "휴가유형", "사유", "시작일", "종료일", "승인상태"};
		dtmVacation = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jtVacation = new JTable(dtmVacation);
		JScrollPane jsp = new JScrollPane(jtVacation);
		jsp.setBounds(30, 120, 590, 400);
		add(jsp);
		
		jtVacation.getColumn("승인상태").setCellRenderer(new StatusColumnCellRenderer());
		
		// JTable 컬럼 너비 설정
		TableColumnModel tcm = jtVacation.getColumnModel(); 
		tcm.getColumn(0).setMinWidth(0);    // 신청ID
		tcm.getColumn(0).setMaxWidth(0);
		tcm.getColumn(0).setWidth(0);
		tcm.getColumn(1).setPreferredWidth(60);  // 사원번호
		tcm.getColumn(2).setPreferredWidth(70);  // 사원명
		tcm.getColumn(3).setPreferredWidth(80);  // 부서
		tcm.getColumn(4).setPreferredWidth(60);  // 직급
		tcm.getColumn(5).setPreferredWidth(70);  // 휴가유형
		tcm.getColumn(6).setPreferredWidth(150); // 사유
		tcm.getColumn(7).setPreferredWidth(100); // 시작일
		tcm.getColumn(8).setPreferredWidth(100); // 종료일
		tcm.getColumn(9).setPreferredWidth(70);  // 승인상태

		jtVacation.setFont(font);
		jtVacation.getTableHeader().setFont(font);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int i = 0; i < jtVacation.getColumnCount(); i++) {
			if(i != 9) { 
				tcm.getColumn(i).setCellRenderer(centerRenderer);
			}
		}

		VacationMgmEvt vme = new VacationMgmEvt(this);
		
		jbtnSearch.addActionListener(vme);
		jtfEmpName.addKeyListener(vme); 
		jtVacation.addMouseListener(vme); 
		addWindowListener(vme); 

		setBounds(100, 100, 670, 600);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// Getter 메서드
	public JTextField getJtfEmpName() { return jtfEmpName; }
	public DefaultComboBoxModel<DeptSelectDTO> getDcbmDept() { return dcbmDept; }
	public JComboBox<DeptSelectDTO> getJcDept() { return jcDept; }
	public JComboBox<String> getJcStartYear() { return jcStartYear; }
	public JComboBox<String> getJcStartMonth() { return jcStartMonth; }
	public JComboBox<String> getJcStartDay() { return jcStartDay; }
	public JComboBox<String> getJcEndYear() { return jcEndYear; }
	public JComboBox<String> getJcEndMonth() { return jcEndMonth; }
	public JComboBox<String> getJcEndDay() { return jcEndDay; }
	public JButton getJbtnSearch() { return jbtnSearch; }
	public JTable getJtVacation() { return jtVacation; }
	public DefaultTableModel getDtmVacation() { return dtmVacation; }
	
	
	public static void main(String[] args) {
		new VacationMgmDesign();
	}
	
}