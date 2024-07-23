package fileex;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx06 {

	public static void main(String[] args) {
		String currDir = System.getProperty("user.dir"); // 프로젝트 경로 (C:/jwork/first)
		File dir = new File(currDir); // C:/jwork/first를 저장
		File[] files = dir.listFiles(); // listFiles() = 경로에 존재하는 파일, 폴더목록을 가져온다.

		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			String name = f.getName();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mma");
			String attribute = "";
			String size = "";

			// files[i]가 폴더일 경우
			if (files[i].isDirectory()) {
//				객체 attribute를 "DIR"로 변경
				attribute = "DIR";
			} else {
				size = f.length() + "";
				// 읽기전용 파일인가 참=R 거짓=null 반환
				attribute = f.canRead() ? "R" : " ";
				// 쓰기전용 파일인가 참=W 거짓=null 반환
				attribute += f.canWrite() ? "W" : " ";
				// 숨겨진 파일인가 참=H 거짓=null 반환
				attribute += f.isHidden() ? "H" : " ";
			}

			// lastModified() : 최종 수정일
			System.out.printf("최종 수정일: %s , 파일속성: %3s , " + "용량: %6s바이트, 파일명: %s\n",
					df.format(new Date(f.lastModified())), attribute, size, name);
		} // for문 종료 중괄호

	}

}
