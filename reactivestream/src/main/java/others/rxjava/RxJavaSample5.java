package others.rxjava;

import rx.Observable;

public class RxJavaSample5 {

    public static void main(String[] args) {

        Observable.just("Hello, world!")
                .map(s -> s + " -Dan")
                .subscribe(s -> System.out.println(s));

    }

}
