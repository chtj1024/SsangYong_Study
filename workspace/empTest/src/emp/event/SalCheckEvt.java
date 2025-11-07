package emp.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import emp.DTO.SalCheckDTO;
import emp.Service.SalCheckService;
import emp.design.SalCheckDesign;

public class SalCheckEvt extends WindowAdapter implements ActionListener {

	private SalCheckDesign scd;
	private SalCheckService scs;
	private int emp_id;

	public SalCheckEvt(SalCheckDesign scd, int empno) {
		
		this.scd = scd;
		this.scs = new SalCheckService();
		this.emp_id = empno;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		scd.dispose();
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		try {
			loadMySalInfo();
			//콤보박스 현재년도 자동선택
			int currentYear = java.time.Year.now().getValue();
			scd.getJcbYear().setSelectedItem(currentYear + "년");
			loadEmployeePay(currentYear, emp_id);
		} catch (IOException |SQLException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(scd, "급여 정보를 불러오는 중 오류가 발생했습니다.");
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==scd.getJcbYear()) {
			try {
				//Jcombobox에서 선택된 년도 가져오기
				JComboBox<String> jcbYear=scd.getJcbYear();	
				String selected = (String) jcbYear.getSelectedItem();
				//2025년에서 2025만
				int year=Integer.parseInt(selected.replace("년","").trim());
				
				//연도+사원번호 전달
				loadEmployeePay(year, emp_id);
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(scd, "올바른 연도를 선택하세요");
				
			}

		}
	}

	// 창열떄 내급여정보 불러오기
	public void loadMySalInfo() throws SQLException {
		SalCheckDTO sDTO = scs.getMySalInfo(emp_id);
		if (sDTO != null) {
			scd.getJtfName().setText(sDTO.getEmpName());
			scd.getJtfJob().setText(sDTO.getEmpJob());
			scd.getJtfEmpNo().setText(String.valueOf(sDTO.getEmp_id()));
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			scd.getJtfHireDate().setText(sdf.format(sDTO.getHiredate()));

			scd.getJtfYearSal().setText(String.format("%,d",sDTO.getYearlySal()));
			scd.getJtfMonthSal().setText(String.format("%,d",sDTO.getMonthlySal()));
			scd.getJtfBonus().setText(String.format("%,d",sDTO.getBonus()));

		} else {
			JOptionPane.showMessageDialog(scd, "내 정보를 불러오지 못했습니다");
		}
	}

	// 선택된 급여내역 연도 Jtable에 출력
	private void loadEmployeePay(int year, int empno) throws SQLException, IOException {
		// DAO에서 정보받아오기
		List<SalCheckDTO> list = scs.SalaryInfo(year, empno);

		// 디자인에서 테이블모델가져오기
		DefaultTableModel model = scd.getModel();

		// 테이블 초기화 후 다시 추가
		model.setRowCount(0);
		if (list == null || list.isEmpty()) {
			JOptionPane.showMessageDialog(scd, "해당년도의 급여 내역이 없습니다.");
			return;
		}
		
		//합계용 변수설정
		long totalPaySum =0;
		long bonusSum=0;
		long taxSum=0;
		long realPaySum=0;
		
		for (SalCheckDTO sDTO : list) {
			Object[] row = { 
					sDTO.getPayDate(), 
					sDTO.getTotalPay(), 
					sDTO.getBonusPay(), 
					sDTO.getTax(),
					sDTO.getRealPay()
		};
			model.addRow(row);
		
		//합계 누적
		  totalPaySum  += sDTO.getTotalPay();
	      bonusSum += sDTO.getBonusPay();
	      taxSum += sDTO.getTax();
	      realPaySum += sDTO.getRealPay();
		}
	      //행추가
	      Object[] totalRow = { 
	    	    "합계", 
	    	    totalPaySum, 
	    	    bonusSum, 
	    	    taxSum, 
	    	    realPaySum 
	    	    };
		
		model.addRow(totalRow);
		
	}

	}

