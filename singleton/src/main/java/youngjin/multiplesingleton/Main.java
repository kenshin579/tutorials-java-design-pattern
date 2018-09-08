package youngjin.multiplesingleton;

/**
 * 같은 Singleton instance을 가져야 하는데 여러번 인스턴스가 만들어진다.
 */
public class Main extends Thread {
    public static void main(String[] args) {
        System.out.println("Start.");
        new Main("A").start();
        new Main("B").start();
        new Main("C").start();
        System.out.println("End.");
    }

    public void run() {
        Singleton obj = Singleton.getInstance();
        System.out.println(getName() + ": obj = " + obj);
    }

    public Main(String name) {
        super(name);
    }
}
