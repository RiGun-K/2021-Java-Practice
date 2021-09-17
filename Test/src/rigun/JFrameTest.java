package rigun;

import javax.swing.JFrame;

public class JFrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Frame = 기본창(틀) , 내부 내용은 없는 박스 
		
		/*
		 * 1 : 최상위 컨테이너 객체인 JFrame 객체를 생성
		 * 2 : 컨테이너 안에 컴포넌트(버튼)을 추가한다
		 */
		
		// 1
		JFrame f = new JFrame("JFrame Test");
			// 프레임의 속성 설정 (사이즈)
			f.setSize(300, 200);
			// 종료시 수행할 방법)
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// 보이도록 속성 설정 
			f.setVisible(true);
			
		// 2	
	}

}
