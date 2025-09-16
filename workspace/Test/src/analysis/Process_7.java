package analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * log파일의 정보를 처리하는 클래스
 */
public class Process_7 {

	/**
	 * 1. 최다사용 키의 이름과 횟수
	 * @param cuttedFile
	 * @return String
	 */
	public String maxUseKeyNameCnt(List<String> cuttedFile) {
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		List<String[]> data = new ArrayList<String[]>();
		
		for (String row : cuttedFile) {
			String[] parts = row.split("\\]\\[");
			
			parts[0] = parts[0].replace("[", "");
			parts[3] = parts[3].replace("[", "");
			
			data.add(parts);
		}
		
		for (String[] row : data) {
			int start = row[1].indexOf("=") + 1;
			int end = row[1].indexOf("&");
				
			String useKey = "";
			if(start > 0 && end > start) {
				useKey = row[1].substring(start, end);
			}
			countMap.put(useKey, countMap.getOrDefault(useKey, 0) + 1);
		}
		
		String maxUsedKey = "";
		int maxCount = 0;
		
		for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
			
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				maxUsedKey = entry.getKey();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("최다 사용 키 : " + maxUsedKey + " / " + "개수 : " + maxCount);
		return sb.toString();
	}
	
	/**
	 * 2. 브라우저별 접속횟수, 비율
	 * @param cuttedFile
	 * @return String
	 */
	public String browserAcsCntAndRatio(List<String> cuttedFile) {
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		List<String[]> data = new ArrayList<String[]>();
		
		int total = 0;
		
		for (String row : cuttedFile) {
			String[] parts = row.split("\\]\\[");
			
			parts[0] = parts[0].replace("[", "");
			parts[3] = parts[3].replace("[", "");
			
			data.add(parts);
		}
		
		for(String[] row : data) {
			String key = row[2];
			countMap.put(key, countMap.getOrDefault(key, 0) + 1);
			total++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
			String key = entry.getKey();
			int count = entry.getValue();
			double ratio = (count * 100.0) / total;
			sb.append(String.format("%s - %d회 (%.2f%%)\n", key, count, ratio));
		}
		return sb.toString();
	}
	
