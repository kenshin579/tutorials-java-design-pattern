package freelec.factorymethod;

public class DatabaseFactoryImpl implements DatabaseFactory {
    private Database db;

    public Database getDatabase() {
        db = new MySqlDatabaseImpl();
//        db = new OracleDatabaseImpl(); // 이렇게 여기서만 변경해보면 된다. BusinessA에서나 BusinessB에서나 변경사항이 없음.
        return db;
    }
}
