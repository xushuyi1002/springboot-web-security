package com.sinosoft.util;

import com.sinosoft.common.CommonUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by xushuyi on 2017/3/9.
 */
public class DateUtil {

    public static final String YMD = "yyyyMMdd";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YMDHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String YMDHMSS = "yyyy-MM-dd HH:mm:ss,SSS";
    public static final String YYYY_year_MM_month_DD_day = "yyyy年MM月dd日";
    public static final String HHMMSS = "HH:mm:ss";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String YYYYMMDDHHMMSSS = "yyyyMMddHHmmssSSS";
    public static final String TYPE_NUM_BY_BIRTHDAY_YEAR = "year";
    public static final String TYPE_NUM_BY_BIRTHDAY_MONTH = "month";
    public static final String TYPE_NUM_BY_BIRTHDAY_DAY = "day";


    /**
     * 将字符串转换为指定日期格式
     *
     * @param str        字符串
     * @param dateFormat 日期格式
     * @return
     */
    public static Date convertStringToDate(String str, String dateFormat) {
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        try {
            return sf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取年份
     */
    public static int getYear(Date date) {
        Calendar calendar = setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    private static Calendar setTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }


    /**
     * 获取月份
     */
    public static int getMonth(Date date) {
        Calendar calendar = setTime(date);
        return calendar.get(Calendar.MONTH);
    }

    /**
     * 获取当前的日期
     *
     * @return
     */
    public static String currentDate() {
        return currentDate("yyyy-MM-dd");
    }

    /**
     * 获取当前日期（指定日期格式）
     *
     * @param dateFormat
     * @return
     */
    public static String currentDate(String dateFormat) {
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        String currentDate = sf.format(new Date());
        return currentDate;
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return
     */
    public static String convertDate(Date date) {
        return convertDate(date, "yyyy-MM-dd");
    }

    public static String convertDate(Date date, String dateFormat) {
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        String currentDate = sf.format(date);
        return currentDate;
    }

    public static Date getDate() {
        Date date = new Date();
        return date;
    }

    /**
     * 获取秒
     *
     * @param value
     * @return
     */
    private static Pattern SYH_PATTERN = Pattern.compile(":");

    public static int getSecond(String value) {
        StringTokenizer s = new StringTokenizer(value, ":");
        int type = s.countTokens() - 1;
        int result = 0;
        if (type == 0) {
            result = Integer.parseInt(value);
        }
        if (type == 1) {
            String[] strValue = SYH_PATTERN.split(value);
            result = Integer.parseInt(strValue[0]) * 60
                    + Integer.parseInt(strValue[1]);
        }
        if (type == 2) {
            String[] strValue = SYH_PATTERN.split(value);
            result = Integer.parseInt(strValue[0]) * 3600
                    + Integer.parseInt(strValue[1]) * 60
                    + Integer.parseInt(strValue[2]);
        }
        return result;
    }

    public static String getNumByBirthday(Date birthday, String flag) {
        String Num = null;
        String birthdayStr = convertDate(birthday, "yyyy-MM-dd");
        if (!CommonUtil.isEmpty(birthdayStr)) {
            String[] birthdaySplit = birthdayStr.split("-");
            if ((birthdaySplit != null) && (birthdaySplit.length == 3)) {
                if ("year".equals(flag)) {
                    Num = birthdaySplit[0];
                }
                if ("month".equals(flag)) {
                    Num = birthdaySplit[1];
                }
                if ("day".equals(flag)) {
                    Num = birthdaySplit[2];
                }
            }
        }
        return Num;
    }

    public static Date chgDate(Date startDate, int y, int m, int d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(1, y);
        cal.add(2, m);
        cal.add(5, d);
        return cal.getTime();
    }

    public static Date chgDate(String startDate, String pattern, int y, int m,
                               int d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(convertStringToDate(startDate, pattern));
        cal.add(1, y);
        cal.add(2, m);
        cal.add(5, d);
        return cal.getTime();
    }

    /**
     * 获取指定过去N个月是几月
     */
    public static int getLastMonth(int i) {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.MONTH, -i);
        return date.get(Calendar.MONTH);
    }


    /**
     * 获取当日往前推6天的日期点
     *
     * @param startDate
     * @return
     */
    public static Date rollDate(Date startDate) {
        Calendar date = Calendar.getInstance();
        date.setTime(startDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) - 6);
        return date.getTime();
    }

    /**
     * 获取当日往后推N天的日期点
     *
     * @param startDate
     * @return
     */
    public static Date laterDate(Date startDate, Integer days) {
        Calendar date = Calendar.getInstance();
        date.setTime(startDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) + days);
        return date.getTime();
    }

