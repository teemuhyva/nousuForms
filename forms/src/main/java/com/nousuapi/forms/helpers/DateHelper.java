package com.nousuapi.forms.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
	private static Date currentDay = new Date();
	
	public static String getCurrentTime() {
		return formatter.format(currentDay);
	}
	
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
	
	public static String calcExpDate() {
		int noOfDays = 14; //i.e two weeks
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDay);            
		calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
		String date = formatter.format(calendar.getTime());
		return date;
	}
}
