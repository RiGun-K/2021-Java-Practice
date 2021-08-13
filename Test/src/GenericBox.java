// Generic class
// Type parameter

public class GenericBox<T> { 		// <T> 를 사용 ( T 가 관례 ) 하면  안에서 사용하는 타입을 결정하지 않고  
	private T content;
	
	public T getContent() {
		return content;
	}
	
	public void setContent(T content) {
		this.content = content;
	}
}