	/**
	 * 서비스를 성공적으로 수행한(200) 횟수, 실패(404) 횟수
	 * @param cuttedFile
	 * @return String
	 */
	public String successAndFailCnt(List<String> cuttedFile) {
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		List<String[]> data = new ArrayList<String[]>();
		
		for (String row : cuttedFile) {
			String[] parts = row.split("\\]\\[");
			
			parts[0] = parts[0].replace("[", "");
			parts[3] = parts[3].replace("[", "");
			
			data.add(parts);
		}
		
		for(String[] row : data) {
			String key = row[0];
			countMap.put(key, countMap.getOrDefault(key, 0) + 1);
		}
				
		StringBuilder sb = new StringBuilder();
		
		if (countMap.containsKey("200")) {
			sb.append("서비스 성공(200) 횟수 : " + countMap.get("200")).append("\n");
		} else {
			sb.append("서비스 성공(200) 횟수 : " + "0").append("\n");
		}
		
		if (countMap.containsKey("404")) {
			sb.append("실패(404) 횟수 : "  + countMap.get("404"));			
		} else {
			sb.append("실패(404) 횟수 : "  + "0");		
		}
		
		
		
		return sb.toString();
	}
	
	
	 /**
	  * 4. 요청이 가장 많은 시간
	 * @param cuttedFile
	 * @return String
	 */
	public String hourlyRequest(List<String> cuttedFile) {
	        Map<Integer, Integer> hourlyRequests = new HashMap<>();

	        for (String row : cuttedFile) {
	            String[] parts = row.split("\\]\\[");

	            if (parts.length > 3) {
	               
	                parts[0] = parts[0].replace("[", "");
	                parts[3] = parts[3].replace("]", "");

	                int hourOfDay = extractHourFromLog(parts[3]);

	                if (hourOfDay != -1) {
	                    hourlyRequests.put(hourOfDay, hourlyRequests.getOrDefault(hourOfDay, 0) + 1);
	                }
	            }
	        }

	        StringBuilder sb = new StringBuilder();
	        sb.append("시간대별 요청 수:\n");

	        for (int h = 0; h < 24; h++) {
	            int cnt = hourlyRequests.getOrDefault(h, 0);
	            sb.append(String.format("%02d시: %d건\n", h, cnt));
	        }

	        int maxHour = -1;
	        int maxCount = -1;

	        if (!hourlyRequests.isEmpty()) {
	            for (Map.Entry<Integer, Integer> entry : hourlyRequests.entrySet()) {
	                if (entry.getValue() > maxCount) {
	                    maxCount = entry.getValue();
	                    maxHour = entry.getKey();
	                }
	            }
	            sb.append(String.format("\n가장 요청이 많은 시간 : %02d시\n", maxHour));
	        } 
	 

	        return sb.toString();
	    }

	
	    /**
	     * 5. 비정상적인 요청(403)이 발생한 횟수, 비율
	     * @param cuttedFile
	     * @return String
	     */
	    public String errorRequests(List<String> cuttedFile) {
	        Map<Integer, Integer> codeCounts = new HashMap<>();
	        int totalRequests = cuttedFile.size(); 

	        for (String row : cuttedFile) { 
	            String[] parts = row.split("\\]\\[");

	            if (parts.length > 0) {
	                parts[0] = parts[0].replace("[", ""); 
	                try {
	                    int statusCode = Integer.parseInt(parts[0]);
	                    codeCounts.put(statusCode, codeCounts.getOrDefault(statusCode, 0) + 1);
	                } catch (NumberFormatException e) {
	                   
	                }
	            }
	        }

	        // 403 에러 횟수와 비율 계산
	        int errorCount = codeCounts.get(403) != null ? codeCounts.get(403) : 0;
	        double errorRate = (double) errorCount / totalRequests * 100;

	        StringBuilder sb = new StringBuilder();
	        sb.append("\n비정상적인 요청[403] 분석 결과:\n")
	          .append("총 요청 수: ").append(totalRequests).append("건\n")
	          .append("403 에러 발생 횟수: ").append(errorCount).append("건\n")
	          .append(String.format("403 에러 발생 비율: %.2f%%\n", errorRate));

	        return sb.toString();
	    }
	
	    /**
	     * 6.books에 대한 요청 URL중 에러(500)가 발생한 횟수, 비율 구하기
	     * @param cuttedFile
	     * @return String
	     */
	    public String booksErrorRequest(List<String> cuttedFile) {
	        int totalBooksRequests = 0;
	        int errorBooksRequests = 0;

	        for (String row : cuttedFile) { 
	            String[] parts = row.split("\\]\\[");

	            if (parts.length > 1) { 
	                parts[0] = parts[0].replace("[", ""); 

	                if (parts[1].contains("books")) { 
	                    totalBooksRequests++;

	                    try {
	                        int statusCode = Integer.parseInt(parts[0]);
	                        if (statusCode == 500) {
	                            errorBooksRequests++;
	                        }
	                    } catch (NumberFormatException e) {
	                        
	                    }
	                }
	            }
	        }

	        StringBuilder sb = new StringBuilder();
	        sb.append("\nbooks 요청 URL 중 에러[500] 분석 결과:\n")
	          .append("전체 books 요청 수: ").append(totalBooksRequests).append("건\n")
	          .append("500 에러 발생 횟수: ").append(errorBooksRequests).append("건\n");

	        if (totalBooksRequests > 0) {
	            double errorRate = (double) errorBooksRequests / totalBooksRequests * 100;
	            sb.append(String.format("500 에러 발생 비율 : %.2f%%\n", errorRate));
	        } 
	        return sb.toString();
	    }
	    
	    /**
	     * 시간 추출
	     * @param dateTimeStr
	     * @return
	     */
	    private int extractHourFromLog(String dateTimeStr) {
	    	try {
	    		if (dateTimeStr != null && dateTimeStr.length() >= 13) {
	    			String hourStr = dateTimeStr.substring(11, 13);
	    			return Integer.parseInt(hourStr);
	    		}
	    	} catch (Exception e) {
	    		
	    	}
	    	return -1;
	    }
}
