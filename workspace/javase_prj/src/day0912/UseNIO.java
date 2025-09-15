package day0912;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * NIO를 사용한 대용량 파일읽기
 */
public class UseNIO {
	
	public UseNIO() {
		File file = new File("c:/dev/temp/big.txt");
		//1. 파일과 연결
//		Path path = Paths.get("c:/dev/temp/big.txt");
		Path path = Path.of(file.getAbsolutePath());
		System.out.println(path.getFileName());
		
		//2.파일과 NIO를 사용하여 모든 행을 읽어 들인다.
		try {
			List<String> list = Files.readAllLines(path);
			for(String line : list) {
				System.out.println(line);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new UseNIO();
	}
}
