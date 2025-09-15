package input_output;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import analysis.Process_7;

public class Work_7 {

    private Process_7 analyzer;

    public Work_7() {
        analyzer = new Process_7();
    }

    /**
     * 사용자가 선택한 파일의 경로(filePath)를 받아,
     * nio를 이용해 파일 내용을 읽고 List<String>으로 반환하는 메소드
     * @param filePath 사용자가 FileDialog를 통해 선택한 파일의 전체 경로
     * @return 파일의 모든 라인이 담긴 List<String>
     */
    public List<String> loadLogFile(String filePath) {
        List<String> lines = new ArrayList<>(); // 파일 내용을 담을 새로운 리스트
        File file = new File(filePath);

        if (!file.exists()) {
            System.err.println("파일을 찾을 수 없습니다: " + filePath);
            return lines; // 파일을 못 찾으면 비어있는 리스트를 반환
        }

        Path path = Path.of(file.getAbsolutePath());

        try {
            // 읽어온 내용을 새 리스트에 바로 저장
            lines = Files.readAllLines(path);
            System.out.println(path.getFileName() + " 파일 로딩 완료. (" + lines.size() + " 라인)");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines; // 내용이 담긴 리스트를 반환
    }


    //1번 기능
    public String analyzeKey(List<String> cuttedFile) {
    	 return analyzer.maxUseKeyNameCnt(cuttedFile);
    }

    //2번 기능
    public String analyzeBrowser(List<String> cuttedFile) {
    	 return analyzer.browserAcsCntAndRatio(cuttedFile);
    }

    //3번 기능
    public String analyzeServiceSuccessRate(List<String> cuttedFile) {
    	 return analyzer.successAndFailCnt(cuttedFile);
    }

    //4번 기능
    public String analyzeRequestsByHour(List<String> cuttedFile) {
        return analyzer.hourlyRequest(cuttedFile);
    }

    //5번 기능
    public String findTopErrorCode(List<String> cuttedFile) {
        return analyzer.errorRequests(cuttedFile);
    }

    //6번 기능
    public String findBooksError(List<String> cuttedFile) {
        return analyzer.booksErrorRequest(cuttedFile); 
    }

}