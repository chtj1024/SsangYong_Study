package day0818;

/**
 * this keyword형식.<br>
 * 지역변수의 이름과 인스턴스 변수의 이름이 같을 때 각각의 변수를 식별하여 사용하기 위해서<br>
 * this 키워드는 instance영역에서만 사용된다.( static 영역은 객체를 사용하지 않고 호출되기 때문에
 *   생성객체의 주소 정보를 얻을 수 없다. )
 */
public class ThisKeyword {
	int i; //heap

	//this를 사용하지 않으면 객체의 주소를 전달할 수 있는 데이터형으로 매개변수를 선언하고
	//호출하는 곳에서 객체를 arguments 입력하면 된다. => 매변 객체를 입력해야하므로 불편.=> this
//	public void setI(int i, ThisKeyword tk) {
//		tk.i=i;
//	}//end setI
	
	public void setI(int i) {
		System.out.println(this); // method를 호출하는 객체의 주소로 변환
		this.i=i;
	}
	
	public int getI() {
		return i;
	}//getI
	
	public void printThis() {
		//method를 호출하는 객체의 주소로 변환된다.
		System.out.println("this "+ this );//tk의 주소일수도 있고, tk2의 주소도 된다.
	}

	public static void main(String[] args) {
		ThisKeyword tk=new ThisKeyword();
		ThisKeyword tk2=new ThisKeyword();
		System.out.println("생성된 객체 "+ tk );
		System.out.println("생성된 객체2 "+ tk2 );
//		System.out.println(this);// static 영역에서는 this를 사용할 수 없다.
		tk.printThis();
		tk2.printThis();
		
//		tk.setI(2025, tk);
		tk.setI(2025); // method안에서 this가 호출하는 객체의 주소로 변환된다
		System.out.println(tk.getI());
	}//main

}//class
