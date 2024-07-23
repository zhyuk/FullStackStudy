package networkex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//클라이언트에서 보내온 메세지를 전달받아 출력하는 서버프로그램
public class ChatServer {
	public static void main(String[] args) throws IOException {
		//서버: 클라이언트의 요청을 받기 위한 준비를 한다. 
		ServerSocket echoServer = new ServerSocket(4000);
		
		System.out.println("[message] 서버 실행중...");
		BufferedReader in = null;
		try {
			//클라이언트의 요청을 받아 들인다.
			Socket socket = echoServer.accept();
			
			// 클라이언트가 보내온 메세지를 읽어들인다.
			// 클라이언트가 보내온 메세지가 없는 경우 스레드(작업은) 일시 중지가 된다.
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// in.readLine()=> 클라이언트가 보낸 문자를 다 읽어들인다.
			String str = in.readLine();
			System.out.println(
			  "[" + socket.getInetAddress().getHostAddress() + "]님이 보내온 메세지 >> "
			  + str);
			
			socket.close();
		} catch (IOException e) {
			System.out.println("[error] 서버에 문제가 생겼습니다.");
		} finally {
			in.close();
			echoServer.close();
		}
	}
}