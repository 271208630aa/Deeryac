package com.deerYac.util;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类 获取日期时间，格式化日期时间等
 *
 * @author Yangjianliang datetime 2008-12-22
 */
public class DateUtil {

    public static final String PATTERN_DATE = "yyyy-MM-dd";
    public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final int BIGGER = 1;
    public static final int SMALLER = -1;
    public static final int SAME = -1;

    /**
     * 把String类型日期格式化成java.util.Date类型 默认是 yyyy-MM-dd HH:mm:ss 格式
     *
     * @param datestr 字符型日期
     * @return java.util.Date类型
     * @throws ParseException
     */
    public static Date parseDate(String datestr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATETIME);
        return sdf.parse(datestr);
    }

    /**
     * 把String类型日期格式化成java.util.Date类型
     *
     * @param datestr 字符型日期
     * @param pattern 格式化样式。如：yyyy-MM-dd HH:mm:ss
     * @return java.util.Date类型
     * @throws ParseException
     */
    public static Date parseDate(String datestr, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(datestr);
    }

    /**
     * 把DATE类型按指定格式格式化后返回String 返回类型为"yyyy-MM-dd HH:mm:ss"
     *
     * @param dt 以前的时间
     * @return yyyy-MM-dd HH:mm:ss 格式时间
     */
    public static String formatDate(Date dt) {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATETIME);
        return sdf.format(dt);
    }

    /**
     * 把DATE类型按指定格式格式化后返回String
     *
     * @param dt         以前的时间
     * @param dateFormat 需要的格式
     * @return 用户指定格式的时间
     */
    public static String formatDate(Date dt, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(dt);
    }

    /**
     * 将字符串类型时间格式化成指定格式的字符串
     *
     * @param strdate    字符串类型的时间
     * @param dateFormat 需要返回的格式 String类型的yyyy-MM-dd格式的字符串 转指定格式的Date类型
     * @return 用户指定格式的时间
     */
    public static String formatDate(String strdate, String dateFormat) {
        String toDate = "";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        SimpleDateFormat sdf_to = new SimpleDateFormat(dateFormat);
        try {
            Date dt = sdf.parse(strdate);
            toDate = sdf_to.format(dt);
        } catch (ParseException e) {
            System.err.print("字符转换时间错误！");
        } catch (Exception e) {
            System.err.print("时间格式化错误！");
        }
        return toDate;
    }

    /**
     * 当前日期
     *
     * @return yyyy-MM-dd 格式时间
     */
    public static String currentDateString() {

        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE);
        String mDateTime = dateFormat.format(currentTime());
        return mDateTime;
    }

    /**
     * 当前日期时间
     *
     * @return yyyy-MM-dd HH:mm:ss 格式时间
     */
    public static String currentDateTimeString() {

        SimpleDateFormat dateTimeFormat = new SimpleDateFormat(PATTERN_DATETIME);
        String mDateTime = dateTimeFormat.format(currentTime());
        return mDateTime;
    }

    /**
     * 当前日期时间
     *
     * @return java.util.Date类型的当前时间
     */
    public static Date currentTime() {

        return Calendar.getInstance().getTime();
    }

    /**
     * 由指定日期计算指定月数后的日期
     *
     * @return yyyy-MM-dd 格式时间
     * @throws ParseException
     */
    public static String getDateByResetMonth(String datestr, int months) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parseDate(datestr));
        cal.add(Calendar.MONTH, months);
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE);
        String redate = dateFormat.format(cal.getTime());
        return redate;
    }

    /**
     * 由指定日期计算指定月数后的日期
     *
     * @return java.util.Date类型
     * @throws ParseException
     */
    public static Date getDateByResetMonth(Date date, int months) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

    /**
     * 由指定日期计算指定天数后的日期
     *
     * @return yyyy-MM-dd 格式时间
     * @throws ParseException
     */
    public static String getDateByResetDay(String datestr, int days) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parseDate(datestr));
        cal.add(Calendar.DATE, days);
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE);
        String redate = dateFormat.format(cal.getTime());
        return redate;
    }

    /**
     * 日期加天数得到新日期: 如果2012-12-12  加3 为2012-12-15
     *
     * @param date 当前日期
     * @param days 加上相应天数(可以为负数)
     * @return
     */
    public static Date addDayNumsDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    /**
     * 给指定日期加上指定天数后得到的日期
     *
     * @param sDate
     * @param DayNums
     * @return yyyy-MM-dd 格式时间
     */
    public static String addDayNumsDate(String sDate, int DayNums) {
        String mDateTime = "";
        if (sDate == null)
            return null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE);
            Date StartDate = dateFormat.parse(sDate);
            Date endDate = addDayNumsDate(StartDate, DayNums);
//			long lTime = (StartDate.getTime() / 1000) + 60 * 60 * 24 * DayNums;
//			StartDate.setTime(lTime * 1000);
            mDateTime = dateFormat.format(endDate);
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }

        return mDateTime;
    }

    /**
     * 两个指定日期之间相隔的天数
     *
     * @param sDate
     * @param eDate
     * @return 天数
     */
    public static long dateDayInteval(String sDate, String eDate) {
        long day = 0;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE);
            Date StartDate = dateFormat.parse(sDate);
            Date EndDate = dateFormat.parse(eDate);
            day = (EndDate.getTime() - StartDate.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }
        return day;
    }

    /**
     * 根据指定日期确定星期几
     *
     * @param date 日期
     * @return
     * @throws ParseException
     */
    public static String getWeekDay(String date) throws ParseException {
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        Date d = parseDate(date, PATTERN_DATE);
        cal.setTime(d);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 时间比较
     *
     * @param dt1
     * @param dt2
     * @return BIGGER:dt1 > dt2 ;SMALLER: dt1 < dt2 ; SAME: dt1=dt2
     */
    public static int compareDate(Date dt1, Date dt2) {
        if (dt1.getTime() > dt2.getTime()) {
            // dt1 大于 dt2
            return BIGGER;
        } else if (dt1.getTime() < dt2.getTime()) {
            // dt1 小于 dt2;
            return SMALLER;
        } else {
            //相等
            return SAME;
        }
    }

    /**
     * 与系统时间比较
     * @param dt1
     * @return BIGGER:大于系统时间;SMALLER: 小于系统时间 ; SAME: 相等
     */
    public static int compareBySysDate(Date dt1){
        Date dt2 = Calendar.getInstance().getTime();
        if (dt1.getTime() > dt2.getTime()) {
            // dt1 大于 dt2
            return BIGGER;
        } else if (dt1.getTime() < dt2.getTime()) {
            // dt1 小于 dt2;
            return SMALLER;
        } else {
            //相等
            return SAME;
        }
    }


  /*  public static void main(String[] strs) throws ParseException {
        String dt1 = "2015-12-19";
        String dt2 = "2015-12-19 19:00";
        String dt3 = "2015-12-19 19:00:01";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(compareDate(sdf1.parse(dt1), sdf2.parse(dt2)));

    }*/
}
