package javautilex;

import java.text.SimpleDateFormat;
import java.util.*;

public class UtilEx03 {
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
		
		Date day = cal.getTime();
		System.out.println("day: " + day);
		System.out.println();
		
		Date nowday = new Date();
		System.out.println("nowday: " + nowday);
		
		SimpleDateFormat sdf1, sdf2, sdf3;
		sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:a");
		
		System.out.println("sdf1: " + sdf1.format(day));
		System.out.println("sdf2: " + sdf2.format(day));
		System.out.println("sdf3: " + sdf3.format(day));
		sdf2 = new SimpleDateFormat("yy-M-d h:m");
		System.out.println("sdf2: " + sdf2.format(day));
	}
}
