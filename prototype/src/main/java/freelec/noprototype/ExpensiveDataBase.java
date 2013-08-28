package freelec.noprototype;

import java.sql.*;
import java.util.Vector;

public class ExpensiveDataBase {

    private Connection con;
    private Statement stmt;
    private ResultSet rset;

    int _default = 0, age = 1, name = 2, tel = 3;

    public ExpensiveDataBase(String server) {

        try {
            // for Oracle
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            //con=DriverManager.getConnection("jdbc:oracle:thin:@"+server+":1521:ORCL","scott","tiger");
            // For MySQL
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + server + ":3306/designdb";
            con = DriverManager.getConnection(url, "root", "1234");
            stmt = con.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Address[] getAllAddresses(int mode) {

        String query = null;

        // 정렬 방식에 따라 호출되는 쿼리를 달리한다.
        if (mode == _default) {
            query = "select * from address";
        } else if (mode == age) {
            query = "select * from address order by ssn";
        } else if (mode == name) {
            query = "select * from address order by name";
        } else if (mode == tel) {
            query = "select * from address order by tel";
        }

        try {
            rset = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Vector v = new Vector();

        try {

            while (rset.next()) {
                String ssn = rset.getString("ssn");
                String name = rset.getString("name");
                String tel = rset.getString("tel");
                String address = rset.getString("address");
                int gender = rset.getInt("gender");
                Address _address = new Address(ssn, name, tel, address, gender);
                v.addElement(_address);
            }

        } catch (SQLException e) {
            System.out.println("can't reference that");
            e.printStackTrace();
        }

        Address addresses[] = new Address[v.size()];
        v.copyInto(addresses);

        return addresses;

    }

}

