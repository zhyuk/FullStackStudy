package fileex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class FileEx07 {

	public static void main(String[] args) {
		try {
			OutputStream output = new FileOutputStream("C:/jwork/Output.txt");
			String str = "오늘 날씨는 아주 덥습니다.";
			byte[] by = str.getBytes(); // 문자열.getBytes() = 문자열을 바이트코드화시켜 보관

			output.write(by); // 바이트스트림은 byte, byte[], int만 작성할 수 있음
			output.close();

			FileInputStream fis = new FileInputStream("C:/jwork/Output.txt"); // 바이트방식으로 읽음
			InputStreamReader isr = new InputStreamReader(fis); // 바이트방식으로 입력했으나 문자방식으로 변환해 출력 -> 바이트코드화된 파일을 문자 형식으로 변환
			int c;
			// isr 파일을 한 글자씩 유니코드로 읽는다.
			while ((c = isr.read()) != -1) {
				// (char) 작성되지 않을 경우, 유니코드 출력됨
				System.out.print((char) c);
			}
			// 닫을 때는 선언한 역순으로
			isr.close();
			fis.close();

			System.out.println();
			System.out.println("작업 완료\n");

		} catch (Exception e) {
			e.getStackTrace();
		}
		System.out.println("프로그램 종료");
	}

}
