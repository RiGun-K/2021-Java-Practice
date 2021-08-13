
public class Box4 {
	private String content;
	
	public Object getContent() {
		return content;
	}
	
	
	
	public static void process(Box4 box) {
		// 
		Object obj = box.getContent();    // Object 를 이용 하여 box를 꺼냄
		if (obj instanceof Student) {
		
		Student std = (Student)obj;
		
		String s = std.getName();
		
		int = std.getGrade();
	
		}	else if (obj instanceof String) {
			// 문자열 처리
		}	else if (obj instanceof Integer) {
			//정수 처리...
		}
	

}
	
}
