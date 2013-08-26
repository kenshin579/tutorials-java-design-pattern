package freelec.factorysimpleconfig;

import java.sql.*;

public class MySqlDatabaseImpl implements Database {

    private Connection con;
    private Statement stmt;
    private ResultSet rset;

    public MySqlDatabaseImpl() {
        // 여기서 DBUtil을 통해서 설정을 함.

//        String server = "localhost";

        try {
            // For MySQL
            Class.forName(DBConfig.DRIVER);
            System.out.println("MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            // For MySQL
            String url = DBConfig.URL + DBConfig.SCHEMA_NAME;
            con = DriverManager.getConnection(url, DBConfig.USER_NAME, DBConfig.PASSWORD);

            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return con;
    }

}
