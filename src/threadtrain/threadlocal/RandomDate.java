package threadtrain.threadlocal;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDate {
    long startDate;
    private final long dateNow = Timestamp.valueOf(LocalDateTime.now()).getTime();

    public RandomDate(long startDate) {
        this.startDate = startDate;
    }

    Long getRandomDate(){
        long random = ThreadLocalRandom
                .current()
                .nextLong(startDate, dateNow);
        return random;
    }
}
