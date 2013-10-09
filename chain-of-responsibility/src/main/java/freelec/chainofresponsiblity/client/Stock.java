package freelec.chainofresponsiblity.client;

import java.io.Serializable;

public class Stock implements Serializable {

    private String item;
    private int current;
    private float upndwn;
    private float upndwnper;

    public Stock(String item, int current, float upndwn, float upndwnper) {
        this.item = item;
        this.current = current;
        this.upndwn = upndwn;
        this.upndwnper = upndwnper;
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

    public float getUpnDwn() {
        return upndwn;
    }

    public void setUpnDwn(float upndwn) {
        this.upndwn = upndwn;
    }

    public float getUpnDwnPer() {
        return upndwnper;
    }

    public void setUpnDwnPer(float upndwnper) {
        this.upndwnper = upndwnper;
    }

}
