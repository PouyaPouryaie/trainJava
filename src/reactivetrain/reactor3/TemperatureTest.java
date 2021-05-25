package reactivetrain.reactor3;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class TemperatureTest {

    static final Random random = new Random();

    public static void main(String[] args) {

        Flux.just("Esfehan", "Tehran")
                .flatMap(TemperatureTest::getTemperature)
                .subscribe(System.out::println, Throwable::getMessage, () -> System.out.println("is Done"));
    }

    public static Flux<TempInfo> getTemperature(String town){
        List<TempInfo> tempInfos = new ArrayList<>();

        Stream.generate(() -> random.nextInt(100))
                .limit(10)
                .forEach(number -> tempInfos.add(new TempInfo(town, number)));
        return Flux.fromIterable(tempInfos);
    }
}
