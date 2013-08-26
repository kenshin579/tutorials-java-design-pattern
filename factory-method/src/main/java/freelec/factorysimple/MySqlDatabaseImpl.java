package freelec.factorysimple;

import java.sql.*;

public class MySqlDatabaseImpl implements Database {

    private Connection con;
    private Statement stmt;
    private ResultSet rset;

    public MySqlDatabaseImpl() {

        String server = "localhost";

        try {
            // For MySQL
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            // For MySQL
            String url = "jdbc:mysql://" + server + ":3306/designdb";
            con = DriverManager.getConnection(url, "root", "1234");

            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return con;
    }

}
