package pers.jack.leave.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import pers.jack.leave.common.ProjectConstants;

public class TimeFormatUtil {
	private static Calendar calendar;
	static {
		calendar = Calendar.getInstance(Locale.CHINA);
	}

	private TimeFormatUtil() {

	}

	public static String formatTime(long time) {
		SimpleDateFormat sdf = new SimpleDateFormat(
				ProjectConstants.TIME_FORMAT, Locale.CHINA);
		calendar.clear();
		calendar.setTimeInMillis(time);
		return sdf.format(calendar.getTime());
	}

	public static long getTimeInMillis(int year, int month, int day) {
		calendar.clear();
		calendar.set(year, month, day);
		return calendar.getTimeInMillis();
	}

	public static boolean compareDate(int startYear, int startMonth,
			int startDay, int endYear, int endMonth, int endDay) {
		calendar.clear();
		calendar.set(startYear, startMonth - 1, startDay);
		Date dateStart = calendar.getTime();
		calendar.clear();
		calendar.set(endYear, endMonth - 1, endDay);
		Date dateEnd = calendar.getTime();
		return dateStart.before(dateEnd);
	}
}
