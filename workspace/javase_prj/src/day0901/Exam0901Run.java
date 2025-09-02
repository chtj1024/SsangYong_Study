package day0901;

public class Exam0901Run {
	private Exam0901Work work;
	
	public Exam0901Run() {
		work = new Exam0901Work();
	}
	
	
	public void useMenu() {
		work.menu();
	}
	
	public static void main(String[] args) {
		Exam0901Run e0901r = new Exam0901Run();
		e0901r.useMenu();
	}
}
