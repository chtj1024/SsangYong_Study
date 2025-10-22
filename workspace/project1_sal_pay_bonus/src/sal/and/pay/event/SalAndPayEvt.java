package sal.and.pay.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JOptionPane;

import sal.and.pay.design.SalAndPayDesign;
import sal.and.pay.design.UpdateSalDesign;
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
	
	// 업데이트 이벤트 작성해야함
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 연봉수정 버튼 클릭 시 행을 클릭했는가
		int selectedRow = sapd.getJtYearSal().getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "한 명의 사원을 선택해주세요");
		} else {
			openUpdateSal(selectedRow);
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		sapd.dispose();
	}

	
}
