package admin.design;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddDeptDesign extends JDialog {
    private JTextField jtfDeptName;
    private JButton jbtnDeptAdd;

    public AddDeptDesign(JFrame parent) {
        super(parent, "부서 추가", true);

        jtfDeptName = new JTextField(15);
        jbtnDeptAdd = new JButton("부서 추가");

        setLayout(new BorderLayout(10, 10));
        
        // CENTER
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(new JLabel("부서명"));
        inputPanel.add(jtfDeptName);
        
        // SOUTH
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(jbtnDeptAdd);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack(); 
        setLocationRelativeTo(parent);
        setLocationRelativeTo(null);
    }
    
    public void getter() {}
    public JTextField getJtfDeptName() { return jtfDeptName; }
    public JButton getJbtnDeptAdd() { return jbtnDeptAdd; }
}