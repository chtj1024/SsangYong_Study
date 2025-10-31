package admin.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener; 
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import admin.design.VacationAprDesign;
import admin.design.VacationMgmDesign;
import admin.dto.DeptSelectDTO;
import admin.dto.VacationMgmDTO;
import admin.service.VacationMgmService;

public class VacationMgmEvt extends WindowAdapter implements ActionListener, KeyListener, MouseListener {

	private VacationMgmDesign vmd;
	private VacationMgmService vms;

	public VacationMgmEvt(VacationMgmDesign vmd) {
		this.vmd = vmd;
		this.vms = new VacationMgmService();
		
		
		loadDeptComboBox();
		infoVacation();
	}
	
	
	public void loadDeptComboBox() {
		DefaultComboBoxModel<DeptSelectDTO> model = vmd.getDcbmDept();
		model.addElement(new DeptSelectDTO(-1, "전체"));
		
		List<DeptSelectDTO> list = vms.findAllDepartments();
		for(DeptSelectDTO dDTO : list) {
			model.addElement(dDTO);
		}
	}

	public void infoVacation() {
		List<VacationMgmDTO> list = vms.infoVacation();
		setTableData(list);
	}
	
	public void searchVacation() {
		DeptSelectDTO selectedDept = (DeptSelectDTO) vmd.getJcDept().getSelectedItem();
		String dName = "전체";
		if(selectedDept != null) {
			dName = selectedDept.getDName();
		}
		
		String eName = vmd.getJtfEmpName().getText().trim();
		
		String startDate = vmd.getJcStartYear().getSelectedItem().toString() + "-" +
						   vmd.getJcStartMonth().getSelectedItem().toString() + "-" +
						   vmd.getJcStartDay().getSelectedItem().toString();
		
		String endDate = vmd.getJcEndYear().getSelectedItem().toString() + "-" +
						 vmd.getJcEndMonth().getSelectedItem().toString() + "-" +
						 vmd.getJcEndDay().getSelectedItem().toString();

		List<VacationMgmDTO> list = vms.searchVacation(dName, eName, startDate, endDate);
		setTableData(list);
	}
	
	public void setTableData(List<VacationMgmDTO> list) {
		DefaultTableModel dtm = vmd.getDtmVacation();
		dtm.setRowCount(0);
		
		if(list.isEmpty()) {
			JOptionPane.showMessageDialog(vmd, "데이터가 없습니다.");
			return;
		}
		
		for(VacationMgmDTO vmDTO : list) {
			Object[] rowData = {
				vmDTO.getUse_id(),
				vmDTO.getEmp_id(),
				vmDTO.geteName(),
				vmDTO.getdName(),
				vmDTO.getpName(),
				vmDTO.getVtName(),
				vmDTO.getReason(),
				vmDTO.getStartDate(),
				vmDTO.getEndDate(),
				vmDTO.getApprove() 
			};
			dtm.addRow(rowData);
		}
	}
	
	public void aprVacation() {
		JTable table = vmd.getJtVacation();
		int selectedRow = table.getSelectedRow();
		
		if(selectedRow == -1) {
			return;
		}
		
		int useId = (int) table.getValueAt(selectedRow, 0); 
		String currentStatus = (String) table.getValueAt(selectedRow, 9); 
		
		VacationAprDesign vad = new VacationAprDesign(vmd, currentStatus);
		new VacationAprEvt(vad, useId, this);
		vad.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == vmd.getJbtnSearch()) {
			searchVacation();
		}
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		if(ke.getSource() == vmd.getJtfEmpName() && ke.getKeyCode() == KeyEvent.VK_ENTER) {
			searchVacation();
		}
	}

	@Override
	public void windowClosing(WindowEvent we) {
		vmd.dispose();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		if(me.getSource() == vmd.getJtVacation()) {
			JTable table = vmd.getJtVacation();
			int row = table.rowAtPoint(me.getPoint());
			int col = table.columnAtPoint(me.getPoint());
			
			if(col == 9 && row != -1) { 
				table.setRowSelectionInterval(row, row); 
				aprVacation();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
	
	
}