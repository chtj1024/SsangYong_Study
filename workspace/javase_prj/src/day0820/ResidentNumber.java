package day0820;

/**
 * 아래의 작업을 instance method로 만들어서 사용하는 class를 작성하고, 작업 사용하는 클래스를 만들고
 * 객체화하여 method를 호출하는 코드를 구현.<br>
 * +클래스 다이어그램 그리기<br>
 * 
 * 문제.<br>
 * 주민번호의 형식 : xxxxxx-xxxxxxx<br>
 * 
 * 1. 주민번호를 입력 받아 instance variable에 저장하는 생성자를 생성<br>
 * 2. getter, setter method 생성<br>
 * 3. 주민번호의 글자수가 14자리인지 확인(-포함)하여 boolean으로 반환하는 method 작성<br>
 * 4. 주민번호의 6번째 인덱스의 문자가 '-'인지 확인하여 boolean으로 반환하는 method 작성<br>
 * 5. 주민번호에서 생년월일을 연산하여 문자열로 반환하는 method 작성<br>
 * - 뒤의 문자 1,2 : 1900년대 생 내국인 남여
 * - 뒤의 문자 5,6 : 1900년대 생 외국인 남여
 * - 뒤의 문자 3,4 : 2000년대 생 내국인 남여
 * - 뒤의 문자 7,8 : 2000년대 생 외국인 남여
 * - 뒤의 문자 9,0 : 1800년대 생 내국인 남여
 * 6. 나이를 구하여 정수로 반환하는 method
 * 7. 성별을 구하여 문자열로 반환하는 method
 * 8. 내국인/외국인 판별하여 문자열로 반환하는 method
 * 9. 띠를 구하여 문자열로 반환하는 method
 */
public class ResidentNumber {
   
   //1.
   private String residentNumber;
   private int check;
   private int year;
   
   public ResidentNumber(String residentNumber) {
      setResidentNumber(residentNumber);
      if(residentNumber!=null) {
         check = Integer.parseInt(String.valueOf(residentNumber.charAt(7)));
         switch(check) {
         case 1:
         case 2:
         case 5:
         case 6:
            year = Integer.parseInt("19"+residentNumber.substring(0,2));
            break;
         case 3:
         case 4:
         case 7:
         case 8:
            year = Integer.parseInt("20"+residentNumber.substring(0,2));
            break;
         default:
            year = Integer.parseInt("18"+residentNumber.substring(0,2));
         }   
      }
   }
   
   //2.
   public void setResidentNumber(String residentNumber) {
      this.residentNumber = residentNumber;
   }
   
   public String getResidentNumber() {
      return residentNumber;
   }
   
   //3.
   public boolean checkResidentNumberCount() {
      if(residentNumber.length() == 14){
       return true;
      }
      return false;
   }
   
   //4.
   public boolean checkResidentNumberDot() {
      if(residentNumber.indexOf("-") == 6) return true;
      return false;
   }
   
   //5. 생년월일을 문자열로 변환
//    * - 뒤의 문자 1,2 : 1900년대 생 내국인 남여
//    * - 뒤의 문자 5,6 : 1900년대 생 외국인 남여
//    * - 뒤의 문자 3,4 : 2000년대 생 내국인 남여
//    * - 뒤의 문자 7,8 : 2000년대 생 외국인 남여
//    * - 뒤의 문자 9,0 : 1800년대 생 내국인 남여
   public String birthDay() {
      int month = Integer.parseInt(residentNumber.substring(2,4));
      int day = Integer.parseInt(residentNumber.substring(4,6));
      
      return String.format("%d년 %02d월 %02d일",year, month, day);
   }
   
   //6. 나이를 계산해서 정수로 변환
   public int age() {
      return 2025-year+1;
   }
   
   //7. 남여 판별하여 문자열로 변환
   public String gender() {
      if(check%2 == 0) return "여자";
      return "남자";
   }
   
   //8. 내국인/외국인 판별하여 문자열로 반환
   public String checkLocal() {
      if(check<9 && check>4) return "외국인";
      return "내국인";
   }
   
   //9. 띠를 구하여 문자열로 반환
   public String birthYearAnimal() {
      int yearAnimal = year %12;
      
      
      }
      return null;
   }

}
