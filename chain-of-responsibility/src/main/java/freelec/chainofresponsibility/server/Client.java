package freelec.chainofresponsibility.server;

// 서버 측에 등록된 클라이언트 측 객체를 통해
// 호출될 메소드를 정의한 인터페이스

import freelec.chainofresponsiblity.client.Exchange;
import freelec.chainofresponsiblity.client.Fund;
import freelec.chainofresponsiblity.client.Stock;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote {

    // 서버 측에서 변경된 주식 시세를 설정하는 메소스
    public void setAllStocks(Stock stocks[]) throws RemoteException;

    // 서버 측에서 변경된 주식 시세를 설정하는 메소스
    public void setAllFunds(Fund funds[]) throws RemoteException;

    // 서버 측에서 변경된 주식 시세를 설정하는 메소스
    public void setAllExchanges(Exchange exchange[]) throws RemoteException;

}
