package emp.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import emp.DTO.VacInfoDTO;
import emp.DTO.VacInfoResponseDTO;
import emp.Service.VacInfoService;
import emp.view.VacInfoCenterPanel;
import emp.view.VacInfoDesign;
import emp.view.VacInfoNorthPanel;
import emp.view.VacInfoSouthPanel;

public class VacInfoEvt extends WindowAdapter implements ActionListener, KeyListener {
	private VacInfoDesign vid;
	private VacInfoService vis;
	private int empId;
	private final static int TOO_PAST = 1;
	private final static int TOO_LONG_TO_HAVE_BREAK = 2;
	
	
	public VacInfoEvt(VacInfoDesign vid, int currentUser) {
		this.vid = vid;
		this.empId= currentUser;
		vis = new VacInfoService();
		inputNameDept();
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		vid.dispose();
	}
	
	public void inputNameDept() {
		VacInfoNorthPanel vinp = vid.getVinp();
		
		String[] names = vis.getNameDept(empId);
		
		vinp.getJlName().setText(names[0]);
		vinp.getJlDept().setText(names[1]);
	}
	
	public void inputVacDays() {
		VacInfoNorthPanel vinp = vid.getVinp();
		
		int vacDays = vis.getVacDays(empId);
		double useDays = vis.countOneVac(empId) + (vis.countHalfVac(empId) * 0.5);
		
		vinp.getJtfTotalDate().setText("총 휴가 일 수: " +
				String.valueOf(vacDays));
		vinp.getJtfUseDate().setText("사용한 휴가 일 수: " +
				String.valueOf(useDays));
		vinp.getJtfRemainDate().setText("남은 휴가 일 수: " +
				String.valueOf(vacDays - useDays));
	}
	
	public void inputDcbm() {
		VacInfoCenterPanel vicp = vid.getVicp();
		
		List<String> vacTypeList = vis.getVacType();
		
		for(String vacType : vacTypeList) {
			vicp.getDcbmVacayType().addElement(vacType);
		}
		
		vicp.getDcbmStartYear().addElement("2025");
		vicp.getDcbmStartYear().addElement("2026");
		vicp.getDcbmEndYear().addElement("2025");
		vicp.getDcbmEndYear().addElement("2026");
		
		Calendar cal = Calendar.getInstance();
		
		for(int i = 1; i < 13; i ++) {
			vicp.getDcbmStartMonth().addElement(String.valueOf(i));
			vicp.getDcbmEndMonth().addElement(String.valueOf(i));
			cal.set(Calendar.MONTH, i);
		}
		
		for(int i = 1; i < 32; i++ ) {
			vicp.getDcbmStartDay().addElement(String.valueOf(i));
			vicp.getDcbmEndDay().addElement(String.valueOf(i));
		}
	}
	
