package day0908;

/**
 * 개발자가 예외처리(try~catch~finally)를 하지 않아도 코드상에 에러가 발생하지 않는 예외.
 * main method에 arguments로 숫자 두 개를 받아서 두수를 나눈 결과를 저
 */
public class UseRuntimeException {
	
	public static void main(String[] args) {
		
		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
		
			double result = (double) num1 / num2;

			System.out.println(num1 + " / " + num2 + " = " + result);
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("사용법 : java UseRuntimeException 값 값");
			
			System.err.println("간단한 예외 메세지 : " + aioobe.getMessage());
			System.err.println("예외처리 객체와 간단한 예외 메세지 : " + aioobe); // toString()
			aioobe.printStackTrace();
			
		} catch (ArithmeticException ae) {
			ae.printStackTrace();
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		} catch (Exception e) { // 하위 Exception들은 필요가 없기 때문에 에러가 발생한다. 
			System.out.println("개발자가 예측하지 못한 예외가 발생했을 때 사용자에게 제공할 메세지");
			e.printStackTrace();
		} finally {
			System.out.println("예외가 발생하든 정상적으로 동작하는 사용자에게 반드시 제공할 코드");
			System.out.println("감사합니다.");
		}
	}
}
