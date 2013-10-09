package freelec.chainofresponsibility.server;

import freelec.chainofresponsiblity.client.Exchange;
import freelec.chainofresponsiblity.client.Fund;
import freelec.chainofresponsiblity.client.Stock;

import java.sql.*;
import java.util.Vector;

public class Wrapper {

    private static final String url = "jdbc:mysql://" + "localhost:3306/test";

    // 오라클 사용자를 위한 url
    //private static final String url =  "jdbc:oracle:thin:@"+"127.0.0.1"+":1521:ORCL";

    private static final String id = "scott";
    private static final String passwd = "tiger";

    private static final String driver = "org.gjt.mm.mysql.Driver";

    //private static final String driver ="oracle.jdbc.driver.OracleDriver";
    // 오라클 사용자를 위한 드라이버

    private Connection con;
    private Statement stmt;

    private static Wrapper wrapper = new Wrapper();

    public static Wrapper getInstance() {
        return wrapper;
    }

    private Wrapper() {
        loadDriver();
        getConnection();
    }

    // 드라이버 로딩하는 메소드
    public void loadDriver() {

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    // Connection 객체를 반환하는 메소드
    public Connection getConnection() {

        try {
            con = DriverManager.getConnection(url, id, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;

    }

    // PreparedStatement 를 반환하는 메소드
    public PreparedStatement getPreparedStatement(String query) {


        PreparedStatement pStmt = null;

        try {
            pStmt = con.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pStmt;

    }

    // Select 쿼리를 실행하고 결과 객체(ResultSet)를 반환한다.
    public ResultSet select(PreparedStatement pStmt) {

        ResultSet rset = null;

        try {
            rset = pStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rset;

    }

    // Update 쿼리를 수행한다.
    public void update(PreparedStatement pStmt) {

        try {
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean hasNextElements(ResultSet rset) {

        boolean flag = false;

        try {
            if (rset.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;

    }

    // 쿼리에 포함 되어야 할 변수 값을 초기화
    public void setParameter(PreparedStatement pStmt, int index, String str) {

        try {
            pStmt.setString(index, str);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 쿼리에 포함되어야 할 변수 값을 초기화
    public void setParameter(PreparedStatement pStmt, int index, int value) {

        try {
            pStmt.setInt(index, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setParameter(PreparedStatement pStmt, int index, float value) {

        try {
            pStmt.setFloat(index, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 전체 주식 시세를 참조할 수 있는 메소드
    public Stock[] getAllStocks() {

        Vector v = new Vector();

        String query = "select * from stock";

        PreparedStatement pStmt = getPreparedStatement(query);

        ResultSet rset = select(pStmt);

        while (hasNextElements(rset)) {

            try {
                String item = rset.getString("item");
                int current = rset.getInt("current");
                float upndwn = rset.getFloat("upndwn");
                float upndwnper = rset.getFloat("upndwnper");
                Stock stock = new Stock(item, current, upndwn, upndwnper);
                v.addElement(stock);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        Stock stocks[] = new Stock[v.size()];

        v.copyInto(stocks);

        return stocks;

    }

    // 패턴과는 무관함 메소드로서
    // 단지 시물레이션에 의해 변동된 주식 가격을 테이타 베이스에 설정하기 위함 메소드
    public void setAllStocks(Stock stocks[]) {

        String query = "update stock set current = ?, upndwn = ? , upndwnper = ? where item = ?";

        PreparedStatement pStmt = getPreparedStatement(query);

        for (int i = 0; i < stocks.length; i++) {
            setParameter(pStmt, 1, stocks[i].getCurrent());
            setParameter(pStmt, 2, stocks[i].getUpnDwn());
            setParameter(pStmt, 3, stocks[i].getUpnDwnPer());
            setParameter(pStmt, 4, stocks[i].getItem());
            update(pStmt);
        }

    }

    // 전체 펀드 시세를 참조할 수 있는 메소드
    public Fund[] getAllFunds() {

        Vector v = new Vector();
        String query = "select * from fund";
        PreparedStatement pStmt = getPreparedStatement(query);
        ResultSet rset = select(pStmt);

        while (hasNextElements(rset)) {

            try {
                String item = rset.getString("item");
                int current = rset.getInt("current");
                float commision = rset.getFloat("commision");
                float daycommision = rset.getFloat("daycommision");
                Fund fund = new Fund(item, current, commision, daycommision);
                v.addElement(fund);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        Fund funds[] = new Fund[v.size()];
        v.copyInto(funds);

        return funds;

    }

    // 패턴과는 무관함 메소드로서
    // 단지 시물레이션에 의해 변동된 펀드 가격을 테이타 베이스에 설정하기 위함 메소드

    public void setAllFunds(Fund funds[]) {

        String query = "update fund set current = ?, commision = ? , daycommision = ? where item = ?";

        PreparedStatement pStmt = getPreparedStatement(query);

        for (int i = 0; i < funds.length; i++) {
            setParameter(pStmt, 1, funds[i].getCurrent());
            setParameter(pStmt, 2, funds[i].getCommision());
            setParameter(pStmt, 3, funds[i].getDayCommision());
            setParameter(pStmt, 4, funds[i].getItem());
            update(pStmt);
        }

    }

    // 전체 외환 시세를 참조할 수 있는 메소드
    public Exchange[] getAllExchanges() {

        Vector v = new Vector();

        String query = "select * from exchange";
        PreparedStatement pStmt = getPreparedStatement(query);
        ResultSet rset = select(pStmt);

        while (hasNextElements(rset)) {

            try {
                String item = rset.getString("item");
                float buy = rset.getFloat("buy");
                float sell = rset.getFloat("sell");
                float rate = rset.getFloat("rate");
                Exchange exchange = new Exchange(item, buy, sell, rate);
                v.addElement(exchange);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        Exchange exchanges[] = new Exchange[v.size()];
        v.copyInto(exchanges);

        return exchanges;

    }

    // 패턴과는 무관함 메소드로서
    // 단지 시물레이션에 의해 변동된 외환 시세를 테이타 베이스에 설정하기 위한 메소드

    public void setAllExchanges(Exchange[] exchanges) {

        String query = "update exchange set buy = ?, sell = ? , rate = ? where item = ?";

        PreparedStatement pStmt = getPreparedStatement(query);

        for (int i = 0; i < exchanges.length; i++) {
            setParameter(pStmt, 1, exchanges[i].getBuy());
            setParameter(pStmt, 2, exchanges[i].getSell());
            setParameter(pStmt, 3, exchanges[i].getRate());
            setParameter(pStmt, 4, exchanges[i].getItem());
            update(pStmt);
        }

    }

}
