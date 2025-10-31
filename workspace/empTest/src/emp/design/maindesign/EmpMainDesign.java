package emp.design.maindesign;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import emp.DTO.UserInfoDTO;
import emp.event.EmpMainEvt;

public class EmpMainDesign extends JFrame {
	private EmpProfileDesign epd;
	private EmpWorkDesign ewd;
	private EmpMenuDesign emd;
	
	private List<JFrame> childFrames = new ArrayList<>();
	
	public EmpMainDesign(UserInfoDTO userInfo) {
		super("사용자화면");
		
		setLayout(new BorderLayout(0, 10));
		epd = new EmpProfileDesign();
        ewd = new EmpWorkDesign();
        emd = new EmpMenuDesign();
        
        epd.displayUserInfo(userInfo);
        
        addEvt(userInfo);
        
        add(epd, BorderLayout.NORTH);
        add(ewd, BorderLayout.CENTER);
        add(emd, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
       //일반 관리자구분
      
//        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
        

        
	}//EmpMainDesign
	//하위창 등록매서드
	public void registerChildFrame(JFrame frame) {
		childFrames.add(frame);
	}
	
	

	private void addEvt(UserInfoDTO userInfo) {
        EmpMainEvt eme=new EmpMainEvt(this, userInfo);
        ewd.getJbtnIn().addActionListener(eme);
        ewd.getJbtnOut().addActionListener(eme);
        emd.getJbtnWorkLog().addActionListener(eme);
        emd.getJbtnVacation().addActionListener(eme);
        emd.getJbtnSalary().addActionListener(eme);
        emd.getJbtnMyPage().addActionListener(eme);
        addWindowListener(eme);
        }//addEvt
	
	public EmpProfileDesign getEpd() {
		return epd;
	}

	public EmpWorkDesign getEwd() {
		return ewd;
	}

	public EmpMenuDesign getEmd() {
		return emd;
	}
	
	
	
}//class
