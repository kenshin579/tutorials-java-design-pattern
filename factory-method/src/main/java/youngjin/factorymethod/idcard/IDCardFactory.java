package youngjin.factorymethod.idcard;

import youngjin.factorymethod.framework.Factory;
import youngjin.factorymethod.framework.Product;

import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory {
    private List owners = new ArrayList();

    protected Product createProduct(String owner, String type) {
        Product product = null;

        if (type.equals("company")) {
            return new IDCard(owner);
        } else if (type.equals("health")) {
            return new HealthCard(owner);
        } else {
            System.out.println("invalid card type");
        }

        return product;

    }

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    protected void registerProduct(Product product) {
        if (product instanceof IDCard) {
            owners.add(((IDCard) product).getOwner());
        } else if (product instanceof HealthCard) {
            owners.add(((HealthCard) product).getOwner());
        }

    }

    public List getOwners() {
        return owners;
    }
}
