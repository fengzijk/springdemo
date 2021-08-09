package com.fengzijk.springdemo.util;

import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class DateUtil {

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String DATE_PATTERN_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_PATTERN_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String DATE_PATTERN_YTD = "yyyy年MM月dd日";
    public static final String DATE_PATTERN_MD = "MM月dd日";
    public static final String DATE_PATTERN_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    /**
     * 获得当月最大时间 2019-04-30T23:59:59.999999999
     *
     * @author : fengzijk
     * @date : 2019/5/7 17:04
     */
    public static LocalDateTime getMounthEndTime() {
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MAX);
        return startOfDay.with(TemporalAdjusters.lastDayOfMonth());
    }

    public static LocalDateTime getMounthEndTime(LocalDateTime localDateTime) {
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MAX);
        return startOfDay.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 获得当月最小时间 2019-04-30 00:00:00
     *
     * @author : fengzijk
     * @date : 2019/5/7 17:04
     */
    public static LocalDateTime getMounthStartTime() {
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return startOfDay.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获得当月最小时间 2019-04-30 00:00:00
     *
     * @author : fengzijk
     * @date : 2019/5/7 17:04
     */
    public static LocalDateTime getMounthStartTime(LocalDateTime localDateTime) {
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return startOfDay.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获得当天最小时间 2019-04-30 00:00:00
     *
     * @author : fengzijk
     * @date : 2019/5/7 17:04
     */
    public static LocalDateTime getDayStartTime(LocalDateTime localDateTime) {
        return localDateTime.with(LocalTime.MIN);
    }


    /**
     * 将Date转换为LocalDateTime
     *
     * @param date java.util.Date类型的参数
     * @return java.time.LocalDateTime
     * @author: fengzijk
     * @email :guozhifengvip@gmail.com
     * @Date: 2019/5/24 22:12
     */
    public static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 时间戳 转 LocalDateTime
     *
     * @param timestamp 时间戳
     * @return 返回LocalDateTime
     */
    public static LocalDateTime timestamp2LocalDateTime(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId);
    }

    /**
     * <pre> 毫秒数转LocalDateTime</pre>
     *
     * @param str str 毫秒数字符串
     * @return java.time.LocalDateTime
     * @author: fengzijk
     * @email :guozhifengvip@gmail.com
     * @date: 2019/7/23 19:46
     */
    public static LocalDateTime timeMillis2LocalDateTime(String str) {
        Instant instant = Instant.ofEpochMilli(Long.parseLong(str));
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId);
    }

    /**
     * LocalDateTime 转 时间戳
     *
     * @param localDateTime LocalDateTime 类型参数
     * @return 返回时间戳
     */
    public static long localDateTime2Timestamp(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zoneId).toInstant();
        return instant.toEpochMilli();
    }

    /**
     * 时间转为指定格式的字符串
     *
     * @param time    LocalDateTime 类型的参数
     * @param pattern 需要转换的格式类型
     * @return 返回String类型
     */
    public static String time2FormatString(LocalDateTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 指定格式的字符串转为时间
     *
     * @param formatString 字符串
     * @param pattern      需要转换的格式类型
     * @return 返回  LocalDateTime 类型
     */
    public static LocalDateTime formatString2Time(String formatString, String pattern) {
        return LocalDateTime.parse(formatString, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取当前时间加另一个时间后的时间
     *
     * @param number 要加的数字
     * @param unit   单位 eg:ChronoUnit.SECONDS
     * @return LocalDateTime LocalDateTime
     * @author: fengzijk
     * @email :guozhifengvip@gmail.com
     * @Date: 2019/5/24 22:39
     */
    @SuppressWarnings("WeakerAccess")
    public static LocalDateTime getNowAddition(long number, TemporalUnit unit) {
        return LocalDateTime.now().plus(number, unit);
    }

    /**
     * 获取指定时间加另一个时间后的时间
     *
     * @param number 要加的数字
     * @param unit   单位 eg:ChronoUnit.SECONDS
     * @return LocalDateTime LocalDateTime
     * @author lch
     * @date 2019-06-11
     */
    public static LocalDateTime getTimeAddition(LocalDateTime time, long number, TemporalUnit unit) {
        return time.plus(number, unit);
    }

    /**
     * 获取当前时间减去另一个时间后的时间
     *
     * @param number 要加的数字
     * @param unit   单位 eg:ChronoUnit.SECONDS
     * @return LocalDateTime LocalDateTime
     * @author: fengzijk
     * @email :guozhifengvip@gmail.com
     * @Date: 2019/5/24 22:39
     */
    public static LocalDateTime getNowMinus(long number, TemporalUnit unit) {
        return LocalDateTime.now().minus(number, unit);
    }



    /**
     * <pre>计算两个时间相差分钟数/pre>
     * @param startTime start time
     * @param endTime endTime
     * @return java.lang.Long
     * @author: fengzijk
     * @email :guozhifengvip@gmail.com
     * @date: 2019/6/6 8:44
     */
    public static Long getBetweenMinutes(LocalDateTime startTime, LocalDateTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        //相差毫秒数
        long minutes = duration.toMinutes();
        return minutes;
    }



    /**
     * <pre> Date类型格式化LocalDateTime  </pre>
     *
     * @param date data 类型参数
     * @return java.time.LocalDateTime
     * @author: fengzijk
     * @email :guozhifengvip@gmail.com
     * @date: 2019/6/12 13:39
     */
    public static LocalDateTime formartDateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }


    /**
     * @author lvqidong
     * @date 2019/7/4 16:04
     */
    public static String parse(Duration d) {
        StringBuilder stringBuilder = new StringBuilder();
        if (d.toDays() > 0) {
            long day = d.toDays();
            stringBuilder.append(d.toDays() + "天");
            d = d.minusDays(day);
        }
        if (d.toHours() > 0) {
            long h = d.toHours();
            String sh = h < 10 ? "" + h : "" + h;
            stringBuilder.append(sh + "小时");
            d = d.minusHours(h);
        }
        if (d.toMinutes() > 0) {
            long min = d.toMinutes();
            String smin = min < 10 ? "" + min : "" + min;
            stringBuilder.append(smin + "分钟");
        }
        return stringBuilder.toString();
    }


    /**
     * @MethodName:
     * @description: TODO
     * @author lvqidong
     * @date 2019/7/4 16:04
     */
    public static String parseDuration(Duration d) {
        StringBuilder stringBuilder = new StringBuilder();
        if (d.toDays() > 0) {
            long day = d.toDays();
            stringBuilder.append(d.toDays() + "天");
            d = d.minusDays(day);
        }
        if (d.toHours() > 0) {
            long h = d.toHours();
            stringBuilder.append(h + "小时");
            d = d.minusHours(h);
        }
        if (d.toMinutes() > 0) {
            long min = d.toMinutes();
            stringBuilder.append(min + "分钟");
        }
        if (StringUtils.isBlank(stringBuilder.toString())) {
            stringBuilder.append("少于1分钟");
        }
        return stringBuilder.toString();
    }


    
    /**
     * 秒转为天时分秒
     * @author   lvqidong
     * @date  2019/12/11 20:02
     * @params second 秒
     * @return str 时间格式
     */
    public static String secToTime(Long second) {
        //转换天数
        long days = second / 86400;
        //剩余秒数
        second = second % 86400;
        //转换小时数
        long hours = second / 3600;
        //剩余秒数
        second = second % 3600;
        //转换分钟
        long minutes = second / 60;
        //剩余秒数
        second = second % 60;
        if (0 < days){
            return days + "天"+hours+"小时"+minutes+"分"+second+"秒";
        }else {
            StringBuilder sb = new StringBuilder();
           if(hours >0){
               sb.append(hours+"小时");
           }
            if(minutes >0){
                sb.append(minutes+"分");
            }if(second>0){
                sb.append(second+"秒");
            }
            return sb.toString();
        }
    }


    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10) {
            retStr =  Integer.toString(i);
        }
        else {
            retStr = "" + i;
        }
        return retStr;
    }


    public static void main(String[] args) throws InterruptedException {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime endTime1 =  LocalDateTime.parse("2019-12-12 19:56:01",df);
        LocalDateTime endTime2 =  LocalDateTime.parse("2019-12-11 19:48:19",df);
        System.out.println(DateUtil.getCurrentDateTimeMisStr());
    }

    /**
     * <pre> 获取今天的日期  </pre>
     *
     * @return java.time.LocalDateTime
     * @author: fengzijk
     * @email :guozhifengvip@gmail.com
     * @date: 2019/6/12 13:39
     */
    public static String getTodayDateStr() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_PATTERN_YYYYMMDD);
        LocalDateTime time = LocalDateTime.now();
        return df.format(time);
    }

    public static String getLocalDateTimeStr(LocalDateTime dateTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
        return df.format(dateTime);
    }

    public static String getTodayDateTimeStr() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_PATTERN_YYYYMMDDHHMMSS);
        LocalDateTime time = LocalDateTime.now();
        return df.format(time);
    }

    /**
     * 获取当前时间戳-毫秒
     * @return 交接
     */
    public static String getCurrentDateTimeMisStr(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_PATTERN_YYYYMMDDHHMMSSSSS);
        LocalDateTime time = LocalDateTime.now();
        return df.format(time);
    }

    /**
     * 获取给定时间段数组
     * @param startTime
     * @param endTime
     * @return [2019-08-01,2019-08-02,2019-08-03...]
     */
    public static List<String> getDateStrList(LocalDateTime startTime, LocalDateTime endTime){
        Boolean flag = true;
        List<String> result = new ArrayList<>();
        LocalDateTime tmp = startTime;
        if(startTime.compareTo(endTime)>-1){
            result.add(DateUtil.time2FormatString(endTime,DateUtil.DATE_PATTERN));
            return result;
        }
        while(flag){
            if(DateUtil.time2FormatString(tmp,DateUtil.DATE_PATTERN).equals(DateUtil.time2FormatString(endTime,DateUtil.DATE_PATTERN))){
                flag=false;
                result.add(DateUtil.time2FormatString(tmp,DateUtil.DATE_PATTERN));
            }else{
                result.add(DateUtil.time2FormatString(tmp,DateUtil.DATE_PATTERN));
                tmp=DateUtil.getTimeAddition(tmp,1, ChronoUnit.DAYS);
            }
        }
        return result;
    }
}
