package sal.and.pay.design;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sal.and.pay.dto.SalAndPayDTO;
import sal.and.pay.event.SalAndPayEvt;
import sal.and.pay.service.SalAndPayService;

public class SalAndPayDesign extends JFrame{
	
	private JTabbedPane jtpSalAndPay;
	private CardLayout clPayDate, clPayRecords;
	private JButton jbtnSalUpdate;
	private DefaultTableModel dtmYearSal;
	private JTable jtYearSal;
	
	public SalAndPayDesign() {
		super("연봉/급여/보너스 수정");
		SalAndPayEvt sape = new SalAndPayEvt(this);
		
		// 탭 선언
		jtpSalAndPay = new JTabbedPane();
		
		// 연봉 탭
		JPanel salPanel = new JPanel(new BorderLayout());
		// 상단 우측 '연봉수정'버튼
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jbtnSalUpdate = new JButton("연봉수정");
		topPanel.add(jbtnSalUpdate);
		
		// 연봉 테이블
		String[] columns = {"사번", "이름", "부서", "직급", "연봉"}; 
		
		// DB에서 가져온 데이터들 레코드로 뿌리기 위한 2차원 배열
		Object[][] data = sape.loadSalEmp();	
		// 테이블에 적용
		dtmYearSal = new DefaultTableModel(data, columns);
		jtYearSal = new JTable(dtmYearSal);
		JScrollPane scrollPane = new JScrollPane(jtYearSal);
		
		
		//
		salPanel.add(topPanel, BorderLayout.NORTH);
		salPanel.add(scrollPane, BorderLayout.CENTER);
		
		// 급여 탭
		JPanel payPanel = new JPanel();
		
		
		
		jtpSalAndPay.addTab("연봉", salPanel);
		jtpSalAndPay.addTab("급여", payPanel);
		
		add(jtpSalAndPay);
		
		addWindowListener(sape);
		jbtnSalUpdate.addActionListener(sape);
		
		setBounds(100, 100, 500, 400);
		setVisible(true);
	}

	public JTabbedPane getJtpSalAndPay() {
		return jtpSalAndPay;
	}

	public CardLayout getClPayDate() {
		return clPayDate;
	}

	public CardLayout getClPayRecords() {
		return clPayRecords;
	}

	public JButton getJbtnSalUpdate() {
		return jbtnSalUpdate;
	}

	public DefaultTableModel getDtmYearSal() {
		return dtmYearSal;
	}

	public JTable getJtYearSal() {
		return jtYearSal;
	}
	
}
