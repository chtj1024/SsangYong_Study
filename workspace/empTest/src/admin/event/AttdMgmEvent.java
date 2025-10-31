package admin.event; 

import admin.design.AttdMgmDesign;
import admin.dto.AttendanceDTO;
import admin.service.AttdMgmService;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.util.List;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter; 
import java.time.format.DateTimeParseException;


public class AttdMgmEvent extends WindowAdapter implements ActionListener, TableModelListener { 
    
    private AttdMgmDesign ad;
    private AttdMgmService as;
    // [추가] 메시지 중복 출력을 방지하기 위한 플래그
    private boolean isRestoringTable = false; 

    public AttdMgmEvent(AttdMgmDesign design) {
        
this.ad
 = design;
        
this.as
 = new AttdMgmService(); 
        
        initDeptComboBox();
        setComboBoxInTable(); 
        
        searchAttd();
        
        ad.getDtmAttd().addTableModelListener(this); 
    }

    @Override
    public void windowClosing(WindowEvent e) {
        ad.dispose(); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ad.getJbtnSearch()) {
            searchAttd();
        } 
    }
    
    @Override
    public void tableChanged(TableModelEvent e) {
        if (isRestoringTable) {
            return; 
        }

        if (e.getType() == TableModelEvent.UPDATE) {
            int row = e.getFirstRow();
            int column = e.getColumn(); 
            
            if (column == 7) { // 근태 상태 컬럼
                DefaultTableModel model = ad.getDtmAttd();
                
                // 테이블 UI에서 변경된 새로운 값
                String newStatus = (String) model.getValueAt(row, column);
                String targetDate = getTargetDate();
                int empNo = Integer.parseInt(model.getValueAt(row, 1).toString()); 
                
                modifyAttdStatus(empNo, newStatus, targetDate);
            }
        }
    }

    private String getTargetDate() {
        String startYear = (String) ad.getJcbStartYear().getSelectedItem();
        String startMonth = (String) ad.getJcbStartMonth().getSelectedItem();
        String startDay = (String) ad.getJcbStartDay().getSelectedItem();
        return startYear + "-" + startMonth + "-" + startDay;
    }


    public void initDeptComboBox() {
        
        List<String> deptList = as.selectAllDepartments();
        
        ad.getDcbmDept().removeAllElements();
        ad.getDcbmDept().addElement("전체");
        for (String dept : deptList) {
            ad.getDcbmDept().addElement(dept);
        }
    }

    public void searchAttd() {
        String selectedDept = (String) ad.getJcbDept().getSelectedItem();
        
        String targetDate = getTargetDate();

        try {
            LocalDate.parse(targetDate, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
             JOptionPane.showMessageDialog(ad, "선택된 날짜가 유효하지 않습니다.", "날짜 오류", JOptionPane.ERROR_MESSAGE);
             return;
        }
        
        List<AttendanceDTO> attdList;
        
        attdList = as.searchAttendanceByDate(selectedDept, targetDate);
        
        ad.getDtmAttd().setRowCount(0);
        
        if (attdList != null) {
            for (AttendanceDTO dto : attdList) {
                ad.getDtmAttd().addRow(dto.toObjectArray());
            }
        }
    }
    
    public void setComboBoxInTable() {
        List<String> statusList = as.selectAllAttendanceStatus();
        ad.setComboBoxInTable(statusList);
    }

    public void modifyAttdStatus(int empNo, String newStatus, String targetDate) {

        // 1. DB에서 현재 상태를 다시 조회하여 '미등록'인지 확인합니다.
        List<AttendanceDTO> currentAttdList = as.searchAttendanceByDate(
            (String) ad.getJcbDept().getSelectedItem(), targetDate);
        
        String originalStatus = null;
        for (AttendanceDTO dto : currentAttdList) {
            if (dto.getEmpNo() == empNo) { 
                originalStatus = dto.getAttendanceStatus();
                break;
            }
        }

        // 2. '미등록' 상태인 경우 수정을 차단
        if ("미등록".equals(originalStatus)) {
            ad.getDtmAttd().removeTableModelListener(this);
            isRestoringTable = true; // 플래그 설정

            JOptionPane.showMessageDialog(ad, 
                "미등록 상태는 수정 대상이 아닙니다.", 
                "수정 불가", 
                JOptionPane.WARNING_MESSAGE);
            
            searchAttd();
            
            isRestoringTable = false;
            ad.getDtmAttd().addTableModelListener(this);
            return;
        }
        
        // 3. '미등록'이 아닌 경우, 정상적인 수정 프로세스를 진행
        ad.getDtmAttd().removeTableModelListener(this); 
        
        int result = JOptionPane.showConfirmDialog(
            ad,
            empNo + " 사원의 근태 상태를 " + newStatus + "으로 수정하시겠습니까?", 
            "근태 상태 수정 확인",
            JOptionPane.YES_NO_OPTION
        );
        
        if (result == JOptionPane.YES_OPTION) {
            
            int updateResult = as.modifyAttdStatus(empNo, newStatus);
            
            if (updateResult > 0) {
                JOptionPane.showMessageDialog(ad, "수정 성공!", "알림", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(ad, "수정 실패!", "알림", JOptionPane.WARNING_MESSAGE);
            }
        } 
        
        searchAttd();
        ad.getDtmAttd().addTableModelListener(this);
    }
} 