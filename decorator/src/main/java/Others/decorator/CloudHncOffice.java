package Others.decorator;


public class CloudHncOffice implements Product {

    @Override
    public double cost() {
        return 289009;
    }

    @Override
    public String getDescription() {
        return "Cloud Hnc Office";
    }
}
