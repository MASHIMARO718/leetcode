package com.example.leetcode.java8;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.util.regex.Pattern;

/**
 * @ClassName DateTimeDemo
 * @Description TODO
 * @Author mhJiang
 * @Date 2020/12/29 11:01
 * @Version 1.0
 */
public class DateTimeDemo {
    @Test
    public void testClock(){
        //时钟提供给我们用于访问某个特定 时区的 瞬时时间、日期 和 时间的。
        Clock c1 = Clock.systemUTC(); //系统默认UTC时钟(当前瞬时时间 System.currentTimeMillis())
        System.out.println(c1.millis()); //每次调用将返回当前瞬时时间(UTC)
        Clock c2 = Clock.systemDefaultZone(); //系统默认时区时钟(当前瞬时时间)
        System.out.println(c2);
        Clock c31 = Clock.system(ZoneId.of("Europe/Paris")); //巴黎时区
        System.out.println(c31.millis()); //每次调用将返回当前瞬时时间(UTC)
        Clock c32 = Clock.system(ZoneId.of("Asia/Shanghai"));//上海时区
        System.out.println(c32.millis());//每次调用将返回当前瞬时时间(UTC)
        Clock c4 = Clock.fixed(Instant.now(), ZoneId.of("Asia/Shanghai"));//固定上海时区时钟
        System.out.println(c4.millis());
        System.out.println(c4.millis()); //不变 即时钟时钟在那一个点不动
        Clock c5 = Clock.offset(c1, Duration.ofSeconds(2)); //相对于系统默认时钟两秒的时钟
        System.out.println(c1.millis());
        System.out.println(c5.millis());
    }
    @Test
    public void testLocalDateTime(){
        LocalDateTime now = LocalDateTime.now() ;//2020-12-29T11:03:49.994

        LocalDateTime d1 = LocalDateTime.of(2013, 12, 31, 23, 59);//2013-12-31T23:59
        //年月日 时分秒 纳秒
        LocalDateTime d2 = LocalDateTime.of(2013, 12, 31, 23, 59, 59, 11);//2013-12-31T23:59:59.000000011

        LocalDateTime d3 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());//2020-12-29T11:05:33.115

        LocalDateTime d4 = LocalDateTime.parse("2013-12-31T23:59"); //2013-12-31T23:59

        LocalDateTime d5 = LocalDateTime.parse("2013-12-31T23:59:59.999");//2013-12-31T23:59:59.999

        //使用DateTimeFormatter API 解析 和 格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime d6 = LocalDateTime.parse("2013-12-31T23:59:59.999", formatter); //2013/12/31 23:59:59

        //时间增减
        LocalDateTime d7 = d6.minusDays(1);//2013-12-30T23:59:59
        LocalDateTime d8 = d7.plusYears(1);//2014-12-30T23:59:59
        System.out.println(d6);
        System.out.println(d8);
    }
    @Test
    public void te(){
        try {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-10-24 10:20:11.10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
