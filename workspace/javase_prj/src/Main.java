
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[][] dohwaji = new boolean[101][101];
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int tc = 0; tc < N; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int i = x; i < x + 10; i++) {
				if (i >= 100) break;
				
				for (int j = y; j < y + 10; j++) {
					if (j >= 100) break;
					dohwaji[i][j] = true;
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i < dohwaji.length; i++) {
			for (int j = 0; j < dohwaji[0].length; j++) {
				if (dohwaji[i][j] == true) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}
