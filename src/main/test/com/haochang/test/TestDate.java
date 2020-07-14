package com.haochang.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: TestDate
 * @Description TODO
 * @Author: youzhi.gao
 * @Date: 2020-01-10 11:27
 * @Version 1.0.0
 */
public class TestDate {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Calendar calendar = Calendar.getInstance();
        // 2019-12-31
        calendar.set(2019, Calendar.DECEMBER, 31);
        Date strDate1 = calendar.getTime();
        // 2020-01-01
        calendar.set(2020, Calendar.JANUARY, 1);
        Date strDate2 = calendar.getTime();
        // 大写 YYYY
        SimpleDateFormat formatYYYY = new SimpleDateFormat("YYYY/MM/DD");
        System.out.println("2019-12-31 转 YYYY/MM/dd 格式: " + formatYYYY.format(strDate1));
        System.out.println("2020-01-01 转 YYYY/MM/dd 格式: " + formatYYYY.format(strDate2));
        // 小写 YYYY
        SimpleDateFormat formatyyyy = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("2019-12-31 转 yyyy/MM/dd 格式: " + formatyyyy.format(strDate1));
        System.out.println("2020-01-01 转 yyyy/MM/dd 格式: " + formatyyyy.format(strDate2));
    }
}
