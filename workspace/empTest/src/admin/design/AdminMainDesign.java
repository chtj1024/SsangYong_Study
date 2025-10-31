package admin.design;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import admin.event.AdminMainEvt;
import emp.DTO.LoginDTO;

/**
 * 관리자로 로그인했을 때의 메인 화면
 * 43번째 줄의 관리자 이름에 로그인한 사용자의 이름을 넣어주면 됩니다
 */
public class AdminMainDesign extends JFrame {
	private JButton jbtnEmp, jbtnDept, jbtnAttendance, jbtnVacation, jbtnSal,jbtnUser;
	private LoginDTO lDTO;
	

	
	public AdminMainDesign(LoginDTO lDTO) {
		super("관리자 화면");
		this.lDTO = lDTO;
		
		jbtnEmp = new JButton("사원관리");
		jbtnDept = new JButton("부서관리");
		jbtnAttendance = new JButton("근태관리");
		jbtnVacation = new JButton("휴가관리");
		jbtnSal = new JButton("연봉관리");
		jbtnUser = new JButton("사용자화면");
		
		
		jbtnUser.setPreferredSize(new Dimension(150, 70));
		jbtnEmp.setPreferredSize(new Dimension(150, 70));
		jbtnDept.setPreferredSize(new Dimension(150, 70));
		jbtnAttendance.setPreferredSize(new Dimension(150, 70));
		jbtnVacation.setPreferredSize(new Dimension(150, 70));
		jbtnSal.setPreferredSize(new Dimension(150, 70));
		
		JPanel jpCenter = new JPanel();
		JPanel jpNorth = new JPanel();
		JPanel jpSouth = new JPanel();
		
		jpNorth.add(jbtnUser);
		jpNorth.add(jbtnEmp);
		jpNorth.add(jbtnDept);
		
		jpSouth.add(jbtnAttendance);
		jpSouth.add(jbtnVacation);
		jpSouth.add(jbtnSal);
		
		jpCenter.setBorder(new TitledBorder("관리자 " + /*들어갈 이름 + */ " 님, 환영합니다."));
		
		jpCenter.add("North", jpNorth);
		jpCenter.add("South", jpSouth);
		
		add("Center", jpCenter);
		
		AdminMainEvt ame = new AdminMainEvt(this);
		ame.setLoginDTO(lDTO);
		
		addWindowListener(ame);
		
		jbtnUser.addActionListener(ame);
		jbtnEmp.addActionListener(ame);
		jbtnDept.addActionListener(ame);
		jbtnAttendance.addActionListener(ame);
		jbtnVacation.addActionListener(ame);
		jbtnSal.addActionListener(ame);
		
		setResizable(false);
		setBounds(100, 100, 500, 300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JButton getJbtnEmp() { return jbtnEmp; }
	public JButton getJbtnDept() { return jbtnDept; }
	public JButton getJbtnAttendance() { return jbtnAttendance; }
	public JButton getJbtnVacation() { return jbtnVacation; }
	public JButton getJbtnSal() { return jbtnSal; } 
	public JButton getjbtnUser() { return jbtnUser; } 


}
