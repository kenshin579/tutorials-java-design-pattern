package freelec.noobserver.server;

import java.sql.*;
import java.util.Vector;

public class JulyThread extends Thread {

    private String url = "jdbc:mysql://" + "localhost:3306/test";
    private String id = "scott";
    private String passwd = "tiger";
    private String driver = "org.gjt.mm.mysql.Driver";

    private Connection con;
    private Statement stmt;
    boolean flag = true;

    //private CallByClientImpl ref;

    //public JulyThread(CallByClientImpl ref){
    public JulyThread() {
        //this.ref = ref;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url, id, passwd);
            //con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void run() {

        while (true) {
            try {
                sleep(3000);
                update();
                //ref.callByJuly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void update() throws SQLException {

        Vector v = new Vector();
        String query = "select * from stock";

        stmt = con.createStatement();
        ResultSet rset = stmt.executeQuery(query);
        Stock all[] = null;

        while (rset.next()) {
            String symbol = rset.getString("symbol");
            int price = rset.getInt("price");
            Stock stock = new Stock(symbol, price);
            v.addElement(stock);
        }

        all = new Stock[v.size()];
        v.copyInto(all);
        query = "update stock set price = ? where symbol = ?";

        if (flag) {
            for (int i = 0; i < all.length; i++) {
                all[i].setPrice(all[i].getPrice() + (int) (Math.random() * 10));
            }
            flag = false;
        } else {
            for (int i = 0; i < all.length; i++) {
                int price = all[i].getPrice() - (int) (Math.random() * 10);
                if (price <= 0) {
                    price = all[i].getPrice();
                }
                all[i].setPrice(price);
            }
            flag = true;
        }

        for (int i = 0; i < all.length; i++) {

            PreparedStatement pStmt = con.prepareStatement(query);
            pStmt.setInt(1, all[i].getPrice());
            pStmt.setString(2, all[i].getSymbol());
            pStmt.executeUpdate();

        }

    }

    public static void main(String args[]) {
        new JulyThread().start();
    }

}
