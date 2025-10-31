package emp.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import emp.design.MyPageDesign;
import emp.design.SalCheckDesign;
import emp.design.WorkRecordsDesign;
import emp.design.maindesign.EmpMainDesign;
import emp.view.VacInfoDesign;
import emp.DTO.UserInfoDTO;
import emp.DTO.WorkRecordsResultDTO;
import emp.Service.EmpMainService;

public class EmpMainEvt extends WindowAdapter implements ActionListener {
	private EmpMainDesign emd;
	private EmpMainService ems;
	private UserInfoDTO currentUser;
	private WorkRecordsDesign wrd;
	private VacInfoDesign vid;
	private SalCheckDesign scd;
	private MyPageDesign mpd;

	public EmpMainEvt(EmpMainDesign emd, UserInfoDTO userinfo)  {
		this.emd=emd;
		this.currentUser = userinfo;
		ems=EmpMainService.getInstance();
		searchWorkLog();
		
	}//EmpMainEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == emd.getEwd().getJbtnIn()) {
			clockIn();}
		if(ae.getSource() == emd.getEwd().getJbtnOut()) {
			clockOut();}
		if(ae.getSource() == emd.getEmd().getJbtnWorkLog()) {
			wrd=new WorkRecordsDesign(currentUser);
		}
		if(ae.getSource() == emd.getEmd().getJbtnVacation()) {
			vid=new VacInfoDesign(currentUser);
		}
		if(ae.getSource() == emd.getEmd().getJbtnSalary()) {
			scd=new SalCheckDesign(currentUser.getEmpId());
		}
		if(ae.getSource() == emd.getEmd().getJbtnMyPage()) {
			mpd=new MyPageDesign(currentUser.getEmpId(),this);
		}
	}//actionPerformed
	
	private void clockIn() {
		try {
			this.ems.recordClockIn(currentUser.getEmpId());
				JOptionPane.showMessageDialog(emd, "출근 처리 되었습니다");
				searchWorkLog();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//clockIn
	
	private void clockOut() {
		try {
			boolean flag = this.ems.recordClockOut(currentUser.getEmpId());
			if (flag) {
				JOptionPane.showMessageDialog(emd, "퇴근 처리 되었습니다");
				searchWorkLog();
			}else {
				JOptionPane.showMessageDialog(emd, "출근 기록이 없거나 이미 퇴근처리 되었습니다.");
			}//end if
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//clockOut

	public void searchWorkLog() {
		try {
			List<WorkRecordsResultDTO> list=this.ems.searchRecentWork(currentUser.getEmpId());
			emd.getEwd().updateWorkLogTable(list);
			setClockButtonState();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//serchWorkLog
	
	public void refreshProfileInfo() {
		try {
			UserInfoDTO refrUserInfo = this.ems.searchEmpInfo(currentUser.getEmpId());
		if(refrUserInfo != null) {
			this.currentUser =refrUserInfo;
			emd.getEpd().displayUserInfo(this.currentUser);
		}else {
			JOptionPane.showMessageDialog(emd, "사용자 정보를 새로고침하는데 실패했습니다");
		}//end if
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	}//refreshProfileInfo
	
	public void setClockButtonState() {
		DefaultTableModel dtm=emd.getEwd().getDtmWorkLog();
		int rowCnt = dtm.getRowCount();
		if (rowCnt == 0) {
			emd.getEwd().getBtnCardLayout().show(emd.getEwd().getBtnCardPanel()
					, "IN");
			emd.getEwd().getJbtnIn().setEnabled(true);
			return;
		}//end if
		
		int topRow = 0;
		String lastCheckIn = (String)dtm.getValueAt(topRow, 0);
		String lastStatus = (String)dtm.getValueAt(topRow, 2);
		String checkInDate = "";
		if(lastCheckIn != null && lastCheckIn.length() >= 15) {
			checkInDate = lastCheckIn.substring(5,15);
		}//end if
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		
		if(today.equals(checkInDate)) {
			if("정상".equals(lastStatus)) {
				emd.getEwd().getBtnCardLayout().show(emd.getEwd().getBtnCardPanel(), "IN");
				emd.getEwd().getJbtnIn().setEnabled(false);
			}else {
				emd.getEwd().getBtnCardLayout().show(emd.getEwd().getBtnCardPanel(), "OUT");
			}//end if
			}else {
				emd.getEwd().getBtnCardLayout().show(emd.getEwd().getBtnCardPanel(), "IN");
				emd.getEwd().getJbtnIn().setEnabled(true); // 활성화
		}//end if
	}//setClockButtonState
	
	@Override
	public void windowClosing(WindowEvent e) {
		  if(wrd != null) { wrd.dispose(); }
	      if(vid != null) { vid.dispose(); }
	      if(scd != null) { scd.dispose(); }
	      if(mpd != null) { mpd.dispose(); }
	      
	      emd.dispose();
	}//serchWorkLog
	
	

}
