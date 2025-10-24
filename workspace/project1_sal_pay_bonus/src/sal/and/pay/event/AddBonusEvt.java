package sal.and.pay.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JOptionPane;

import sal.and.pay.design.AddBonusDesign;
import sal.and.pay.dto.SalAndPayDTO;
import sal.and.pay.service.SalAndPayService;

public class AddBonusEvt extends WindowAdapter implements ActionListener{

	private AddBonusDesign abd;
	private SalAndPayService saps;
	private SalAndPayEvt sape;
	
	public AddBonusEvt(AddBonusDesign abd, SalAndPayEvt sape) {
		this.abd = abd;
		saps = new SalAndPayService();
		this.sape = sape;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == abd.getJbtnAddBonus()) {
			addBonus();
		}
	}

	public Object[][] loadEmpBonus() {
		List<SalAndPayDTO> list = saps.selectBonus(abd.getEmp_id());
		Object[][] data = new Object[list.size()][3];
		
		for(int i = 0; i < list.size(); i++) {
			SalAndPayDTO bonus = list.get(i);
			data[i] = new Object[]{bonus.getPay(), bonus.getPay_date(), bonus.getPay_note()};
		}
		return data;
	}
	
	public void addBonus() {
		String strBonus = abd.getJtfBonus().getText().trim();
		String strReason = abd.getJtfReason().getText().trim();
		
		if (strBonus.isEmpty()) {
			JOptionPane.showMessageDialog(null, "보너스 금액을 입력해주세요.");
			return;
		}
		int bonus;
		try {
			bonus = Integer.parseInt(strBonus);				
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "보너스는 숫자만 입력해주세요.");
			abd.getJtfBonus().requestFocus();
			return;
		}
		
		if (bonus >= 10000000) {
			JOptionPane.showMessageDialog(null, "1000만원 미만만 입력 가능합니다.");
			return;
		}
		if (strReason.isEmpty()) {
			JOptionPane.showMessageDialog(null, "사유는 공백이면 안됩니다.");
			return;
		}
		if (strReason.length() > 20) {
			JOptionPane.showMessageDialog(null, "사유는 20자 이하로 입력해주세요.");
			return;
		}
		
		SalAndPayDTO sDTO = new SalAndPayDTO(abd.getEmp_id(), 0, 0, bonus, 0, 0, "", "", "", strReason, null);
		
		String msg = abd.getName() + "사원의 보너스를 추가할 수 없습니다.";
		if (saps.insertBonus(sDTO)) {
			msg = abd.getName() + "사원의 보너스가 성공적으로 추가되었습니다.";
		}
		JOptionPane.showMessageDialog(null, msg);
		// 보너스 테이블 갱신(최신화)
		refreshBonusTable();
		// 입력칸 초기화
		abd.getJtfBonus().setText("");
		abd.getJtfReason().setText("");
		
		// 지급예정 테이블 최신화
		sape.refreshPayDateTable();
	}
	
	public void refreshBonusTable() {
		abd.getDtmBonus().setRowCount(0);
		
		Object[][] newData = loadEmpBonus();
		
		for(Object[] row : newData) {
			abd.getDtmBonus().addRow(row);
		}
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		abd.dispose();
	}

}
