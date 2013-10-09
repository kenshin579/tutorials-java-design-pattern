package freelec.bridge;

import java.sql.*;

public class Wrapper {

    private static final String url = "jdbc:mysql://" + "localhost:3306/designdb";

    // 오라클 사용자를 위한 url
    //private static final String url =  "jdbc:oracle:thin:@"+"127.0.0.1"+":1521:ORCL";

    private static final String id = "root";
    private static final String passwd = "1234";

    private static final String driver = "com.mysql.jdbc.Driver";

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


}
