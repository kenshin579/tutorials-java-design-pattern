package freelec.factorysimple;

public class DatabaseFactoryImpl implements DatabaseFactory {
    private Database db;

    public Database getDatabase(String type) {
        if ("mysql".equals(type)) {
            db = new MySqlDatabaseImpl();
        } else if ("oracle".equals(type)) {
            db = new OracleDatabaseImpl();
        } else if ("derby".equals(type)) {
            db = new DerbyDatabaseImpl();
        } else return null;
        return db;
    }
}
