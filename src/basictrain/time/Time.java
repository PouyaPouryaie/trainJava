package basictrain.time;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

/**
 *  convert from UTC to local Date and reverse
 */
public class Time {

    public static void main(String[] args) throws ParseException {

        // localDate Library
        LocalDate localDate = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime past10Min = LocalDateTime.now().minusMinutes(10);
        LocalDateTime buildTime = LocalDateTime.of(2020, 2, 1, 20, 22, 30);
        System.out.println(localDate.atTime(10, 10));
        System.out.println(past10Min);
        System.out.println(past10Min.getHour());
        System.out.println(buildTime);
        System.out.println(now.isAfter(past10Min));
        System.out.println(now.compareTo(past10Min));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime parseWithFormatter = LocalDateTime.parse("2024-04-02 10:12:30", dateTimeFormatter);
        System.out.println(parseWithFormatter);

        String dateTimeFormat = LocalDateTime.now().format(dateTimeFormatter);
        System.out.println(dateTimeFormat);

        //timezone
        TimeZone timeZone = TimeZone.getDefault();

        System.out.println(timeZone.getDisplayName());
        System.out.println(timeZone.getOffset(System.currentTimeMillis()));

        //timestamp
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Timestamp epocUTC = Timestamp.valueOf(LocalDateTime.now());

        System.out.printf("timestamp: %s %n", timestamp);
        System.out.printf("epoch UTC: %s %n", epocUTC);

        // I don't know
        final ZoneId zoneId = ZoneId.of("UTC");
        LocalDateTime ldt = LocalDateTime.now();
        OffsetDateTime offsetDateTime = ldt.atZone(zoneId).toOffsetDateTime();
        System.out.printf("as offsetDatetime %s %n", offsetDateTime);

        // change zone
        System.out.printf("UTC as Timestamp %s %n", Timestamp.valueOf(LocalDateTime.now(ZoneOffset.UTC)));
        System.out.printf("UTC as LocalDateTime %s %n", LocalDateTime.now(ZoneOffset.UTC));

        //simpleDateFormatter
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        format.setTimeZone(TimeZone.getTimeZone("Asia/Tehran"));

        Date date = format.parse("2020-04-09 22:00:00.000");
        long millis = date.getTime();
        System.out.println(millis);

        //1586446200000
        Date date1 = new Date(1586451572439L);
        Date date2 = new Date();
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        format1.setTimeZone(TimeZone.getTimeZone("Asia/Tehran"));
        System.out.println(format1.format(date2));
    }
}
