package input_output;

import javax.swing.*;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import authLogin.LoginProcess; 

public class Event_7 implements ActionListener {

	private Design_7 design7;
	private Work_7 work7;
	private LoginProcess lp; 

	public Event_7(Design_7 design, Work_7 work,  LoginProcess lp) {
		this.design7 = design;
		this.work7 = work;
		this.lp = lp; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 1. 사용자에게 파일 선택 창을 보여줌
		FileDialog fdOpen = new FileDialog(design7, "분석할 로그 파일 선택", FileDialog.LOAD);
		fdOpen.setVisible(true);

		String dir = fdOpen.getDirectory();
		String file = fdOpen.getFile();

		if (dir == null || file == null) {
			System.out.println("파일 선택을 취소했습니다.");
			JOptionPane.showMessageDialog(design7, "파일 열기를 취소했습니다.","파일취소",JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		// 2. 허용된 파일(input1, input2)인지 먼저 확인
		if (!file.equals("sist_input_1.log") && !file.equals("sist_input_2.log")) {
			JOptionPane.showMessageDialog(design7, "sist_input_1.log 또는 sist_input_2.log 파일만 선택해주세요.", "파일 선택 오류",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// 3. Work_7에게 파일을 읽어달라고 요청
		String fullPath = dir + file; // 선택된 파일의 전체 경로
		List<String> selectedLogData = work7.loadLogFile(fullPath); // 파일 읽기 실행

		// 파일을 읽지 못했다면 즉 비어있는 리스트가 반환되었다면 분석 중단
		if (selectedLogData.isEmpty()) {
			JOptionPane.showMessageDialog(design7, "파일을 읽어오는 데 실패했습니다.", "파일 오류", JOptionPane.ERROR_MESSAGE);
			return;
		}

		int totalLines = selectedLogData.size();
		String startInput = String.format("%s의 시작 라인을 입력하세요 (1 ~ %d).\n(전체 분석은 비워두세요)", file, totalLines);
		String startLineStr = JOptionPane.showInputDialog(design7, startInput, "시작 라인", JOptionPane.PLAIN_MESSAGE);

		if (startLineStr == null)
			return;

		String endInput = String.format("%s의 종료 라인을 입력하세요 (1 ~ %d).\n(전체 분석은 비워두세요)", file, totalLines);
		String endLineStr = JOptionPane.showInputDialog(design7, endInput, "종료 라인", JOptionPane.PLAIN_MESSAGE);

		if (endLineStr == null)
			return;

		List<String> cuttedFile;
		if (startLineStr.isEmpty() && endLineStr.isEmpty()) {
			cuttedFile = selectedLogData;
		} else {
			try {
				int startLine = 1;
				int endLine = totalLines;

				if (!startLineStr.isEmpty())
					startLine = Integer.parseInt(startLineStr);
				if (!endLineStr.isEmpty())
					endLine = Integer.parseInt(endLineStr);

				if (startLine <= 0 || endLine > selectedLogData.size() || startLine > endLine) {
					JOptionPane.showMessageDialog(design7, "라인 범위가 올바르지 않습니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				cuttedFile = new ArrayList<>(selectedLogData.subList(startLine - 1, endLine));
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(design7, "숫자만 입력해야 합니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		Map<String, String> analysisResults = new HashMap<>();
		System.out.println("분석 시작: 총 " + cuttedFile.size() + "라인");

		// 분석 실행
		analysisResults.put("최다사용키", work7.analyzeKey(cuttedFile));
		analysisResults.put("브라우저비율", work7.analyzeBrowser(cuttedFile));
		analysisResults.put("서비스성공률", work7.analyzeServiceSuccessRate(cuttedFile));
		analysisResults.put("시간대별요청", work7.analyzeRequestsByHour(cuttedFile));
		analysisResults.put("비정상요청", work7.findTopErrorCode(cuttedFile));
		analysisResults.put("books에러", work7.findBooksError(cuttedFile));

		System.out.println("모든 분석 완료. 다음 페이지에 결과 전달 중...");
		design7.setVisible(false);
		new OutPut(analysisResults, lp, file, design7);
	
	}
}