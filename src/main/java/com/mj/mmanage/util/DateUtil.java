/**
 *@Title：DateUtili.java
 *@Package:com.citic.portal.core.util
 *@version:version V1.0
 */
package com.mj.mmanage.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Description:日期工具类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p> 
 * <p>
 * Create Date: 2015-12-7
 * </p>
 * <p>
 * Company: CITIC BANK
 * </p>
 * 
 * @author:YX-LiAnDong
 * @version:version V1.0
 */
public class DateUtil {

	/**
	 * 生成一个TimeStamp
	 * 
	 * @return
	 * @throws Exception
	 */
	static public Timestamp getTimeStamp() throws Exception {
		return new java.sql.Timestamp(System.currentTimeMillis());

	}

	/**
	 * 将日期字符串转换成Date
	 * 
	 * @param str
	 *            1
	 * @param formatStr
	 *            日期字符串格式 yyyyMMddhhmmss/yyyyMMdd
	 * @return 日期 str为空返回null
	 */
	public static Date parseDateStr(String str, String formatStr) {
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		try {
			return format.parse(str);
		} catch (ParseException e) {

		}
		return null;
	}

	/**
	 * 将日期格式化
	 * 
	 * @param date
	 *            日期
	 * @param formatStr
	 *            格式化字符串
	 * @return
	 * @throw:
	 */
	public static String getDateString(Date date, String formatStr) {
		return new SimpleDateFormat(formatStr).format(date);
	}

	/**
	 * 将14位的字符串转换成Timestamp
	 * 
	 * @param str
	 *            14位日期字符串 yyyyMMddhhmmss 20130923100210
	 * @return 日期 str为空返回null
	 */
	public static Timestamp strToTimestamp(String str, String formatStr) {
		Date d = DateUtil.parseDateStr(str, formatStr);
		Timestamp temdate = new Timestamp(d.getTime());
		return temdate;
	}

	/**
	 * 取得当前以后的某些小时的时间
	 * 
	 * @param count
	 *            几天之后
	 * @return 日期
	 */
	public static Timestamp afterHourOfCurrentHour(int count) {

		// 得到当前时间
		Calendar dt = Calendar.getInstance();
		Timestamp temdate = new Timestamp(dt.getTimeInMillis());
		// 取得当前以后的某些小时的时间
		temdate.setHours(temdate.getHours() + count);
		return temdate;
	}
	
	/**
	 * 取得当前时间以前的某些小时的时间
	 * 
	 * @param count
	 *            几小时以前
	 * @return 日期
	 */
	public static Timestamp beforeHourOfCurrentHour(int count) {

		// 得到当前时间
		Calendar dt = Calendar.getInstance();
		Timestamp temdate = new Timestamp(dt.getTimeInMillis());
		// 取得当前以后的某些小时的时间
		temdate.setHours(temdate.getHours() - count);
		return temdate;
	}

	/**
	 * 取得当前以后的某些分钟的时间
	 * 
	 * @param count
	 *            几天之后
	 * @return 日期
	 */
	public static Timestamp afterMinutesOfCurrentMinutes(int count) {

		// 得到当前时间
		Calendar dt = Calendar.getInstance();
		Timestamp temdate = new Timestamp(dt.getTimeInMillis());
		// 取得当前以后的某些小时的时间
		temdate.setMinutes(temdate.getMinutes() + count);
		return temdate;
	}
	
