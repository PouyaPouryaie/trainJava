package reactivetrain.reactor3;

import reactor.core.publisher.Flux;

public class BasicReactor {

    public static void main(String[] args) {

        Flux<String> hello = Flux.<String>generate(sink -> sink.next("hello")).take(50);
        hello.subscribe(System.out::println);
    }
}
