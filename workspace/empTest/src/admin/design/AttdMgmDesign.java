package admin.design;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.time.LocalDate;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import admin.event.AttdMgmEvent; 

public class AttdMgmDesign extends JFrame {
    
    private JButton jbtnSearch;
    private JTable jtAttd;
    private DefaultTableModel dtmAttd;
    private DefaultComboBoxModel<String> dcbmDept;
    private JComboBox<String> jcbDept;
    private JComboBox<String> jcbStartYear;
    private JComboBox<String> jcbStartMonth;
    private JComboBox<String> jcbStartDay;

    public AttdMgmDesign() {
        String[] sampleDepts = {"전체"}; 
        dcbmDept = new DefaultComboBoxModel<>(sampleDepts);
        jcbDept = new JComboBox<>(dcbmDept);
        jbtnSearch = new JButton("검색");
        
        jcbStartYear = new JComboBox<>(getYears(2023, 2025));
        jcbStartMonth = new JComboBox<>(getMonths());
        jcbStartDay = new JComboBox<>(getDays());
        
        LocalDate today = LocalDate.now();
        String currentYear = String.valueOf(today.getYear());
        String currentMonth = String.format("%02d", today.getMonthValue());
        String currentDay = String.format("%02d", today.getDayOfMonth());

        jcbStartYear.setSelectedItem(currentYear);
        jcbStartMonth.setSelectedItem(currentMonth);
        jcbStartDay.setSelectedItem(currentDay);


        String[] columnNames = {"날짜", "사원번호", "사원명", "부서", "직급", "출근 시간", "퇴근 시간", "근태 상태"}; 
        dtmAttd = new DefaultTableModel(columnNames, 0); 
        jtAttd = new JTable(dtmAttd);
        JScrollPane scrollPane = new JScrollPane(jtAttd);
        
        setLayout(new BorderLayout());

        // NORTH
        JPanel searchPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPnl.add(new JLabel("부서"));
        searchPnl.add(jcbDept);
        
        searchPnl.add(new JLabel("기준일"));
        searchPnl.add(jcbStartYear);
        searchPnl.add(new JLabel("/"));
        searchPnl.add(jcbStartMonth);
        searchPnl.add(new JLabel("/"));
        searchPnl.add(jcbStartDay);
        
        searchPnl.add(jbtnSearch);
        
        add(searchPnl, BorderLayout.NORTH);

        // CENTER
        add(scrollPane, BorderLayout.CENTER);
        
        setTitle("근태 관리 UI (일별 조회)"); 
        setSize(800, 600); // UI 폭 조정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        AttdMgmEvent attdEvent = new AttdMgmEvent(this);
        this.getJbtnSearch().addActionListener(attdEvent);
        this.addWindowListener(attdEvent); 
        this.setVisible(true);
    }
    
    // 콤보박스 데이터
    private String[] getYears(int start, int end) {
        String[] years = new String[end - start + 1];
        for (int i = 0; i <= end - start; i++) {
            years[i] = String.valueOf(start + i);
        }
        return years;
    }

    private String[] getMonths() {
        String[] months = new String[12];
        for (int i = 1; i <= 12; i++) {
            months[i - 1] = String.format("%02d", i);
        }
        return months;
    }

    private String[] getDays() {
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = String.format("%02d", i);
        }
        return days;
    }

    public void setComboBoxInTable(List<String> statusList) {
        if (statusList == null || statusList.isEmpty()) { return; }
        
        int statusColumnIndex = 7; 
        
        TableColumn statusColumn = jtAttd.getColumnModel().getColumn(statusColumnIndex);
        
        JComboBox<String> comboBox = new JComboBox<>();
        for (String status : statusList) {
            comboBox.addItem(status);
        }
        
        statusColumn.setCellEditor(new DefaultCellEditor(comboBox));
    }


    public JButton getJbtnSearch() { return jbtnSearch; }
    public JTable getJtAttd() { return jtAttd; }
    public DefaultTableModel getDtmAttd() { return dtmAttd; }
    public DefaultComboBoxModel<String> getDcbmDept() { return dcbmDept; }
    public JComboBox<String> getJcbDept() { return jcbDept; }
    public JComboBox<String> getJcbStartYear() { return jcbStartYear; }
    public JComboBox<String> getJcbStartMonth() { return jcbStartMonth; }
    public JComboBox<String> getJcbStartDay() { return jcbStartDay; }

//    public void getter() {}
}