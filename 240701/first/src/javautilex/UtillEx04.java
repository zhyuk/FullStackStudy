package javautilex;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;

public class UtillEx04 {

	public static void main(String[] args) {
		int nYear, nMonth, nDay;
		
		// 현재날짜 구하기
		Calendar calendar = new GregorianCalendar();
		nYear = calendar.get(Calendar.YEAR);
		nMonth = calendar.get(Calendar.MONTH) +1;
		nDay = calendar.get(Calendar.DAY_OF_MONTH); // DAY_OF_MONTH = DATE
		System.out.println("Gregorian Calendar = " + nYear + "년 " + nMonth + "월 " + nDay + "일");
		
		calendar = new GregorianCalendar(2018, 0, 5);
		nYear = calendar.get(Calendar.YEAR);
		nMonth = calendar.get(Calendar.MONTH) +1;
		nDay = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("Gregorian Calendar = " + nYear + "년 " + nMonth + "월 " + nDay + "일");
		
		// date 로 구하기
		SimpleDateFormat fm1 = new SimpleDateFormat("yyyy년 MM월 dd일"); //SimpleDateFormat는 Date 자료형만 받을 수 있음.
		String date = fm1.format(new Date());
		System.out.println("현재시간 년월일 = " + date);
		
		SimpleDateFormat fm2 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss.S초 a");
		String date1 = fm2.format(new Date());
		System.out.println("현재시간 시분초 = " + date1);
		fm2 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 ww째주");
		date1 = fm2.format(new Date());
		System.out.println("현재는 일년 중 몇째주 = " + date1);
	}

}
