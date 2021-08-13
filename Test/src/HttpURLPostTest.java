import java.net.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLPostTest {

	public static void main(String[] args) throws Exception {		// 직접 하면 throws  아니면 throw
		// TODO Auto-generated method stub
		String site = "https://www.google.com/serach?q=java";
		URL url = new URL(site);
		
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		
		con.setDoOutput(true);			// Output	= 출력 스트림 (내가 보내는 데이터들이 서버로 전달 ) 
		con.setDoInput(true);   		// Input	= 입력 스트림 
		con.setRequestMethod("POST");	// POST 방식
		
		con.setRequestProperty("content-type", "application/x-www-form-urlencoded");	// form 형태의 데이터로 보낸다  
			
		// ID : scpark 
		// PW : 1111  // (파라미터 이름,값 의 쌍으로)
		
		String data = "id=scpark&pw=1111";
		
		OutputStream stream = con.getOutputStream();
		
		OutputStreamWriter owriter = new OutputStreamWriter(stream, "UTF-8");
		// 내가 쓰는 데이터 유형이 아스키 코드가 아니라 UTF-8의 문자집합으로 보낸다.
		PrintWriter writer = new PrintWriter(owriter);
		writer.println(data);
		writer.flush();			// 담아두지 말고 바로 보내라.
		//////////////////////////////////////////////////////////////
		// 보낸 데이터들을 읽기위해서 InputStreamReader 을 사용한다..
		InputStream stream1 = con.getInputStream();
		
		InputStreamReader streamReader = new InputStreamReader(stream1, "UTF-8");
		
		BufferedReader reader = new BufferedReader(streamReader);
		String line;
		while((line = reader.readLine()) != null)	// 다읽으면 null  즉 다 읽을때 까지 한다
			System.out.println(line);
	 
	 	System.out.println();
		
	
	}

}

// powershell 
/* app.post('/todos', (req, res) => {	
  console.log(req.body.todo)
}) 										// post 방식으로 todos를 요청하여  req, res 전달되면 console 찍어라
*/


// ctrl + c 하면 다시 창띄움 


// node app : 실행 , localhost:9090/todos 

// chrome arc -> arc 가면 get,post 방식으로 받아 볼 수 있다.

// gson java에 넣는법 = Test 폴더 우클릭 Build Path -> Add Extrail 에서 가져오면 Referenced Libraries에 저장됨..

