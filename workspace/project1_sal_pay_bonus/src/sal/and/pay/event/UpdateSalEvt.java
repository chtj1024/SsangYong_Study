package sal.and.pay.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import sal.and.pay.design.UpdateSalDesign;
import sal.and.pay.dto.SalAndPayDTO;
import sal.and.pay.service.SalAndPayService;

public class UpdateSalEvt extends WindowAdapter implements ListSelectionListener, ActionListener{

	private UpdateSalDesign usd;
	private SalAndPayService saps;
	
	public UpdateSalEvt(UpdateSalDesign usd) {
		this.usd = usd;
		saps = new SalAndPayService();
	}
	
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
