package rigun;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ServerClient1105_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner input = new Scanner(System.in);
		/*
		 *  1. 소켓 생성
		 *	2. 키보드의 내용을 입력받는다.
		 *	3. exit 메시지가 나오면 종료, 아니면 데이터를 서버에 전송한다.
		 */
		
		// Ctrl + Space 하면 메소드 종류 나옴
		try {
			// 1.
		
			Socket socket = new Socket("10.30.3.94", 5555);
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			 
			while(true) {
			// 2.
				String data = input.next();
				
			// 3.
				if (data.equals("exit")) {
					break;
				}
				pw.println(data);
				pw.flush();
			}
			// 4. 소켓 닫는다.
				pw.close();
				socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
