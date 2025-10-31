package emp.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import emp.design.WorkRecordsDesign;
import emp.DTO.WorkRecordSearchDTO;
import emp.DTO.WorkRecordsResultDTO;
import emp.Service.WorkRecordsService;

public class WorkRecordsEvt extends WindowAdapter implements ActionListener{
	public WorkRecordsDesign wrd;
	public WorkRecordsService wrs;
	
	public WorkRecordsEvt (WorkRecordsDesign wrd) {
		this.wrd=wrd;
		this.wrs=WorkRecordsService.getInstance();
		searchWorkRecords();
	}//WorkRecordsEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == wrd.getJbtnView()) {
			searchWorkRecords();
		}
	}//actionPerformed

	@Override
	public void windowClosing(WindowEvent e) {
		wrd.dispose();
	}//windowClosing
	
	private void searchWorkRecords() {
		try {
			WorkRecordSearchDTO search = new WorkRecordSearchDTO();

			//사용자 정보를 가져와 empId 설정
			search.setEmpId(wrd.getUserInfo().getEmpId());

			//콤보박스에서 선택된 년/월/일 값 가져오기
			int startYear = (int) wrd.getJcbStartYear().getSelectedItem();
			int startMonth = (int) wrd.getJcbStartMonth().getSelectedItem();
			int startDay = (int) wrd.getJcbStartDay().getSelectedItem();
			search.setStartDate(String.format("%04d-%02d-%02d", startYear, startMonth, startDay));

			int endYear = (int) wrd.getJcbEndYear().getSelectedItem();
			int endMonth = (int) wrd.getJcbEndMonth().getSelectedItem();
			int endDay = (int) wrd.getJcbEndDay().getSelectedItem();
			search.setEndDate(String.format("%04d-%02d-%02d", endYear, endMonth, endDay));

			// 시작일이 종료일보다 나중이면 오류 메시지 표시 후 종료
			if (search.getStartDate().compareTo(search.getEndDate()) > 0) {
				JOptionPane.showMessageDialog(wrd, "시작일은 종료일보다 이전 날짜여야 합니다.", "날짜 오류", JOptionPane.ERROR_MESSAGE);
				return; // 메소드 종료
			}//end if
			
			List<WorkRecordsResultDTO> results = wrs.searchRecords(search);
			wrd.updateWorkLogTable(results);
			
			if (results.isEmpty()) {
				JOptionPane.showMessageDialog(wrd, "해당 기간의 근무 기록이 없습니다.");
			}//end if

		} catch (SQLException e) { 
			e.printStackTrace(); // 콘솔에 오류 상세 내용 출력 (개발자 확인용)
			JOptionPane.showMessageDialog(wrd, "근무 기록 조회 중 오류가 발생했습니다. 관리자에게 문의하세요.");
		} catch (IOException e) { // 입출력 관련 예외 처리 (DB 연결 등)
			e.printStackTrace();
			JOptionPane.showMessageDialog(wrd, "근무 기록 조회 중 오류가 발생했습니다. 관리자에게 문의하세요");
		} catch (Exception e) { // 그 외 예외 처리
            e.printStackTrace();
            JOptionPane.showMessageDialog(wrd, "알 수 없는 오류가 발생했습니다. 관리자에게 문의하세요 ");
        }//end catch
	}//searchWorkRecords
}//class
