package day0901;

public class RunWork0829 {
	private Work0829 work;
	
	public RunWork0829() {
		work = new Work0829();
	}
	
	/**
	 * 사용자에게 제공할 menu를 사용.
	 */
	public void useMenu() {
		work.menu();
	}
	
	public static void main(String[] args) {
		RunWork0829 rw = new RunWork0829();
		rw.useMenu();
	}
}
