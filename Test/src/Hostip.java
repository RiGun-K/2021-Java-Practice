import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.*;

public class Hostip {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String hostname = "www.naver.com";		// https:// 는 생략 
		
		try {
			InetAddress address = InetAddress.getByName(hostname);
			System.out.println("IP 주소는 " + address.getHostAddress() + " 입니닷.");	
			
		}
		
		catch (UnknownHostException e) {
			System.out.println(hostname +" 에 해당하는 IP 주소를 찾을 수 없습니닷");
			
			
		}
	
	
	}

}
