package authLogin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfoEvt {

	public StringBuilder maxUseKeyNameCnt(List<String> cuttedFile) {
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
			// getOrDefault() : 찾는 key 값이 존재하면 value를 반환하고
			// 없으면 defaultValue를 반환한다. -> 여기에선 0
			countMap.put(useKey, countMap.getOrDefault(useKey, 0) + 1);
		}
		
		String maxUsedKey = "";
		int maxCount = 0;
		// entrySet() : Map에서 모든 key-value쌍을 가져와 set객체로 반환
		for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
			
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				maxUsedKey = entry.getKey();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("최다 사용 키 : " + maxUsedKey + " / " + "개수 : " + maxCount);
		return sb;
	}
	
	public StringBuilder browserAcsCntAndRatio(List<String> cuttedFile) {
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
		return sb;
	}
	
	public StringBuilder successAndFailCnt(List<String> cuttedFile) {
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
		
		sb.append("서비스 성공(200) 횟수 : " + countMap.get("200")).append("\n");
		sb.append("실패(404) 횟수 : "  + countMap.get("404"));
		
		return sb;
	}
}
