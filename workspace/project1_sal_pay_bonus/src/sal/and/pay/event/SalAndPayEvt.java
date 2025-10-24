package sal.and.pay.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import sal.and.pay.design.AddBonusDesign;
import sal.and.pay.design.SalAndPayDesign;
import sal.and.pay.design.UpdateSalDesign;
import sal.and.pay.dto.PayDateDTO;
import sal.and.pay.dto.SalAndPayDTO;
import sal.and.pay.service.SalAndPayService;

public class SalAndPayEvt extends WindowAdapter implements ActionListener {

	private SalAndPayDesign sapd;
	private SalAndPayService saps;
	
	public SalAndPayEvt(SalAndPayDesign sapd) {
		this.sapd = sapd;
		saps = new SalAndPayService();
	}
	
	
	
	/** 연봉에 관한 사원 행들 뿌리기
	 * @return : 연봉과 사원정보들
	 */
	public Object[][] loadSalEmp() {
		
		List<SalAndPayDTO> list = saps.selectSalEmp();
		Object[][] data = new Object[list.size()][5];
		
		for(int i = 0; i < list.size(); i++) {
			SalAndPayDTO sal = list.get(i);
			data[i] = new Object[]{sal.getEmp_id(), sal.getName(), sal.getdName(), sal.getpName(), sal.getSal()};
		}
		return data;
	}
	
	/**
	 * 연봉 수정하는 모달창을 키며 사번, 이름을 연봉수정 모달창Design에게 넘긴다
	 * @param selectedRow
	 */
	public void openUpdateSal(int selectedRow) {
		// 연봉 정보 모달창 오픈
		Object emp_id = sapd.getJtYearSal().getValueAt(selectedRow, 0);
		Object name = sapd.getJtYearSal().getValueAt(selectedRow, 1);
					
		new UpdateSalDesign(sapd, (int)emp_id, (String)name);	
			
	}
	
	/**
	 * 업데이트 이후 연봉 테이블을 최신화 해주는 메서드 
	 */
	public void refreshYearSalTable() {
		sapd.getDtmYearSal().setRowCount(0);
		
		Object[][] newData = loadSalEmp();
		
		for(Object[] row : newData) {
			sapd.getDtmYearSal().addRow(row);
		}
	}
	
	/**
	 * 지급예정일 JLabel에서 25일이 지나있으면 다음 달 25일을 표기해주는 메서드
	 * @return
	 */
	public String nextPayDate() {
		LocalDate now = LocalDate.now();
		LocalDate thisMonth25 = LocalDate.of(now.getYear(), now.getMonth(), 25);
		
		// 25일이 이미 지났으면 다음 달 25일
		if (now.isAfter(thisMonth25)) {
			thisMonth25 = thisMonth25.plusMonths(1);
		}
		return thisMonth25.toString();
	}
	
	public Object[][] loadPayDate() {
		
		List<PayDateDTO> list = saps.selectPayDate();
		Object[][] data = new Object[list.size()][6];
		
		for(int i = 0; i < list.size(); i++) {
			PayDateDTO payDateValues = list.get(i);
			data[i] = new Object[]{payDateValues.getEmp_id(),
					payDateValues.getName(),
					payDateValues.getPay(),
					payDateValues.getDuty(),
					payDateValues.getBonus(),
					payDateValues.getRealPay()};
		}
		return data;
	}
	
	public void refreshPayDateTable() {
		sapd.getDtmPayDate().setRowCount(0);
		
		Object[][] newData = loadPayDate();
		
		for(Object[] row : newData) {
			sapd.getDtmPayDate().addRow(row);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 연봉수정 버튼 클릭 시 행을 클릭했는가
		if (e.getSource() == sapd.getJbtnSalUpdate()) {			
			int selectedRow = sapd.getJtYearSal().getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(null, "한 명의 사원을 선택해주세요");
			} else {
				openUpdateSal(selectedRow);
			}
		}
		
		// 지급예정 버튼 클릭 시 지급예정 화면(CardLayout)출력
		if (e.getSource() == sapd.getJbtnShowPayDate()) {
			sapd.getClPayDate().show(sapd.getJpCard(), "PAY_DATE");
		}
		// 지급기록 버튼 클릭 시 지급기록 화면(CardLayout)출력
		if (e.getSource() == sapd.getJbtnShowPayRecords()) {
			sapd.getClPayDate().show(sapd.getJpCard(), "PAY_RECORDS");
		}
		
		// 보너스 확인 버튼을 클릭했을 때
		if (e.getSource() == sapd.getJbtnCheckBonus()) {
			int selectedRow = sapd.getJtPayDate().getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(null, "한 명의 사원을 선택해주세요");
			} else {
				int emp_id = (int) sapd.getJtPayDate().getValueAt(selectedRow, 0); // 사번
				String name = (String) sapd.getJtPayDate().getValueAt(selectedRow, 1); // 이름
				new AddBonusDesign(sapd, emp_id, name);
			}
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		sapd.dispose();
	}

	
}
