package fileex;

import java.io.*;

public class FileEx01_01 {

	public static void main(String[] args) throws IOException {
		String path = "C:/upload"; // C:/upload = C:\\upload
		File file = new File(path);
		if (!file.isDirectory()) { file.mkdirs(); } // file 객체가 폴더인지를 검사
//		if(!file.exists()) {file.mkdirs();} // file 객체에 존재하지 않으면, file 생성3
		path = path + "/file.txt"; // "C:/upload/file.txt"

//		FileWrite(file, true); true는 뒷 줄에 추가됨
//		디폴트는 false임. false는 덮어쓰기 됨.
		FileWriter fw = new FileWriter(path, true);
		fw.write("FileWriter는 한글로된 " + "\n");
		fw.write("문자열을 바로 출력할 수 있다. " + "\n");
		fw.flush(); 
		fw.close(); //데이터 손실을 막기 위해 꼭 닫아줘야한다.

		System.out.println("파일이 저장되었습니다.");

	}

}
