package com.mright.mq.chapter01;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author : zhaochuanzhen
 * @description :
 * @date : 2020/5/18 10:52
 */
public class QueueDemo {

    public static void main(String[] args) throws ParseException {
        List<String> dateList = new ArrayList<>(16);
        // 西式日期，1为周日，2为周一。此处采用中式日期，周一始，周日止
        for (int i = 1; i <= 7; i++) {
            dateList.add(getOneDayByWeek("yyyyMMdd", i));
        }

        dateList.forEach(date -> {
            System.out.println(date);
        });
    }

    public static String getOneDayByWeek(String formatPatten, Integer week) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf1.parse("2020-05-18"));
        if ("星期日".equals(printWeekDay(cal.getTime()))) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(week);
        int day = cal.get(Calendar.DAY_OF_WEEK);

        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day + 1);
        SimpleDateFormat sdf = new SimpleDateFormat(formatPatten);


        return sdf.format(cal.getTime());
    }

    private static String printWeekDay(Date date) {
        SimpleDateFormat sdw = new SimpleDateFormat("E");
        return sdw.format(date);
    }

    @Test
    public void test(){
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(8);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println(sdf.format(cal.getTime()));
    }

}
