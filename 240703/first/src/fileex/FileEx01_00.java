package fileex;

import java.io.*;

public class FileEx01_00 {

	public static void main(String[] args) throws Exception { // FileWriter가 throws를 갖고있기 때문에 예외처리 해줘야함

		String source = "하늘을 우러러 한 점 부끄럼이 없기를\n" + " 잎새에 이는 바람에도 나는 괴로워했다\n" + " ...\n" + " 오늘 밤에도 별이 바람에 스치운다.\n";
		System.out.println(source.length());
		char intxt[] = new char[source.length()];
		
		// 문자열을 char 배열로 변환해주는 메소드
		// getChars(복사할 객체의 시작인덱스번호(int), 복사할 객체의 마지막인덱스번호-1(int)),
		// 복사해서 붙여넣기할 객체명, 붙여넣을 객체의 시작 위치 인덱스 번호 (int));
		source.getChars(0, source.length(), intxt, 0);
//		source.getChars(6, 20, intxt, 5);
		
		// new FileWriter("파일명"); 파일위치의 기본값은 프로젝트 폴더임
		FileWriter fw = new FileWriter("data1.txt");
		fw.write(intxt);
//		fw.write(source);
		fw.close();

	}

}
