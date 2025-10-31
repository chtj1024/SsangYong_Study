package admin.event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JOptionPane;

import admin.design.DeptDetailsDesign;
import admin.dto.DeptDTO;
import admin.service.DeptService;

import java.awt.Color;

public class DeptDetailsEvt extends WindowAdapter implements ActionListener {
    
    private DeptDetailsDesign ddd;
    private DeptService ds;
    private int currentDeptNo;
    private int currentDeleteYn; 

    public DeptDetailsEvt(DeptDetailsDesign design) {
        this.ddd = design;
        this.ds = new DeptService();
        
        ddd.getJbtnSave().addActionListener(this);
        ddd.getJbtnDelete().addActionListener(this); 
        ddd.getJbtnCancel().addActionListener(this);
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        ddd.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ddd.getJbtnCancel()) {
            ddd.dispose();
        } else if (e.getSource() == ddd.getJbtnSave()) {
            updateDept(); 
        } else if (e.getSource() == ddd.getJbtnDelete()) {
            if (ddd.getJbtnDelete().getText().equals("부서 삭제")) {
                deleteDept();
            } else if (ddd.getJbtnDelete().getText().equals("부서 복구")) {
                restoreDept();
            }
        }
    }
    
    public void loadDeptData(int deptNo) {
        this.currentDeptNo = deptNo;

        List<DeptDTO> deptList = ds.searchDept(null, deptNo); 
        
        if (!deptList.isEmpty()) {
            DeptDTO dto = deptList.get(0);
            
            this.currentDeleteYn = dto.getDeleteYn(); 
            
            ddd.getJtfDeptno().setText(String.valueOf(dto.getDeptNo()));
            ddd.getJtfDeptName().setText(dto.getDeptName());
            ddd.getJtfDeptHead().setText(dto.getDeptHead());
            
            int empCount = ds.getEmployeeCount(deptNo);
            ddd.getJtfEmpcnt().setText(String.valueOf(empCount));

            List<String[]> empList = ds.getEmployeesList(deptNo);
            ddd.showEmp(empList); 
            
            if (currentDeleteYn == 1) {
                // 삭제된 부서일 경우: 복구 버튼 표시 및 수정 비활성화
                ddd.getJbtnDelete().setText("부서 복구");
                ddd.getJbtnDelete().setForeground(Color.BLACK);
                ddd.getJbtnDelete().setBackground(new Color(152, 251, 152));
                ddd.getJbtnSave().setEnabled(false); 
                ddd.getJtfDeptName().setEditable(false);
            } else {
                // 활성 부서일 경우: 삭제 버튼 표시 및 수정 활성화
                ddd.getJbtnDelete().setText("부서 삭제");
                ddd.getJbtnDelete().setForeground(Color.WHITE);
                ddd.getJbtnDelete().setBackground(new Color(220, 20, 60)); 
                ddd.getJbtnSave().setEnabled(true);
                ddd.getJtfDeptName().setEditable(true);
            }
            
        } else {
            JOptionPane.showMessageDialog(ddd, "부서 정보 로드에 실패했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateDept() {
        String newName = ddd.getJtfDeptName().getText();
        
        if (newName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(ddd, "부서명은 필수 입력 항목입니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DeptDTO updatedDto = new DeptDTO(currentDeptNo, newName, null); 
        
        boolean success = ds.updateDept(updatedDto);
        
        if (success) {
            JOptionPane.showMessageDialog(ddd, "부서 정보가 수정되었습니다.", "수정 완료", JOptionPane.INFORMATION_MESSAGE);
            loadDeptData(currentDeptNo); 
        } else {
            JOptionPane.showMessageDialog(ddd, "부서 정보 수정에 실패했습니다.", "실패", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteDept() {
        int confirm = JOptionPane.showConfirmDialog(
            ddd, 
            ddd.getJtfDeptName().getText() + " 부서를 삭제하시겠습니까?", 
            "부서 삭제 확인", 
            JOptionPane.YES_NO_OPTION
        );
        
        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = ds.removeDept(currentDeptNo);
            
            if (success) {
                JOptionPane.showMessageDialog(ddd, "부서가 삭제되었습니다.", "삭제 완료", JOptionPane.INFORMATION_MESSAGE);
                loadDeptData(currentDeptNo); 
            } else {
                JOptionPane.showMessageDialog(ddd, "부서 삭제에 실패했습니다.", "실패", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void restoreDept() {
        int confirm = JOptionPane.showConfirmDialog(
            ddd, 
            ddd.getJtfDeptName().getText() + " 부서를 복구하시겠습니까?", 
            "부서 복구 확인", 
            JOptionPane.YES_NO_OPTION
        );
        
        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = ds.restoreDept(currentDeptNo);
            
            if (success) {
                JOptionPane.showMessageDialog(ddd, "부서 복구가 완료되었습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
                loadDeptData(currentDeptNo); 
            } else {
                JOptionPane.showMessageDialog(ddd, "부서 복구에 실패했습니다.", "실패", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}