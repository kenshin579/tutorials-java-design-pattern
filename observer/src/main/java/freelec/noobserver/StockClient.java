package freelec.noobserver.client;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class StockClient extends Thread {

    private StockInf ref = null;
    private Stock all[];
    private List list;
    private Frame frame;

    public StockClient() {

        // 참조할 NamingServie
        String url = "rmi://127.0.0.1/Stock";

        try {
            // 비즈니스 객체의 참조값
            ref = (StockInf) Naming.lookup(url);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

        frame = new Frame("Stock");
        list = new List();
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );

        frame.add(list);

        try {
            refrash(ref.getAllStocks());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        frame.setBounds((1280 - 80) / 2, (1024 - 100) / 2, 80, 100);
        frame.setVisible(true);

    }

    // 주어진 시간 간격으로 서버에 요청을 보내는 메소드
    public void run() {

        try {
            while (true) {
                sleep(5000);
                // 변경된 주식 시세를 update 한다
                refrash(ref.getAllStocks());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void refrash(Stock all[]) {
        list.removeAll();
        for (int i = 0; i < all.length; i++) {
            String symbol = all[i].getSymbol();
            int price = all[i].getPrice();
            list.add(symbol + "\t" + price);
        }
    }

    // RMI 서버의 비즈니스 객체를 참조하여 메소드를 호출
    public Stock[] getAllStocks() {

        Stock all[] = null;

        try {
            all = ref.getAllStocks();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return all;
    }

    public static void main(String args[]) {
        new StockClient().start();
    }

}


