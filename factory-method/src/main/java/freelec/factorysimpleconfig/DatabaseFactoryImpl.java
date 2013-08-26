package freelec.factorysimpleconfig;

public class DatabaseFactoryImpl implements DatabaseFactory {
    private Database db;

    public Database getDatabase(int CURRENT_DMBS) {
        if (CURRENT_DMBS == DBConfig.MYSQL) {
            db = new MySqlDatabaseImpl();
        } else if (CURRENT_DMBS == DBConfig.ORACLE) {
            db = new OracleDatabaseImpl();
        } else if (CURRENT_DMBS == DBConfig.DERBY) {
            db = new DerbyDatabaseImpl();
        } else return null;
        return db;
    }
}
