package freelec.nofactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Business {
    // Database db = new Database("id"); 이렇게 다른 DB로 변경하고 싶다면... 전체 Business*를 변경해야 하는 사항이 팔상하게 됨
    Database db = new Database();
    Connection con = db.getConnection();

    public void insert(String id, String code, int quality) {
        String query = "insert into product values ( " + id + "," + code + "," + quality + ")";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet selectAll() {
        String query = "select * from product";
        ResultSet resultSet = null;
        try {
            Statement stmt = con.createStatement();
            resultSet = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String id = resultSet.getString("id");
            String code = resultSet.getString("code");
            int quality = resultSet.getInt("quality");

            System.out.println("id: " + id + " code: " + code + " quality: " + quality);
        }
    }

    public static void main(String[] argv) {
        Business business = new Business();
//        business.insert("1", "111", 4);
//        business.insert("2", "222", 2);
//        business.insert("3", "333", 3);
        ResultSet resultSet = business.selectAll();
        try {
            business.writeResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
