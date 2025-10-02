package kr.co.sist.statement.design;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import kr.co.sist.statement.event.MemberEvent;

public class MemberDesign extends JFrame{
		
	private MemberLeftPanel mlp;
	private MemberRightPanel mrp;
	private MemberSouthPanel msp;
	
	public MemberDesign() {
		super("호갱 관리");
		
		JPanel jpCenter = new JPanel();
		
		mlp = new MemberLeftPanel();		
		msp = new MemberSouthPanel();
		mrp = new MemberRightPanel();
		
		MemberEvent me = new MemberEvent(this);
		msp.setMemberEvent(me); // South Panel 이벤트 등록
		mrp.setMemberEvent(me); // Right Penel 이벤트 등록
		msp.addEvent();
		
		
		jpCenter.setLayout(new GridLayout(1, 2));
		
		jpCenter.add(mlp);
		jpCenter.add(mrp);
		
		add("Center", jpCenter);
		add("South", msp);
		
		addWindowListener(me);
		
		setBounds(100, 100, 600, 300);
		setVisible(true);
	}

	public MemberLeftPanel getMlp() {
		return mlp;
	}

	public MemberRightPanel getMrp() {
		return mrp;
	}

	public MemberSouthPanel getMsp() {
		return msp;
	}
	
}
