package freelec.strategy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Database {

    private Wrapper wrap;
    private static Database db = new Database();

    private Stock stocks[];

    private Database() {
        wrap = Wrapper.getInstance();
    }

    public static Database getInstance() {
        return db;
    }

    public Stock[] getAllStocks(int code) {

        String query = null;

        // 순이익 순으로 정렬하고
        if (code == 1) {
            query = "select * from stock order by profit desc";

            // 연구 개발시 순으로 정렬하고
        } else if (code == 2) {
            query = "select * from stock order by rd desc";

            // 매출액 순으로 정렬하고
        } else if (code == 3) {
            query = "select * from stock order by sale desc";
        }

        PreparedStatement pStmt = wrap.getPreparedStatement(query);
        ResultSet rset = wrap.select(pStmt);
        Vector v = new Vector();

        while (wrap.hasNextElements(rset)) {

            try {

                String name = rset.getString("name");
                int property = rset.getInt("property");
                int sale = rset.getInt("sale");
                int profit = rset.getInt("profit");
                int rd = rset.getInt("rd");

                v.addElement(new Stock(name, property, sale, profit, rd));

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        stocks = new Stock[v.size()];
        v.copyInto(stocks);

        return stocks;

    }

}
