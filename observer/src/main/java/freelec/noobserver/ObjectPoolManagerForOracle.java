package freelec.noobserver.server;

import java.sql.Connection;

public class ObjectPoolManagerForOracle implements ObjectPool {

    private static ObjectPoolManagerForOracle instance = new ObjectPoolManagerForOracle();

    private static final String url = "jdbc:oracle:thin:@" + "127.0.0.1" + ":1521:ORCL";

    private static final String id = "scott";
    private static final String passwd = "tiger";

    private static final int min = 5;
    private static final int max = 10;

    private static final String driver = "oracle.jdbc.driver.OracleDriver";

    private ConnectionPool pool;

    private ObjectPoolManagerForOracle() {
        pool = new ConnectionPool(url, id, passwd, min, max, driver);
    }


    public static ObjectPoolManagerForOracle getInstance() {
        return instance;
    }//*/

    public synchronized Connection getConnection() {
        Connection con = pool.getConnection();
        return con;
    }

    public synchronized void releaseConnection(Connection con) {
        pool.releaseConnection(con);
    }

}
