package day0829;

/**
 * 제네릭을 사용한 클래스
 * 생성된 객체가 제네릭에 설정한 데이터 형으로만 값을 저장하고 사용할 수 있도록 만들 수 있다.
 * = 데이터형의 안정성
 * @param <T>
 */
public class UseGeneric<T> {
	private T t;
	
	public void set(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
}
