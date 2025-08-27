package day0827;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * SimpleDateFormat, Date 클래스 사용.
 */
public class UseSimpleDateFormat {
	
	public UseSimpleDateFormat() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy a H, k, K, h:mm:ss E요일");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy a H, k, K, h:mm:ss EEEE", Locale.KOREA);
		SimpleDateFormat sdf3 = new SimpleDateFormat("MM-dd-yyyy a H, k, K, h:mm:ss EEEE", Locale.JAPAN);
		
		System.out.println(date);
		System.out.println(sdf.format(date));
		System.out.println(sdf2.format(date));
		System.out.println(sdf3.format(date));
	}
	
	public static void main(String[] args) {
		new UseSimpleDateFormat();
	}
}
