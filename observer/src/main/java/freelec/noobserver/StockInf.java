package freelec.noobserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

// 비지니스 로직을 선언한 인터페이스
public interface StockInf extends Remote {
    public Stock[] getAllStocks() throws RemoteException;
}
