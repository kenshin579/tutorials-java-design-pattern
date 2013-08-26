package freelec.singleton;

public class Singleton {
    // static이기 때문에 클래스의 호출로 메모리에 적재됨
    private static Singleton single = new Singleton();

    /* 은닉성을 적용하여 외부의 클래스로부터의 접근을 막는다.
       - Singleton에서만 객체를 생성할 수 있도록 한다.
     */
    private Singleton() {
    }

    public static Singleton getSingleton() {
        return single;
    }
}
