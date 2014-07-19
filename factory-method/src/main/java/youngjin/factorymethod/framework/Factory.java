package youngjin.factorymethod.framework;

public abstract class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    public final Product create(String owner, String type) {
        Product p = createProduct(owner, type);
        registerProduct(p);
        return p;
    }

    protected abstract Product createProduct(String owner);

    protected abstract Product createProduct(String owner, String type);

    protected abstract void registerProduct(Product product);
}
