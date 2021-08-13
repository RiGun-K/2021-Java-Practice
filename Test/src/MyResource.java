
public class MyResource implements AutoCloseable {
	public MyResource() {
		System.out.println("MyResource 생성");
		
	}
	
	
	public int getValue() throws OutofResourcesException {
		int random = (int)(Math.random()*2);
		if (random == 0) {
			throw new OutofResourcesException("자원고갈 오류...");  	// new 객체 생성  = new Exception
		}
		return (int)(Math.random()*100);
	}
	
	public void close() {
		System.out.println("close...지원 반납....");
	}
}
