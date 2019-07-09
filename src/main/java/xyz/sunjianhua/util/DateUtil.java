package xyz.sunjianhua.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;


/**
 * 工具类-日期处理
 * 
 * @author xx
 * @version 2.0
 * @since 2014年1月28日
 */
public class DateUtil {
	
	/**
	 * 获得当前日期
	 * @return
	 */
	public static Date getNow() {
		Calendar cal = Calendar.getInstance();
		Date currDate = cal.getTime();
		return currDate;
	}

	/**
	 * 日期转换为字符串 格式自定义
	 * 
	 * @param date
	 * @param f
	 * @return
	 */
	public static String dateStr(Date date, String f) {
		SimpleDateFormat format = new SimpleDateFormat(f);
		String str = format.format(date);
		return str;
	}

	/**
	 * 日期转换为字符串 MM月dd日 hh:mm
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr(Date date) {
		return dateStr(date, "MM月dd日 hh:mm");
	}

	/**
	 * 日期转换为字符串 yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr2(Date date) {
		return dateStr(date, "yyyy-MM-dd");
	}

	/**
	 * yyyy年MM月dd日HH时mm分ss秒
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr5(Date date) {
		return dateStr(date, "yyyy年MM月dd日 HH时mm分ss秒");
	}

	/**
	 * yyyyMMddHHmmss
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr3(Date date) {
		return dateStr(date, "yyyyMMddHHmmss");
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr4(Date date) {
		return dateStr(date, "yyyy-MM-dd HH:mm:ss");

	}

	/**
	 * yyyy年MM月dd日
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr6(Date date) {
		return dateStr(date, "yyyy年MM月dd日");
	}

	/**
	 * yyyyMMdd
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr7(Date date) {
		return dateStr(date, "yyyyMMdd");
	}

	/**
	 * MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr8(Date date) {
		return dateStr(date, "MM-dd");
	}

	/**
	 * MMdd
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr10(Date date) {
		return dateStr(date, "MMdd");
	}
	
	/**
	 * yyyyMM
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr11(Date date) {
		return dateStr(date, "yyyyMM");
	}
	
	/**
	 * yyyyMM
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr12(Date date) {
		return dateStr(date, "yyyy-MM-dd HH:mm:ss:SSS");
	}
	
	/**
	 * yyyyMMddHH
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr13(Date date) {
		return dateStr(date, "yyyyMMddHH");
	}
	
	/**
	 * yyyyMMddHHmm
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr14(Date date) {
		return dateStr(date, "yyyyMMddHHmm");
	}
	
	/**
	 * 将时间戳转换为Date
	 * 
	 * @param times
	 * @return
	 */
	public static Date getDate(String times) {
		long time = Long.parseLong(times);
		return new Date(time * 1000);
	}

	
	
	public static String dateStr(String times) {
		return dateStr(getDate(times));
	}

	public static String dateStr2(String times) {
		return dateStr2(getDate(times));
	}

	public static String dateStr3(String times) {
		return dateStr3(getDate(times));
	}

	public static String dateStr4(String times) {
		return dateStr4(getDate(times));
	}

	public static String dateStr5(String times) {
		return dateStr5(getDate(times));
	}

	/**
	 * 将Date转换为时间戳
	 * 
	 * @param date
	 * @return
	 */
	public static long getTime(Date date) {
		return date.getTime() / 1000;
	}

