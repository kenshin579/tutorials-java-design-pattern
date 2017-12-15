package freelec.noobserver.server;

import java.sql.Connection;

public class ObjectPoolManager {
    private static ObjectPoolManager instance = new ObjectPoolManager();
    // Singleton 객체를 생성한다

    private static final String url = "jdbc:mysql://" + "localhost:3306/test";

    // 오라클 사용자를 위한 url
    //private static final String url =  "jdbc:oracle:thin:@"+"127.0.0.1"+":1521:ORCL";

    private static final String id = "root";
    private static final String passwd = "1234";
    // 오라클 사용자를 위한 아이디와 패트워드

    private static final int min = 5;
    // 최소 Connection 객체
    private static final int max = 10;
    private static final String driver = "org.gjt.mm.mysql.Driver";

    //private static final String driver ="oracle.jdbc.driver.OracleDriver";
    // 오라클 사용자를 위한 드라이버

    private ConnectionPool pool;

    // 외부로부터의 접근을 막기 위해 private으로 선언한다.
    private ObjectPoolManager() {
        pool = new ConnectionPool(url, id, passwd, min, max, driver);
    }

    // 유일한 클래스 자신의 객체를 반환하는 메소드
    public static ObjectPoolManager getInstance() {
        return instance;
    }

    // Connection 객체를 반환 받기 위해 호출할 메소드
    // Connection 객체의 공유를 막기위해 동기화 메소드로 선언한다.
    public synchronized Connection getConnection() {
        Connection con = pool.getConnection();
        return con;
    }

    // 사용을 마친 Connection 객체를 반환 하는 메소드
    // Connection 객체의 공유를 막기위해 동기화 메소드로 선언한다.
    public synchronized void releaseConnection(Connection con) {
        pool.releaseConnection(con);
    }

}
