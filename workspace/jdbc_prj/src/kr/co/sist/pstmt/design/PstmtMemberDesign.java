package kr.co.sist.pstmt.design;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import kr.co.sist.pstmt.event.PstmtMemberEvent;

public class PstmtMemberDesign extends JFrame{
		
	private PstmtMemberLeftPanel mlp;
	private PstmtMemberRightPanel mrp;
	private PstmtMemberSouthPanel msp;
	
	public PstmtMemberDesign() {
		super("더호갱 관리");
		
		JPanel jpCenter = new JPanel();
		
		mlp = new PstmtMemberLeftPanel();		
		msp = new PstmtMemberSouthPanel();
		mrp = new PstmtMemberRightPanel();
		
		PstmtMemberEvent me = new PstmtMemberEvent(this);
		msp.setMemberEvent(me); // South Panel 이벤트 등록
		mrp.setMemberEvent(me); // Right Penel 이벤트 등록
		msp.addEvent();
		
		
		jpCenter.setLayout(new GridLayout(1, 2));
		
		jpCenter.add(mlp);
		jpCenter.add(mrp);
		
		add("Center", jpCenter);
		add("South", msp);
		
		addWindowListener(me);
		
		setBounds(100, 100, 1200, 300);
		setVisible(true);
	}

	public PstmtMemberLeftPanel getMlp() {
		return mlp;
	}

	public PstmtMemberRightPanel getMrp() {
		return mrp;
	}

	public PstmtMemberSouthPanel getMsp() {
		return msp;
	}
	
}
