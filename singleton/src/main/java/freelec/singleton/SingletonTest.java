package freelec.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton s = Singleton.getSingleton();
        Singleton s1 = Singleton.getSingleton();

//        Singleton s2 = new Singleton();

        System.out.println("s == s1 ? " + (s == s1));
//        System.out.println("s == s2 ? " + (s == s2));
    }
}
