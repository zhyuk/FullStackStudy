package networkex.chatting;

import java.io.*;

/*
 * extends Thread, implements Runnable은 쓰레드 구현을 위해 사용합니다.
 * extends Thread는 Thread를 상속받고 객채화한 뒤에 객체명.start()를 통해 사용하며,
 * implements Runnable은 Thread 객체 안에 쓰레드를 사용하려는 객체를 넣어줘서 객체화한 뒤 사용합니다.
 * extends Thread와 implements Runnable은 비슷합니다.
 * 하지만 implements Runnable을 사용하면 다중 상속이 가능합니다.
 */
public class Send implements Runnable{
	 /*
	  * Java 간단한 채팅 참조 : https://lktprogrammer.tistory.com/64?category=672211
	  * DataOutputStream 정보 참조 : https://apphappy.tistory.com/69
	  * Send Class는 Client에서 쓰레드를 실행할 때 사용됩니다.
	  */
	DataOutputStream out;
	
	/*
	 * Send 클래스에서의 in2는 채팅 내용을 받아오는 역할을 합니다.
	 */
	BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
	
	
	public Send(DataOutputStream out) {
		this.out = out;
	}
	
	public void run() {
		while(true) {
			try {
				String msg = in2.readLine(); // 클라이언트가 콘솔창에 입력하는 부분이면서, 입력한 데이터를 받아오는 곳
				out.writeUTF(msg); // 클라이언트가 입력한 데이터를 서버로 전송하는 부분(실제로는 Receiver 클래스의 run메소드의 
				//readUTF();로 전송. 보내라(write)
			}catch(Exception e) {
				
			}
		}
	}
}