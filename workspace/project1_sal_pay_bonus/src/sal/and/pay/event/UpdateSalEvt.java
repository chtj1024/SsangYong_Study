package sal.and.pay.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import sal.and.pay.design.UpdateSalDesign;
import sal.and.pay.dto.SalAndPayDTO;
import sal.and.pay.service.SalAndPayService;

public class UpdateSalEvt extends WindowAdapter implements ListSelectionListener, ActionListener{

	private UpdateSalDesign usd;
	private SalAndPayService saps;
	private SalAndPayEvt sape;
	
	public UpdateSalEvt(UpdateSalDesign usd, SalAndPayEvt sape) {
		this.usd = usd;
		saps = new SalAndPayService();
		this.sape = sape;
	}
	
	/**
	 * 연봉 테이블의 정보만 뿌리기
	 * @return
	 */
	public Object[][] loadSalInfo() {
		List<SalAndPayDTO> list = saps.selectSalInfo();
		Object[][] data = new Object[list.size()][2];
		
		for(int i = 0; i < list.size(); i++) {
			SalAndPayDTO sal = list.get(i);
			data[i] = new Object[]{sal.getSal_code(), sal.getSal()};
		}
		return data;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		super.windowClosing(e);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 사원을 선택한 연봉 모달창에서 수정버튼 눌렀을 때
		if(e.getSource() == usd.getJbtnUpdateSal()) {		
			updateEmpSalCode();
		}
		
	}

	public void updateEmpSalCode() {
		if(usd.getJtfSal().getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "연봉을 선택해주세요.");
		} else {
			Object[][] data = loadSalInfo();
			int intSal = Integer.parseInt(usd.getJtfSal().getText().trim());
			boolean found = false; // 일치하는 연봉을 찾았는지
			
			for(int i = 0; i < data.length; i++) {
				if ((int)data[i][1] == intSal) {
					int codeSal = (int)data[i][0];
					SalAndPayDTO sDTO = new SalAndPayDTO();
					sDTO.setEmp_id(usd.getEmp_id());
					sDTO.setSal_code(codeSal);
					sDTO.setSal(intSal);
					
					saps.updateSal(sDTO); // 해당 사원의 연봉정보 업데이트
					
					JOptionPane.showMessageDialog(null, "해당 사원의 연봉정보가 업데이트 되었습니다.");
					
					// 사원들의 연봉 테이블 최신화
					sape.refreshYearSalTable();
					
					found = true;
					
					usd.dispose();
					
					break;
				}
			}
			if (!found) {
				JOptionPane.showMessageDialog(null, "선택한 연봉에 해당하는 코드가 없습니다.");
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// 연봉 테이블의 행이 클릭되었을 때 JTextField에 업데이트
		if(!e.getValueIsAdjusting()) {
			int row = usd.getJtSal().getSelectedRow();
									
			if (row != -1) {
				String salValue = usd.getDtmSal().getValueAt(row, 1).toString();
				usd.getJtfSal().setText(salValue);
			} 
		}
	}

	
}
