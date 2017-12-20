package others.reactive;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;

public class ReactiveStreamsSubPubOnMain {
    private static final Logger LOG = LoggerFactory.getLogger(ReactiveStreamsSubPubOnMain.class);

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

        //PubSub으로 한번 감싸주는 방식
        Subscriber subOnSub = new Subscriber() {
            @Override
            public void onSubscribe(Subscription subscription) {
                Executors.newSingleThreadExecutor().execute(() -> sub.onSubscribe(subscription));
            }

            @Override
            public void onNext(Object o) {
                Executors.newSingleThreadExecutor().execute(() -> sub.onNext(o));
            }

            @Override
            public void onError(Throwable throwable) {
                Executors.newSingleThreadExecutor().execute(() -> sub.onError(throwable));
            }

            @Override
            public void onComplete() {
                Executors.newSingleThreadExecutor().execute(() -> sub.onComplete());
            }
        };
        Publisher pubOnPub = subscriber -> Executors.newSingleThreadExecutor().execute(() -> pub.subscribe(subOnSub));
        pubOnPub.subscribe(subOnSub); //subscribe를 하게 되면 데이터 처리가 시작됨

        //Flux에서는 publishOn과 subscribeOn 메서드가 이런 일을 해줌
        System.out.println("exit");
    }
}

