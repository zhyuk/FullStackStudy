package networkex.chatting;


import java.io.*;
import java.net.*;

public class Client {
	/*
	 * Java 간단한 채팅 참조 : https://lktprogrammer.tistory.com/64?category=672211
	 * BufferedReader 참조 : https://jhnyang.tistory.com/92
	 */
	public static void main(String[] args) {
		Socket socket = null;
		DataInputStream in = null; // 이 변수는 사용자가 입력하는 채팅 부분에 해당됩니다.
		BufferedReader in2 = null; // 이 변수는 사용자의 닉네임에 해당됩니다
		
		DataOutputStream out = null; // 이 변수는 사용자가 입력한 데이터를 출력할 때 사용합니다.
		
		try {
			InetAddress ia = null; // Local Host IP Address 가져오기 위한 변수
			ia = InetAddress.getLocalHost(); // 현재 PC의 IP Address 가져오기
			socket = new Socket(ia, 7777); // ia에 서버의 IP와 port 번호 입력 
			
			/*
			 * DataInputStream은 입력 스트림을 받는 매개변수이며,
			 * socket.getInputStream()함수를 통해 소켓에서 전달되는 데이터 스트림을 읽어옵니다.
			 * BufferedReader는 Scanner와 비슷한 개념입니다.
			 * Scanner보다 빠르다는 장점이 있지만 String형으로 버퍼에 저장하기 때문에
			 * 따로 데이터를 가공해서 사용해야하는 경우가 많습니다.
			 */
			in = new DataInputStream(socket.getInputStream()); //서버에서 들어온 데이터를 전송받는 객체
			in2 = new BufferedReader(new InputStreamReader(System.in)); //클라이언트에서 닉네임을 입력할 때 사용하는 객체
			out = new DataOutputStream(socket.getOutputStream());//서버로 전송할 데이터를 담아두는 객체, 전송개체
			
			System.out.print("닉네임을 입력해주세요 : ");
			String data = in2.readLine(); // 채팅에 사용할 닉네임을 받아옵니다. in2에 readLine으로 한 문장의 닉네임 입력
			
			out.writeUTF(data); // 닉네임을 UTF-8로 변경 후 출력스트림에 넣습니다. 입력하면 리시버에서 readUTF대기중이었던 애가 받음
			Thread th = new Thread(new Send(out)); // 새로운 쓰레드에 out을 집어넣도록 합니다. 
			th.start(); // 쓰레드 시작
		}catch(IOException e) {
			
		}
		
		try {
			/*
			 * 끊어지기 전까지는 계속 채팅을 입력받기 때문에
			 * 무한루프(while)안에서 동작합니다.
			 * 만일 끊고 싶다면 break에 대한 조건문을 걸면 됩니다.
			 */
			while(true) {
				String str2 = in.readUTF(); //서버에 연결된 User클래스의 sendMsg메소드 안의
				//clientmap.get(clientname).writeUTF(name + " : " + msg); 
				//코드로 인해 전송된 데이터를 받아들입니다.
				System.out.println(str2);
				if(str2.equals("종료")) break;
			}
		}catch(IOException e) {
			
		}
	}
}