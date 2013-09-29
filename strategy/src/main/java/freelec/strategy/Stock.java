package freelec.strategy;

public class Stock {

    private String name;
    private int property;
    private int sale;
    private int profit;
    private int rd;

    public Stock(String name, int property, int sale, int profit, int rd) {
        this.name = name;
        this.property = property;
        this.sale = sale;
        this.profit = profit;
        this.rd = rd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProperty() {
        return property;
    }

    public void setProperty(int property) {
        this.property = property;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getRd() {
        return rd;
    }

    public void setRd(int rd) {
        this.rd = rd;
    }

}
