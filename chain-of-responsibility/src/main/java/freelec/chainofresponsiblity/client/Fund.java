package freelec.chainofresponsiblity.client;

import java.io.Serializable;

public class Fund implements Serializable {

    private String item;
    private int current;
    private float commision;
    private float daycommision;

    public Fund(String item, int current, float commision, float daycommision) {
        this.item = item;
        this.current = current;
        this.commision = commision;
        this.daycommision = daycommision;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public float getCommision() {
        return commision;
    }

    public void setCommision(float commision) {
        this.commision = commision;
    }

    public float getDayCommision() {
        return daycommision;
    }

    public void setDayCommision(float daycommision) {
        this.daycommision = daycommision;
    }

}
