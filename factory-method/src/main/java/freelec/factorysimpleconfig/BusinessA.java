package freelec.factorysimpleconfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Simple Factory 방식으로 변경해보았음.
 */
public class BusinessA {
    //DB설정 파일 로드
    DBConfig dbConfig = DBConfig.getInstance();

    // DatabaseFactory 타입의 클래스는 Database 타입의 객체를 생성하도록 구현해야 함
    DatabaseFactory databaseFactory = new DatabaseFactoryImpl();
    //Database 객체 생성을 위임 받은 DatabaseFactory를 통해서 필요로 하는 객체를 취득
    Database db = databaseFactory.getDatabase(dbConfig.CURRENT_DBMS);

    // Factory에 의해 구현된 Database 객체는 getConnection() 메서도를 구현하여 Connection 객체를 반환하도록 함
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
        BusinessA business = new BusinessA();
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
