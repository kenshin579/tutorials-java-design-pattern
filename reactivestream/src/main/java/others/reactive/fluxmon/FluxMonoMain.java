package others.reactive.fluxmon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class FluxMonoMain {
    private static final Logger LOG = LoggerFactory.getLogger(FluxMonoMain.class);

    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== Empty Mono ===");
        Mono.empty().subscribe(System.out::println);

        System.out.println("=== Mono.just ===");
        Mono.just("JSA")
                .map(item -> "Mono item: " + item)
                .subscribe(System.out::println);

        System.out.println("=== Empty Flux ===");
        Flux.empty()
                .subscribe(System.out::println);

        System.out.println("=== Flux.just ===");
        Flux.just("Java", "Sample", "Approach", ".com")
                .map(item -> item.toUpperCase())
                .subscribe(System.out::print);

        System.out.println("\n=== Flux from List ===");
        List<String> list = Arrays.asList("JAVA", "SAMPLE", "APPROACH", ".COM");
        Flux.fromIterable(list)
                .map(item -> item.toLowerCase())
                .subscribe(System.out::print);

        System.out.println("\n=== Flux emits increasing values each 100ms ===");
        Flux.interval(Duration.ofMillis(100))
                .map(item -> "tick: " + item)
                .take(10)
                .subscribe(System.out::println);

        Thread.sleep(1500);

        System.out.println("=== Mono emits an Exception ===");
        Mono.error(new CustomException("Mono"))
                .doOnError(e -> {
                    System.out.println("inside Mono doOnError()");
                })
                .subscribe(System.out::println);

        System.out.println("=== Flux emits an Exception ===");
        Flux.error(new CustomException("Flux"))
                .subscribe(System.out::println);
    }
}

