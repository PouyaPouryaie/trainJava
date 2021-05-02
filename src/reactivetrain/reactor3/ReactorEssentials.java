package reactivetrain.reactor3;


import reactor.core.publisher.Flux;

public class ReactorEssentials {

    public static void main(String[] args) {
        Flux.range(1, 100)
                .repeat()
                .collectList()
                .block();
    }
}
