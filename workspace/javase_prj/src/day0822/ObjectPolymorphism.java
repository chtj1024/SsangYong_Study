package day0822;

public class ObjectPolymorphism {
	
	/**
	 * 매개변수로 Person객체를 받는 method
	 * @param person
	 */
	public void usePerson(Person person) {
		// 같은 이름의 객체를 다르게 사용한다. (객체 다형성)
		System.out.println(person.eat());
	}
	
	public static void main(String[] args) {
		ObjectPolymorphism op = new ObjectPolymorphism();
		Person p = new HongGilDong();
		Person p2 = new Clark();
		
		op.usePerson(p2);
		op.usePerson(p);
	}
}
