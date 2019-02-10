package com.nousuapi.forms.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	
	public int getDayOfWeek(Date givenDate) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
	}
	
	public String startEndTime(Date startTime, Date endTime) {
		Date date = new Date();
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
        String timeOnsite = localDateFormat.format(date)  + localDateFormat.format(date);
        return timeOnsite;
	}
}
