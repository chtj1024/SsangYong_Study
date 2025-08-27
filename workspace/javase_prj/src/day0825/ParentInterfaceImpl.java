package day0825;

public class ParentInterfaceImpl implements ParentInterface{

	@Override
	public void methodA() {
		System.out.println("구현 클래스가 Override한 method");
	}//methodA
	
	@Override
	public String methodB(int ... va) {
		StringBuilder sbResult=new StringBuilder();
		for(int i : va) {
			sbResult.append( i ).append(" ");
		}//end for 
		
		return sbResult.toString();
	}//methodB
	
	public static void main(String[] args) {

		//interface는 객체화 되지 않는다. 
//		ParentInterface pi=new ParentInterface();
		
		//구현클래스의 주소는 저장할 수 있다.
		// is a 관계의 객체화
		ParentInterface pi=new ParentInterfaceImpl();
		// pi객체로 사용할 수 있는 것은 ParentInterface의 상수, default method,
		// 구현 클래스가 Override한 method
		pi.methodA();
		System.out.println( pi.methodB(2025, 8, 25, 14, 44));
		
		System.out.println( pi.msg() );
		
	}//main


}//class
