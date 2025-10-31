package admin.event;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import admin.design.AddDeptDesign;
import admin.design.DeptDetailsDesign;
import admin.design.DeptMgmDesign;
import admin.dto.DeptDTO;
import admin.service.DeptService;


public class DeptMgmEvt extends WindowAdapter implements ActionListener {
    
    private DeptMgmDesign dm;
    private DeptService ds;

    public DeptMgmEvt(DeptMgmDesign design) {
        this.dm = design;
        this.ds = new DeptService();
        
        initDeptList();
        
        dm.getJtDeptList().addMouseListener(new DeptTableMouseAdapter());
        
        setDeptNameRenderer();
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        dm.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dm.getJbtnDeptAdd()) {
            addDept(); 
        }
    }
    
    /**
     * 삭제된 부서명에 취소선(Strike-through)을 긋는 렌더러 설정
     */
    private void setDeptNameRenderer() {
        dm.getJtDeptList().getColumnModel().getColumn(DeptMgmDesign.COL_DEPT_NAME)
            .setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                // 숨겨진 컬럼 (COL_DELETE_YN)의 값을 읽어옵니다.
                Object deleteYn = table.getModel().getValueAt(row, DeptMgmDesign.COL_DELETE_YN);
                
                if (deleteYn != null && deleteYn.toString().equals("1")) {
                    // 삭제된 경우: 취소선 HTML 태그 적용
                    ((JLabel) c).setText("<html><strike>" + value.toString() + "</strike></html>");
                    c.setForeground(java.awt.Color.GRAY); // 색상 변경 (선택 사항)
                } else {
                    // 활성 부서인 경우: 일반 텍스트 및 기본 색상 적용
                    ((JLabel) c).setText(value.toString());
                    c.setForeground(table.getForeground());
                }
                return c;
            }
        });
    }


    private class DeptTableMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                JTable target = (JTable) e.getSource();
                int row = target.getSelectedRow();
                
                if (row != -1) {
                    int deptNo = Integer.parseInt(target.getValueAt(row, DeptMgmDesign.COL_DEPT_NO).toString()); 
                    
                    DeptDetailsDesign detailsPopup = new DeptDetailsDesign(dm);
                    DeptDetailsEvt detailsEvt = new DeptDetailsEvt(detailsPopup);
                    detailsEvt.loadDeptData(deptNo);
                    
                    detailsPopup.setVisible(true);
                    
                    initDeptList(); 
                }
            }
        }
    }
    
    public void initDeptList() {
        List<DeptDTO> deptList = ds.searchDept(null, 0); 
        
        List<Object[]> deptData = new ArrayList<>();
        
        for (DeptDTO dto : deptList) {
            deptData.add(new Object[]{
                String.valueOf(dto.getDeptNo()),
                dto.getDeptName(),
                dto.getDeleteYn()
            });
        }
        
        dm.showDeptList(deptData);
    }

    public void addDept() {
        final AddDeptDesign addDeptPopup = new AddDeptDesign(dm);
        
        addDeptPopup.getJbtnDeptAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deptName = addDeptPopup.getJtfDeptName().getText().trim();
                
                if (deptName.isEmpty()) {
                    JOptionPane.showMessageDialog(addDeptPopup, "부서명을 입력해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int result = JOptionPane.showConfirmDialog(
                    addDeptPopup,
                    "부서명: " + deptName + "\n추가하시겠습니까?",
                    "부서 추가 확인",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                
                if (result == JOptionPane.YES_OPTION) {
                    DeptDTO newDept = new DeptDTO(0, deptName, null);
                    boolean success = ds.addtDept(newDept);
                    
                    if (success) {
                        JOptionPane.showMessageDialog(addDeptPopup, "부서가 성공적으로 추가되었습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
                        addDeptPopup.dispose(); 
                        initDeptList(); 
                    } else {
                        JOptionPane.showMessageDialog(addDeptPopup, "부서 추가에 실패했습니다.", "실패", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        addDeptPopup.setVisible(true);
    }
}