
public class OutofResourcesException extends Exception {
	public  OutofResourcesException() {
		System.out.println("OutofResourcesException 객체 생성");
	}
	
	public  OutofResourcesException(String msg) {
		super(msg);
		System.out.println("OutofResourcesException 객체 생성");
	}
}
