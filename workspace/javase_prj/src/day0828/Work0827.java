package day0828;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Work0827 {
   public String dateFormat(int num) {
	  LocalDateTime ldt = LocalDateTime.now();
	  Locale[] loc = {Locale.KOREA, Locale.GERMAN, Locale.US, Locale.JAPAN};
	  
	  if (num < 0 && num > 3) {
		  num = 0;
	  }
	  
      DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MM-dd-yyyy a EEEE HH:mm:ss",Locale.KOREA);
      return ldt.format(dtf);
   }
   public String backUpFile(String fileName) {
      StringBuilder sb = new StringBuilder(fileName);

      int lastDotIndex = sb.lastIndexOf(".");

      if(lastDotIndex != -1) { // 확장자가 있는 파일 
         sb.insert(lastDotIndex, "_bak");
      } else { // 확장자가 없는 파일 : hosts
         sb.append("_bak");
      }

      return sb.toString();
   }
}
//class