package freelec.noobserver;

import java.rmi.Naming;

// Rmi 서버 프로그램으로 비즈니스 객체를 제공한다.
public class StockServer {

    public static void main(String args[]) {

        try {
            StockImpl ref = new StockImpl();
            Naming.bind("Stock", ref);
        } catch (java.rmi.AlreadyBoundException e) {
            e.printStackTrace();
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
        } catch (java.rmi.RemoteException e) {
            e.printStackTrace();
        }
        System.out.println("Stock object ready");
    }

}
