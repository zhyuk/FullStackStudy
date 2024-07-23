package networkex;

import java.net.*;
import java.io.*;

public class NetEx02 {
	public static void main(String args[]) {
		URL url = null;
		BufferedReader input = null;
		String address = "https://www.naver.com";
		String line = "";

//		try {
//			url = new URL(address);
//			input = new BufferedReader(new InputStreamReader(url.openStream()));
//
//			while ((line = input.readLine()) != null) {
//				System.out.println(line);
//			}
//			input.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		try {
			url = new URL("http://www.example.com:80/search/index.html?d=Java");
			String protocal = url.getProtocol(); 
			System.out.println("프로토콜: " + protocal);
			
			String host = url.getHost(); 
			System.out.println("호스트명: " + host);

			int port = url.getPort(); 
			System.out.println("포트번호: " + port);
			
			String file = url.getFile();
			System.out.println("파일 이름( 경로+쿼리 문자열 ): " + file);

			String path = url.getPath();
			System.out.println("경로: " + path);
			
			//쿼리 문자열 구하기 (URL이 쿼리 문자열을 포함하지 않는 경우는 null)
			String query = url.getQuery();
			System.out.println("쿼리 문자열: " + query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}




