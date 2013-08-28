package youngjin.prototype;

import youngjin.prototype.framework.Manager;
import youngjin.prototype.framework.Product;

/**
 * Product는 Cloneable interface로 정의를 했음
 * <p/>
 * clone() 메서드를 사용하기 위해서는 다음을 고려해야 함
 * 1. clone은 protected로 선언되어 있으므로 외부에서 호출이 불가능하다.
 * (그래서 다른 객체에서 Cloneable 인터페이스를 상속받아서 재정의를 해야 함)
 * 2. Cloneable 인터페이스가 있는 상태에서 사용이 가능하다.
 */
public class Main {
    public static void main(String[] args) {
        // prepartion
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("strong message", upen);
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);

        // 미리 등록한 객체를 생성한다.
        Product p1 = manager.create("strong message");
        p1.use("Hello, world.");
        Product p2 = manager.create("warning box");
        p2.use("Hello, world.");
        Product p3 = manager.create("slash box");
        p3.use("Hello, world.");
    }
}
