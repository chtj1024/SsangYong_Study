package day0829;

public class RunWork0828 {
	
	private Work0828 work;
	public RunWork0828() {
		work = new Work0828();
	}
	
	public void useCreateCalendar() {
		System.out.println(work.createCalendar(null, null));
		System.out.println(work.createCalendar("", ""));
	}
	
	public static void main(String[] args) {
		new RunWork0828().useCreateCalendar();
	}
}
