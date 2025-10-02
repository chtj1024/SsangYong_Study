package kr.co.sist.pstmt.design;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import kr.co.sist.statement.event.MemberEvent;

public class PstmtMemberRightPanel extends JPanel {
	
	private DefaultListModel<String> dlmMember;
	private JList<String> jlMember;
	private JScrollPane jspJlMember;
	private MemberEvent me;
		
	public PstmtMemberRightPanel() {
		dlmMember = new DefaultListModel<String>();
		
		jlMember = new JList<String>(dlmMember);
		
		jlMember.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		setBorder(new TitledBorder("회원정보"));
		setLayout(new BorderLayout());
		
		jspJlMember = new JScrollPane(jlMember);
		
		add(jspJlMember);
			
	}

	/**
	 * 이벤트 처리객체를 받은 후, JList Component를 이벤트에 등록
	 * 모든 회원 정보를 dlm에 설정하는 일
	 * @param me
	 */
	public void setMemberEvent(MemberEvent me) {
		this.me = me;
//		jlMember.addListSelectionListener(me);
		jlMember.addMouseListener(me);
		
		me.searchAllMember();
	}
	
	public DefaultListModel<String> getDlmMember() {
		return dlmMember;
	}

	public JList<String> getJlMember() {
		return jlMember;
	}

	public JScrollPane getJspJlMember() {
		return jspJlMember;
	}
	
	
}
