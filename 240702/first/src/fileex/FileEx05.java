package fileex;

import java.io.*;

public class FileEx05 {

	public static void main(String[] args) throws IOException {
		File f = new File("C:/jwork/Second/fileex/FilEx04.java");
		String fileName = f.getName(); // FileEx04.java
		int pos = fileName.lastIndexOf("."); // FileEx04.java에서 오른쪽에서부터 .을 찾는다.

		System.out.println("경로를 제외한 파일이름 - " + f.getName());
		System.out.println("확장자를 제외한 파일이름 - " + fileName.substring(0, pos)); // substring(a, b) : a부터 b만큼 잘라서 가져오기.
		System.out.println("확장자 - " + fileName.substring(pos + 1)); // substring(a) : a부터 끝까지 잘라서 가져오기.

		System.out.println("경로를 포함한 파일이름 - " + f.getPath()); // 내가 입력한 경로.
		System.out.println("파일의 절대경로 - " + f.getAbsolutePath());
		System.out.println("파일이 속해 있는 디렉토리 - " + f.getParent()); // f의 부모 경로를 가져와라. File에서 가장 자식으로 오며, .확장자가 붙으면 자동으로 파일로 인식
		System.out.println("");

		System.out.println("File.separator - " + File.separator); // separator = 구분자, 구분자를 알아오는 코드임, String 자료형으로 반환
		System.out.println("File.separatorChar - " + File.separatorChar); // char 자료형으로 반환
		System.out.println("현재 디렉토리 - " + System.getProperty("user.dir"));
	}

}
