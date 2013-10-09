package freelec.chainofresponsibility.server;

// 주식과 관련된 이벤트를 담당하는 클래스

import java.rmi.RemoteException;

public class StockDealer extends Dealer {


    public StockDealer(Market market) {
        this.market = market;
    }

    // 상위 클래스로부터 재정의함
    public boolean getSolution(Notice notice) {

        boolean flag = false;

        String code = null;

        try {

            // 발생된 이벤트를 분석하여
            code = notice.getCode();

            // 주식과 관련된 이벤트라면
            if (code.equals("Stock++") || code.equals("Stock--")) {

                // 이 이벤트를 처리할 수 있고
                flag = true;

                // 변동된 주식 가격을 참조함
                stocks = wrap.getAllStocks();
            }

        } catch (NullPointerException e) {
            System.out.println("Stock dealer has not been yet");
        }

        // 발생된 이벤트에 대한 처리 여부를 반환함
        return flag;

    }

    // 클라이언트에게 메세지를 통보하는 메소드
    public void sendMessageToClient() {

        try {

            // 이벤트를 클라이언트에 통보함
            market.sendMessageToClient(stocks, Constants.stock);

        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

}



