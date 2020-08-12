package com.haochang.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private final static Logger logger = LoggerFactory
			.getLogger(DateUtil.class);
	
	public static String toString(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
		return formatter.format(date);   
	}
	
	public static String toStringDate(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date);   
	}
	
	public static String toStringNew(Date date){
		if(date == null){
			return "";
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);   
	}
	
	public static Date toDateNew(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String sdf = formatter.format(date);
		Date dat = null;
		try {
			dat = formatter.parse(sdf);
		} catch (ParseException e) {
			logger.error("toDateNew:日期解析错误",e);
			e.printStackTrace();
		}
		return dat;
	}
	
	/**
     * 两个时间相差距离多少天多少小时多少分多少秒
     * @param str1 时间参数 1 格式：1990-01-01 12:07:00
     * @param str2 时间参数 2 格式：1990-01-01 15:00:00
     * @return String 返回值为：xx天xx小时xx分xx秒
     */
//    public static Double getDistanceTime(String date1, String date2) {
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date one;
//        Date two;
//        long day = 0;
//        long hour = 0;
//        long min = 0;
//        long sec = 0;
//        try {
//            one = df.parse(date1);
//            two = df.parse(date2);
//            long time1 = one.getTime();
//            long time2 = two.getTime();
//            long diff ;
//            if(time1<time2) {
//                diff = time2 - time1;
//            } else {
//                diff = time1 - time2;
//            }
//            day = diff / (24 * 60 * 60 * 1000);
//            hour = (diff / (60 * 60 * 1000) - day * 24);
//            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
//            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return  NumUtil.add(hour,NumUtil.add(NumUtil.div(min,60),NumUtil.div(sec,3600)));
//    }
    
    /**
     * 两个时间相差距离多少天多少小时多少分多少秒
     * @param str1 时间参数 1 格式：1990-01-01 12:07:00
     * @param str2 时间参数 2 格式：1990-01-01 15:00:00
     * @return String 返回值为：xx天xx小时xx分xx秒
     */
    public static Long getDistanceDay(String date1, String date2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date one;
        Date two;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        try {
            one = df.parse(date1);
            two = df.parse(date2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff ;
            if(time1<time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  day;
    }
    
    public static void main(String[] args){
    
    	System.out.print(DateUtil.getDistanceDay("2014-1-01 01:02:15","2014-01-03 01:18:15"));
    }
}
