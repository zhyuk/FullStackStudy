package fileex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {

	public static void main(String[] args) {
		long millisecond = 0;

		try {
			FileInputStream fis = new FileInputStream("C:/jwork/Exam/file.zip");
			FileOutputStream fos = new FileOutputStream("copy.zip"); // 루트경로 생략됨 (C:/jwork/first), 해당 경로에 빈 파일 생성됨
			millisecond = System.currentTimeMillis(); // 시스템의 현재 시간을 긴 정수값으로 표현해주는 기능
			int i;
			while ((i = fis.read()) != -1) {
				fos.write(i);
			}
			millisecond = System.currentTimeMillis() - millisecond;

			fos.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("파일 복사 하는 데 " + millisecond + " milliseconds 소요되었습니다.");
	}

}
