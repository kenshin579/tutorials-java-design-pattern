package freelec.noobserver.server;

import java.sql.Connection;

public class ObjectPoolManagerForMsSQL implements ObjectPool {

    private static ObjectPoolManagerForMsSQL instance = new ObjectPoolManagerForMsSQL();

    private static final String url = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=temp";

    private static final String id = "scott";
    private static final String passwd = "tiger";

    private static final int min = 5;
    private static final int max = 10;

    private static final String driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";

    private ConnectionPool pool;

    private ObjectPoolManagerForMsSQL() {
        pool = new ConnectionPool(url, id, passwd, min, max, driver);
    }


    public static ObjectPoolManagerForMsSQL getInstance() {
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
