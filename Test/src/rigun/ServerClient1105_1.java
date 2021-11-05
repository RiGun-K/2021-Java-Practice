package rigun;

import java.io.*;
import java.net.*;

public class ServerClient1105_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		
		try {
			serverSocket = new ServerSocket(5555);
			while (true) {
				clientSocket = serverSocket.accept();
				BufferedReader in = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream()));
				String inputLine;
				inputLine = in.readLine();
				System.out.println(inputLine);
				in.close();
				clientSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
