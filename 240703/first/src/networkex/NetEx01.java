package networkex;

import java.net.*;

public class NetEx01 {
	public static void main(String args[]) throws UnknownHostException {
//		InetAddress Address = InetAddress.getLocalHost();
		
//		getLocalHost() 메소드는 static으로 선언된 클래스 메소드임
//		System.out.println("로컬 컴퓨터의 이름 : " + Address.getHostName());
//		System.out.println("로컬 컴퓨터의 IP 주소1 : " + Address.getHostAddress());
//		System.out.println("로컬 컴퓨터의 IP 주소2 : " + Address.toString());
//		System.out.println(Address);
//		System.out.println();
		
//		Address = InetAddress.getByName("java.sun.com");
//		System.out.println("java.sun.com 컴퓨터의 이름과 IP 주소 : " + Address);
//		System.out.println();		
//		
		System.out.println("naver도메인에 대응되는 Ip를 반환함");
		
		InetAddress sw[] = InetAddress.getAllByName("www.naver.com");
		for (int i = 0; i < sw.length; i++)
			System.out.println(sw[i]);
	}
}













