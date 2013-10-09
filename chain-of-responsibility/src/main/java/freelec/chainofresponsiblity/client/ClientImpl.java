package freelec.chainofresponsiblity.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// this class must be on client side
public class ClientImpl extends UnicastRemoteObject implements Client {

    protected Market market;

    // GUI ������ ����ϴ� director Ŭ����
    protected Director director;

    private static ClientImpl instance;

    private ClientImpl() throws RemoteException {

        // remote object ��ü�� ����

        try {

            String url = "rmi://127.0.0.1/Chain";
            market = (Market) Naming.lookup(url);

            // Ŭ���̾�Ʈ ��ü�� ���� �� ���
            market.regist(this);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public static ClientImpl getInstance() {
        try {
            instance = new ClientImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return instance;
    }

    // ���� �� ȣ��Ǿ� ������ �ֽ� ������ Ŭ���̾� �� ������
    public void setAllStocks(Stock[] stocks) {

        director = new Director(new StockBuilder(stocks));

        // �����Ǵ� �ֽ� �������� GUI �� ����
        director.build();

    }

    // ���� �� ȣ��Ǿ� ���� Fund ������ Ŭ���̾�Ʈ �� ������
    public void setAllFunds(Fund funds[]) {

        director = new Director(new FundBuilder(funds));

        // �����Ǵ� Fund �������� GUI �� ����
        director.build();

    }

    // ���� �� ȣ��Ǿ� ������ ��ȯ �ü��� Ŭ���̾� �� ������
    public void setAllExchanges(Exchange exchanges[]) {

        director = new Director(new ExchangeBuilder(exchanges));

        // �����Ǵ� ��ȯ�ü��� GUI �� ����
        director.build();

    }

    public static void main(String args[]) {
        try {
            new ClientImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
