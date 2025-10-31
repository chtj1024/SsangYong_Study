package emp.design;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import emp.event.LoginEvt;

public class LoginDesign extends JFrame {

	private JTextField jtfid;
	private JPasswordField jpfPass;
	private JButton jbtnLogin,jbtnCancle;
	
	public LoginDesign() {
		super("로그인");
		
		JLabel jlblTitle = new JLabel("SIST COMPANY");
		JLabel jlblId = new JLabel("ID");
		JLabel jlblPw = new JLabel("PW");
		
		jtfid=new JTextField();
		jpfPass=new JPasswordField();
		jbtnLogin=new JButton("로그인");
		jbtnCancle=new JButton("취소");
		
		setLayout(null);
		
		jlblTitle.setFont(new Font("SansSerif", Font.BOLD, 30)); // 폰트 설정
        jlblTitle.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
        jlblTitle.setBounds(50, 30, 300, 40);
        
        jlblId.setBounds(100, 100, 50, 30);
        jtfid.setBounds(160, 100, 140, 30);
		
        jlblPw.setBounds(100, 140, 50, 30);
        jpfPass.setBounds(160, 140, 140, 30);

        jbtnLogin.setBounds(110,200,80,30);
        jbtnCancle.setBounds(210,200,80,30);
        
        add(jlblTitle);
        add(jlblId);
        add(jtfid);
        add(jlblPw);
        add(jpfPass);
        add(jbtnLogin);
        add(jbtnCancle);
        
        addEvt();
        
        setSize(400,300);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}//LoginDesign

	private void addEvt() {
		LoginEvt le=new LoginEvt(this);
        jbtnLogin.addActionListener(le);
        jbtnCancle.addActionListener(le);
        jpfPass.addActionListener(le);
        addWindowListener(le);
	}//addEvt
	
	public JTextField getJtfid() {
		return jtfid;
	}

	public JPasswordField getJpfPass() {
		return jpfPass;
	}

	public JButton getJbtnLogin() {
		return jbtnLogin;
	}

	public JButton getJbtnCancle() {
		return jbtnCancle;
	}
	
	
	
}
