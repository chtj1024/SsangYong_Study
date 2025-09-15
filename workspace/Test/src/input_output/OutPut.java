package input_output;

import javax.swing.*;
import authLogin.LoginProcess;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class OutPut {

    private Map<String, String> analysisResults;
    private String result;
    private String userId;
    private String file;
    private Design_7 design7; 

    public OutPut(Map<String, String> analysisResults, LoginProcess lp, String file, Design_7 design7) {
        this.analysisResults = analysisResults;
        this.userId = lp.getLoginUserId();
        this.file = file;
        this.design7 = design7;
        result = mapToString(analysisResults);

        while (true) {
        	String choice = showMenu();

            if ("1".equals(choice)) {
                showResult(result);
                design7.setVisible(true);
                break;
            } else if ("2".equals(choice)) {
                if ("root".equals(userId)) {
                    JOptionPane.showMessageDialog(null, "권한이 없습니다.");
                } else {
                    saveResultFile(userId, result);
                    design7.setVisible(true);
                    break;
                }
            } else if (choice == null) { // 사용자가 '취소'를 누르거나 창을 닫은 경우
                design7.setVisible(true); // 숨겨뒀던 이전 창을 다시 보여줍니다.
                break;
            } else if ("".equals(choice)) { // 빈 값으로 확인을 누른 경우
            	JOptionPane.showMessageDialog(design7, "빈 값으로 두시면 안됩니다.");
            }else {
            	JOptionPane.showMessageDialog(design7, "1 아니면 2만 입력해주세요");
            }
        }
    }//OutPut

    private String mapToString(Map<String, String> analysisResults) {
        StringBuilder result = new StringBuilder();

        result.append("1. 최다사용 키: ")
                .append(analysisResults.get("최다사용키"))
                .append("\n\n");

        result.append("2. 브라우저별 접속 비율:\n")
                .append(analysisResults.get("브라우저비율"))
                .append("\n\n");

        result.append("3. 서비스 성공/실패 횟수:\n")
                .append(analysisResults.get("서비스성공률"))
                .append("\n\n");

        result.append("4. 요청이 가장 많은 시간: ")
                .append(analysisResults.get("시간대별요청"))
                .append("\n\n");

        result.append("5. 비정상적인 요청(403) 발생 횟수, 비율:\n")
                .append(analysisResults.get("비정상요청"))
                .append("\n\n");

        result.append("6. books 요청 중 에러(500) 발생 횟수, 비율:\n")
                .append(analysisResults.get("books에러"));

        return result.toString();
    }//mapToString

    private String showMenu() {
        return JOptionPane.showInputDialog(null,
                "작업을 선택하세요\n\n1. 분석 결과 보기\n2. 리포트 파일 저장");
    }//showMenu

    private void showResult(String result) {
        if (result == null || result.isEmpty()) {
            result = "데이터가 없습니다.";
        }

        JTextArea jta = new JTextArea(25, 60);
        jta.setText(result);
        jta.setEditable(false);

        JScrollPane jsp = new JScrollPane(jta);

        JOptionPane.showMessageDialog(null, jsp);
    }//showResult

    private void saveResultFile(String userId, String result) {
        // 경로 생성
        File reportDir = new File("c:/dev/report");
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        // 파일 생성
        String fileName = "report_" + System.currentTimeMillis() + ".dat";
        File reportFile = new File(reportDir, fileName);

        // 파일 내용 작성
        try (FileWriter fw = new FileWriter(reportFile)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String head = file + " (" + sdf.format(new Date()) + ")\n";
            String line = "--------------------------------------------------------\n";

            fw.write(head);
            fw.write(line);
            fw.write(result);
            fw.flush();

            JOptionPane.showMessageDialog(null, "저장 완료");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }//saveResultFile
}//class