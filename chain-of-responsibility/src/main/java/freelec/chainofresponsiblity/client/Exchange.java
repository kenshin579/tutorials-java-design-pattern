package freelec.chainofresponsiblity.client;

import java.io.Serializable;

public class Exchange implements Serializable {

    private String item;
    private float buy;
    private float sell;
    private float rate;

    public Exchange(String item, float buy, float sell, float rate) {
        this.item = item;
        this.buy = buy;
        this.sell = sell;
        this.rate = rate;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public float getBuy() {
        return buy;
    }

    public void setBuy(float buy) {
        this.buy = buy;
    }

    public float getSell() {
        return sell;
    }

    public void setSell(float sell) {
        this.sell = sell;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

}
