package freelec.chainofresponsibility.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class MarketServer {

    public static void main(String args[]) {

        // Rmiregistry 에 remote object 를 생성
        Market marketRef = null;

        try {
            marketRef = new MarketImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        // 발생되는 이벤트를 처리할 수 있는 객체들을 생성하고
        Dealer dealers[] =
                {
                        new StockDealer(marketRef),
                        new FundDealer(marketRef),
                        new ExchangeDealer(marketRef)
                };


        // 발생된 이벤트를 처리하지 못할 경우를 위해
        for (int i = 0; i < dealers.length - 1; i++) {
            // 이 이벤트 처리를 다음 dealer에게 위임함
            dealers[i].setNextDealer(dealers[i + 1]);
        }


        // rmiregistry 에 remote object를 등록
        try {
            Naming.rebind("Chain", marketRef);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // 시물레이션 가동
        JulyThread july = new JulyThread(dealers);
        july.start();

        System.out.println("server starting");

    }

}

