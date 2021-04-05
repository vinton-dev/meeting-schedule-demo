package com.calendardemo.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

	public static String getDateFormatter(Date dateTime) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormatter.format(dateTime);
	}
}
