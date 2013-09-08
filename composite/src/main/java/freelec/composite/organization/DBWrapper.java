package freelec.composite.organization;

import java.sql.*;
import java.util.Vector;

public class DBWrapper {

    private static final String url = "jdbc:mysql://" + "localhost:3306/designdb";
    private static final String id = "root";
    private static final String passwd = "1234";
    private static final String driver = "com.mysql.jdbc.Driver";
    //private static final String driver ="oracle.jdbc.driver.OracleDriver";
    // 오라클 사용자를 위한 드라이버

    private Connection con;
    private Statement stmt;
    private ResultSet rset;

    private int total;

    public DBWrapper() {
        loadDriver();
        setConnection();
    }

    public void loadDriver() {

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void setConnection() {

        try {
            //con = DriverManager.getConnection(url);
            con = DriverManager.getConnection(url, id, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 모든 부서 체계를 반환하는 메소드
    public Organ[] getAllOrgan() {

        Organ all[] = null;

        Vector v = new Vector();
        String query = "select * from depart";

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            while (rset.next()) {
                String title = rset.getString("title");
                Organ depart = new Department(title);
                v.addElement(depart);
            }

            all = new Organ[v.size()];
            v.copyInto(all);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return all;

    }

    // 부서 조직 체계를 이용하여,
    // 이들의 하부 구조를 모두 반환한다.
    public Organ[] getAllOrgan(Organ all[])
            throws InvalidAdditionException {

        Vector v = new Vector();
        String query = "select * from subdepart";

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            while (rset.next()) {
                String title = rset.getString("title");
                String subtitle = rset.getString("subtitle");
                int invest = rset.getInt("invest");
                int loss = rset.getInt("loss");
                Minor minor = new Minor(subtitle, invest, loss);

                if (Constants.SALES.equals(title)) {
                    for (int i = 0; i < all.length; i++) {
                        if (all[i].getTitle().equals(title)) {
                            all[i].add(minor);
                        }
                    }
                } else if (Constants.PLANNING.equals(title)) {
                    for (int i = 0; i < all.length; i++) {
                        if (all[i].getTitle().equals(title)) {
                            all[i].add(minor);
                        }
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return all;

    }

}
