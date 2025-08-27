package day0827;

/**
 * 생성된 임시 비밀번호와 로또번호를 사용하는 일.
 */
public class RunWork0827 {
	
	private void printTempPassword(String str) {
		System.out.println(str);
	}
	
	private void printTempLotto() {
		
	}	
	
	public static void main(String[] args) {
		Work0827 w0827 = new Work0827();
		String password = w0827.createTempPassword();
		
		RunWork0827 rw0827 = new RunWork0827();
		rw0827.printTempPassword(password);
	}
}
