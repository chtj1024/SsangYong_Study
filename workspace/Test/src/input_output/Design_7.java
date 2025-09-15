package input_output;

import javax.swing.*;
import java.awt.Font;
import authLogin.LoginDesign;
import authLogin.LoginProcess;

public class Design_7 extends JFrame {

    private JButton jbtnStartInput;

    public Design_7(LoginDesign ld, Work_7 work7, LoginProcess lp) {
        super("log파일 분석");

        jbtnStartInput = new JButton("분석 범위 입력 시작");
        
        Font font = new Font("맑은 고딕", Font.BOLD, 18);
        jbtnStartInput.setFont(font);
        
        setLayout(null);
        
        jbtnStartInput.setBounds(50, 40, 300, 60);

        add(jbtnStartInput);
        
        
        Event_7 ev = new Event_7(this, work7, lp);
        jbtnStartInput.addActionListener(ev);

        setBounds(100, 100, 420, 180); 
        
        setLocationRelativeTo(ld); // LoginDesign 위에 둠
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JButton getJbtnStartInput() { 
        return jbtnStartInput; 
    }
    
}