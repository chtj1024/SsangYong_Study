package admin.design;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DeptDetailsDesign extends JDialog { 
    
    private JTextField jtfDeptno;   // 부서번호
    private JTextField jtfDeptName; // 부서명
    private JTextField jtfDeptHead; // 부서장
    private JTextField jtfEmpcnt;   // 사원수
    private JButton jbtnDelete; // 삭제 버튼
    private JButton jbtnSave;   // 저장 (수정) 버튼
    private JButton jbtnCancel; // 취소 버튼
    private JTable jtEmpList;
    private DefaultTableModel dtmEmpList;
    
    public DeptDetailsDesign(JFrame parent) {
        super(parent, "부서 상세 정보", true);

        // 1. 필드 초기화
        jtfDeptno = new JTextField(20);
        jtfDeptName = new JTextField(20);
        jtfDeptHead = new JTextField(20);
        jtfEmpcnt = new JTextField(20);
        
        jbtnDelete = new JButton("삭제");
        jbtnSave = new JButton("저장(수정)");
        jbtnCancel = new JButton("취소");
        
        jtfDeptno.setEditable(false); 
        jtfDeptHead.setEditable(false);
        jtfEmpcnt.setEditable(false); 
        
        String[] columnNames = {"사원번호", "사원명", "직급", "입사일"};
        dtmEmpList = new DefaultTableModel(columnNames, 0); 
        jtEmpList = new JTable(dtmEmpList);
        JScrollPane scrollPane = new JScrollPane(jtEmpList);
        
        setLayout(new BorderLayout(10, 10));

        // NORTH
        JPanel detailsPanel = new JPanel(new GridBagLayout());
        detailsPanel.setBorder(BorderFactory.createTitledBorder("부서 정보"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        int row = 0;
        gbc.gridx = 0; gbc.gridy = row; detailsPanel.add(new JLabel("부서번호:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++; gbc.weightx = 1.0; detailsPanel.add(jtfDeptno, gbc);
        
        gbc.gridx = 0; gbc.gridy = row; detailsPanel.add(new JLabel("부서명:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++; detailsPanel.add(jtfDeptName, gbc);
        
        gbc.gridx = 0; gbc.gridy = row; detailsPanel.add(new JLabel("부서장:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++; detailsPanel.add(jtfDeptHead, gbc);
        
        gbc.gridx = 0; gbc.gridy = row; detailsPanel.add(new JLabel("사원수:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++; detailsPanel.add(jtfEmpcnt, gbc);
        
        add(detailsPanel, BorderLayout.NORTH);

        // CENTER
        JPanel empListPanel = new JPanel(new BorderLayout());
        empListPanel.setBorder(BorderFactory.createTitledBorder("부서원 목록"));
        empListPanel.add(scrollPane, BorderLayout.CENTER);
        add(empListPanel, BorderLayout.CENTER);
        
        // SOUTH
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(jbtnDelete);
        buttonPanel.add(jbtnSave);
        buttonPanel.add(jbtnCancel);
        add(buttonPanel, BorderLayout.SOUTH);

        setTitle("부서 상세 정보");
        setSize(600, 700);
        setLocationRelativeTo(parent); 
    }
    
    public void showEmp(List<String[]> empData) {
        dtmEmpList.setRowCount(0); // 기존 데이터 제거
        if (empData != null) {
            for (String[] row : empData) {
                dtmEmpList.addRow(row);
            }
        }
    }

    public void getter() {}
    public JTextField getJtfDeptno() { return jtfDeptno; }
    public JTextField getJtfDeptName() { return jtfDeptName; }
    public JTextField getJtfDeptHead() { return jtfDeptHead; }
    public JTextField getJtfEmpcnt() { return jtfEmpcnt; }
    public JButton getJbtnDelete() { return jbtnDelete; }
    public JButton getJbtnSave() { return jbtnSave; }
    public JButton getJbtnCancel() { return jbtnCancel; }
    public JTable getJtEmpList() { return jtEmpList; }
    public DefaultTableModel getDtmEmpList() { return dtmEmpList; }
}