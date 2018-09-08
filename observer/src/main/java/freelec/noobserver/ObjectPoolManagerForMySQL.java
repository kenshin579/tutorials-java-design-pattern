package freelec.noobserver.server;

import java.sql.Connection;

public class ObjectPoolManagerForMySQL implements ObjectPool {
    private static ObjectPoolManagerForMySQL instance = new ObjectPoolManagerForMySQL();
    private static final String url = "jdbc:mysql://" + "localhost:3306/test";
    private static final String id = "root";
    private static final String passwd = "1234";

    private static final int min = 5;
    private static final int max = 10;

    private static final String driver = "com.mysql.jdbc.Driver";

    private ConnectionPool pool;

    private ObjectPoolManagerForMySQL() {
        pool = new ConnectionPool(url, id, passwd, min, max, driver);
    }


    public static ObjectPoolManagerForMySQL getInstance() {
        return instance;
    }

    public synchronized Connection getConnection() {
        Connection con = pool.getConnection();
        return con;
    }

    public synchronized void releaseConnection(Connection con) {
        pool.releaseConnection(con);
    }

}

