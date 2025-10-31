package emp.design;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import emp.design.maindesign.EmpProfileDesign;
import emp.event.EmpMainEvt;
import emp.event.MyPageEvt;

public class MyPageDesign extends JFrame{
	private JTextField jtfJob,jtfDeptName,jtfEmpNo;
	private JTextField jtfname,jtftel,jtfEmail,jtfAddr;
	private JPasswordField jtfCurrentPass,jtfNewPass,jtfConfirmPass;
	private MyPageEvt me;
	private JButton updateMyInfo,updatePass;
	
	private EmpProfileDesign empProfile;
	private EmpMainEvt mevt;
	

	public MyPageDesign(int emp_id, EmpMainEvt mevt) {
		super("마이페이지");
		this.mevt=mevt;
		setSize(500,660);
		setLocationRelativeTo(null); // 창 가운데 표시
		setLayout(null);
		
//		int emp_id=1003; //임시로그인
		Font font=new Font("맑은 고딕",Font.BOLD,14);
		
		JLabel jlblWelcome = new JLabel(emp_id+"님 환영합니다.");
		jlblWelcome.setFont(font);
		jlblWelcome.setBounds(20, 10, 400, 30);
		add(jlblWelcome);
		
		//직급
		JLabel jlblJob= new JLabel("직급");
		jlblJob.setFont(font);
		jlblJob.setBounds(50, 50, 150, 30);
		add(jlblJob);
		
		jtfJob=new JTextField();
		jtfJob.setBounds(150,50,300,30);
		jtfJob.setEditable(false);
		add(jtfJob);
		
		//부서
		JLabel jlblDeptName = new JLabel("부서");	
		jlblDeptName.setFont(font);
		jlblDeptName.setBounds(50,90,150,30);
		add(jlblDeptName);
		
		jtfDeptName=new JTextField();
		jtfDeptName.setBounds(150,90,300,30);
		jtfDeptName.setEditable(false);
		add(jtfDeptName);
		
		//사원번호
		JLabel jlblempNo = new JLabel("사원번호");
		jlblempNo.setFont(font);
		jlblempNo.setBounds(50, 130, 150, 30);
		add(jlblempNo);
		
		jtfEmpNo=new JTextField();	
		jtfEmpNo.setBounds(150,130,300,30);
		jtfEmpNo.setEditable(false);
		add(jtfEmpNo);
		
		///개인정보관리
		// ===== 구분선 =====
		JLabel jlblLine = new JLabel("개인정보관리");
		jlblLine.setFont(font);
		jlblLine.setOpaque(true);
		jlblLine.setBackground(new Color(220, 220, 220));
		jlblLine.setHorizontalAlignment(JLabel.CENTER);
		jlblLine.setBounds(30, 170, 420, 30);
		add(jlblLine);
		
		//사원명
		JLabel jlblEmpName=new JLabel("사원명");
		jlblEmpName.setFont(font);
		jlblEmpName.setBounds(50, 210, 150, 30);
		add(jlblEmpName);
		
		jtfname =new JTextField();
		jtfname.setBounds(150, 210, 300, 30);
		jtfname.setEditable(false);
		add(jtfname);
		
		
		//연락처
		JLabel jlblPhone = new JLabel("연락처");
        jlblPhone.setFont(font);
        jlblPhone.setBounds(50, 250, 100, 30);
        add(jlblPhone);

        jtftel = new JTextField();
        jtftel.setBounds(150, 250, 300, 30);
        add(jtftel);

		
        //이메일
        JLabel jlblEmail = new JLabel("이메일");
        jlblEmail.setFont(font);
        jlblEmail.setBounds(50, 290, 100, 30);
        add(jlblEmail);

        jtfEmail = new JTextField();
        jtfEmail.setBounds(150, 290, 300, 30);
        add(jtfEmail);

//        JButton jbtnEmail = new JButton("수정하기");
//        jbtnEmail.setBounds(360, 290, 90, 30);
//        add(jbtnEmail);
        
        // 주소
        JLabel jlblAddr = new JLabel("주소");
        jlblAddr.setFont(font);
        jlblAddr.setBounds(50, 330, 100, 30);
        add(jlblAddr);

        jtfAddr = new JTextField();
        jtfAddr.setBounds(150, 330, 300, 30);
        add(jtfAddr);
        
        updateMyInfo = new JButton("수정하기");
        updateMyInfo.setBounds(360, 370, 90, 30);
        add(updateMyInfo);


// ===================하단비번====================
        
		JLabel jlblSouth = new JLabel("비밀번호관리");
		jlblSouth.setFont(font);
		jlblSouth.setOpaque(true);
		jlblSouth.setBackground(new Color(220, 220, 220));
		jlblSouth.setHorizontalAlignment(JLabel.CENTER);
		jlblSouth.setBounds(30, 410, 420, 30);
		add(jlblSouth);
        
        // 비밀번호 currentPass,newPass,confirmPass
        JLabel currentPass = new JLabel("비밀번호");
        currentPass.setFont(font);
        currentPass.setBounds(50, 450, 100, 30);
        add(currentPass);

        jtfCurrentPass = new JPasswordField();
        jtfCurrentPass.setBounds(150, 450, 300, 30);
        add(jtfCurrentPass);
     
        JLabel newPass = new JLabel("새비밀번호");
        newPass.setFont(font);
        newPass.setBounds(50, 490, 100, 30);
        add(newPass);
        
        jtfNewPass = new JPasswordField();
        jtfNewPass.setBounds(150, 490, 300, 30);
        add(jtfNewPass);
  
        JLabel confirmPass = new JLabel("비밀번호확인");
        confirmPass.setFont(font);
        confirmPass.setBounds(50, 530, 100, 30);
        add(confirmPass);
        
        jtfConfirmPass = new JPasswordField();
        jtfConfirmPass.setBounds(150, 530, 300, 30);
        add(jtfConfirmPass);

        
        
        updatePass = new JButton("수정하기");
        updatePass.setBounds(360, 570, 90, 30);
        add(updatePass);
        
        
        //이벤트
		me=new MyPageEvt(this,mevt,emp_id);//로그인 이벤트랑연결
        updateMyInfo.addActionListener(me);
        updatePass.addActionListener(me);
        me.loadMyInfo();//내정보 불러오기
//        addWindowListener(me);
        
    

        
		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	





	public JTextField getJtfJob() {
		return jtfJob;
	}







	public JTextField getJtfDeptName() {
		return jtfDeptName;
	}







	public JTextField getJtfEmpNo() {
		return jtfEmpNo;
	}







	public JTextField getJtfname() {
		return jtfname;
	}







	public JTextField getJtftel() {
		return jtftel;
	}







	public JTextField getJtfEmail() {
		return jtfEmail;
	}







	public JTextField getJtfAddr() {
		return jtfAddr;
	}







	public JPasswordField getJtfCurrentPass() {
		return jtfCurrentPass;
	}







	public JPasswordField getJtfNewPass() {
		return jtfNewPass;
	}







	public JPasswordField getJtfConfirmPass() {
		return jtfConfirmPass;
	}







	public MyPageEvt getMe() {
		return me;
	}







	public JButton getUpdateMyInfo() {
		return updateMyInfo;
	}







	public JButton getUpdatePass() {
		return updatePass;
	}


}



