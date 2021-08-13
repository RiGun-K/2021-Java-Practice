import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PapagoTranslater extends JFrame implements ActionListener {
	
	private JTextArea in, out;
    private JButton convert , cancel;

    private final String CLIENT_ID = "WKI8RUaS1Ti6RLys3ays";//애플리케이션 클라이언트 아이디값";
    private final String CLIENT_SECRET = "WOPQilqTql";//애플리케이션 클라이언트 시크릿값";
    
    public PapagoTranslater() {
        this.setTitle("Translate");


        in = new JTextArea(10,14);
        out = new JTextArea(10,14);

        in.setLineWrap(true); // 자동 줄 바꿈
        out.setLineWrap(true); // 자동 줄 바꿈
        out.setEditable(false); // 편집 불가

        JPanel textAreaPanel = new JPanel(new GridLayout(1,2,20,20));
        textAreaPanel.add(in);
        textAreaPanel.add(out);

        convert = new JButton("변환");
        cancel = new JButton("취소");
        convert.addActionListener(this);
        cancel.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(convert);
        buttonPanel.add(cancel);

        JPanel MainPanel = new JPanel(new BorderLayout(10,10));
        MainPanel.add(textAreaPanel, BorderLayout.CENTER);
        MainPanel.add(buttonPanel,BorderLayout.SOUTH);

        this.setLayout((new FlowLayout(FlowLayout.CENTER,20,20)));
        this.add(MainPanel);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
      @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        /* 
            변환 버튼이 클릭되었다면
            좌측 textArea (textIn)의 텍스트를 읽어서
            영어로 변환하고 그 변환된 결과를
            우측 textArea (textout) 에 append
            취소 버튼이 클릭되었다면
            우측을 빈 문자열로 설정
        */
        if(e.getSource() == convert) {
            //out.append(toEnglish(in.getText()));
        	String str = in.getText();
			String result = toEnglish(str);
			out.setText(result);
		}else {
			out.setText("");
		}

      }
      
      private String toEnglish(String korean) {
    	  
    	  String result = korean;
    	  result = result.replace("텍스트", "text");
    	  result = result.replace("영어", "english");
    	  
    	  String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
    	  String text;
  		try {
  			text = URLEncoder.encode(korean, "UTF-8");
  		} catch (UnsupportedEncodingException e) {
  			throw new RuntimeException("인코딩 실패", e);
  		}

  		Map<String, String> requestHeaders = new HashMap<>();
  		requestHeaders.put("X-Naver-Client-Id", CLIENT_ID);
  		requestHeaders.put("X-Naver-Client-Secret", CLIENT_SECRET);

  		result = post(apiURL, requestHeaders, text);

  		//결과값만 출력하게 하기
  		result = result.substring(result.indexOf("translatedText")+"translatedText".length()+3,result.indexOf("engineType")-3);

  		System.out.println(result);


  		return result;

  	}
    			  
      
    
      private static String post(String apiUrl, Map<String, String> requestHeaders, String text){
          HttpURLConnection con = connect(apiUrl);
          String postParams = "source=ko&target=en&text=" + text; //원본언어: 한국어 (ko) -> 목적언어: 영어 (en)
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

    	PapagoTranslater hello =new PapagoTranslater();
        hello.setVisible(true);
    }
	
      
	
	

}
