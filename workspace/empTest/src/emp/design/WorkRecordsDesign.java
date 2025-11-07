package emp.design;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import emp.DTO.UserInfoDTO;
import emp.DTO.WorkRecordsResultDTO;
import emp.event.WorkRecordsEvt;

public class WorkRecordsDesign extends JFrame {
	private JLabel jlblName,jlblPname;
	private JComboBox<Integer> jcbStartYear, jcbStartMonth, jcbStartDay,jcbEndYear, jcbEndMonth, jcbEndDay;
	private JButton jbtnView;
	private JTable jtaWorkLog;
	private DefaultTableModel dtmWorkLog;
	private UserInfoDTO userInfo;
	
	public WorkRecordsDesign(UserInfoDTO userInfo) {
		super("근무기록");
		
		this.userInfo = userInfo;
		setLayout(new BorderLayout(10,10));
		
		//상단패널
		JPanel topPanel = new JPanel(new BorderLayout());
		jlblName = new JLabel(userInfo.getName());
		jlblPname = new JLabel(userInfo.getPname());
		jlblName.setFont(new Font("SansSerif", Font.BOLD, 30));
		jlblPname.setFont(new Font ("SansSerif", Font.PLAIN, 16));
		JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		namePanel.add(jlblName);
		namePanel.add(jlblPname);
		
		//콤보박스
		jcbStartYear = new JComboBox<>();
		jcbStartMonth = new JComboBox<>();
		jcbStartDay = new JComboBox<>();
		jcbEndYear = new JComboBox<>();
		jcbEndMonth = new JComboBox<>();
		jcbEndDay = new JComboBox<>();
		jbtnView = new JButton("조회");
		
		Dimension Size = new Dimension(70, 25);
		jcbStartYear.setPreferredSize(Size);
		jcbStartMonth.setPreferredSize(Size);
		jcbStartDay.setPreferredSize(Size);
		jcbEndYear.setPreferredSize(Size);
		jcbEndMonth.setPreferredSize(Size);
		jcbEndDay.setPreferredSize(Size);
		
		populateComboBoxes();
		JPanel datePanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 2, 0, 2);
		
		JLabel lblStart = new JLabel("시작일:");
		JLabel lblEnd = new JLabel("종료일:");
		Font labelFont = lblStart.getFont().deriveFont(14f);
		lblStart.setFont(labelFont);
		lblEnd.setFont(labelFont);
	
		gbc.gridx = 0; gbc.gridy = 0;
		datePanel.add(lblStart, gbc);

		gbc.gridx = 1; datePanel.add(jcbStartYear, gbc);
		gbc.gridx = 2; datePanel.add(new JLabel("년"), gbc);
		gbc.gridx = 3; datePanel.add(jcbStartMonth, gbc);
		gbc.gridx = 4; datePanel.add(new JLabel("월"), gbc);
		gbc.gridx = 5; datePanel.add(jcbStartDay, gbc);
		gbc.gridx = 6; datePanel.add(new JLabel("일"), gbc);

		gbc.gridx = 7; gbc.insets = new Insets(0, 35, 0, 2);
		datePanel.add(lblEnd, gbc);
		gbc.insets = new Insets(0, 2, 0, 2);

		gbc.gridx = 8; datePanel.add(jcbEndYear, gbc);
		gbc.gridx = 9; datePanel.add(new JLabel("년"), gbc);
		gbc.gridx = 10; datePanel.add(jcbEndMonth, gbc);
		gbc.gridx = 11; datePanel.add(new JLabel("월"), gbc);
		gbc.gridx = 12; datePanel.add(jcbEndDay, gbc);
		gbc.gridx = 13; datePanel.add(new JLabel("일"), gbc);

		gbc.gridx = 14; gbc.insets = new Insets(0, 30, 0, 0);
		datePanel.add(jbtnView, gbc);
		
		topPanel.add(namePanel, BorderLayout.NORTH);
		topPanel.add(datePanel, BorderLayout.CENTER);
		topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		//중앙 패널
		String[] columnNames = {"날짜", "출근시간", "퇴근시간", "총 근무시간", "상태"};
        dtmWorkLog = new DefaultTableModel(columnNames, 0) {
        	@Override
        	public boolean isCellEditable(int row, int column) {
        		return false;
        	}
        };
        
