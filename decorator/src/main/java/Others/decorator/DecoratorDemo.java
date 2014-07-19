package Others.decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        Product[] products = new Product[4];

        products[0] = new CloudHncOffice();

        products[1] = new StubPromotionCode(new CloudHncOffice());
        products[2] = new CashOnlyDeco(new CloudHncOffice());
        products[3] = new CashOnlyDeco((new StubPromotionCode(new CloudHncOffice())));

        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].getDescription() + " : " + products[i].cost());
        }
    }
}
