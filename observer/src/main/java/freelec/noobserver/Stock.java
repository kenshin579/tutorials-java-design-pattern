package freelec.noobserver.client;

import java.io.Serializable;

// 테이타 베이스 Stock 테이블에 대한 Wrapper 클래스
public class Stock implements Serializable {

    private String symbol;
    private int price;

    public Stock(String symbol, int price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
