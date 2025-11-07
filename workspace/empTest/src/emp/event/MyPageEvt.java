package emp.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.JOptionPane;

import emp.DTO.MyPageDTO;
import emp.Service.MyPageService;
import emp.design.MyPageDesign;

public class MyPageEvt extends WindowAdapter implements ActionListener{
	private MyPageDesign mpd;
	private MyPageService mps;
	private int emp_id;
	
	private EmpMainEvt eme; //사용자정보 즉시반영
	
	public MyPageEvt() {
		
	}

	public MyPageEvt(MyPageDesign mpd, int empno) {
		
		this.mpd = mpd;
		this.emp_id = empno;
		this.mps = new MyPageService();
		
		
		//서비스 연동
	}
	
	public MyPageEvt(MyPageDesign mpd, EmpMainEvt eme, int emp_id) {
		this.mpd=mpd;
		this.eme=eme;
		this.emp_id=emp_id;
		this.mps=new MyPageService();
	}
		
	@Override
	public void windowOpened(WindowEvent e) {
		loadMyInfo();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		mpd.dispose();
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == mpd.getUpdateMyInfo()) { //개인정보수정
			updateMyInfo();
			if(eme != null) {
				eme.refreshProfileInfo();
			
			}
			
			try {
				
			}catch(NullPointerException np) {
				JOptionPane.showMessageDialog(mpd, "회원정보가 수정되었습니다.");
			}//end catch
		}//end if
		
		if(ae.getSource() ==mpd.getUpdatePass())  { //비밀번호수정
			changePassword();
			try {
				
			}catch(NullPointerException np) {
				JOptionPane.showMessageDialog(mpd, "비밀번호가 수정되었습니다.");
			}//end catch
		}//end if
		
		
	}
	
	
	//내정보 표시
	
	public void loadMyInfo() {
		MyPageDTO mDTO=mps.getMyinfo(emp_id);
		if(mDTO !=null) {
			mpd.getJtfJob().setText(mDTO.getEmpJob());
			mpd.getJtfDeptName().setText(mDTO.getDeptName());
			mpd.getJtfEmpNo().setText(String.valueOf(mDTO.getEmp_id()));
			
			mpd.getJtfname().setText(mDTO.getEmpName());
			mpd.getJtftel().setText(mDTO.getTel());
			mpd.getJtfEmail().setText(mDTO.getEmail());
			mpd.getJtfAddr().setText(mDTO.getAddr());
			
		}else {
			JOptionPane.showMessageDialog(mpd, "내 정보를 불러오지 못했습니다");
		}
		
	}
	
	//내정보 수정
	public void updateMyInfo() {
		
		try {
		//입력값 가져오기
		
		String tel=mpd.getJtftel().getText().trim();
		String email=mpd.getJtfEmail().getText().trim();
		String addr=mpd.getJtfAddr().getText().trim();
		
		//유효성검증
		if(tel.isEmpty()||email.isEmpty()||addr.isEmpty()){
			JOptionPane.showMessageDialog(mpd, "모든 항목을 입력해주세요");
			return;
		}
		//전화번호, 이메일형식
		if(!tel.matches("\\d{3}-\\d{4}-\\d{4}$")) {
			JOptionPane.showMessageDialog(mpd, "전화번호 형식이 올바르지 않습니다. 예)010-1234-5678");
			return;
		}
		if(!email.contains("@")||!email.contains(".")){
			JOptionPane.showMessageDialog(mpd, "이메일 형식이 올바르지 않습니다. 예)abc@gmail.com");
			return;
		}
		
			
		MyPageDTO mDTO=new MyPageDTO();
		mDTO.setEmp_id(Integer.parseInt(mpd.getJtfEmpNo().getText().trim()));
		mDTO.setTel(mpd.getJtftel().getText());
		mDTO.setEmail(mpd.getJtfEmail().getText());
		mDTO.setAddr(mpd.getJtfAddr().getText());
		
		boolean result = mps.updateMyPage(mDTO);
		JOptionPane.showMessageDialog(mpd, 
				result ? "개인정보 수정 완료" : "개인정보 변경 실패");
		

		
		
		}catch(NullPointerException | NumberFormatException e){
			JOptionPane.showMessageDialog(mpd, "공백 또는 잘못된 문자가 입력되었습니다.");
			
		}
		if (eme != null) {
			eme.refreshProfileInfo(); // 프로필 정보 즉시 갱신
		}
	}
	

	//비번변경
	public void changePassword() {
		try {
		String currentPass=new String(mpd.getJtfCurrentPass().getPassword());
		String newPass=new String(mpd.getJtfNewPass().getPassword());
		String  confirmPass=new String(mpd.getJtfConfirmPass().getPassword());
		//비밀번호가 비었거나 공백
		if(currentPass.isEmpty()||newPass.isEmpty()||confirmPass.isEmpty()) {
			JOptionPane.showMessageDialog(mpd, "모든 비밀번호 입력칸을 채워주세요.");
			return;
		}
		
		//문자열 중간에 공백제거
		if(currentPass.contains(" ")||newPass.contains(" ")||confirmPass.contains(" ")) {
			JOptionPane.showMessageDialog(mpd, "비밀번호에 공백은 포함될 수 없습니다.");
			return;
		}
		
		
		
		//현재비번확인
		if(!mps.checkCurrentPassword(emp_id, currentPass)) {
			JOptionPane.showMessageDialog(mpd, "현재 비밀번호가 일치하지 않습니다.");
			return;
		}
		
		
		//새비번 확인
		if(!mps.checkNewPassword(newPass, confirmPass)) {
			JOptionPane.showMessageDialog(mpd, "새 비밀번호가 일치하지 않습니다.");
			return;
		}
		//바꾼번호가 기존번호랑 같음
		if(mps.checkCurrentPassword(emp_id, confirmPass)==
				(mps.checkNewPassword(newPass, confirmPass))) {
			JOptionPane.showMessageDialog(mpd, "기존 비밀번호와 같습니다. 변경해주세요");
			return;
		}
		
		//새비번맞으면 변경
		MyPageDTO mDTO= new MyPageDTO();
		mDTO.setEmp_id(emp_id);
		mDTO.setPass(newPass);
		
		boolean result=mps.updatePass(mDTO);
		JOptionPane.showMessageDialog(mpd, result ? "비밀번호 변경완료":"비밀번호 변경실패");
		
		}catch(Exception e) {
			JOptionPane.showMessageDialog(mpd,"비밀번호 변경중 오류발생.");
			e.printStackTrace();
		}
		
		
		
		
	}


	
}
