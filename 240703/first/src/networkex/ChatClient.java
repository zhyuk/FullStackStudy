package networkex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

//키보드로 메세지를 입력받아 서버에 접속하여 전달하는 클라이언트 프로그램
public class ChatClient {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = null;
		
//		socket객체 생성: 서버에 접속 요청을 한다.
//		Socket socket = new Socket("서버하기로 한 사람의 ip", 4000);
//		Socket socket = new Socket("192.168.0.39", 4000);
//		Socket socket = new Socket("127.0.0.1", 4000);
		Socket socket = new Socket("localhost", 4000);
		try {
		
			System.out.println("전달 메세지 입력 >> ");
			String message = in.readLine();
			
			//서버로 데이터를 보낼 (써서 담아둘) 객체 생성
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			out.write(message); //메세지 쓰기
			out.flush(); //메세지 내보내기, 버퍼 강제 비우기
			
		} catch (IOException e) {
			System.out.println("[에러] 서버에 접속할 수 없습니다.");
		} finally {
			 out.close();
		     in.close();
			socket.close();
		}
	}
}
