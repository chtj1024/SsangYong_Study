package emp.design.maindesign;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EmpMenuDesign extends JPanel {
	private JButton jbtnWorkLog,jbtnVacation,jbtnSalary,jbtnMyPage;
	
	public EmpMenuDesign() {
		//레이아웃 설정
		setLayout(new FlowLayout(FlowLayout.CENTER));
		//버튼 레이아웃 설정
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 4, 10, 5));
	
		jbtnWorkLog = new JButton("근무기록조회");
		jbtnVacation = new JButton("휴가신청/조회");
		jbtnSalary = new JButton("급여조회");
		jbtnMyPage = new JButton("MY PAGE");
		
		buttonPanel.add(jbtnWorkLog);
        buttonPanel.add(jbtnVacation);
        buttonPanel.add(jbtnSalary);
        buttonPanel.add(jbtnMyPage);
        
        add(buttonPanel);
	}//EmpMenuDesign

	public JButton getJbtnWorkLog() {
		return jbtnWorkLog;
	}

	public JButton getJbtnVacation() {
		return jbtnVacation;
	}

	public JButton getJbtnSalary() {
		return jbtnSalary;
	}

	public JButton getJbtnMyPage() {
		return jbtnMyPage;
	}

}
