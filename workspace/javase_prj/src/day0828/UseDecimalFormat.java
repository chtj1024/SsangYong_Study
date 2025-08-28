package day0828;

import java.text.DecimalFormat;

public class UseDecimalFormat {
	
	public UseDecimalFormat() {
		int num = 2_500_000;
		System.out.println(num);
		
		// 0패턴
		DecimalFormat df = new DecimalFormat("0,000,000,000");
		DecimalFormat df2 = new DecimalFormat("#,###,###,###");
		
		int tempNum = 2025;
		System.out.println(df.format(tempNum));
		System.out.println(df2.format(tempNum));
		
		double tempNum2 = 2025.0828;
		DecimalFormat df3 = new DecimalFormat("0,000,000,000.00");
		System.out.println(tempNum2 * 2);
		System.out.println(df3.format(tempNum2));
		
		DecimalFormat df4 = new DecimalFormat("#,###");
		System.out.println(df4.format(1));
		System.out.println(df4.format(2025));
		System.out.println(df4.format(1111111));
		System.out.println(df4.format(1111111111));
	}
	
	public static void main(String[] args) {
		new UseDecimalFormat();
	}
}
