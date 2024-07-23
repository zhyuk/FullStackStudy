package networkex.chatting;

import java.io.DataInputStream;
import java.net.Socket;

/*
 * extends Thread, implements Runnable은 쓰레드 구현을 위해 사용합니다.
 * extends Thread는 Thread를 상속받고 객채화한 뒤에 객체명.start()를 통해 사용하며,
 * implements Runnable은 Thread 객체 안에 쓰레드를 사용하려는 객체를 넣어줘서 객체화한 뒤 사용합니다.
 * extends Thread와 implements Runnable은 비슷합니다.
 * 하지만 implements Runnable을 사용하면 다중 상속이 가능합니다.
 */
public class Receiver implements Runnable {
	/*
	 * Java 간단한 채팅 참조 : https://lktprogrammer.tistory.com/64?category=672211
	 * DataInputStream 정보 참조 : https://apphappy.tistory.com/69
	 * implements runnable 정보 참조 : 
	 */
	Socket socket;
	DataInputStream in;
	String name;
	User user = new User();
	
	/*
	 * 전역변수들을 전부 초기화합니다.
	 * 또한 user 클래스에 AddClient를 호출하여 사용자를 등록합니다.
	 */
	public Receiver(User user, Socket socket) throws Exception 
	{
		this.user = user;
		this.socket = socket;
		in = new DataInputStream(socket.getInputStream());
		this.name = in.readUTF(); // UTF-8 로 인코딩 후 읽어옴
		user.AddClient(name, socket); // 사용자 등록
	}
	
	public void run() {
		try {
			while(true) {
				String msg = in.readUTF(); // 클라이언트의 Send클래스의 run메소드 안에 있는 out.writeUTF(msg); 코드로 인해 
				//전송된 데이터를 받아오는 곳.
				user.sendMsg(msg, name); // 
				if(msg.equals("종료")) user.RemoveClient(this.name);
			}
		}catch(Exception e) {
			user.RemoveClient(this.name); // 에러 발생시 name 유저를 client에서 삭제
		}
	}
}