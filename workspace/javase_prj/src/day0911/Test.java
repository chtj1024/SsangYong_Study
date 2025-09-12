package day0911;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;

import day0908.TabaccoException;

public class Test {
	
	public void work() throws TabaccoException{
		
		if(new Random().nextBoolean()) {
			throw new TabaccoException();
		}
		
		System.out.println("예외가 발생하지 않은 정상적인 상황");
	}
	
	public static void main(String[] args) {
		
		Test t = new Test();
		try {
			t.work();
			System.out.println("정상적으로 업무를 처리 후 코드");
		} catch (TabaccoException e) {
			JOptionPane.showMessageDialog(null, "죄송합니다. 잠시 후에 다시 시도해주세요.");
			
			//예외가 발생했을 때 "c:/dev/temp/err_20250911.log" 파일을 만들고
			//예외의 내용을 출력해보세요.
			
			
			// 내가 한 거
			try (FileWriter fw = new FileWriter("c:/dev/temp/err_20250911.log", true)){
					
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				e.printStackTrace(pw);
				String stackTrace = sw.toString();
				
				fw.write(stackTrace);
				System.err.println("업무 처리 method에서 발생한 문제가(정상적으로 처리되지 않은예외)가 발생했을 때 코드");
//				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			File dir = new File("c:/dev/temp");
			if(!dir.exists()) {
				dir.mkdir();
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			File file = new File(dir.getAbsolutePath()+File.separator
					+sdf.format(new Date())+".log");
			
			try(PrintWriter pw = new PrintWriter(new FileWriter(file))) {
				e.printStackTrace(pw);
			} catch(IOException ie) {
				
			}
			
		}
		
	}
}
