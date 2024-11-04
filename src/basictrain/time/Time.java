package basictrain.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *  convert from UTC to local Date and reverse
 */
public class Time {

    public static void main(String[] args) throws ParseException {

        TimeZone timeZone = TimeZone.getDefault();

        System.out.println(timeZone.getDisplayName());
        System.out.println(timeZone.getOffset(System.currentTimeMillis()));


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
        System.out.println(format1.format(date1));
    }
}
