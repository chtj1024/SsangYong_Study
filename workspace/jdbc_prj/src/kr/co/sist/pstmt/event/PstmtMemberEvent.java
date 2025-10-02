package kr.co.sist.pstmt.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import kr.co.sist.pstmt.design.PstmtMemberDesign;
import kr.co.sist.pstmt.service.PstmtMemberService;
import kr.co.sist.statement.design.MemberDesign;
import kr.co.sist.statement.design.MemberLeftPanel;
import kr.co.sist.statement.dto.MemberDTO;
import kr.co.sist.statement.service.MemberService;

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
		DefaultListModel<String> dlm = md.getMrp().getDlmMember();
		JList<String> jl = md.getMrp().getJlMember();
		String selectedMember = dlm.elementAt(jl.getSelectedIndex());
		String[] memberArrData = selectedMember.split(",");
		
		//선택한 회원의 번호 얻기
		int memberNum = Integer.parseInt(memberArrData[0]);
		MemberDTO mDTO = ms.searchOneMember(memberNum); //회원번호로 검색한 결과 DTO저장 반환
		MemberLeftPanel mlp = md.getMlp();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a");
		
		mlp.getJtfNum().setText(String.valueOf(mDTO.getNum()));
		mlp.getJtfName().setText(mDTO.getName());
		mlp.getJtfAge().setText(String.valueOf(mDTO.getAge()));
		mlp.getJtfGender().setText(mDTO.getGender());
		mlp.getJtfTel().setText(mDTO.getTel());
		mlp.getJtfInputDate().setText(sdf.format(mDTO.getInput_date()));
	}
	
	public void useSplit() {
		DefaultListModel<String> dlm = md.getMrp().getDlmMember();
		JList<String> jl = md.getMrp().getJlMember();
		String selectedMember = dlm.elementAt(jl.getSelectedIndex());
//		System.out.println(selectedMember);
		String[] memberArrData = selectedMember.split(",");
		//배열의 데이터를 JTextField에 설정
		MemberLeftPanel mlp = md.getMlp();
		mlp.getJtfNum().setText(memberArrData[0]);
		mlp.getJtfName().setText(memberArrData[1]);
		mlp.getJtfAge().setText(memberArrData[2]);
		mlp.getJtfGender().setText(memberArrData[3]);
		mlp.getJtfTel().setText(memberArrData[4]);
		mlp.getJtfInputDate().setText(memberArrData[5]);
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
		MemberLeftPanel mlp = md.getMlp();

		
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
		MemberLeftPanel mlp = md.getMlp();
		
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
		MemberLeftPanel mlp = md.getMlp();
		
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
		MemberLeftPanel mlp = md.getMlp();
		
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
		List<String> listMemberData = ms.searchAllMember();
		
		DefaultListModel<String> dlm = md.getMrp().getDlmMember();
		dlm.clear(); // 리스트모델을 초기화
		
		if(listMemberData.isEmpty()) { //검색된 결과 없음.
			dlm.addElement("가입된 회원 정보가 조재하지 않습니다.");
		}
		for(String recordData : listMemberData) {
			dlm.addElement(recordData); // 리스트모델에 조회결과 추가
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
