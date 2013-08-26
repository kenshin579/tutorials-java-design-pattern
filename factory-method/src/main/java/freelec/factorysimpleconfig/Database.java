package freelec.factorysimpleconfig;

import java.sql.Connection;

/**
 * Connection 객체를 반환하는 역할을 함
 */
public interface Database {
    public Connection getConnection();
}
