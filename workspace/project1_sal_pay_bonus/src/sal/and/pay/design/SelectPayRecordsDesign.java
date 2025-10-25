package sal.and.pay.design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import sal.and.pay.event.SalAndPayEvt;
import sal.and.pay.event.SelectPayRecordsEvt;

public class SelectPayRecordsDesign extends JDialog{
	private JTextArea jtaCommand;
	private JButton jbtnSearch, jbtnCancel;
	
	public SelectPayRecordsDesign(JFrame sapd) {
		super(sapd, "검색 커맨드 입력", true);
		SalAndPayEvt mainEvt = ((SalAndPayDesign)sapd).getSape();
		
		initDesign(mainEvt);
	}
	
	private void initDesign(SalAndPayEvt mainEvt) {
		setLayout(new BorderLayout(10, 10));
		
		setBounds(200, 200, 800, 400);
		
		SelectPayRecordsEvt spre = new SelectPayRecordsEvt(this, mainEvt);
		
		 // 상단 안내 라벨
        JLabel jlbGuide = new JLabel(
            "<html>"
            + "<b>검색 방법</b><br>"
            + "* 컬럼명_값1~값2,컬럼명_값1 형식으로 검색합니다.<br>"
            + "예) 지급날짜_2025-08-01~2025-10-31,월급_4000000~5000000<br><br>"
            + "* 이름 검색 방법<br>"
            + "예) 이름_현,사번_1~200 → 박현빈, 현주선, 이주현<br>"
            + "예) 이름_현주 → 현주선, 박현주, 현주원<br>"
            + "사번, 이름, 지급날짜, 월급(세전), 보너스 컬럼만 최대 3개까지 조건 검색이 가능합니다. (,를 2번 사용하여 검색하는 것)"
            + "</html>"
        );
        jlbGuide.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
        jlbGuide.setBorder(new EmptyBorder(10, 15, 10, 15));
        add(jlbGuide, BorderLayout.NORTH);
        
        // 중앙 JTextArea 커맨드 입력란
        jtaCommand = new JTextArea("여기에 커맨드를 입력하세요.");
        jtaCommand.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        jtaCommand.setForeground(Color.GRAY);
        jtaCommand.setLineWrap(true);
        jtaCommand.setWrapStyleWord(true);
        jtaCommand.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        // 중앙 정렬
        JPanel jpCommand = new JPanel();
        JScrollPane jspCommand = new JScrollPane(jtaCommand);
        jspCommand.setPreferredSize(new Dimension(400, 150));
        jpCommand.add(jspCommand);
        add(jpCommand, BorderLayout.CENTER);
        
        // 검색, 취소버튼 (하단 중앙)
        JPanel jpBottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        jbtnSearch = new JButton("검색");
        jbtnCancel = new JButton("취소");
        
        jbtnSearch.setPreferredSize(new Dimension(100, 35));
        jbtnCancel.setPreferredSize(new Dimension(100, 35));
        
        jpBottom.add(jbtnSearch);
        jpBottom.add(jbtnCancel);
        add(jpBottom, BorderLayout.SOUTH);
        
        // 초기에 "여기에 커맨드를 입력하세요." 문구를 표시하다 JTextArea에 클릭하면 사라지게 하기 위해
        jtaCommand.addFocusListener(spre);
        jlbGuide.setFocusable(true);
        
        jbtnSearch.addActionListener(spre);
        jbtnCancel.addActionListener(spre);
        
        setVisible(true);
	}

	public JTextArea getJtaCommand() {
		return jtaCommand;
	}

	public JButton getJbtnSearch() {
		return jbtnSearch;
	}

	public JButton getJbtnCancel() {
		return jbtnCancel;
	}

}
