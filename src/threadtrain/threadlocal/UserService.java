package threadtrain.threadlocal;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserService {

    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        LocalDate of = LocalDate.of(1992, 2, 15);
        LocalDateTime localDateTime = of.atStartOfDay();
        long time = Timestamp.valueOf(localDateTime).getTime();
        RandomDate randomDate = new RandomDate(time);

        for(int i=0; i <100; i++){
            int number = i;
            threadPool.submit(() -> {
                String birthDate = new UserService().birthDate(new Date(randomDate.getRandomDate()));
                System.out.println("user id:" + number + " birthDate is " + birthDate);
            });
        }

        threadPool.shutdown();
    }

    public String birthDate(Date date){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }
}
