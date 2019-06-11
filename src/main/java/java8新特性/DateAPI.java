package java8新特性;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @Author: fang
 * @Date: 2019/6/11 21:44
 * @Description:
 * Clock
 *Timezones
 * LocalDate
 * LocalDateTime
 *
 * Clock 类提供了访问当前日期和时间的方法，Clock 是时区敏感的，可以用来取代 System.currentTimeMillis() 来获取当前的微秒数。某一个特定的时间点也可以使用 Instant 类来表示，Instant 类也可以用来创建旧版本的java.util.Date 对象。
 *
 * 在新API中时区使用 ZoneId 来表示。时区可以很方便的使用静态方法of来获取到。 抽象类ZoneId（在java.time包中）表示一个区域标识符。 它有一个名为getAvailableZoneIds的静态方法，它返回所有区域标识符。
 *
 * jdk1.8中新增了 LocalDate 与 LocalDateTime等类来解决日期处理方法，同时引入了一个新的类DateTimeFormatter 来解决日期格式化问题。可以使用Instant代替 Date，LocalDateTime代替 Calendar，DateTimeFormatter 代替 SimpleDateFormat
 */
public class DateAPI {

    public static void main(String[] args) {
       // clockDemo();
       // Timezones();
       // LocalDateAndLocalDateTime();
         DateTimeFormatterDemo();


    }

    /**
     * DateTimeFormatter 来解决日期格式化问题
     */
    private static void DateTimeFormatterDemo() {

        String str1 = "2014==04==12 01时06分09秒";
        // 根据需要解析的日期、时间字符串定义解析所用的格式器
        DateTimeFormatter fomatter1 = DateTimeFormatter
                .ofPattern("yyyy==MM==dd HH时mm分ss秒");

        LocalDateTime dt1 = LocalDateTime.parse(str1, fomatter1);
        System.out.println(dt1); // 输出 2014-04-12T01:06:09

        String str2 = "2014$$$四月$$$13 20小时";
        DateTimeFormatter fomatter2 = DateTimeFormatter
                .ofPattern("yyy$$$MMM$$$dd HH小时");
        LocalDateTime dt2 = LocalDateTime.parse(str2, fomatter2);
        System.out.println(dt2); // 输出 2014-04-13T20:00


        //再来看一个使用 DateTimeFormatter 格式化日期的示例
        LocalDateTime rightNow=LocalDateTime.now();
        String date=DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(rightNow);
        System.out.println(date);//2019-03-12T16:26:48.29
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        System.out.println(formatter.format(rightNow));//2019-03-12 16:26:48

    }

    /**
     *  LocalDate 与 LocalDateTime等类来解决日期处理方法
     */
    private static void LocalDateAndLocalDateTime() {


        //localdate
        LocalDate today = LocalDate.now();//获取现在的日期
        System.out.println("今天的日期: "+today);//2019-03-12
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        System.out.println("明天的日期: "+tomorrow);//2019-03-13
        LocalDate yesterday = tomorrow.minusDays(2);
        System.out.println("昨天的日期: "+yesterday);//2019-03-11
        LocalDate independenceDay = LocalDate.of(2019, Month.MARCH, 12);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println("今天是周几:"+dayOfWeek);//TUESDAY
    }


    /**
     * 在新API中时区使用 ZoneId 来表示。时区可以很方便的使用静态方法of来获取到。
     * 抽象类ZoneId（在java.time包中）表示一个区域标识符。 它有一个名为getAvailableZoneIds的静态方法，它返回所有区域标识符
     */
    private static void Timezones() {
        //输出所有区域标识符
        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());// ZoneRules[currentStandardOffset=+01:00]
        System.out.println(zone2.getRules());// ZoneRules[currentStandardOffset=-03:00]
        System.out.println(ZoneId.of("UTC+8"));//
    }


    /**
     * Clock 类提供了访问当前日期和时间的方法，Clock 是时区敏感的，
     * 可以用来取代 System.currentTimeMillis() 来获取当前的微秒数。
     * 某一个特定的时间点也可以使用 Instant 类来表示，
     * Instant 类也可以用来创建旧版本的java.util.Date 对象。
     */
    public static void clockDemo(){

        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);//1552379579043
        Instant instant = clock.instant();
        System.out.println(instant);
        Date legacyDate = Date.from(instant); //2019-03-12T08:46:42.588Z
        System.out.println(legacyDate);//Tue Mar 12 16:32:59 CST 2019

    }

}
