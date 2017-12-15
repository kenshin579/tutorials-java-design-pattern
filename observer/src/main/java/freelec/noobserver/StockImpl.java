package freelec.noobserver.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

// 실질적인 비즈니스 로직을 구현해 놓은 클래스
public class StockImpl extends UnicastRemoteObject implements StockInf {

    ObjectPool pool;
    ObjectPoolIF pool_factory;

    // 객체의 생성과 더블어 ConnectionPool을 생성한다.
    public StockImpl() throws RemoteException {
        pool_factory = ObjectPoolImpl.getInstance();
        pool = pool_factory.getObjectPool("mysql");
    }

    // 주식 시세를 알아보기 위해 호출하는 메소드
    // 인터페이스에 선언된 비즈니스 로직
    public Stock[] getAllStocks() {

        Connection con = null;
        Statement stmt = null;

        try {
            con = pool.getConnection();
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Stock all[] = null;

        Vector v = new Vector();

        String query = "select * from stock";
        ResultSet rset = null;

        try {
            rset = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rset.next()) {
                String symbol = rset.getString("symbol");
                int price = rset.getInt("price");
                Stock stock = new Stock(symbol, price);
                v.addElement(stock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        all = new Stock[v.size()];
        v.copyInto(all);
        pool.releaseConnection(con);

        return all;

    }

}

