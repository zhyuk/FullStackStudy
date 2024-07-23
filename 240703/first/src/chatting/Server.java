package networkex.chatting;

import java.net.*;

public class Server {
	/*
	 * Java 간단한 채팅 참조 : https://lktprogrammer.tistory.com/64?category=672211
	 */
	public static void main(String[] args) {
		Socket socket = null; // Client와 통신하기 위한 Socket 생성
		User user = new User(); // 채팅방에 접속해 있는 Client 관리 객체
		ServerSocket server_socket = null; // Client 접속을 받기 위한 ServerSocket
		
		// 쓰레드 할당을 위한 정수
		int count = 0; 
		// 10개까지 쓰레드 할당, 즉 채팅방에 10명이 접속 가능. 따로따로 쓸 수 있게 하기 위해 쓰레드 사용
		Thread thread[] = new Thread[10]; 
		
		try {
			server_socket = new ServerSocket(7777); // 서버 포트로 소켓을 연다
			
			while(true) {
				socket = server_socket.accept(); //

				/*
				 * receiver Class에서 implements Runnable을 사용했기 때문에
				 * Thread 객체 안에 쓰레드를 사용하려는 객체를 넣어줘서 객체화를 할 수 있습니다.
				 */
				//Receiver 클래스를 Thread에서 돌림
				thread[count] = new Thread(new Receiver(user, socket)); //thread를 하나씩 카운트를 늘려서 만들고 시작하고 반복
				//0번방에 클라이언트1번에 대한 정보를 담아둠. user는 공동
				thread[count].start(); // 쓰레드 시작
				count++;
			}
		}catch(Exception e) {
			
		}
	}
}