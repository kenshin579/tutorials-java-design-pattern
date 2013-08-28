package youngjin.prototype.framework;

import java.util.HashMap;

/**
 * Manager 객체에서는 여러 객체(UnderlinePen, MessageBox)를 관리만 해준다.
 */
public class Manager {
    private HashMap showcase = new HashMap();

    public void register(String name, Product proto) {
        showcase.put(name, proto);
    }

    public Product create(String protoname) {
        Product p = (Product) showcase.get(protoname);
        return p.createClone();
    }
}
