package emp.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import admin.design.AdminMainDesign;
import emp.design.LoginDesign;
import emp.design.maindesign.EmpMainDesign;
import emp.DTO.LoginDTO;
import emp.DTO.UserInfoDTO;
import emp.Service.EmpMainService;
import emp.Service.LoginService;

public class LoginEvt extends WindowAdapter implements ActionListener{
	private LoginDesign ld;
	private LoginService ls;
	
	public LoginEvt (LoginDesign ld) {
		this.ld=ld;
		ls=LoginService.getInstance();
	}//LoginEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == ld.getJbtnLogin() || ae.getSource() == ld.getJpfPass()) {
			loginProcess();
		}//end if
		if(ae.getSource()==ld.getJbtnCancle()) {
			ld.dispose();
		}//end if
	}//actionPerformed

	@Override
	public void windowClosing(WindowEvent e) {
		ld.dispose();
	}//windowClosing
	
	private void loginProcess() {
		String id = ld.getJtfid().getText().trim();
		String pass=new String(ld.getJpfPass().getPassword());
		
		if(id.isEmpty() && pass.isEmpty()) {
			JOptionPane.showMessageDialog(ld, "회원 정보를 입력해주세요");
			ld.getJtfid().requestFocus();
			return;
		}//end if
		if(id.isEmpty()) {
			JOptionPane.showMessageDialog(ld, "아이디를 입력해주세요.");
			ld.getJtfid().requestFocus();
			return;
		}//end if
		if(pass.isEmpty()) {
			JOptionPane.showMessageDialog(ld, "비밀번호를 입력해주세요.");
			ld.getJpfPass().requestFocus();
			return;
		}//end if
		
		LoginDTO inputDTO = new LoginDTO();
		
		try{
			inputDTO.setEmpId(Integer.parseInt(id));
		}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(ld, "사원번호는 숫자만 입력해주세요.");
			ld.getJtfid().requestFocus();
			return;
		}//end catch
		
		inputDTO.setPwd(pass);
		
		LoginDTO resultDTO;
		try {
			resultDTO = ls.login(inputDTO);

			if(resultDTO != null) {
				JOptionPane.showMessageDialog(ld, resultDTO.getName()+ "님, 환영합니다");
	
				int authType = resultDTO.getAuthType();

				if (authType == 0) { // 이용자일 경우
					// UserInfoDTO 가져와서 EmpMainDesign 열기
					UserInfoDTO userInfo = EmpMainService.getInstance().searchEmpInfo(resultDTO.getEmpId());
					if(userInfo != null ) {
						new EmpMainDesign(userInfo); 
						ld.dispose();
					} else {
						JOptionPane.showMessageDialog(ld, "사용자 정보를 불러오는데 실패하였습니다");
					}
				} else if (authType == 1) { // 관리자일 경우
					 new AdminMainDesign(resultDTO); // 예시: 관리자 화면 클래스 호출
					 ld.dispose(); // 로그인 창 닫기
				} else {
					// authType이 0이나 1이 아닌 경우 (예외 처리)
					JOptionPane.showMessageDialog(ld, "알 수 없는 사용자 권한입니다.");
				}
			}else {
				JOptionPane.showMessageDialog(ld, "로그인 정보가 일치하지 않습니다");
			}//end if
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(ld, "시스템 접속에 실패했습니다. 관리자에게 문의하세요.");
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(ld, "시스템 접속에 실패했습니다. 관리자에게 문의하세요.");
		}//end catch
		
	}//loginProcess
	
	
	
}
