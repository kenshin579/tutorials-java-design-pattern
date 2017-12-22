package others.reactive.fluxmon;

import reactor.core.publisher.Flux;

public class FluxExample1 {
    public static void main(String[] args) {
        Flux.just("red", "white", "blue")
                .log()
                .map(String::toUpperCase)
                .subscribe(System.out::println);
    }
}
