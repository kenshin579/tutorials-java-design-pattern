package freelec.chainofresponsibility.server;

import freelec.chainofresponsiblity.client.Exchange;
import freelec.chainofresponsiblity.client.Fund;
import freelec.chainofresponsiblity.client.Stock;

public class JulyThread extends Thread {

    private Wrapper wrap;
    private Notice notice;
    private Dealer[] dealer;

    public JulyThread(Dealer[] dealer) {
        wrap = Wrapper.getInstance();
        this.dealer = dealer;
    }

    public Notice getNotice() {
        return notice;
    }

    public void run() {

        while (true) {

            random();

            try {
                sleep(6 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            notifyToDealers();

        }

    }

    public void notifyToDealers() {

        // 변동된 시세를 처리할 것을 명함
        dealer[0].sendMessage(notice);

    }

    // 주식, 펀드, 외환 시세 중 택일하여 시세 변동을 발생시킴
    public void random() {

        int max = 3;
        int min = 1;
        int num = (int) (Math.random() * max + min);

        if (num == 1) {
            randomForStock();
        } else if (num == 2) {
            randomForFund();
        } else if (num == 3) {
            randomForExchange();
        }

    }

    // 주식 시세를 변동시키는 메소드
    public void randomForStock() {

        String code = null;
        Stock stocks[] = wrap.getAllStocks();

        for (int i = 0; i < stocks.length; i++) {
            int current = stocks[i].getCurrent();
            float upndwn = stocks[i].getUpnDwn();
            float upndwnper = stocks[i].getUpnDwnPer();
            int selected = (int) (Math.random() * 10);

            if (selected % 2 == 1) {
                current += selected;
                upndwn += selected;
                upndwnper += selected / 10;
                code = "Stock++";
            } else {
                current -= selected;
                upndwn -= selected;
                upndwnper -= selected / 10;
                code = "Stock--";
            }
            stocks[i].setCurrent(current);
            stocks[i].setUpnDwn(upndwn);
            stocks[i].setUpnDwnPer(upndwnper);
        }

        wrap.setAllStocks(stocks);

        // 주식 시세가 변동되었음을 통보하는 객체를 생성
        notice = new Notice(code);

    }

    // 펀드 시세를 변동시키는 메소드
    public void randomForFund() {

        String code = null;
        Fund funds[] = wrap.getAllFunds();

        for (int i = 0; i < funds.length; i++) {

            int current = funds[i].getCurrent();
            float commision = funds[i].getCommision();
            float daycommision = funds[i].getDayCommision();
            int selected = (int) (Math.random() * 10);

            if (selected % 2 == 1) {
                current += selected;
                commision += selected;
                daycommision += selected;
                code = "Fund++";
            } else {
                current -= selected;
                commision -= selected;
                daycommision -= selected;
                code = "Fund--";
            }

            funds[i].setCurrent(current);
            funds[i].setCommision(commision);
            funds[i].setDayCommision(daycommision);

        }

        wrap.setAllFunds(funds);

        // 펀드 시세가 변동되었음을 통보하는 객체를 생성
        notice = new Notice(code);

    }

    // 외환 시세를 변동시키는 메소드
    public void randomForExchange() {

        String code = null;
        Exchange[] exchanges = wrap.getAllExchanges();

        for (int i = 0; i < exchanges.length; i++) {

            float buy = exchanges[i].getBuy();
            float sell = exchanges[i].getSell();
            float rate = exchanges[i].getRate();
            int selected = (int) (Math.random() * 10);

            if (selected % 2 == 1) {
                buy += selected;
                sell += selected;
                rate += selected / 10;
                code = "Exchange++";
            } else {
                buy -= selected;
                sell -= selected;
                rate -= selected / 10;
                code = "Exchange--";
            }

            exchanges[i].setBuy(buy);
            exchanges[i].setSell(sell);
            exchanges[i].setRate(rate);

        }

        wrap.setAllExchanges(exchanges);

        //외환 시세가 변동되었음을 통보하는 객체를 생성
        notice = new Notice(code);

    }

}
