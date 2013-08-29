package youngjin.multiplesingleton;

public class Singleton {
    private static Singleton singleton = null;

    private Singleton() {
        System.out.println("an instance created.");
        slowdown(); // 복수의 인스턴스를 확실히 생성시키기 위해 일부러 속도를 늦춘 것
    }

    /**
     * lazy initialization (lazy loading)의 이
     * new Singleton()을 하기전에 다른 쓰레드가 null 조건문을 체크할지도 모르는 문제점이 있음
     * @return
     */
//    public static Singleton getInstance() {
//        if (singleton == null) {
//            singleton = new Singleton();
//        }
//        return singleton;
//    }

    /**
     * 해결책 1
     */
//    public static synchronized Singleton getInstance() {
//        if (singleton == null) {
//            singleton = new Singleton();
//        }
//        return singleton;
//    }

    /**
     * 해결책 2: double checked locking방법으로 first call일때만 동기화가 일어나도록 함
     */
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (null == singleton) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    private void slowdown() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
