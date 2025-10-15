package kr.co.sist.pstmt.design;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.co.sist.pstmt.event.PstmtMemberEvent;

public class PstmtMemberRightPanel extends JPanel {
	
	private DefaultTableModel dtmMember;
	private JTable jtMember;
	private JScrollPane jspJlMember;
	private PstmtMemberEvent me;
		
	public PstmtMemberRightPanel() {
		String[] columnNames = {"번호","이름","나이","성별","전화번호","가입일"};
		dtmMember = new DefaultTableModel(columnNames, 0);
		jtMember = new JTable(dtmMember);
		
		// column의 넓이 설정
		TableColumnModel tcm =  jtMember.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(40); //번호
		tcm.getColumn(1).setPreferredWidth(80); //회원명
		tcm.getColumn(2).setPreferredWidth(40); //나이
		tcm.getColumn(3).setPreferredWidth(60); //성별
		tcm.getColumn(4).setPreferredWidth(100); //전화번호
		tcm.getColumn(5).setPreferredWidth(120); //가입일
		
		jtMember.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		setBorder(new TitledBorder("회원정보"));
		setLayout(new BorderLayout());
		
		jspJlMember = new JScrollPane(jtMember);
		
		add(jspJlMember);
			
	}

	/**
	 * 이벤트 처리객체를 받은 후, JList Component를 이벤트에 등록
	 * 모든 회원 정보를 dlm에 설정하는 일
	 * @param me
	 */
	public void setMemberEvent(PstmtMemberEvent me) {
		this.me = me;
//		jlMember.addListSelectionListener(me);
		jtMember.addMouseListener(me);
		
		me.searchAllMember();
	}

	public DefaultTableModel getDtmMember() {
		return dtmMember;
	}

	public JTable getJtMember() {
		return jtMember;
	}

	public JScrollPane getJspJlMember() {
		return jspJlMember;
	}

	
	
	
}