        jtaWorkLog = new JTable(dtmWorkLog);
        jtaWorkLog.getTableHeader().setReorderingAllowed(false);
        TableColumnModel columnModel = jtaWorkLog.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);  // 날짜 (좁게)
        columnModel.getColumn(1).setPreferredWidth(120);  // 출근시간
        columnModel.getColumn(2).setPreferredWidth(120);  // 퇴근시간
        columnModel.getColumn(3).setPreferredWidth(120); // 총 근무시간 (넓게)
        columnModel.getColumn(4).setPreferredWidth(40);
		
        JScrollPane jsp = new JScrollPane(jtaWorkLog);
        jsp.setPreferredSize(new Dimension(780, 500));
        
        add(topPanel, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		addEvt();
		
		pack();
		setSize(900, 600);
		setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}//WorkRecordsDesign
	
	private void populateComboBoxes() {
		Calendar cal = Calendar.getInstance();
		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONTH) + 1;
		int currentDay = cal.get(Calendar.DAY_OF_MONTH);
		
		Calendar startCal = Calendar.getInstance();
		startCal.add(Calendar.MONTH, -1);
		int startYear = startCal.get(Calendar.YEAR);
		int startMonth = startCal.get(Calendar.MONTH) + 1;
		int startDay = startCal.get(Calendar.DAY_OF_MONTH);
		
		// 년 (현재년도 - 30년)
		for(int i = currentYear; i >= currentYear -30; i--) {
			jcbStartYear.addItem(i);
			jcbEndYear.addItem(i);
		}
		// 월 (1 ~ 12)
		for(int i = 1; i <= 12; i++) {
			jcbStartMonth.addItem(i);
			jcbEndMonth.addItem(i);
		}
		// 일 (1 ~ 31)
		for(int i = 1; i <= 31; i++) {
			jcbStartDay.addItem(i);
			jcbEndDay.addItem(i);
		}
		
		jcbStartYear.setSelectedItem(startYear);
		jcbStartMonth.setSelectedItem(startMonth);
		jcbStartDay.setSelectedItem(startDay);
		jcbEndYear.setSelectedItem(currentYear);
		jcbEndMonth.setSelectedItem(currentMonth);
		jcbEndDay.setSelectedItem(currentDay);
	}
	
	public void updateWorkLogTable(List<WorkRecordsResultDTO> list) {
		
		dtmWorkLog.setRowCount(0);
		if (list == null || list.isEmpty()) {return;}
		
		for (WorkRecordsResultDTO dto : list) {
			Object[] rowData = {
					dto.getWorkDate(),    // "날짜" 컬럼
					dto.getClockInTime(), // "출근시간" 컬럼
					dto.getClockOutTime(),// "퇴근시간" 컬럼
					dto.getWorkHours(),   // "총 근무시간" 컬럼
					dto.getAsName()       // "상태" 컬럼
			};
			dtmWorkLog.addRow(rowData); // 테이블 모델에 행 추가
		}
	}// updateWorkLogTable

	private void addEvt() {
		WorkRecordsEvt wre = new WorkRecordsEvt(this);
		jbtnView.addActionListener(wre);
		addWindowListener(wre);
	}//addEvt

	public JComboBox<Integer> getJcbStartYear() {
		return jcbStartYear;
	}

	public JComboBox<Integer> getJcbStartMonth() {
		return jcbStartMonth;
	}

	public JComboBox<Integer> getJcbStartDay() {
		return jcbStartDay;
	}

	public JComboBox<Integer> getJcbEndYear() {
		return jcbEndYear;
	}

	public JComboBox<Integer> getJcbEndMonth() {
		return jcbEndMonth;
	}

	public JComboBox<Integer> getJcbEndDay() {
		return jcbEndDay;
	}

	public JButton getJbtnView() {
		return jbtnView;
	}

	public JTable getJtaWorkLog() {
		return jtaWorkLog;
	}

	public DefaultTableModel getDtmWorkLog() {
		return dtmWorkLog;
	}

	public UserInfoDTO getUserInfo() {
		return userInfo;
	}
	
}//class
