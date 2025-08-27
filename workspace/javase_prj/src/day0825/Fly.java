package day0825;

/**
 * 날기위한 일의 목록을 정의한 인터페이스이스
 * 날기위해서 양력(lift )과 추진력 ( thrust )을 가져야한다. 
 */
public interface Fly {
	
	/**
	 * 양력
	 * @return 양력을 얻는 재료
	 */
	public abstract String lift();
	
	/**
	 * 추진력
	 * @return 추진력을 얻는 방법
	 */
	public String thrust();
	
}
