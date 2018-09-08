package others.reactive;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReactiveStreamsMain {
    private static final Logger LOG = LoggerFactory.getLogger(ReactiveStreamsMain.class);

    public static void main(String[] args) {
        //Observable 역할
        Publisher pub = subscriber -> subscriber.onSubscribe(new Subscription() {
            @Override
            public void request(long l) {
                System.out.println("request - " + l);
                subscriber.onNext(1);
                subscriber.onNext(2);
                subscriber.onComplete();
            }

            @Override
            public void cancel() {

            }
        });

        //Observer 역할
        Subscriber sub = new Subscriber() {
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("onSubscribe");
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Object o) {
                System.out.println("onNext - " + o);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        /*
        문제점: 메인 메서드를 붙잡고 있음.
        - Reactive Streams가 해주고 싶었던 궁극적인 목적은 병렬 프로그래밍을 손쉽게 하기 위해 옵저버 무델을 가져간건데
         */
        pub.subscribe(sub);

        //옵션 - 메인 메서드에서 이런 코드가 직접 뜬다는 건 좀 구조상 그렇다.

//        Executors.newSingleThreadExecutor().execute(new Runnable() {
//            @Override
//            public void run() {
//                pub.subscribe(sub);
//            }
//        });

        System.out.println("exit");
    }
}

