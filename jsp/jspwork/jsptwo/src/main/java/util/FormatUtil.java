package util;

import java.text.DecimalFormat;

public class FormatUtil {
	public static String number(long number, String pattern) {
		// 포맷 형식을 제공해주는 클래스
		DecimalFormat format = new DecimalFormat(pattern);
		return format.format(number);
	}
}