    /**
     * 获取当日往前推一周的日期点
     *
     * @param startDate
     * @return
     */
    public static Date rollWeek(Date startDate) {
        Calendar date = Calendar.getInstance();
        date.setTime(startDate);
        date.add(Calendar.WEEK_OF_YEAR, -1);
        return date.getTime();
    }

    /**
     * 获取当日往前推一月的日期点
     *
     * @param startDate
     * @return
     */
    public static Date rollMonth(Date startDate) {
        Calendar date = Calendar.getInstance();
        date.setTime(startDate);
        date.add(Calendar.MONTH, -1);
        return date.getTime();
    }

    /**
     * 获取当前月份
     */
    public static int currentMonth() {
        Calendar date = Calendar.getInstance();
        return date.get(Calendar.MONTH);
    }

    /**
     * 获取当日往前推一年的日期点
     *
     * @param startDate
     * @return
     */
    public static Date rollYear(Date startDate) {
        Calendar date = Calendar.getInstance();
        date.setTime(startDate);
        date.add(Calendar.YEAR, -1);
        return date.getTime();
    }

    public static String dateAdd(Date targetDate, String format, int dateNum,
                                 String unit) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat(format);
        cal.setTime(targetDate);
        if ("Y".equals(unit)) {
            cal.add(1, dateNum);
        } else if ("M".equals(unit)) {
            cal.add(2, dateNum);
        } else if ("D".equals(unit)) {
            cal.add(5, dateNum);
        }
        return df.format(cal.getTime());
    }

    public static String dateAddNoCriticality(Date targetDate, String format,
                                              int dateNum, String unit) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat(format);
        cal.setTime(targetDate);
        if ("Y".equals(unit)) {
            cal.add(1, dateNum - 1);
        } else if ("M".equals(unit)) {
            cal.add(2, dateNum);
        } else if ("D".equals(unit)) {
            cal.add(5, dateNum);
        }
        cal.add(5, 1);
        return df.format(cal.getTime());
    }

    public static Date getStartDate(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);

        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);

        return calendar.getTime();
    }

    /**
     * 得到当前的时间，不包含年、月、日
     *
     * @return
     */
    public static String getNowTime() {
        String pattern = "HH:mm:ss";
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Date today = new Date();
        String tString = df.format(today);
        return tString;
    }

    /**
     * 将日期以简单日期String格式(yyyy-MM-dd)输出
     *
     * @param date
     * @return
     */
    public static String simpleDateStr(Date date) {
        if (date != null) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");// DateFormat.getDateInstance();
            return df.format(date);
        } else {
            return null;
        }
    }

    /**
     * 将格式为yyyy-MM-dd HH:mm:ss的String转换为Date类型
     *
     * @param dateStr
     * @return
     */
    public static Date hmsSrToDate(String dateStr) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getNowDate() {
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH) + 1;
        int date = ca.get(Calendar.DAY_OF_MONTH);
        String dateStr = "" + year + "-" + month + "-" + date;
        DateFormat df = DateFormat.getDateInstance();
        Date newDate = null;
        try {
            newDate = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }

    /**
     * 根据出身日期获取年龄
     *
     * @param birthDate 出生日期
     * @return int
     */
    public static int getAge(Date birthDate) {
        if (birthDate == null) {
            throw new RuntimeException("出生日期不能为null");
        }
        int age = 0;
        Date now = new Date();
        SimpleDateFormat format_y = new SimpleDateFormat("yyyy");
        SimpleDateFormat format_M = new SimpleDateFormat("MM");
        String birth_year = format_y.format(birthDate);
        String this_year = format_y.format(now);
        String birth_month = format_M.format(birthDate);
        String this_month = format_M.format(now);
        // 初步，估算
        age = Integer.parseInt(this_year) - Integer.parseInt(birth_year);
        // 如果未到出生月份，则age - 1
        if (this_month.compareTo(birth_month) < 0) {
            age -= 1;
        }
        if (age < 0) {
            age = 0;
        }
        return age;
    }

    /**
     * 根据日期计算出年龄（明细到日）
     *
     * @param birthDay
     * @return
     * @throws Exception
     */
    public static int getAgeInfo(Date birthDay) throws Exception {

        if (birthDay == null) {
            throw new RuntimeException("出生日期不能为null");
        }

        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                age--;
            }
        }
        return age;
    }

    /**
     * 比较两个日期
     *
     * @param DATE1 日期1
     * @param DATE2 日期2
     * @return
     */
    public static int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 比较两个日期
     *
     * @param dt1 日期1
     * @param dt2 日期2
     * @return int
     */
    public static int compareDate(Date dt1, Date dt2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (dt1.getTime() > dt2.getTime()) {

                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取当日往前推1天的日期点
     *
     * @param startDate 开始时间
     * @return date
     */
    public static Date yesterdayDate(Date startDate) {
        Calendar date = Calendar.getInstance();
        date.setTime(startDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
        return date.getTime();
    }

    /**
     * 获取指定日期往前推N天的日期点
     *
     * @param startDate 指定日期
     * @param num       往前推N天
     * @return date
     */
    public static Date forwardDate(Date startDate, Integer num) {
        Calendar date = Calendar.getInstance();
        date.setTime(startDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) - num);
        return date.getTime();
    }

    /**
     * 获取给定日期的开始时间
     *
     * @param date
     * @return
     */
    public static Date getBegainOfDate(Date date) {
        Calendar today = Calendar.getInstance();
        today.setTime(date);
        setToBegainOfDate(today);
        return today.getTime();
    }

    private static void setToBegainOfDate(Calendar today) {
        today.set(Calendar.HOUR_OF_DAY, 23);
        today.set(Calendar.MINUTE, 59);
        today.set(Calendar.SECOND, 59);
        today.add(Calendar.DAY_OF_MONTH, -1);
    }

    private static void setToBegainOfThisDate(Calendar today) {
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.add(Calendar.DAY_OF_MONTH, -1);
    }

    /**
     * 获取给定时间的结束时间
     *
     * @param date
     * @return
     */
    public static Date getEndOfDate(Date date) {
        Calendar today = Calendar.getInstance();
        today.setTime(date);
        setEndOfDate(today);
        return today.getTime();
    }


    public static Date getEndOfLastDate(Date date) {
        Calendar today = Calendar.getInstance();
        today.setTime(date);
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 00);
        today.set(Calendar.SECOND, 00);
        // today.add(Calendar.DAY_OF_MONTH,-1);
        return today.getTime();
    }

    private static void setEndOfDate(Calendar today) {
        today.set(Calendar.HOUR_OF_DAY, 23);
        today.set(Calendar.MINUTE, 59);
        today.set(Calendar.SECOND, 59);
    }


    /**
     * 获取0点
     */
    public static Date zero(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取凌晨1点
     */
    public static Date firstdate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static Date testDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 17);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date testlasthourDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 18);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 获取今天开始的一秒（前一天的最后一秒）
     *
     * @return
     */
    public static Date getBegainOfToday() {
        return getBegainOfDate(new Date());
    }


    /**
     * 获取今天最后一秒
     *
     * @return
     */
    public static Date getEndOfToday() {
        return getEndOfDate(new Date());
    }

    public static Date getEndOfLastday() {
        return getEndOfLastDate(new Date());
    }

    /**
     * 获取给定日期 date的下一天
     *
     * @param date
     * @return
     */
    public static Date getNextDate(Date date) {
        Calendar today = Calendar.getInstance();
        today.setTime(date);
        today.add(Calendar.DAY_OF_MONTH, 1);
        return today.getTime();

    }

    /**
     * 获取某月的1号
     *
     * @param date
     * @return
     */
    public static Date getFirstofMonth(Date date) {
        Calendar today = Calendar.getInstance();
        today.setTime(date);
        today.set(Calendar.DAY_OF_MONTH, 1);
        today.add(Calendar.MONTH, 0);
        return today.getTime();
    }

    /**
     * 获取某天的前N天
     *
     * @param date
     * @param i
     * @return
     */
    public static Date getLastDate(Date date, int i) {
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        day.set(Calendar.HOUR_OF_DAY, 0);
        day.set(Calendar.MINUTE, 00);
        day.set(Calendar.SECOND, 00);
        day.add(Calendar.DAY_OF_MONTH, -i);
        return day.getTime();
    }

    public static Date getStartOfWeek() {
        Calendar cal = Calendar.getInstance();


        int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        cal.add(Calendar.DATE, -day_of_week + 1);
        setToBegainOfDate(cal);
        return cal.getTime();
    }

    public static Date getEndOfWeek() {
        Calendar cal = Calendar.getInstance();


        int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        cal.add(Calendar.DATE, -day_of_week + 7);
        setEndOfDate(cal);
        return cal.getTime();
    }

    /**
     * 获取下一个月
     */
    public static Date getNextMonth(Date date) {
        Calendar today = Calendar.getInstance();
        today.setTime(date);
        today.add(Calendar.MONTH, 1);
        return today.getTime();
    }

    /**
     * 获取下一年
     *
     * @param date
     * @return
     */
    public static Date getNextYear(Date date) {
        Calendar today = Calendar.getInstance();
        today.setTime(date);
        today.add(Calendar.YEAR, 1);
        return today.getTime();
    }

    /**
     * 获取某月最后一天
     */
    public static Date getEndOfMonthDate(Date date) {
        Calendar today = Calendar.getInstance();
        today.setTime(date);
        today.add(Calendar.MONTH, 1);
        today.set(Calendar.DAY_OF_MONTH, 0);
        setEndOfDate(today);
        return today.getTime();
    }

    /**
     * 获取当某月第一天
     */
    public static Date getStartOfMonthDate(Date date) {
        Calendar today = Calendar.getInstance();
        today.setTime(date);
        today.set(Calendar.DAY_OF_MONTH, 1);
        setToBegainOfDate(today);
        return today.getTime();
    }

    /**
     * 获取当前月最后一天
     */
    public static Date getEndOfMonth() {

        return getEndOfMonthDate(new Date());
    }

    /**
     * 获取当前月第一天
     */
    public static Date getStartOfMonth() {
        return getStartOfMonthDate(new Date());
    }


    /**
     * 获取之前N个月最后一天
     */
    public static Date getEndOfMonth(int i) {
        Calendar today = Calendar.getInstance();

        today.add(Calendar.MONDAY, -i);
        today.set(Calendar.DAY_OF_MONTH, 0);
        setEndOfDate(today);

        return today.getTime();
    }

    /**
     * 获取之前N个月第一天
     */
    public static Date getStartOfMonth(int i) {
        Calendar today = Calendar.getInstance();

        today.add(Calendar.DAY_OF_MONTH, -1);
        today.add(Calendar.MONDAY, -i);
        setToBegainOfDate(today);

        return today.getTime();
    }

    /**
     * 获取前n 年的第一天日期
     *
     * @param n 年份
     * @return Date
     */
    public static Date getLastYearFirst(int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.add(Calendar.YEAR, -n);
        return calendar.getTime();
    }

    /**
     * 获取某年第一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        setToBegainOfDate(calendar);
        return calendar.getTime();
    }

    public static Date getFistYearDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2017);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    /**
     * 获取当年的第一天
     *
     * @return
     */
    public static Date getCurrYearFirst() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }

    /**
     * 获取某年最后一天日期
     *
     * @return Date
     */
    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        setEndOfDate(calendar);
        return calendar.getTime();
    }

    /**
     * 获取当年的最后一天
     *
     * @return
     */
    public static Date getCurrYearLast() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    private static final int FIRST_DAY = Calendar.MONDAY;


    private static Map<String, Date> printWeekdays() {
        Map<String, Date> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        setToFirstDay(calendar);
        printDay(calendar);
        map.put("Mindate", calendar.getTime());
        calendar.add(Calendar.DATE, 6);
        printDay(calendar);
        map.put("MaxDate", calendar.getTime());
        System.out.print(map);
        return map;

    }

    /**
     * 得出本周起始和末的日期
     *
     * @return
     */
    public static Map<String, String> getDataDate() {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, Date> list = printWeekdays();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date minDate = list.get("Mindate");
        Date maxDate = list.get("MaxDate");
        map.put("MinDate", dateFormat.format(minDate));
        map.put("MaxDate", dateFormat.format(maxDate));
        System.out.print(map);
        return map;
    }


    private static void setToFirstDay(Calendar calendar) {
        while (calendar.get(Calendar.DAY_OF_WEEK) != FIRST_DAY) {
            calendar.add(Calendar.DATE, -1);
        }
    }

    private static void printDay(Calendar calendar) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(calendar.getTime()));
    }

    /**
     * 取本周7天的第一天（周一的日期）
     *
     * @return
     */
    public static String getNowWeekBegin() {
        int mondayPlus;
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
        if (dayOfWeek == 1) {
            mondayPlus = 0;
        } else {
            mondayPlus = 1 - dayOfWeek;
        }
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday + " 00:00:00";
    }

    /**
     * 取本周7天的第一天,时间类型（周一的日期）
     *
     * @return
     */
    public static Date getNowWeekBeginDate() {
        return convertStringToDate(getNowWeekBegin(), "yyyy-MM-dd");
    }

    public static Date getCurrYearFirst(Date date) {
        Calendar currCal = Calendar.getInstance();
        currCal.setTime(date);

        return getYearFirst(currCal.get(Calendar.YEAR));
    }

    public static Date getCurrYearLast(Date date) {
        Calendar currCal = Calendar.getInstance();
        currCal.setTime(date);
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    public static Date getStartOfThisWeek() {
        Date date = getStartOfWeek();
        Calendar currCal = Calendar.getInstance();
        currCal.setTime(date);
        setToBegainOfThisDate(currCal);
        currCal.add(Calendar.DAY_OF_MONTH, 2);
        return currCal.getTime();
    }

    public static Date getEndOfThisWeek() {
        Date date = getEndOfWeek();
        Calendar currCal = Calendar.getInstance();
        currCal.setTime(date);
        currCal.set(Calendar.HOUR_OF_DAY, 1);
        return currCal.getTime();
    }

    public static Date getStartOfThisMonth() {
        Date date = getStartOfMonth();
        Calendar currCal = Calendar.getInstance();
        currCal.setTime(date);
        setToBegainOfThisDate(currCal);
        currCal.add(Calendar.DAY_OF_MONTH, 2);
        return currCal.getTime();
    }

    public static Date getEndOfThisMonth() {
        return getEndOfMonth();
    }

    /**
     * 获取当前月的第一天
     *
     * @return
     */
    public static Date getCurrThisYearFirst() {
        Date date = getCurrYearFirst();
        Calendar currCal = Calendar.getInstance();
        currCal.setTime(date);
        setToBegainOfThisDate(currCal);
        currCal.add(Calendar.DAY_OF_MONTH, 2);
        return currCal.getTime();
    }

    /**
     * 获取当前月最后一天
     *
     * @return
     */
    public static Date getCurrThisYearLast() {
        Date date = getCurrYearLast();
        Calendar currCal = Calendar.getInstance();
        currCal.setTime(date);
        currCal.set(Calendar.HOUR_OF_DAY, 1);
        return currCal.getTime();
    }

    /**
     * 获取项目开始的日期
     *
     * @return date
     */
    public static Date getProjectStart() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, 0, 1, 0, 0);
        return calendar.getTime();
    }

    /**
     * 获取两个日期相差的天数
     *
     * @param date1 被减数日期
     * @param date2 减数日期
     * @return days
     * @throws ParseException E
     */
    public static int getDateSpace(String date1, String date2)
            throws ParseException {
        int result = 0;
        Calendar calst = Calendar.getInstance();
        Calendar caled = Calendar.getInstance();
        calst.setTime(DateUtil.convertStringToDate(date1, DateUtil.YYYY_MM_DD));
        caled.setTime(DateUtil.convertStringToDate(date2, DateUtil.YYYY_MM_DD));
        //设置时间为0时
        calst.set(Calendar.HOUR_OF_DAY, 0);
        calst.set(Calendar.MINUTE, 0);
        calst.set(Calendar.SECOND, 0);
        caled.set(Calendar.HOUR_OF_DAY, 0);
        caled.set(Calendar.MINUTE, 0);
        caled.set(Calendar.SECOND, 0);
        //得到两个日期相差的天数
        int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst.getTime().getTime() / 1000)) / 3600 / 24;
        return days;
    }

    /**
     * 将时间戳转为日期
     *
     * @param timestmp
     * @return
     */
    public static String stampToDate(Long timestmp) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long lt = new Long(timestmp);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 日期格式化
     *
     * @param date   传入日期
     * @param format 格式
     * @return
     */
    public static Date formatDate(Date date, String format) {
        return DateUtil.convertStringToDate(DateUtil.convertDate(date), format);
    }

    /**
     * 上周开始时间
     *
     * @param date 日期
     * @return date
     */
    public static Date getLastWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday(date));
        cal.add(Calendar.DATE, -5);
        setToBegainOfThisDate(cal);
        return cal.getTime();
    }

    /**
     * 上周结束的日期
     *
     * @param date 日期
     * @return date
     */
    public static Date getLastWeekSunday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday(date));
        cal.add(Calendar.DATE, 0);
        setEndOfDate(cal);
        return cal.getTime();
    }

    /**
     * 获取本周的周一
     *
     * @param date 时间
     * @return date
     */
    public static Date getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        setToBegainOfThisDate(cal);
        return cal.getTime();
    }
}
