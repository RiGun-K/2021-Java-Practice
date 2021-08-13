import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileError2 {

	public static void main(String[] args) {
		writeList();
		
	}
	private static void writeList() {
		PrintWriter out = null;
//		FileWriter fw = null;
//		fw = new FileWriter("C:/abc/out.txt");	// IOE이라는 오류가 생겼으므로 throws IOException 사용하면 해결 	
		// 작업종료 + finally end  + finally code 까지 호출 
		
		try (FileWriter fw = new FileWriter("out2.txt")) {	// 자동으로 닫아줌
			// AutoCloseable 인터페이스를 구현해야 한다.
			// 그 객체는 try with resources 절에 사용될 수 있다.
		out = new PrintWriter(fw);				
		out.println("Hello i love you. and you?");
		System.out.println("작업종료...");
//		out.close();
		} catch(IOException e) {
		// System.out.println(e.getMessage());
			System.out.println("catch:"+e.getMessage());
/*		} finally {
			System.out.println("finally code...");
			if (out != null)					   // 지정된 경로 찾을수 없음 + finally end  + finally code 까지 호출 
			out.close(); 
			System.out.println("finally end...");  // 지정된 경로 찾을수 없음 + finally end 호출 
		}
*/		
	
	}
	// SQL에서 데이터를 요청할떄는 DB서버에 요청(연결)한후 데이터를 받아옴 ,, DB서버는 한번에 연결하는데에 제한이 있음, 그러므로 사용후 연결종료를 해야함 
}


}