package others.rxjava;

import rx.Observable;

import java.util.Arrays;
import java.util.List;

public class RxJavaSample16 {

    public static void main(String[] args) {

        query("Hello, world!")
                .flatMap(urls -> Observable.from(urls))
                .flatMap(url -> getTitle(url))
                .filter(title -> title != null)
                .take(5)
                .subscribe(title -> System.out.println(title));

    }

    // Returns a List of website URLs based on a text search
    public static Observable<List<String>> query(String text) {
        return Observable.just(Arrays.asList("www.naver.com", "www.google.com", "www.kakao1.com", "www.kakao2.com", "www.kakao3.com", "www.kakao4.com"));
    }

    // Returns the title of a website, or null if 404
    public static Observable<String> getTitle(String URL) {
        return Observable.just("title: " + URL);
    }

}