	public int checkDate(Calendar startDate, Calendar endDate) {
		int vacDays = vis.getVacDays(empId);
		int useDays = vis.countOneVac(empId) + (vis.countHalfVac(empId) / 2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		LocalDate ld = LocalDate.now();
		Calendar cal = Calendar.getInstance();
		
		cal.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
		
		long subDateTime = endDate.getTimeInMillis() - startDate.getTimeInMillis();
		int subDateDate = (int) (subDateTime /86400000L);
		
		startDate.add(Calendar.DATE, 1);
		endDate.add(Calendar.DATE, 1);
		
		if(startDate.getTimeInMillis() < cal.getTimeInMillis() ||
				endDate.getTimeInMillis() < cal.getTimeInMillis()) {
			return TOO_PAST;
		}
		
		if(subDateDate > (vacDays - useDays)) {
			return TOO_LONG_TO_HAVE_BREAK;
		}
		
		return 0;
	}
	
	public void resistVac() {
		VacInfoCenterPanel vicp = vid.getVicp();
	      
	      if("".equals(vicp.getJtfReason().getText().trim())) {
	         JOptionPane.showMessageDialog(vicp, "사유를 입력하세요.");
	         return;
	      }
	      
	      Calendar sCal = Calendar.getInstance();
	      Calendar eCal = Calendar.getInstance();
	      
	      Date startDate = null;
	      Date endDate = null;
	      
	      sCal.setLenient(false);
	      eCal.setLenient(false);
	      
	      int sYear = Integer.parseInt(vicp.getDcbmStartYear().getElementAt(vicp.getJcStartYear().getSelectedIndex()));
	      int sMonth = Integer.parseInt(vicp.getDcbmStartMonth().getElementAt(vicp.getJcStartMonth().getSelectedIndex()));
	      int sDate = Integer.parseInt(vicp.getDcbmStartDay().getElementAt(vicp.getJcStartDay().getSelectedIndex()));
	      
	      int eYear = Integer.parseInt(vicp.getDcbmEndYear().getElementAt(vicp.getJcEndYear().getSelectedIndex()));
	      int eMonth = Integer.parseInt(vicp.getDcbmEndMonth().getElementAt(vicp.getJcEndMonth().getSelectedIndex()));
	      int eDate = Integer.parseInt(vicp.getDcbmEndDay().getElementAt(vicp.getJcEndDay().getSelectedIndex()));
	      
	      try {
	         sCal.set(sYear, sMonth-1, sDate);
	         eCal.set(eYear, eMonth - 1, eDate);
	         
	         startDate = new Date(sCal.getTimeInMillis());
	         endDate = new Date(eCal.getTimeInMillis());
	         
	      } catch (IllegalArgumentException e) {
	          JOptionPane.showMessageDialog(vicp, "존재하지 않는 날짜입니다.");
	          return;
	      }
	      
	      if((sCal.getTimeInMillis() - eCal.getTimeInMillis()) > 0) {
	         JOptionPane.showMessageDialog(vicp, "시작일의 날짜가 더 큽니다.");
	         return;
	      }
	      
	      switch (checkDate(sCal, eCal)) {
	      case TOO_PAST: JOptionPane.showMessageDialog(vicp, "현재 날짜에 맞게 신청해주십시오."); break;
	      case TOO_LONG_TO_HAVE_BREAK: JOptionPane.showMessageDialog(vicp, "보유한 연차보다 긴 휴가는 사용할 수 없습니다."); break;
	      
	      default: 
	         String vtname = vicp.getDcbmVacayType().getElementAt(vicp.getJcVacayType().getSelectedIndex());
	         VacInfoDTO vDTO = new VacInfoDTO(0, empId, vis.getVtCode(vtname), vicp.getJtfReason().getText()
	               .trim(), startDate, endDate, ' ');
	         boolean flag = vis.resistVacUse(vDTO);
	         
	         if(flag) {
	            setComboBox();
	            vicp.getJtfReason().setText("");
//	            new VacInfoCenterPanel();
	         } else {
	            JOptionPane.showMessageDialog(vicp, "오류! 관리자에게 보고해주세요.");
	         }
	      }
	}
	
	public void callVacInfo() {
		VacInfoSouthPanel visp = vid.getVisp();
		
		List<VacInfoResponseDTO> vacInfoList = vis.callVacUse(empId);
		DefaultTableModel dtm = visp.getDtmApplyDetails();
		
		String[] rowData = null;
		dtm.setRowCount(0);
		
		for(VacInfoResponseDTO virDTO : vacInfoList) {
			rowData = new String[4];
			
			rowData[0] = virDTO.getVtname();
			rowData[1] = virDTO.getStart_date().toString() + " - "
					 + virDTO.getEnd_date().toString();
			rowData[2] = virDTO.getReason();
			
			switch (virDTO.getApprove()){	
			case 'P': rowData[3] = "대기"; break;
			case 'Y': rowData[3] = "승인"; break;
			case 'N': rowData[3] = "반려"; break;
			}
			
			dtm.addRow(rowData);
		}
		
	}
	
	public void setComboBox() {
		VacInfoCenterPanel vicp = vid.getVicp();
		
		vicp.getJcVacayType().setSelectedIndex(0);
		
		vicp.getJcStartYear().setSelectedIndex(0);
		vicp.getJcStartMonth().setSelectedIndex(0);
		vicp.getJcStartDay().setSelectedIndex(0);
		
		vicp.getJcEndYear().setSelectedIndex(0);
		vicp.getJcEndMonth().setSelectedIndex(0);
		vicp.getJcEndDay().setSelectedIndex(0);
		
	}

	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			resistVac();
			
			vid.getVisp().setVacInfo(this);
			vid.getVisp().repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) { }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vid.getVicp().getJbtnApply()) {
			resistVac();
			
			vid.getVisp().setVacInfo(this);
			vid.getVisp().repaint();
		}
	}

}
