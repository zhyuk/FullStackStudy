package javatimeex;

import java.time.*;

public class TimeEx {

	public static void main(String[] args) {
		// LocalDate 해당 국가를 인식하는 클래스
		// LocalDate 년, 월, 일 정보만 갖는다. (오늘 날짜 가져오기)
		LocalDate nowDate = LocalDate.now();
		System.out.println("현재 년, 월, 일 정보 : " + nowDate + "\n");
		
		// 특정일 지정 가능. 년, 월, 일 (월 1부터 계산 -Date, Calendar 개선)
		LocalDate ofDate = LocalDate.of(2021, 01, 11);
		System.out.println("특정 년, 월, 일 정보 : " + ofDate + "\n");
		
		// LocalTime은 시, 분, 초 정보만을 가진다.
		LocalTime nowTime = LocalTime.now();
		System.out.println("현재 시, 분, 초, 나노세컨드초 정보 : " + nowTime + "\n");
		
		// LocalDateTime은 년, 월, 일, 시, 분, 초 모두 가짐.
		LocalDateTime nowDateTime = LocalDateTime.now();
		System.out.println("현재 날짜시간 정보 : " + nowDateTime + "\n");
		
		// 특정일, 특정시간 지정 가능.
		LocalDateTime ofDateTime = LocalDateTime.of(2018, 12, 11, 15, 13, 32);
		DayOfWeek dayOfWeek = ofDateTime.getDayOfWeek();
		System.out.println("특정일 날짜시간 정보 : " + ofDateTime + " " + dayOfWeek);

	}

}