	/**
	 * 计算年龄
	 * 
	 * @param birthDay
	 *            出生日期
	 * @param dateNow
	 *            截至计算的日期
	 * @return
	 * @throw:
	 */
	public static int getAge(Date birthDay, Date dateNow) {

		Calendar now = Calendar.getInstance();
		now.setTime(dateNow);

		int yearNow = now.get(Calendar.YEAR);
		int monthNow = now.get(Calendar.MONTH) + 1;
		int dayNow = now.get(Calendar.DAY_OF_MONTH);
		Calendar day = Calendar.getInstance();
		day.setTime(birthDay);
		int yearBirth = day.get(Calendar.YEAR);
		int monthBirth = day.get(Calendar.MONTH) + 1;
		int dayBirth = day.get(Calendar.DAY_OF_MONTH);
		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				if (dayNow < dayBirth) {
					age--;
				}
			} else {
				age--;
			}
		}
		return age;
	}

	/**
	 * 日志转换成字符串 
	 *@param date 待处理日期
	 *@return 格式后的日期结果字符
	 */
	public static String getDateTime12Str(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String datestr = format.format(date);
		SimpleDateFormat formatTime = new SimpleDateFormat("HHmmss");
		String timestr = formatTime.format(date);
		String datetimestr = datestr + timestr;
		return datetimestr.substring(2);
	}
	/**
	 * 日志转换成字符串 
	 *@param date 待处理日期
	 *@return 格式后的日期结果字符
	 */
	public static String getDateTime8Str(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String datestr = format.format(date);
		return datestr.substring(2);
	}

	/**
	 * 取得今天以后的某一天
	 * 
	 * @param count
	 *            几天之后
	 * @return 日期
	 */
	public static Timestamp afterDaysOfToday(int count) {
		Calendar dt = Calendar.getInstance();
		dt.add(Calendar.DAY_OF_YEAR, count);
		Timestamp temdate = new Timestamp(dt.getTimeInMillis());
		return temdate;
	}
	/**
	 * 
	 * 比较结束日期(如20151211) 与  开始日期(如20151111) + 时间间隔(天数)的大小
	 *@param endTimeStr 结束时间
	 *@param startTimeSr 开始时间
	 *@param DayCount 时间间隔-天数
	 *@return boolean
	 *@throws ParseException
	 *@throw:
	 */
	public static boolean endCompareToStart(String endDateStr ,String startDateStr,int count) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date endDate = sdf.parse(endDateStr);
		Date startDate = sdf.parse(startDateStr);
		
        Calendar dt = Calendar.getInstance();
        dt.setTime(startDate);
        dt.add(Calendar.DAY_OF_YEAR, count);
        startDate = dt.getTime(); 
        boolean b = endDate.before(startDate);
        return b;
    }
	/**
	 * 
	 * 比较结束日期(如20151211) 与  开始日期(如20151112) + 时间间隔(月份)的大小
	 *@param endDateStr 结束时间
	 *@param startDateStr 开始时间
	 *@param count  时间间隔-月份
	 *@return
	 *@throws ParseException
	 *@throw:
	 */
	public static boolean endCompareToStartByMonth(String endDateStr ,String startDateStr,int count) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date endDate = sdf.parse(endDateStr);
		Date startDate = sdf.parse(startDateStr);
		
        Calendar dt = Calendar.getInstance();
        dt.setTime(startDate);
        dt.add(Calendar.MONDAY, count);
        startDate = dt.getTime(); 
        boolean b = endDate.before(startDate);
        return b;
    }
	/**
	 * 
	 * 比较结束日期 和开始日期  在月份中的号是否相同
	 *@param endDateStr
	 *@param startDateStr
	 *@return
	 *@throws ParseException
	 *@throw:
	 */
	public static boolean compareToDay(String endDateStr ,String startDateStr) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date endDate = sdf.parse(endDateStr);
		Date startDate = sdf.parse(startDateStr);
		int endTimeDay = endDate.getDate();
		int startTimeDay = startDate.getDate();
        boolean b = (endTimeDay == startTimeDay);
        return b;
    }
	/**
	 * 
	 * 比较结束日期与开始日期的周几是否相等
	 *@param endDateStr
	 *@param startDateStr
	 *@return
	 *@throws ParseException
	 *@throw:
	 */
	public static boolean compareToWeek(String endDateStr ,String startDateStr) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date endDate = sdf.parse(endDateStr);
		Date startDate = sdf.parse(startDateStr);
		Calendar dt = Calendar.getInstance();
	    dt.setTime(startDate);
	    int startInWeek = dt.get(Calendar.DAY_OF_WEEK);
	    dt.setTime(endDate);
	    int endInWeek =  dt.get(Calendar.DAY_OF_WEEK);
        boolean b = (endInWeek== startInWeek);
        return b;
    }
	
	/**
	 * 字符串转换成日期格式化
	 *@param s 待转换字符串
	 *@return 日志对象
	 *@throws ParseException 应用异常
	 */
	public static  Date parseDateTime(String s) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.parse(s);
	}
	/**
     * 格式化当前日期时间为12位的字符串，格式为：yyyyMMddHHmmss
     * @return 格式后的时间字符串
     */
    static public String getTodayDate12Str(){
    	Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String datestr = format.format(date);
		SimpleDateFormat formatTime = new SimpleDateFormat("HHmmss");
		String timestr = formatTime.format(date);
		String datetimestr = datestr + timestr;
		return datetimestr;
	}
    /**
     * 获取带格式的当前系统时间
     *@param format 日期格式
     *@return
     *@throw:
     */
    public static String getCurrentDate2Str(String format){
    	Date date = new Date();
    	String dateString = getDateString(date,format);
    	return dateString;
    }
	protected static final ThreadLocal<Map<String, DateFormat>> formats = new ThreadLocal<Map<String, DateFormat>>();

    protected static DateFormat getFormat(String formatStr) {
		if (formats.get() == null) {
			formats.set(new HashMap<String, DateFormat>());
		}
		Map<String, DateFormat> temp = formats.get();
		if (temp.get(formatStr) == null) {
			DateFormat f = new SimpleDateFormat(formatStr);
			temp.put(formatStr, f);
		}
		return temp.get(formatStr);
	}
    public static String dateWeekOpt(Date date, int day, String formatStr){
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(5, day);
		DateFormat format = getFormat(formatStr);
		return format.format(gc.getTime());
	
	}
	
	/**
     * 取得某天数月以前的某一天
     * @param count 几月之后或之前
     * @return 日期
     */
    public static Date beforeMonthsOfDate(Date temdate,int count){
    	if(count<0) return temdate;
    	
        Calendar dt = Calendar.getInstance();
        dt.setTime(temdate);
        dt.add(Calendar.MONTH, -count);
        temdate = dt.getTime(); 
        return temdate;
    }
	/**
	 * @see 将8位日期格式化成10位日期 如:20080112--->2008-01-12
	 * @param valueStr
	 *            要处理的日期
	 * @return 处理后的日期
	 * @throws AppException
	 */
	public static String formatDate8ToDate10(String valueStr) {

		if (valueStr == null || (valueStr.trim()).equals(""))
			return valueStr;
		if ("00000000".equals(valueStr))
			return "";

		if (valueStr.matches("[0-9]{8}")) {
			String newValue = valueStr.substring(0, 4) + "-"
					+ valueStr.substring(4, 6) + "-" + valueStr.substring(6);
			return newValue;
		} else {
			return valueStr;
		}
	}
	/**
	 * 字符串转换成日期格式化
	 *@param s 待转换字符串
	 *@return 日志对象
	 *@throws ParseException 应用异常
	 */
	public static  String parseDateTimes(String s) throws ParseException {
		if(StringUtil.isEmpty(s)){
			return s;
		}
		SimpleDateFormat sdf1 = null;
		if(s.length() == 17){
			sdf1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		}else if(s.length() == 14){
			sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
		}else{
			return s;
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long times = sdf1.parse(s).getTime();
		Calendar cl = Calendar.getInstance();
		cl.setTimeInMillis(times);
		return format.format(cl.getTime());
		
	}
	/**
	 * 日期字符串由格式1转换为格式2
	 *@param s
	 *@param format1 日期格式1
	 *@param format2 日期格式2
	 *@return 转换后的日期字符串
	 *@throws ParseException
	 */
	public static String formatDateStr(String s,String format1,String format2) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat(format1);
		SimpleDateFormat sdf2 = new SimpleDateFormat(format2);
		Date date = sdf1.parse(s);
		String dateStr = sdf2.format(date);
		return dateStr;
	}
	
	/**
	 * 返回当前的时间段是AM还是PM,其中AM-0:00-11:59:59; PM:12:00-23:59:59
	 * @return AM:上午;PM:下午
	 * @throws Exception
	 */
	public static String getCurrentPeriod() {
		
		return Constants.PERIOD_AM;
	}
	
	
}
