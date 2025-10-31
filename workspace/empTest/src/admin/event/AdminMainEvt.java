package admin.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import admin.design.AdminMainDesign;
import admin.design.AttdMgmDesign;
import admin.design.DeptMgmDesign;
import admin.design.EmpMgmDesign;
import admin.design.SalAndPayDesign;
import admin.design.VacationMgmDesign;
import emp.DTO.LoginDTO;
import emp.DTO.UserInfoDTO;
import emp.Service.EmpMainService;
import emp.design.maindesign.EmpMainDesign;

/**
 * 관리자 메인 화면의 버튼 이벤트와 창 닫기 이벤트를 처리하는 클래스
 * 각 출력되는 문장에 맞게 클래스를 넣어주시면 됩니다
 */
public class AdminMainEvt extends WindowAdapter implements ActionListener {
	private AdminMainDesign amd;
	private LoginDTO lDTO;
		
	public AdminMainEvt(AdminMainDesign amd) {
		this.amd = amd;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == amd.getJbtnEmp()) {
			new EmpMgmDesign();
		} else if(e.getSource() == amd.getJbtnDept()) {
			new DeptMgmDesign();
		} else if(e.getSource() == amd.getJbtnAttendance()) {
			new AttdMgmDesign();
		} else if(e.getSource() == amd.getJbtnVacation()) {
			new VacationMgmDesign();
		} else if(e.getSource() == amd.getJbtnSal()) {
			new SalAndPayDesign();
		} else if(e.getSource() == amd.getjbtnUser()) {
			UserInfoDTO userInfo=new UserInfoDTO();
			try {
				userInfo = EmpMainService.getInstance().searchEmpInfo(lDTO.getEmpId());
				new EmpMainDesign(userInfo);
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(amd, "관리자에게 문의하세요");
				return;
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(amd, "관리자에게 문의하세요");
				return;
			}
		} else {
			JOptionPane.showMessageDialog(amd, "등록된 버튼 외의 것을 선택하셨습니다.");
		}
	}
	
	public void setLoginDTO(LoginDTO lDTO) {
		this.lDTO = lDTO;
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		amd.dispose();
	}
}
