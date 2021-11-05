package rigun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

// 서버에 접속하여 자신의 이름을 보낸다.
/*
 * 1. 소켓 객체를 생성
 * 2. 해당 객체로 부터 서버의 데이터를 보내기(출력)위한 PrintWriter 객체를 생성
 * 3. PrintWriter 객체에 이름을 보낸다
 * 4. 소켓을 닫는다.
 */
public class ServerClient1105 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 서버에 접속하여 자신의 이름을 보내고 , 서버의 메시지를 받는다.
		
		try {
		
			Socket s = new Socket("10.30.4.181", 5555);
			PrintWriter out = new PrintWriter(s.getOutputStream());
			out.println("ㅇ");
		
			
			
			// 서버에서 보낸 데이터를 받기위해 BufferedReader 객체를 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			// BufferedReader 객체로 데이터를 읽고 출력한다.
			String data = br.readLine();
			System.out.println(data);
			out.close();
			br.close();
			s.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
