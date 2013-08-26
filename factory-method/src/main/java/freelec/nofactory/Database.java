package freelec.nofactory;

import java.sql.*;

public class Database{

    private Connection con;
    private Statement stmt;
    private ResultSet rset;

    public Database() {

        String server = "localhost";

        try{
            // for Oracle
//      Class.forName("oracle.jdbc.driver.OracleDriver");

            // For MySQL
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            // For Oracle
//      con=DriverManager.getConnection("jdbc:oracle:thin:@"+server+":1521:ORCL","scott","tiger");

            // For MySQL
            String url="jdbc:mysql://" + server + ":3306/factoryDB";
            con=DriverManager.getConnection(url, "root", "1234");

            stmt=con.createStatement();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return con;
    }

}
