package freelec.factorysimpleconfig;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * DB에 대한 정보를 관리함
 */
public class DBConfig {
    public static DBConfig dbConfig = null;
    public static final int DERBY = 1;
    public static final int ORACLE = 2;
    public static final int MYSQL = 3;

    public static int CURRENT_DBMS;

    public static String SCHEMA_NAME;
    public static String USER_NAME;
    public static String PASSWORD;
    public static String URL;
    public static String DRIVER;

    private DBConfig() {};

    public static DBConfig getInstance() {
        if (dbConfig == null) {
            dbConfig = new DBConfig();
            dbConfig.getDatabaseInfo();
        }
        return dbConfig;
    }

    public void getDatabaseInfo() {
        try {
            String dbms = ResourceBundle.getBundle("server").getString("dbms");
            if (dbms.equalsIgnoreCase("derby") == true)
                CURRENT_DBMS = DERBY;
            else if (dbms.equalsIgnoreCase("oracle") == true)
                CURRENT_DBMS = ORACLE;
            else if (dbms.equalsIgnoreCase("mysql") == true)
                CURRENT_DBMS = MYSQL;
            else
                CURRENT_DBMS = DERBY;
            SCHEMA_NAME = ResourceBundle.getBundle("server").getString("schema_name");
            DRIVER = ResourceBundle.getBundle("server").getString("driver");
            URL = ResourceBundle.getBundle("server").getString("url");
            USER_NAME = ResourceBundle.getBundle("server").getString("username");
            PASSWORD = ResourceBundle.getBundle("server").getString("password");
        } catch(MissingResourceException e) {
            e.printStackTrace();
        }
    }
}
