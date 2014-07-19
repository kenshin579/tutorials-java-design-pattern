package freelec.noobserver;

import java.sql.Connection;

public interface ObjectPool {
    public Connection getConnection();

    public void releaseConnection(Connection con);
}
