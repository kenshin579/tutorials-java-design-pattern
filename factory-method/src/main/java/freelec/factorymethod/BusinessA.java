package freelec.factorymethod;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BusinessA {
    // DatabaseFactory 타입의 클래스는 Database 타입의 객체를 생성하도록 구현해야 함
    DatabaseFactory df = new DatabaseFactoryImpl();
    //Database 객체 생성을 위임 받은 DatabaseFactory를 통해서 필요로 하는 객체를 취득
    Database db = df.getDatabase();

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

    public static void main(String[] argv) {
        BusinessA business = new BusinessA();
        business.insert("2", "555", 3);
    }

}
