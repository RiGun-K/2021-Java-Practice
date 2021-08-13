import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

// 텍스트 필드에서 getText() 를 이용하여 텍스트를 얻은후에, 텍스트에서 단어를
// 분리하려면 Scanner 클래스의 next()메소드를 사용하자.
// 소스를 입력하고 Ctrl+Shift+O 를 눌러 필요한 파일을 포함한다.

public class TextConverter extends JFrame implements ActionListener {
	 private JButton convertBtn;
     private JButton cancelBtn;
     private JTextArea textIn;
     private JTextArea textOut;
     private final String CLIENT_ID = "WKI8RUaS1Ti6RLys3ays";
     private final String CLIENT_SECERT = "WOPQilqTql";
     
     
     public TextConverter() {
        this.setTitle("텍스트 변환");
        
        // 텍스트 영역
        textIn = new JTextArea(10, 14);		// 한글단어 표시 영역
        textOut = new JTextArea(10, 14);	// 영문단어 표시 영역
        textIn.setLineWrap(true);			// 자동 줄바꿈
        textOut.setLineWrap(true);
        textOut.setEditable(false);			// 비활성화
        
        // 텍스트 영역을 관리할 패널
        JPanel textAreaPanel = new JPanel(new GridLayout(1, 2, 20, 20));
        textAreaPanel.add(textIn);
        textAreaPanel.add(textOut);
        
        // 버튼
        convertBtn = new JButton("변환");
        cancelBtn = new JButton("취소");
        convertBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        
        // 버튼 패널
        JPanel btnPanel = new JPanel();
        btnPanel.add(convertBtn);
        btnPanel.add(cancelBtn);
        
        // 메인 패널
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.add(textAreaPanel, BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);
        
        // 프레임 설정
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        this.add(mainPanel);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

     }
	
	// 버튼의 액션 이벤트를 처리할 버튼 액션 리스너 클래스 생성
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * 
		 * 변환 버튼이 클릭되었다면
		 * 좌측 textArea (textin)의 텍스를 읽어서
		 * 영어로 변환하고 그 변환된 결과를
		 * 우측 textArea (textOut)에 append
		 * 취소 버튼의 클릭되었따면
		 * 우측 (textOut)을 빈 문자열로 설정
		 */
		if (e.getSource() == convertBtn) {
			String str = textIn.getText();
			String result = toEnglish(str);
			textOut.setText(result);
		}	else {
			textOut.setText("");
		}
		
	}
	
	
	private String toEnglish(String korean) {
		// korean 문자열을 영어로 변환해서 반환..
		/* 
		 * 텍스트 => text
		 * 영어  => english
		 */
		
		String result = korean;
//		result = korean.replace("텍스트", "text");
//		result = result.replace("영어", "english");
		
		 String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
	        String text;
	        try {
	            text = URLEncoder.encode(korean, "UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            throw new RuntimeException("인코딩 실패", e);
	        }

	        Map<String, String> requestHeaders = new HashMap<>();
	        requestHeaders.put("X-Naver-Client-Id", CLIENT_ID);
	        requestHeaders.put("X-Naver-Client-Secret", CLIENT_SECERT);

	        result = post(apiURL, requestHeaders, text);
	        result = result.substring(result.indexOf("translatedText")+"translatedText".length() + 3, result.indexOf("engineType")-3);
		return result;
	}
	
	private static String post(String apiUrl, Map<String, String> requestHeaders, String text){
        HttpURLConnection con = connect(apiUrl);
        String postParams = "source=ko&target=en&text=" + text; //원본언어: 한국어 (ko) -> 목적언어: 영어 (en) 언어바꾸려면 여기서 
        try {
            con.setRequestMethod("POST");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postParams.getBytes());
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
                return readBody(con.getInputStream());
            } else {  // 에러 응답
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
	
	public static void main(String[] args) {
		TextConverter t = new TextConverter();
	}
	
}