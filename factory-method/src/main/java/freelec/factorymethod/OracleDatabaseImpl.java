package freelec.factorymethod;

import java.sql.*;

public class OracleDatabaseImpl implements Database {

    private Connection con;
    private Statement stmt;
    private ResultSet rset;

    public OracleDatabaseImpl() {

        String server = "localhost";

        try {
            // for Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Oracle JDBC Driver Registered!");

            // For MySQL
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            // For Oracle
            con=DriverManager.getConnection("jdbc:oracle:thin:@"+server+":1521:ORCL","scott","tiger");

            // For MySQL
//            String url = "jdbc:mysql://" + "localhost:3306/statictest";
//            con = DriverManager.getConnection(url);

            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return con;
    }

}
