package freelec.chainofresponsibility.server;

import freelec.chainofresponsiblity.client.Exchange;
import freelec.chainofresponsiblity.client.Fund;
import freelec.chainofresponsiblity.client.Stock;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

// Market interface 를 구현한 클래스
// 실제 클라이언트에게 서비스를 제공하는 클래스
public class MarketImpl extends UnicastRemoteObject implements Market {

    // 클라이언트 객체를 등록될 벡터 객체
    private Vector v;

    public MarketImpl() throws RemoteException {
        v = new Vector();
    }

    // 클라이언트 측에서 호출하여
    // 클라이언트 객체 자신의 ref를 서버 측에 등록함
    public void regist(Client c) {
        v.addElement(c);
    }

    // 이벤트가 발생하면 이를 클라이언트게 통보
    public void sendMessageToClient(Object obj[], String msg) {

        // 등록되어 있는 모든 클라이언트에게 통보할 수 있도록 함
        for (int i = 0; i < v.size(); i++) {

            Client client = (Client) v.elementAt(i);

            // 주식에 관련된 이벤트가 발생하면
            if (msg.equals(Constants.stock)) {

                Stock[] stocks = (Stock[]) obj;

                try {
                    // 클리어언트 측에서는 발생된 이벤트를 반영함
                    client.setAllStocks(stocks);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

                // 펀드에 관련된 이벤트가 발생하면
            } else if (msg.equals(Constants.fund)) {

                Fund[] funds = (Fund[]) obj;

                try {
                    // 클리어언트 측에서는 발생된 이벤트를 반영함
                    client.setAllFunds(funds);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

                // 외환 시장에 관련된 이벤트가 발생하면
            } else if (msg.equals(Constants.exchange)) {

                Exchange[] exchanges = (Exchange[]) obj;

                try {
                    // 클리어언트 측에서는 발생된 이벤트를 반영함
                    client.setAllExchanges(exchanges);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }
        }

    }

}


