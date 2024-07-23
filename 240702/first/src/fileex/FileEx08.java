package fileex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileEx08 {

	public static void main(String[] args) throws Exception {
		// 파일 출력용
		FileOutputStream fos1 = new FileOutputStream("C:/jwork/out_utf8.txt", true);
		FileOutputStream fos2 = new FileOutputStream("C:/jwork/out_ansi.csv");

		// ANSI 계열 인코딩 유형 - ms949 : 확장완성형
		// 한글 깨짐의 보완하려면 ms949를 사용하는 것이 좋다.
		// unicode 기반의 인코딩 유형 - utf-8 : 조합형
		OutputStreamWriter osw1 = new OutputStreamWriter(fos1, "utf-8");
		OutputStreamWriter osw2 = new OutputStreamWriter(fos2, "ms949"); // 엑셀은 utf-8을 해석할 수 없으므로 ansi 계열 인코딩 ms949 작성

		int c;

		System.out.println("아무 내용이나 입력하세요. 꼭 엔터를 해 주어야만 글이 입력됩니다." + "\n종료를 원하시면 ctrl + z를 눌러주세요");
		InputStreamReader isr = new InputStreamReader(System.in); // System.in = 콘솔창에서 입력할 수 있음
//		isr.read() 때문에 콘솔창에 입력한 것을 읽어들일 수 있음.
		while ((c = isr.read()) != -1) {
			osw1.write(c);
			osw2.write(c);
		}

		System.out.println("작업 완료\n");

		// 닫을 때는 꼭 역순으로 닫아준다.
		osw1.close(); // osw1과 osw2는 선언만 같이 해준 것이고, 서로 값을 받는 것이 없기 때문에 먼저 둘의 위치가 변경되도 오류 X
		osw2.close();
		fos1.close();
		fos2.close();
		isr.close();

		FileInputStream fis = new FileInputStream("C:/jwork/out_ansi.csv");
		isr = new InputStreamReader(fis, "ms949");
		c = 0;
		while ((c = isr.read()) != -1) {
			System.out.print((char) c);
		}
		
		System.out.println();
		System.out.println("출력 끝");
		
		isr.close();
		fis.close();
	}

}
