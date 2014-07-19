package Others.decorator;

abstract class ProductDecorator implements Product {
    protected Product product;

    public ProductDecorator(Product p) {
        product = p;
    }

}
