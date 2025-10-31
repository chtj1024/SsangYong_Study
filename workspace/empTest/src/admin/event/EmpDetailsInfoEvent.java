package admin.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List; // java.util.List 임포트 확인

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import admin.design.EmpDetailsInfoDesign;
import admin.design.EmpMgmDesign;
import admin.dto.DeptSelectDTO;
import admin.dto.EmpDetailDTO;
import admin.dto.PositionDTO;
import admin.service.EmpDetailsInfoService;

public class EmpDetailsInfoEvent extends WindowAdapter implements ActionListener {

	private EmpDetailsInfoDesign edid;
	private EmpDetailsInfoService es;
	private int empNo;
	
	// [신규] 활성화된 부서 목록을 저장하기 위한 리스트
	private List<DeptSelectDTO> activeDeptList; 

	public EmpDetailsInfoEvent(EmpDetailsInfoDesign edid) {
		this.edid = edid;
		this.es = new EmpDetailsInfoService();
		this.empNo = edid.getEmpNo(); 
		
		
		loadComboBoxes();     
		loadEmployeeData(); 
	}

	private void loadComboBoxes() {
		try {
			// [수정] 1. 활성화된 부서 목록을 가져와서 *필드에 저장*
			this.activeDeptList = es.findAllDepartments(); // (DELETE_YN = 0)
			
			DefaultComboBoxModel<DeptSelectDTO> deptModel = edid.getDcbmDept();
			// [수정] 2. 저장된 리스트로 콤보박스 채우기
			for(DeptSelectDTO dDTO : this.activeDeptList) {
				deptModel.addElement(dDTO);
			}
			
			List<PositionDTO> posList = es.findAllPositions();
			DefaultComboBoxModel<PositionDTO> posModel = edid.getDcbmPosition();
			for(PositionDTO pDTO : posList) {
				posModel.addElement(pDTO);
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(edid, "부서/직급 정보 로드 중 오류가 발생했습니다.");
		}
	}

	private void loadEmployeeData() {
		try {
			EmpDetailDTO eDTO = es.loadEmployee(this.empNo); 

			if (eDTO == null) {
				JOptionPane.showMessageDialog(edid, "사원 정보가 존재하지 않습니다.");
				edid.dispose();
				return;
			}

			edid.getJtfEmpNo().setText(String.valueOf(eDTO.getEmpNo()));
			edid.getJtfName().setText(eDTO.getEmpName());
			
			// --- 전화번호 로딩 로직 ---
			String fullTel = eDTO.getTel();
			if(fullTel != null && fullTel.contains("-")) {
				String[] telParts = fullTel.split("-");
				if(telParts.length == 3) {
					boolean prefixFound = false;
					for(int i=0; i < edid.getDcbmTel1().getSize(); i++) {
						if(edid.getDcbmTel1().getElementAt(i).equals(telParts[0])) {
							prefixFound = true;
							break;
						}
					}
					if(prefixFound) {
						edid.getDcbmTel1().setSelectedItem(telParts[0]);
					} else {
						edid.getDcbmTel1().addElement(telParts[0]);
						edid.getDcbmTel1().setSelectedItem(telParts[0]);
					}
					
					edid.getJtfTel2().setText(telParts[1]);
					edid.getJtfTel3().setText(telParts[2]);
				} else {
					edid.getJcbTel1().setSelectedIndex(0); 
					edid.getJtfTel2().setText(""); 
					edid.getJtfTel3().setText("");
				}
			} else {
				edid.getJcbTel1().setSelectedIndex(0); 
				edid.getJtfTel2().setText(""); 
				edid.getJtfTel3().setText("");
			}
			// --- ---
			
			edid.getJtfEmail().setText(eDTO.getEmail()); 
			edid.getJtfAddress().setText(eDTO.getAddress());
			edid.getJtfHireDate().setText(formatDate(eDTO.getHireDate()));
			edid.getJtfQuitDate().setText(formatDate(eDTO.getRetireDate()));
			
			edid.getJtfVacationDays().setText(String.valueOf(eDTO.getVacationDays()));
			
			DecimalFormat df = new DecimalFormat("###,###,###,###원");
			edid.getJtfSal().setText(df.format(eDTO.getSal()));
			
			edid.getJcbAuth().setSelectedIndex(eDTO.getAuth());
			

			// --- 부서 선택 로직 (삭제된 부서 처리) ---
			DefaultComboBoxModel<DeptSelectDTO> deptModel = edid.getDcbmDept();
			boolean deptFound = false;
			// 'activeDeptList' 필드를 사용 (콤보박스 모델을 직접 뒤지지 않음)
			for(DeptSelectDTO dDTO : this.activeDeptList) {
				if(dDTO.getDeptCode() == eDTO.getDeptNo()) {
					deptModel.setSelectedItem(dDTO); 
					deptFound = true;
					break;
				}
			}
			
			if(!deptFound) {
				DeptSelectDTO deletedDeptDTO = new DeptSelectDTO(eDTO.getDeptNo(), eDTO.getDeptName());
				deptModel.addElement(deletedDeptDTO);
				deptModel.setSelectedItem(deletedDeptDTO);
			}
			// --- ---
			
			
			DefaultComboBoxModel<PositionDTO> posModel = edid.getDcbmPosition();
			for(int i = 0; i < posModel.getSize(); i++) {
				PositionDTO pDTO = posModel.getElementAt(i);
				if(pDTO.getPosCode() == eDTO.getPositionCode()) {
					posModel.setSelectedItem(pDTO);
					break;
				}
			}
			
			if(eDTO.getRetireDate() != null) {
				edid.getJbtnSave().setEnabled(false);
				edid.getJbtnQuit().setEnabled(false);
				edid.getJtfVacationDays().setEditable(false); 
				edid.getJbtnResetPwd().setEnabled(false); 
				
				edid.getJcbTel1().setEnabled(false);
				edid.getJtfTel2().setEditable(false);
				edid.getJtfTel3().setEditable(false);
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(edid, "정보 로드 중 오류가 발생했습니다.\n" + e.getMessage());
		}
	}
	
	private String formatDate(Date date) {
		if(date == null) { return "null"; }
		return date.toString();
	}

	private boolean modifyEmployee() {
		int chk = JOptionPane.showConfirmDialog(edid, "정보를 수정하시겠습니까?", "수정 확인", JOptionPane.YES_NO_OPTION);
		if(chk != JOptionPane.YES_OPTION) {
			return false;
		}
			
		DeptSelectDTO selectedDept = (DeptSelectDTO) edid.getJcbDept().getSelectedItem();
		PositionDTO selectedPos = (PositionDTO) edid.getJcbPosition().getSelectedItem();

		// --- [신규] 삭제된 부서인지 검증 ---
		boolean isDeptValid = false;
		// 콤보박스를 채웠던 '활성화된 부서 리스트(activeDeptList)'와 현재 선택된 부서 코드를 비교
		for(DeptSelectDTO validDept : this.activeDeptList) {
			if(validDept.getDeptCode() == selectedDept.getDeptCode()) {
				isDeptValid = true; // 리스트에 존재하면 (활성화된 부서임)
				break;
			}
		}
		
		// '활성화된 부서 리스트'에 없으면 -> (임시로 추가된) 삭제된 부서임
		if(!isDeptValid) {
			JOptionPane.showMessageDialog(edid, "선택한 부서는 존재하지 않거나 삭제된 부서입니다.\n다른 부서를 선택한 후 저장해주세요.", "저장 오류", JOptionPane.ERROR_MESSAGE);
			return false; // 저장 중단
		}
		// --- [검증 끝] ---
		
		String tel1 = (String) edid.getJcbTel1().getSelectedItem();
		String tel2 = edid.getJtfTel2().getText().trim(); 
		String tel3 = edid.getJtfTel3().getText().trim(); 

		if (tel1 == null || tel2.isEmpty() || tel3.isEmpty()) {
			JOptionPane.showMessageDialog(edid, "전화번호를 모두 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
			return false; 
		}
		if (!tel2.matches("^\\d{3,4}$")) {
			JOptionPane.showMessageDialog(edid, "전화번호 중간 부분은 3~4자리의 숫자로 입력하세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
			edid.getJtfTel2().requestFocus();
			return false; 
		}
		if (!tel3.matches("^\\d{4}$")) {
			JOptionPane.showMessageDialog(edid, "전화번호 마지막 부분은 4자리의 숫자로 입력하세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
			edid.getJtfTel3().requestFocus();
			return false; 
		}
		
		String fullTel = tel1 + "-" + tel2 + "-" + tel3; 
		
		String address = edid.getJtfAddress().getText();
		int auth = edid.getJcbAuth().getSelectedIndex();
		String vacationDaysStr = edid.getJtfVacationDays().getText();

		if(vacationDaysStr.length() > 3) {
			JOptionPane.showMessageDialog(edid, "휴가 일수는 3자리까지만 가능합니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
			return false; 
		}
		
		try {
			EmpDetailDTO eDTO = new EmpDetailDTO();
			int vacationDays = 0;
			try {
				vacationDays = Integer.parseInt(vacationDaysStr);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(edid, "보유 휴가일 수는 숫자로만 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
				return false; 
			}
			
			eDTO.setEmpNo(this.empNo);
			eDTO.setDeptNo(selectedDept.getDeptCode()); 
			eDTO.setPositionCode(selectedPos.getPosCode()); 
			eDTO.setTel(fullTel); 
			eDTO.setAddress(address);
			eDTO.setAuth(auth);
			eDTO.setVacationDays(vacationDays); 
			
			int cnt = es.modifyEmployee(eDTO);
			
			if(cnt == 1) {
				JOptionPane.showMessageDialog(edid, "사원 정보가 성공적으로 수정되었습니다.");
				edid.dispose(); 
				return true; 
			} else {
				JOptionPane.showMessageDialog(edid, "사원 정보 수정에 실패했습니다.");
				return false; 
			}
		} catch (NullPointerException npe) {
			JOptionPane.showMessageDialog(edid, "부서 또는 직급 정보가 선택되지 않았습니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
			return false; 
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(edid, "DB 오류로 수정에 실패했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			return false; 
		}
	}

	private void retireEmployee() {
		int chk1 = JOptionPane.showConfirmDialog(edid, "정말로 퇴사 처리하시겠습니까? \n(한번 퇴사처리하면 복구 불가합니다.)", 
				"퇴사 확인 (1/2)", JOptionPane.YES_NO_OPTION);
		
		if(chk1 == JOptionPane.YES_OPTION) {
			
			int chk2 = JOptionPane.showConfirmDialog(edid, 
					"진짜 리얼로... 후회하지 않을 자신 있습니까?\n이 작업은 되돌릴 수 없습니다. 정말로 퇴사 처리합니까?", 
					"최종 확인 (2/2)", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.WARNING_MESSAGE); 
			
			if(chk2 == JOptionPane.YES_OPTION) {
				try {
					int cnt = es.retireEmployee(this.empNo);
					
					if(cnt == 1) {
						JOptionPane.showMessageDialog(edid, "퇴사 처리가 완료되었습니다.");
						loadEmployeeData(); 
					} else {
						JOptionPane.showMessageDialog(edid, "퇴사 처리에 실패했습니다.");
					}
				} catch (SQLException | IOException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(edid, "DB 오류로 퇴사 처리에 실패했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
				}
			} 
		} 
	}

	private void resetPassword() {
		int chk = JOptionPane.showConfirmDialog(edid, 
			"사원의 비밀번호를 '1111'로 초기화하시겠습니까?", 
			"비밀번호 초기화 확인", 
			JOptionPane.YES_NO_OPTION,
			JOptionPane.WARNING_MESSAGE);
		
		if (chk == JOptionPane.YES_OPTION) {
			try {
				int cnt = es.resetPassword(this.empNo);
				if (cnt == 1) {
					JOptionPane.showMessageDialog(edid, "비밀번호가 '1111'로 초기화되었습니다.");
				} else {
					JOptionPane.showMessageDialog(edid, "비밀번호 초기화에 실패했습니다.");
				}
			} catch (SQLException | IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(edid, "DB 오류로 초기화에 실패했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == edid.getJbtnResetPwd()) {
			resetPassword();
		}
		
		if (ae.getSource() == edid.getJbtnSave()) {
			if (modifyEmployee()) {
				new EmpMgmDesign();
			}
		}
		
		if (ae.getSource() == edid.getJbtnQuit()) {
			retireEmployee();
		}
		if (ae.getSource() == edid.getJbtnCancel()) {
			edid.dispose();
			new EmpMgmDesign();
		}
	}

	@Override
	public void windowClosing(WindowEvent we) {
		edid.dispose();
	}
	
}// class