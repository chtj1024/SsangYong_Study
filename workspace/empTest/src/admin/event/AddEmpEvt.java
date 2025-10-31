package admin.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import admin.design.AddEmpDesign;
import admin.dto.AddEmpDTO;
import admin.service.AddEmpService;

public class AddEmpEvt extends WindowAdapter implements ActionListener, KeyListener {
	private AddEmpDesign aed;
	
	public AddEmpEvt(AddEmpDesign aed) {
		this.aed = aed;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		aed.dispose();
	}

	public void inputJcb() {
		AddEmpService aes = new AddEmpService();
		DefaultComboBoxModel<String> dcbm = null;
		List<String> deptList = new ArrayList<String>();
		
		dcbm = aed.getDcbmDept();
		deptList = aes.callAllDept();
		for(String str : deptList) {
			dcbm.addElement(str);
		}
		
		dcbm = aed.getDcbmPos();
		deptList = aes.callAllPos();
		for(String str : deptList) {
			dcbm.addElement(str);
		}
		
		dcbm = aed.getDcbmSal();
		deptList = aes.callAllSal();
		for(String str : deptList) {
			dcbm.addElement(str);
		}
	}
	
	public void addEmp() {
		AddEmpService aes = new AddEmpService();
		AddEmpDTO aDTO = new AddEmpDTO();
		
		aDTO.setName(aed.getJtfName().getText().trim());
		aDTO.setEmail(aed.getJtfEmail().getText().trim());
		aDTO.setTel(aed.getJtfTel().getText().trim());
		aDTO.setAddr(aed.getJtfAddr().getText().trim());
		
		if(!check(aDTO)) {
			JOptionPane.showMessageDialog(aed, "올바른 입력값을 입력하지 않았습니다");
			return;
		}
		
		String dname = aed.getDcbmDept().getElementAt(aed.getJcbDept().getSelectedIndex());
		String pname = aed.getDcbmPos().getElementAt(aed.getJcbPos().getSelectedIndex());
		String sal = aed.getDcbmSal().getElementAt(aed.getJcbSal().getSelectedIndex());
		
		aes.addEmp(aDTO, dname, pname, Integer.parseInt(sal));
		
		JOptionPane.showMessageDialog(aed, "추가되었습니다!");
		aed.dispose();
	}

	public boolean check(AddEmpDTO aed) {
		boolean result = false;
		
		boolean flag1 = false;
		boolean flag2 = false;
		
		if(aed.getEmail().contains("@") && aed.getEmail().contains(".")) {
			flag1 = true;
		}
		
		String[] telArr = null;
		
		try {
			telArr = aed.getTel().split("-");
		} catch (NullPointerException npe) {
			return false;
		}
		
		
		if(telArr.length == 3 && telArr[0].length() == 3 && telArr[1].length() == 4 && telArr[2].length() == 4) {
			flag2 = true;
		}
		
		if(flag1 & flag2) {
			result = true;
		}
		
		return result;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			addEmp();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) { }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == aed.getJbtnConfirm()) {
			addEmp();
		}
		
		if(e.getSource() == aed.getJbtnDeny()) {
			aed.dispose();
		}
	}

}
