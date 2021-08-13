
public class Television1 {

	int channel;
	int volume;
	boolean onOff;
	
	void print() {
		System.out.print("현재 채널은" + channel +"이고 볼륨은" + volume +"입니다.");
	}
	
	int getChannel() {
		return channel;
	}
	
	void setChannel(int ch) {
		channel = ch;
	}
	
	public static void main(String[] args) {
		
	
	Television1 mytv = new Television1();
	mytv.setChannel(99);
	int ch = mytv.getChannel();
	System.out.println("현재 채널은" + ch + "입니다." );
	
// P223 05 메소드 오버로딩	
	
	}
}
