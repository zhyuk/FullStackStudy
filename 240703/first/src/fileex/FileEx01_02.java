package fileex;

import java.io.*;

public class FileEx01_02 {

	public static void main(String[] args) throws IOException {
		// \r : 캐리지리턴, 그 줄의 처음으로 이동해라
		// \n : 한 줄 바꿈의 의미
		// \r\n : 개행문자, 다음 줄의 처음으로 이동해라
		String currDir = System.getProperty("user.dir"); // 기본경로(루트경로)는 프로젝트 폴더
		System.out.println(currDir); // C:\jwork\first
		File file = new File(currDir + "/test.txt"); // 경로가 있든없든 생성 가능 , test.txt 파일이 존재하지 않더라도 File 객체는 받을 수 있음
		if (!file.exists()) file.createNewFile(); // C:/jwork/first/test.txt의 존재 유무 검사
		// createNewFile() : File 클래스에서 제공해주는 메소드. 새로운 파일을 생성하는 메소드

		FileWriter fw = new FileWriter(file);
		char[] buf = { 'm', 'e', 's', 's', 'a', 'g', 'e' };
		for (int i = 0; i < buf.length; i++) fw.write(buf[i]); // write는 char, char[]과 문자열 모두 작성할 수 있음

		fw.write("이 줄의 마지막에서 개행문자 \r\n"); // 여기까지는 파일에 실제로 작성되는 것이 아닌 임시저장소인 버퍼에 저장되어 있음
		fw.close(); // 임시저장소를 출력한 뒤, 파일을 닫아 데이터 손실 방지

		// 입력
		FileReader fr = new FileReader(file);
		int EOF = -1; // 유니코드는 가장 작은 게 0임
		int c; 
		// fr.read() : fr 파일을 읽어보기
		while ((c = fr.read()) != EOF) {
			// 유니코드로 받은 문자를 char형으로 형변환
			System.out.print((char) c);
		} // 이것도 버퍼에 담겨있기 때문에 꼭 close 해주어야함.
		fr.close();
	}

}
