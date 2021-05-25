package reactivetrain.reactor3;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactorEssentials {

    public static void main(String[] args) {

        //basic - start reactor
        Flux.range(1, 100)
                .subscribe(System.out::println);

        //basic - flux
        Flux.range(1, 10)
                .subscribe(System.out::println,
                        Throwable::getMessage,
                        () -> System.out.println("show data is Done"));

        //basic - mono - sum number and show
        Mono.fromCallable(ReactorEssentials::calculate)
                .subscribe(System.out::println);
    }

    public static int calculate(){
        int result = 0;
        for(int i=0; i <= 100; i++){
            result += i;
        }
        return result;
    }
}
