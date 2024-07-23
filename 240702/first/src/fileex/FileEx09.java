package fileex;

import java.io.File;

public class FileEx09 {

	public static void main(String[] args) {
		try {
			File f = new File("C:/jwork/first/src/fileEx", "FileEx01_00.java");
//			== File f = new File("C:/jwork/first/src/fileEx/FileEx01_00.java");
			
			System.out.println(f.getName());
			System.out.println(f.exists()); // 윈도우는 폴더 대소문자 구별 X = true 출력 // 맥은 폴더 대소문자 구별 O = false 출력
			System.out.println(f.length());

//			boolean result = new File("C:/jwork/Exam/log").mkdir(); // Exam 폴더 생성 실패 -> mkdir()은 기존에 존재하는 jwork까지의 디렉토리를 제외하고 한 단계만 만들 수 있음
//			boolean result = new File("C:/jwork/Exam").mkdir(); // Exam 폴더 생성 성공
			boolean result = new File("C:/jwork/Exam/log").mkdirs(); // Exam 폴더, log 폴더 생성 성공 -> mkdirs()는 여러 단계 모두 만들 수 있음

			if (result == true) {
				System.out.println("Exam 디렉토리 생성 성공");
			} else {
				System.out.println("Exam 디렉토리 생성 실패");
			}
			
//			File[] fArr = new File("C:/jwork/Exam").listFiles(); -> Exam 디렉토리 내 파일,폴더의 모든 것을 파일 형태로 가져와라. => 읽기전용, 쓰기전용, 용량, 수정일 등 정보까지 가져올 수 있음
			String[] listing = new File("C:/jwork/Exam").list(); // -> Exam 디렉토리 내 파일,폴더의 이름만 가져와라.
			for (String x : listing) {
				System.out.println("디렉토리 목록 : " + x);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} // cath문 종료

	} // main 메소드 종료

} // 클래스종료
