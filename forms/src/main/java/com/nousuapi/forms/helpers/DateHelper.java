package com.nousuapi.forms.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	
	public int getDayOfWeek(Date givenDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(givenDate);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
	}
	
	public String startEndTime(Date startTime, Date endTime) {
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
        String timeOnsite = localDateFormat.format(startTime)  + localDateFormat.format(endTime);
        return timeOnsite;
	}
}
