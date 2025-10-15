package kr.co.sist.pstmt.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.pstmt.design.PstmtMemberDesign;
import kr.co.sist.pstmt.design.PstmtMemberLeftPanel;
import kr.co.sist.pstmt.design.PstmtMemberRightPanel;
import kr.co.sist.pstmt.service.PstmtMemberService;
import kr.co.sist.statement.dto.MemberDTO;

public class PstmtMemberEvent extends WindowAdapter implements ActionListener, MouseListener{

	private PstmtMemberDesign md;
	private PstmtMemberService ms;
	
	public PstmtMemberEvent(PstmtMemberDesign md) {
		this.md = md;
		ms = new PstmtMemberService();
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		md.dispose();
	}
	
	public void searchOneMember() {
		// JTable에 선택된 행의 컬럼 값을 얻어서 DB table에 한 행 조회 작업수행
		PstmtMemberRightPanel pmrp = md.getMrp();
		DefaultTableModel dtm = pmrp.getDtmMember();
		JTable jt = pmrp.getJtMember();
		
		int selectedRow = jt.getSelectedRow();
		int selectedCol = jt.getSelectedColumn();
		
//		System.out.println(selectedRow + ", " + selectedCol);
//		System.out.println(dtm.getValueAt(selectedRow, selectedCol));
		
		System.out.println(dtm.getValueAt(selectedRow, 0));
		
		//선택한 행의 회원번호를 얻어와서
		int memberNum = Integer.parseInt((String)dtm.getValueAt(selectedRow, 0));
		
		PstmtMemberService pms = new PstmtMemberService();
		//DB Table에서 조회를 수행하고
		MemberDTO mDTO = pms.searchOneMember(memberNum);
		
		PstmtMemberLeftPanel plp = md.getMlp();
		//왼쪽 패널에 JTextField에 설정
		plp.getJtfNum().setText(String.valueOf(mDTO.getNum()));
		plp.getJtfName().setText(mDTO.getName());
		plp.getJtfAge().setText(String.valueOf(mDTO.getAge()));
		plp.getJtfGender().setText(String.valueOf(mDTO.getGender()));
		plp.getJtfTel().setText(String.valueOf(mDTO.getTel()));
		plp.getJtfInputDate().setText(new SimpleDateFormat("yyyy-MM-dd hh:mm")
				.format(mDTO.getInput_date()));
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == md.getMsp().getJbtnAdd()) {
			try {
				addMember();
			} catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(md, "나이는 정수로만 입력가능합니다.");
			}
		}
		
		if(ae.getSource() == md.getMsp().getJbtnModify()) { //변경
			try {
				modifyMember();
			} catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(md, "나이는 정수로만 입력가능합니다.");
			}
		}
		
		if(ae.getSource() == md.getMsp().getJbtnRemove()) { //삭제
			try {
				removeMember();
			} catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(md, "나이는 정수로만 입력가능합니다.");
			}
		}
	}
	
	public void removeMember() throws NumberFormatException{
		PstmtMemberLeftPanel mlp = md.getMlp();
		
		if(mlp.getJtfNum().getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(md, "회원을 먼저 선택 한 후 정보를 삭제해주세요.");
			return;
		}
		
		switch (JOptionPane.showConfirmDialog(md, 
				mlp.getJtfNum().getText() + "번 회원 정보를 정말 삭제하시겠습니까?")) {
		case JOptionPane.OK_OPTION:
			break;
		case JOptionPane.NO_OPTION:
		case JOptionPane.CANCEL_OPTION:
		default:
			return;
		}
		
		//1. 사용자가 입력한 값을 얻고
		int selectedNum = Integer.parseInt(mlp.getJtfNum().getText().trim());		
		
		int flag = ms.removeMember(selectedNum);
		
		String outputMsg = "문제가 발생했습니다. 잠시 후 다시 시도해주세요.";
		
		switch (flag) {
		case 0: outputMsg = selectedNum + "번 회원은 존재하지 않습니다."; break;
		case 1: outputMsg = selectedNum + "번 회원정보를 삭제하였습니다."; break;
		}
		JOptionPane.showMessageDialog(md, outputMsg);
		//변경된 데이터를 바로 반영
		searchAllMember();
		
		resetInputField();
	}
	
	public void modifyMember() throws NumberFormatException{
		PstmtMemberLeftPanel mlp = md.getMlp();
		
		if(mlp.getJtfNum().getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(md, "회원을 먼저 선택 한 후 정보를 변경해주세요.");
			return;
		}
		
		//1. 사용자가 입력한 값을 얻고
		MemberDTO mDTO = new MemberDTO();
		mDTO.setNum(Integer.parseInt(mlp.getJtfNum().getText().trim()));
		mDTO.setAge(Integer.parseInt(mlp.getJtfAge().getText().trim()));
		mDTO.setTel(mlp.getJtfTel().getText().trim());
		
		int flag = ms.modifyMember(mDTO);
		String outputMsg = "문제가 발생했습니다. 잠시 후 다시 시도해주세요.";
		
		switch (flag) {
		case 0: outputMsg = mDTO.getNum() + "번 회원은 존재하지 않습니다."; break;
		case 1: outputMsg = mDTO.getNum() + "번 회원정보를 변경하였습니다."; break;
		}
		JOptionPane.showMessageDialog(md, outputMsg);
		//변경된 데이터를 바로 반영
		searchAllMember();
		
		resetInputField();
	}
	
	public void addMember() throws NumberFormatException{
		PstmtMemberLeftPanel mlp = md.getMlp();
		
		//1. 사용자가 입력한 값을 얻고
		MemberDTO mDTO = new MemberDTO();
		mDTO.setName(mlp.getJtfName().getText().trim());
		mDTO.setAge(Integer.parseInt(mlp.getJtfAge().getText().trim()));
		mDTO.setGender(mlp.getJtfGender().getText().trim());
		mDTO.setTel(mlp.getJtfTel().getText().trim());
		//2. DB에 추가한 후 결과를 보여준다.
		String msg = mDTO.getName() + " 회원의 정보를 추가할 수 없습니다.";
		if(ms.addMember(mDTO)) {
			msg = mDTO.getName() + "회원 정보가 성공적으로 추가되었습니다.";
			searchAllMember(); // 리스트를 갱신
		}
		JOptionPane.showMessageDialog(md, msg);
		
		//3. 입력칸을 초기화
		searchAllMember();
		
		resetInputField();
	}

	public void resetInputField() {
		PstmtMemberLeftPanel mlp = md.getMlp();
		
		mlp.getJtfName().setText("");
		mlp.getJtfAge().setText("");
		mlp.getJtfGender().setText("");
		mlp.getJtfTel().setText("");
		
		mlp.getJtfName().requestFocus();
	}
	
	/**
	 * 모든 회원을 검색하여 dlm에 설정하는 일
	 */
	public void searchAllMember() {
		//오른쪽 패널을 얻고
		PstmtMemberRightPanel prp = md.getMrp();
		//DefaultTable 모델을 얻기
		DefaultTableModel dtmMember = prp.getDtmMember();
		
		PstmtMemberService pms = new PstmtMemberService();
		//모든 회원 정보를 검색
		List<MemberDTO> listMember = pms.searchAllMember();
		//조회된 회원 정보를 사용하여 JTable에 Row로 추가
		String[] rowData = null;
		
		//테이블 행의 수를 초기화
		dtmMember.setRowCount(0);
		
		//모든 레코드를 반복
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(MemberDTO mDTO : listMember) {
			rowData = new String[6]; // JTable의 컬럼의 개수
			rowData[0] = String.valueOf(mDTO.getNum());
			rowData[1] = mDTO.getName();
			rowData[2] = String.valueOf(mDTO.getAge());
			rowData[3] = mDTO.getGender();
			rowData[4] = mDTO.getTel();
			rowData[5] = sdf.format(mDTO.getInput_date());
			
			//배열의 값을 D.T.M에 행으로 설정
			dtmMember.addRow(rowData);
		}
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		
		switch (me.getButton()) {
		case MouseEvent.BUTTON1 : //왼쪽버튼 클릭
			try {				
				searchOneMember(); // DB연동
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(md, "뎨둉합니다. 회원정보가 없습니다.");
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
