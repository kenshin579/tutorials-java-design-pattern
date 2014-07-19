package Others.decorator;

public class StubPromotionCode extends ProductDecorator {
    public StubPromotionCode(Product p) {
        super(p);
    }

    @Override
    public double cost() {
        return product.cost() * 0.5;
    }

    @Override
    public String getDescription() {
        return product.getDescription() + " + Student Promotion DC";
    }
}
