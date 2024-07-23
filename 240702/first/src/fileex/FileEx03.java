package fileex;

import java.io.*;

public class FileEx03 {

	public static void main(String[] args) throws IOException {

		// 바이트(숫자형) 스트림 파일을 출력하기 위한 객체 fos 생성
		FileOutputStream fos = new FileOutputStream("stream1.txt"); // C:/jwork/first/stream1.txt
		// 파일 존재 시 기존 파일 덮어쓰기, 파일 미존재 시 생성

		for (int i = 0; i < 5; i++) {
			fos.write(i);
		}
		fos.close();
		System.out.println("ByteStreamFile을 생성");

		// 문자스트림 방식
		FileWriter fw = new FileWriter("data1.txt");
		for (int i = 0; i < 5; i++) {
			fw.write(i);
//			String s = i + "";
//			fw.write(s);
		}
		fw.close();
		System.out.println("FileWriter을 생성");
		
		// 바이트 스트림 입력을 위한 객체 fis 생성
		FileInputStream fis = new FileInputStream("stream1.txt");
		
		int i;
		while ((i = fis.read()) != -1) {
			System.out.println(i);
		}
		System.out.println("ByteStream을 File로부터 입력");
		fis.close();
	}

}
