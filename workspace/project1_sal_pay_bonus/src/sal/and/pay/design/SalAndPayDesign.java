package sal.and.pay.design;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import sal.and.pay.event.SalAndPayEvt;

public class SalAndPayDesign extends JFrame{
	
	private JTabbedPane jtpSalAndPay;
	private CardLayout clPayDate, clPayRecords;
	private JButton jbtnSalUpdate, jbtnCheckBonus;
	private DefaultTableModel dtmYearSal, dtmPayDate, dtmPayRecords;
	private JTable jtYearSal, jtPayDate, jtPayRecords;
	private JLabel jlbPayDate;
	
	// 연봉 업데이트 후 기존 연봉 테이블을 최신화 하기 위하여 이벤트를 UpdateSalDesign으로 전달하기 위한 선언
	private SalAndPayEvt sape;
	
	private JPanel jpCard;
	
	// 지급예정, 지급기록 CardLayout 전환 버튼
	private JButton jbtnShowPayDate, jbtnShowPayRecords;
	// 지급기록검색, 검색초기화(테이블 초기화) 버튼
	private JButton jbtnSearchPayRecodes, jbtnResetSearch;
	
	public SalAndPayDesign() {
		super("연봉/급여/보너스 수정");
		sape = new SalAndPayEvt(this);
		
		
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
		JPanel payPanel = new JPanel(new BorderLayout());
		
		// 상단 제어 버튼 패널
		JPanel jpTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jbtnShowPayDate = new JButton("지급예정");
		jbtnShowPayRecords = new JButton("지급기록");
		jpTop.add(jbtnShowPayDate);
		jpTop.add(jbtnShowPayRecords);
				
		clPayDate = new CardLayout();
		jpCard = new JPanel(clPayDate);
		
		// 지급예정 부분 CardLayout
		JPanel jpPayDate = payDatePanel();
		// (지급기록 카드 등은 추후 추가 가능)
		jpCard.add(jpPayDate, "PAY_DATE");
		
		// 2. 두 번째 카드 (지급기록) - 임시 패널 추가
		JPanel jpPayRecords = payRecordsPanel();
		jpCard.add(jpPayRecords, "PAY_RECORDS"); 
		
		payPanel.add(jpTop, BorderLayout.NORTH);
		payPanel.add(jpCard, BorderLayout.CENTER);
		
		jtpSalAndPay.addTab("연봉", salPanel);
		jtpSalAndPay.addTab("급여", payPanel);
		
		add(jtpSalAndPay);
		
		addWindowListener(sape);
		jbtnSalUpdate.addActionListener(sape);
		jbtnShowPayDate.addActionListener(sape);
		jbtnShowPayRecords.addActionListener(sape);
		jbtnCheckBonus.addActionListener(sape);
		
		setBounds(100, 100, 900, 600);
		setVisible(true);
	}

	private JPanel payDatePanel() {
		JPanel panel = new JPanel(new BorderLayout());
		
		panel.setBorder(BorderFactory.createEmptyBorder(10,15,15,15));
		
		// 상단
		JPanel jpTop = new JPanel(new BorderLayout());
		
		// 지급예정일 계산
		jlbPayDate = new JLabel("지급예정일 : " + sape.nextPayDate(), SwingConstants.LEFT);
		jlbPayDate.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		
		jbtnCheckBonus = new JButton("보너스 확인");
		jbtnCheckBonus.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		
		jpTop.add(jlbPayDate, BorderLayout.WEST);
		jpTop.add(jbtnCheckBonus, BorderLayout.EAST);
		
		//테이블 영역
		String[] columns = {"사번", "이름", "월급(세전)", "세금", "보너스", "실지급액"};
		Object[][] data = sape.loadPayDate();
		
		dtmPayDate = new DefaultTableModel(data, columns) {
			//셀 수정 불가 처리
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jtPayDate = new JTable(dtmPayDate);
		jtPayDate.setRowHeight(25);
		jtPayDate.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane jsp = new JScrollPane(jtPayDate);
		
		panel.add(jpTop, BorderLayout.NORTH);
		panel.add(jsp, BorderLayout.CENTER);	
		
		
		return panel;
	}

	private JPanel payRecordsPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15));
		
		// 상단 버튼
		JPanel jpTop = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
		jbtnResetSearch = new JButton("검색초기화");
		jbtnSearchPayRecodes = new JButton("지급기록검색");
		
		jbtnResetSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		jbtnSearchPayRecodes.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		
		jpTop.add(jbtnResetSearch);
		jpTop.add(jbtnSearchPayRecodes);
		
		String[] columns = {"지급번호", "사번", "이름", "지급날짜", "월급(세전)", "세금", "보너스", "실지급액"};
		
		// DB에서 불러올 데이터
		
		dtmPayRecords = new DefaultTableModel(columns, 0) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false; // 셀 수정 불가
	        }
	    };
		
	    jtPayRecords = new JTable(dtmPayRecords);
	    jtPayRecords.setRowHeight(25);
	    jtPayRecords.getTableHeader().setReorderingAllowed(false);
	    
	    JScrollPane jspPayRecords = new JScrollPane(jtPayRecords);
	    
	    panel.add(jpTop, BorderLayout.NORTH);
	    panel.add(jspPayRecords, BorderLayout.CENTER);
	    
		return panel;
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

	public JButton getJbtnCheckBonus() {
		return jbtnCheckBonus;
	}

	public DefaultTableModel getDtmYearSal() {
		return dtmYearSal;
	}

	public DefaultTableModel getDtmPayDate() {
		return dtmPayDate;
	}

	public JTable getJtYearSal() {
		return jtYearSal;
	}

	public JTable getJtPayDate() {
		return jtPayDate;
	}

	public JLabel getJlbPayDate() {
		return jlbPayDate;
	}

	public SalAndPayEvt getSape() {
		return sape;
	}

	public JPanel getJpCard() {
		return jpCard;
	}

	public JButton getJbtnShowPayDate() {
		return jbtnShowPayDate;
	}

	public JButton getJbtnShowPayRecords() {
		return jbtnShowPayRecords;
	}
	
}
