package freelec.chainofresponsiblity.client;// ���� �� ��ϵ� Ŭ���̾�Ʈ �� ��ü�� ����
// ȣ��� �޼ҵ带 ������ �������̽�

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote {

    // ���� �� ����� �ֽ� �ü��� �����ϴ� �޼ҽ�
    public void setAllStocks(Stock stocks[]) throws RemoteException;

    // ���� �� ����� �ֽ� �ü��� �����ϴ� �޼ҽ�
    public void setAllFunds(Fund funds[]) throws RemoteException;

    // ���� �� ����� �ֽ� �ü��� �����ϴ� �޼ҽ�
    public void setAllExchanges(Exchange exchange[]) throws RemoteException;

}
