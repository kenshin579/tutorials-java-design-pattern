package Others.decorator;

public class CashOnlyDeco extends ProductDecorator {
    public CashOnlyDeco(Product p) {
        super(p);
    }

    @Override
    public double cost() {
        return product.cost() * 0.9;
    }

    @Override
    public String getDescription() {
        return product.getDescription() + " + Cash Only DC";
    }
}
