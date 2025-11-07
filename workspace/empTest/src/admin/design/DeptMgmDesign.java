package admin.design;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import admin.event.DeptMgmEvt; 

public class DeptMgmDesign extends JFrame {
    
    private JTable jtDeptList;
    private DefaultTableModel dtmDeptList;
    private JButton jbtnDeptAdd;
    
    public static final int COL_DEPT_NO = 0;
    public static final int COL_DEPT_NAME = 1;
    public static final int COL_DELETE_YN = 2;

    public DeptMgmDesign() {
        jbtnDeptAdd = new JButton("부서 추가");
        
        String[] columnNames = {"부서번호", "부서명", "삭제여부"}; 
        dtmDeptList = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        jtDeptList = new JTable(dtmDeptList);
        JScrollPane scrollPane = new JScrollPane(jtDeptList);
        
        jtDeptList.getColumnModel().getColumn(COL_DELETE_YN).setMaxWidth(0);
        jtDeptList.getColumnModel().getColumn(COL_DELETE_YN).setMinWidth(0);
        jtDeptList.getColumnModel().getColumn(COL_DELETE_YN).setPreferredWidth(0);
        
        setLayout(new BorderLayout(10, 10)); 
        setTitle("부서 관리 UI");
        
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(new JLabel("부서 관리 UI", SwingConstants.CENTER));
        add(titlePanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createTitledBorder("부서 목록"));
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        
        JPanel bottomBtnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomBtnPanel.add(jbtnDeptAdd);
        centerPanel.add(bottomBtnPanel, BorderLayout.SOUTH);
        
        add(centerPanel, BorderLayout.CENTER);

        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        DeptMgmEvt deptEvent = new DeptMgmEvt(this);
        
        this.getJbtnDeptAdd().addActionListener(deptEvent);
        this.addWindowListener(deptEvent); 
        
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void showDeptList(List<Object[]> deptData) { 
        dtmDeptList.setRowCount(0); 
        if (deptData != null) {
            for (Object[] row : deptData) {
                dtmDeptList.addRow(row);
            }
        }
    }

    public void getter() {}
    public JButton getJbtnDeptAdd() { return jbtnDeptAdd; }
    public JTable getJtDeptList() { return jtDeptList; }
    public DefaultTableModel getDtmDeptList() { return dtmDeptList; }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new DeptMgmDesign().setVisible(true));
//    }
}