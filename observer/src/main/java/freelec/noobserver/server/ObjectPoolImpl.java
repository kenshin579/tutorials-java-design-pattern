package freelec.noobserver.server;

public class ObjectPoolImpl implements ObjectPoolIF {

    // 사용 가능한 테이테 베이스들
    private static final String ORACLE = "oracle";
    private static final String MYSQL = "mysql";
    private static final String MSSQL = "mssql";

    // Singleton Pattern 을 이용하여 객체를 단일화 한다.
    private static ObjectPoolImpl instance = new ObjectPoolImpl();

    private ObjectPoolImpl() {
        // do -nothing
        // 객체 생성 시 필요한 초기화를 실행할 수 있으나
        // 본 클래스에서는 불필요함으로 생략함
    }

    ;

    public static ObjectPoolImpl getInstance() {
        return instance;
    }

    // 어떤 pool 객체를 생성할 지 결정하여 반환함
    public ObjectPool getObjectPool(String db) {
        ObjectPool pool = null;
        if (ORACLE.equals(db)) {
            pool = ObjectPoolManagerForOracle.getInstance();
        } else if (MYSQL.equals(db)) {
            pool = ObjectPoolManagerForMySQL.getInstance();
        } else if (MSSQL.equals(db)) {
            pool = ObjectPoolManagerForMsSQL.getInstance();
        }
        return pool;
    }

}