	public static int getDay(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * s - 表示 "yyyy-mm-dd" 形式的日期的 String 对象
	 * 
	 * @param f
	 * @return
	 */
	public static Date valueOf(String s) {
		final int YEAR_LENGTH = 4;
		final int MONTH_LENGTH = 2;
		final int DAY_LENGTH = 2;
		final int MAX_MONTH = 12;
		final int MAX_DAY = 31;
		int firstDash;
		int secondDash;
		int threeDash = 0;
		int fourDash = 0;
		Date d = null;

		if (s == null) {
			throw new java.lang.IllegalArgumentException();
		}

		firstDash = s.indexOf('-');
		secondDash = s.indexOf('-', firstDash + 1);
		if (s.contains(":")) {
			threeDash = s.indexOf(':');
			fourDash = s.indexOf(':', threeDash + 1);
		}
		if ((firstDash > 0) && (secondDash > 0) && (secondDash < s.length() - 1)) {
			String yyyy = s.substring(0, firstDash);
			String mm = s.substring(firstDash + 1, secondDash);
			String dd = "";
			String hh = "";
			String MM = "";
			String ss = "";
			if (s.contains(":")) {
				dd = s.substring(secondDash + 1, threeDash - 3);
				hh = s.substring(threeDash - 2, threeDash);
				MM = s.substring(threeDash + 1, fourDash);
				ss = s.substring(fourDash + 1);
			} else {
				dd = s.substring(secondDash + 1);
			}
			if (yyyy.length() == YEAR_LENGTH && mm.length() == MONTH_LENGTH && dd.length() == DAY_LENGTH) {
				int year = Integer.parseInt(yyyy);
				int month = Integer.parseInt(mm);
				int day = Integer.parseInt(dd);
				int hour = 0;
				int minute = 0;
				int second = 0;
				if (s.contains(":")) {
					hour = Integer.parseInt(hh);
					minute = Integer.parseInt(MM);
					second = Integer.parseInt(ss);
				}
				if (month >= 1 && month <= MAX_MONTH) {
					int maxDays = MAX_DAY;
					switch (month) {
					// February determine if a leap year or not
						case 2:
							if ((year % 4 == 0 && !(year % 100 == 0)) || (year % 400 == 0)) {
								maxDays = MAX_DAY - 2; // leap year so 29 days in
														// February
							} else {
								maxDays = MAX_DAY - 3; // not a leap year so 28 days
														// in February
							}
							break;
						// April, June, Sept, Nov 30 day months
						case 4:
						case 6:
						case 9:
						case 11:
							maxDays = MAX_DAY - 1;
							break;
					}
					if (day >= 1 && day <= maxDays) {
						Calendar cal = Calendar.getInstance();
						cal.set(year, month - 1, day, hour, minute, second);
						cal.set(Calendar.MILLISECOND, 0);
						d = cal.getTime();
					}
				}
			}
		}
		if (d == null) {
			throw new java.lang.IllegalArgumentException();
		}
		return d;
	}

	

	/**
	 * 前/后?分钟
	 * 
	 * @param d
	 * @param minute
	 * @return
	 */
	public static Date rollMinute(Date d, int minute) {
		return new Date(d.getTime() + minute * 60 * 1000);
	}

	/**
	 * 前/后?天
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date rollDay(Date d, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}

	/**
	 * 前/后?月
	 * 
	 * @param d
	 * @param mon
	 * @return
	 */
	public static Date rollMon(Date d, int mon) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MONTH, mon);
		return cal.getTime();
	}

	/**
	 * 前/后?年
	 * 
	 * @param d
	 * @param year
	 * @return
	 */
	public static Date rollYear(Date d, int year) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.YEAR, year);
		return cal.getTime();
	}

	public static Date rollDate(Date d, int year, int mon, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.YEAR, year);
		cal.add(Calendar.MONTH, mon);
		cal.add(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}

	/**
	 * 获取当前时间-时间戳字符串
	 * 
	 * @return
	 */
	public static String getNowTimeStr() {
		String str = Long.toString(System.currentTimeMillis() / 1000);
		return str;
	}


	/**
	 * 将Date转换为时间戳
	 * 
	 * @param time
	 * @return
	 */
	public static String getTimeStr(Date time) {
		long date = time.getTime();
		String str = Long.toString(date / 1000);
		return str;
	}

	public static String getTimeStr(String dateStr, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
		String str = DateUtil.getTimeStr(date);
		return str;
	}


	public static Date getIntegralTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getLastIntegralTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getLastSecIntegralTime(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(d.getTime());
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}


	// 获取本周日的日期
	@SuppressWarnings("unused")
	public static String getCurrentWeekday() {
		int weeks = 0;
		int mondayPlus = DateUtil.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
		Date monday = currentDate.getTime();

		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获得当前日期与本周日相差的天数
	private static int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
		if (dayOfWeek == 1) {
			return 0;
		} else {
			return 1 - dayOfWeek;
		}
	}

	// 获得本周一的日期
	@SuppressWarnings("unused")
	public static String getMondayOFWeek() {
		int weeks = 0;
		int mondayPlus = DateUtil.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus);
		Date monday = currentDate.getTime();

		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获取当前月第一天：
	public static String getFirstDayOfMonth() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String first = format.format(c.getTime());
		return first;
	}

	// 获取当月最后一天
	public static String getLastDayOfMonth() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = format.format(ca.getTime());
		return last;
	}

	/**
	 * 日期月份处理
	 * 
	 * @param d 时间
	 * @param month 相加的月份，正数则加，负数则减
	 * @return
	 */
	public static Date timeMonthManage(Date d, int month) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(d);
		rightNow.add(Calendar.MONTH, month);
		return rightNow.getTime();
	}

	/**
	 * 获取指定年月的最后一天
	 * 
	 * @param year_time 指定年
	 * @param month_time 指定月
	 * @return
	 */
	public static Date monthLastDay(int year_time, int month_time) {
		Calendar cal = Calendar.getInstance();
		cal.set(year_time, month_time, 0, 23, 59, 59);
		return cal.getTime();
	}

	/**
	 * 获取指定年月的第一天
	 * 
	 * @param year_time 指定年
	 * @param month_time 指定月
	 * @return
	 */
	public static Date monthFirstDay(int year_time, int month_time) {
		Calendar cal = Calendar.getInstance();
		cal.set(year_time, month_time - 1, 1, 0, 0, 0);
		return cal.getTime();
	}

	/**
	 * 获取指定时间月的第一天
	 * 
	 * @param d 指定时间，为空代表当前时间
	 * @return
	 */
	public static Date currMonthFirstDay(Date d) {
		Calendar cal = Calendar.getInstance();
		if (d != null)
			cal.setTime(d);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 0, 0, 0);
		return cal.getTime();
	}

	/**
	 * 获取指定时间月的最后一天
	 * 
	 * @param d 指定时间，为空代表当前时间
	 * @return
	 */
	public static Date currMonthLastDay(Date d) {
		Calendar cal = Calendar.getInstance();
		if (d != null)
			cal.setTime(d);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 23, 59, 59);
		return cal.getTime();
	}

	/**
	 * 获取指定时间的年
	 * 
	 * @param date 指定时间
	 * @return
	 */
	public static int getTimeYear(Date date) {
		if (date == null)
			date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * 获取指定时间的月
	 * 
	 * @param date 指定时间
	 * @return
	 */
	public static int getTimeMonth(Date date) {
		if (date == null)
			date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取指定时间的天
	 * 
	 * @param date 指定时间
	 * @return
	 */
	public static int getTimeDay(Date date) {
		if (date == null)
			date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DATE);
	}

	public static Date getFirstSecIntegralTime(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(d.getTime());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.DATE, 0);
		return cal.getTime();
	}

	/**
	 * 获取指定时间天的结束时间
	 * 
	 * @param d
	 * @return
	 */
	public static Date getDayEndTime(long d) {
		Date day = null;
		if (d <= 0){
			day = new Date();
		} else{
			day = new Date(d * 1000);
		}
		Calendar cal = Calendar.getInstance();
		if (day != null){
			cal.setTimeInMillis(day.getTime());
		}
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 23, 59, 59);
		return cal.getTime();
	}

	/**
	 * 获取指定时间天的开始时间
	 * 
	 * @param d
	 * @return
	 */
	public static Date getDayStartTime(long d) {
		Date day = null;
		if (d <= 0){
			day = new Date();
		} else {
			day = new Date(d * 1000);
		}
		Calendar cal = Calendar.getInstance();
		if (day != null) {
			cal.setTimeInMillis(day.getTime());
		}
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 0, 0, 0);
		return cal.getTime();
	}

	/**
	 * 获取19位的格式时间
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateByFullDateStr(String dateStr) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
    /** 
     * 计算两个日期之间相差的天数 
     * @param date1 
     * @param date2 
     * @return  date1>date2时结果<0,  date1=date2时结果=0, date2>date1时结果>0
     */  
    public static int daysBetween(Date date1, Date date2){
		DateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		try {
			Date d1 = sdf.parse(DateUtil.dateStr7(date1));
			Date d2 = sdf.parse(DateUtil.dateStr7(date2));
			cal.setTime(d1);
			long time1 = cal.getTimeInMillis();
			cal.setTime(d2);
			long time2 = cal.getTimeInMillis();
			return Integer.parseInt(String.valueOf((time2 - time1) / 86400000L));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
       
    /** 
     * 计算两个日期之间相差的小时数 
     * @param date1 
     * @param date2 
     * @return 
     */  
    public static int hoursBetween(Date date1, Date date2) {
     
        DateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        try {
            Date d1 = sdf.parse(DateUtil.dateStr7(date1));
            Date d2 = sdf.parse(DateUtil.dateStr7(date2));
            cal.setTime(d1);
            long time1 = cal.getTimeInMillis();
            cal.setTime(d2);
            long time2 = cal.getTimeInMillis();
            return Integer.parseInt(String.valueOf((time2 - time1) / 3600000L));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
  
    
    /** 
     * 计算两个日期之间相差的小时数 
     * @param date1 
     * @param date2 
     * @return  date1>date2时结果<0,  date1=date2时结果=0, date2>date1时结果>0
     */  
    public static int hoursBetweenByDateStr(Date date1, Date date2) {
     
        DateFormat sdf=new SimpleDateFormat("yyyyMMddHH");
        Calendar cal = Calendar.getInstance();
        try {
            Date d1 = sdf.parse(DateUtil.dateStr13(date1));
            Date d2 = sdf.parse(DateUtil.dateStr13(date2));
            cal.setTime(d1);
            long time1 = cal.getTimeInMillis();
            cal.setTime(d2);
            long time2 = cal.getTimeInMillis();
            return Integer.parseInt(String.valueOf(((time2 - time1) / 3600000L)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    /** 
     * 计算两个日期之间相差的分钟数 
     * @param date1 
     * @param date2 
     * @return  date1>date2时结果<0,  date1=date2时结果=0, date2>date1时结果>0
     */  
    public static int minuteBetweenByDateStr(Date date1, Date date2) {
     
        DateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
        Calendar cal = Calendar.getInstance();
        try {
            Date d1 = sdf.parse(DateUtil.dateStr14(date1));
            Date d2 = sdf.parse(DateUtil.dateStr14(date2));
            cal.setTime(d1);
            long time1 = cal.getTimeInMillis();
            cal.setTime(d2);
            long time2 = cal.getTimeInMillis();
            return Integer.parseInt(String.valueOf(((time2 - time1) / 60000L)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    /** 
     * 计算两个日期之间相差的秒数 
     * @param date1 
     * @param date2 
     * @return  date1>date2时结果<0,  date1=date2时结果=0, date2>date1时结果>0
     */  
    public static int secondBetweenByDateStr(Date date1, Date date2) {
     
        DateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar cal = Calendar.getInstance();
        try {
            Date d1 = sdf.parse(DateUtil.dateStr3(date1));
            Date d2 = sdf.parse(DateUtil.dateStr3(date2));
            cal.setTime(d1);
            long time1 = cal.getTimeInMillis();
            cal.setTime(d2);
            long time2 = cal.getTimeInMillis();
            return Integer.parseInt(String.valueOf(((time2 - time1) / 1000L)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    /**
	 * 得到两个时间相差的 天，小时，分钟，秒
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static Map<String, Object> getTimeDifference(Date startTime,
			Date endTime) {
		if (startTime == null || endTime == null) {
			return null;
		}
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60; // 一小时的毫秒数
		long nm = 1000 * 60; // 一分钟的毫秒数
		long ns = 1000; // 一秒钟的毫秒数
		long diff;
		diff = endTime.getTime() - startTime.getTime();
		long day = diff / nd; // 天
		long hour = diff % nd / nh; // 小时
		long min = diff % nd % nh / nm; // 分钟
		long sec = diff % nd % nh % nm / ns;// 秒
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("day", day);
		map.put("hour", hour);
		map.put("min", min);
		map.put("sec", sec);
		return map;
	}
	
	
	public static Date getStartTimeToday(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
		try {
			return sdf.parse(sdf.format(DateUtil.getNow()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
    
	
	
	/**
	 * yyMMddHHmm
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr9(Date date) {
		return dateStr(date, "yyMMddHHmm");
	}
	
	
	public static String getStartTimeOneDayStr(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		return sdf.format(date);
	}
	
	
	public static Date getStartTimeByDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		try {
			return sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date getDateByStrTime(String dateStr,String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static int secondsBetween(Date startTime,Date endTime){
		
		System.out.println("当前时间："+dateStr4(startTime));
		System.out.println("当天结束时间："+dateStr4(endTime));
		
		long diff=endTime.getTime()-startTime.getTime();
		
		long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);
        
        System.out.println("两个时间相差：");
        System.out.println(diffDays + " 天, ");
        System.out.println(diffHours + " 小时, ");
        System.out.println(diffMinutes + " 分钟, ");
        System.out.println(diffSeconds + " 秒.");
        
        int totalSecons= Integer.valueOf(String.valueOf(diff/1000));
        System.out.println("两个时间相差总秒数："+totalSecons);
        return totalSecons;
	}
	
	
	public static void main(String[] args) {
		
//		Double rewardFee=BigDecimalUtil.sub(1, 0.2);
//		
//		System.out.println("正常比列:" +rewardFee);
//		
//		Double taxMoney=BigDecimalUtil.roundup(BigDecimalUtil.div((36800-1000.00),rewardFee ),0);
//		
//		System.out.println("扣税部分的总额:" +taxMoney);
//		
//		System.out.println("总额:" +BigDecimalUtil.add(taxMoney,1000)); 
//		
//		if(secondBetweenByDateStr(DateUtil.getDateByStrTime("20180110135900","yyyyMMddHHmmss"),DateUtil.getNow())>=0){
//			System.out.println(secondBetweenByDateStr(DateUtil.getDateByStrTime("20180110135900","yyyyMMddHHmmss"),DateUtil.getNow()));
//			System.out.println("活动已开始" );
//		}else{
//			System.out.println("活动未开始:" );
//		}
//		
//		
//		Date time=DateUtil.getNow();
//		if(DateUtil.daysBetween(DateUtil.getDateByStrTime("20170606","yyyyMMdd"), time) <0){
//			System.out.println("6号之前" );
//		}else{
//			System.out.println("6号之后" );
//		}
		
		
//		Date date=getXinLiCaiAutoInvestTime(DateUtil.getDateByStrTime("20160229","yyyyMMdd"));
//		
//		System.out.println("返回日期:"+dateStr(date, "yyyyMMdd")  );
		
//		System.out.println(dateStr9(new Date()));
//		int value=Integer.valueOf(1608221702);
//		System.out.println("intValue: "+value);
		
//		System.out.println(DateUtil.getStartTimeOneDayStr(DateUtil.rollDay(DateUtil.getNow(), -1)));
//		
//		System.out.println(DateUtil.getStartTimeOneDayStr(DateUtil.rollDay(DateUtil.getNow(), 1)));
//		
//		System.out.println(DateUtil.dateStr2(DateUtil.rollDay(DateUtil.getNow(), -1)));
//		
//		System.out.println(DateUtil.dateStr2(DateUtil.getNow()));
		
		
//		System.out.println(DateUtil.getStartTimeOneDayStr(DateUtil.rollDay(DateUtil.getNow(), 0)));
//		
//		
//		System.out.print(DateUtil.getTime(DateUtil.getNow())+"\n");
//		System.out.print(System.currentTimeMillis());
		
	//	System.out.println("当前时间相差"+DateUtil.daysBetween(DateUtil.getDateByStrTime("20161008","yyyyMMdd"), DateUtil.getDateByStrTime("20161031","yyyyMMdd")));
		
		
//		Date closeTime1 = DateUtil.getDateByFullDateStr(DateUtil.dateStr2(new Date())+" "+"00:06:00");
//		Date closeTime2 = DateUtil.getDateByFullDateStr(DateUtil.dateStr2(new Date())+" "+"00:06:00");
//		
//		System.out.println("closeTime1 : "+DateUtil.dateStr4(closeTime1));
//		System.out.println("closeTime2 : "+DateUtil.dateStr4(closeTime2));
//		
//		if(DateUtil.getNow().compareTo(closeTime1)>=0&&DateUtil.getNow().compareTo(closeTime2)<=0){
//			System.out.println("当前时间为冻结时间不接受任何交易!");
//		}else{
//			System.out.println(DateUtil.dateStr4(DateUtil.getNow()));
//		}
//		
//		
//		
//		int days=DateUtil.daysBetween(DateUtil.getDateByStrTime("20161117000000","yyyyMMddHHmmss"), DateUtil.getNow());
//		
//		System.out.println("当前相差天数为 :"+days);
//		
//		
//		System.out.println("当前时间比较方法1为  : " + compare_date_1(DateUtil.dateStr2(new Date())+" "+"00:06:00", "2016-11-17 00:00:19"));
//		
//		System.out.println("当前时间比较方法1为  : " + compare_date_2(DateUtil.dateStr2(new Date())+" "+"00:06:00", "2016-11-17 00:00:19"));
//		
		
//		System.out.println(DateUtil.rollDay(DateUtil.getNow(), -1));
//		
//		System.out.println(DateUtil.getDateByStrTime("20161123", "yyyyMMdd").compareTo(DateUtil.getDateByStrTime("20161123", "yyyyMMdd")));
//		
//		
//		int abc=DateUtil.daysBetween(DateUtil.getDateByStrTime("20170429","yyyyMMdd"), DateUtil.getDateByStrTime("20170429","yyyyMMdd"));
//		System.out.println("abc:"+abc);
//		
//		System.out.println("明天起始时间 : "+DateUtil.getStartTimeByDate(DateUtil.rollDay(DateUtil.getNow(), 1)));
//		
//		System.out.println("明天起始时间Str:"+DateUtil.getStartTimeOneDayStr(DateUtil.rollDay(DateUtil.getNow(), 1)));
//		System.out.println(getLastMonthLastDay());
//		
//		System.out.println(dateStr4(new Date(1506575450093L)));
//		
//		System.out.println(DateUtil.rollMon(DateUtil.getNow(), -6).getTime());
//		
//		int abc=DateUtil.daysBetween(DateUtil.getDateByStrTime("2017-09-07 04:30:06","yyyy-MM-dd HH:mm:ss"), DateUtil.getDateByStrTime("2017-09-28 18:00:00","yyyy-MM-dd HH:mm:ss"));
//		System.out.println("abc:"+abc);
//		
//		
//		int bcd = DateUtil.compare_date_2("2017-09-07 04:30:06","2017-09-28 18:00:00");
//		
//		System.out.println("bcd"+bcd);
//		
//		System.out.println("时间 : "+System.currentTimeMillis());
		
	}
	
	
	 /** 
     * 给当前时间加一天
     * @param date1 
     * @return 
     */  
	public static Date getAddOneDay(Date d) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}
	
	
	 /** 
     * 给当前时间加一年
     * @param date1 
     * @return 
     */  
	public static Date getAddOneYear(Date d) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		cal.add(Calendar.YEAR, 1);
		return cal.getTime();
	}
	
	/**
	 * 比较时间
	 * @param strDate1  时间1
	 * @param strDate2  时间2
	 * @return 0:相等, <0:strDate1小于strDate2, >0:strDate1大于strDate2
	 */
	public static int compare_date_1(String strDate1, String strDate2) {
		int result=0;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			java.util.Calendar c1=java.util.Calendar.getInstance();
			java.util.Calendar c2=java.util.Calendar.getInstance();
			c1.setTime(df.parse(strDate1));
			c2.setTime(df.parse(strDate2));
			result=c1.compareTo(c2);
			if(result==0){
				System.out.println("c1相等c2");
			}else if(result<0){
				System.out.println("c1小于c2");
			}else{
				System.out.println("c1大于c2");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return result;
	 }
	
	
	
	
	
	
	/**
	 * 比较时间
	 * @param strDate1  时间1
	 * @param strDate2  时间2
	 * @return 0:相等, <0:strDate1小于strDate2, >0:strDate1大于strDate2
	 */
	public static int compare_date_2(String strDate1, String strDate2) {
		int result=0;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date dt1 = df.parse(strDate1);
			Date dt2 = df.parse(strDate2);
			if(dt1.getTime()>dt2.getTime()){
				result=1;
			}else if(dt1.getTime()<dt2.getTime()){
				result=-1;
			}else{
				result=0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return result;
	 }
	
	
	
	 /** 
     * 获取薪理财自动转入的时间
     * @param date  最后一期转入时间
     * @return 
     */  
	public static Date getXinLiCaiAutoInvestTime(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		
		int year=Calendar.YEAR;   //年
		int month=Calendar.MONTH; //月
		int day=Calendar.DATE;    //天
		
		
		Date returnDate=null;
		
		if(month==1 || month==3 || month==5 || month==8 || month==10){
			if(month==1){
				if(day>=28){
					if((year%4==0&&year%100!=0)||year%400==0){
						 returnDate=getDateByStrTime(dateStr(date,"yyyyMM")+29, "yyyyMMdd") ;
					 }else{
						 returnDate=getDateByStrTime(dateStr(date,"yyyyMM")+28, "yyyyMMdd") ;
					 }
				}
			}else{
				if(day>30 ){
					returnDate=getDateByStrTime(dateStr(date,"yyyyMM")+30, "yyyyMMdd") ;
				}else{
					returnDate= rollMon(date, 1);
				}
			}
		}else{
			returnDate= rollMon(date, 1);
		}
		
		return returnDate;
	}
	/**
	 * 获取上一个月的第一天
	 * @return
	 */
	public static String getLastMonthFirstDay(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return sdf.format(calendar.getTime())+" 00:00:00";
	}
	/**
	 * 获取上一个月的最后一天
	 * @return
	 */
	public static String getLastMonthLastDay(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar=Calendar.getInstance();
		int month=calendar.get(Calendar.MONTH);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return sdf.format(calendar.getTime())+" 23:59:59";
	}
	/**
	 * 比较两个时间是否为同一天
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameDay(Date date1, Date date2) {  
	    Calendar calendar = Calendar.getInstance();  
	    calendar.setTime(date1);  
	    int year1 = calendar.get(Calendar.YEAR);  
	    int day1 = calendar.get(Calendar.DAY_OF_YEAR);  
	  
	    calendar.setTime(date2);  
	    int year2 = calendar.get(Calendar.YEAR);  
	    int day2 = calendar.get(Calendar.DAY_OF_YEAR);  
	  
	    if ((year1 == year2) && (day1 == day2)) {  
	        return true;  
	    }  
	    return false;  
	}
	
	
	public static Date getDateByDateAndDateFormate(Date date,String dateFormat){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			return sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date MongoDbTimeToDate(Object mongodbTime) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Date returnD=null;
		try {
			if (mongodbTime instanceof Date) {
				Date d = (Date) mongodbTime;
				returnD= d;
			} else {
				returnD= format1.parse(mongodbTime.toString());
			}
		} catch (ParseException e) {
			try {
				returnD=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(mongodbTime.toString());
			} catch (ParseException e1) {
				try {
					returnD= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(mongodbTime.toString());
				} catch (ParseException e2) {
					e2.printStackTrace();
				}
			}
		}
		return returnD;
	}
	
	/**
	 * 字符串日期转日期格式
	 * @param dateStr
	 * @return
	 */
	public static Date dateStrToDate(String dateStr, String dateFormat) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			return sdf.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 获取指定日期的结束时间
	 * @param date
	 * @return
	 */
	public static String getEndTimeOneDayStr(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		return sdf.format(date);
	}
}
	
