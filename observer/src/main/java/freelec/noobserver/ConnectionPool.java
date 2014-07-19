package freelec.noobserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class ConnectionPool {
    private String url;
    private String id;
    private String passwd;
    private String driver;

    private int min;
    private int max;

    private Vector free = new Vector(1, 1);
    // 사용 가능한 Connection 객체에 대한 저장소

    private Vector occupied = new Vector(1, 1);
    // 사용 중인 Connection 객체의 저장소

    private boolean monitor_flag = false;
    // 사용 가능한 Connection 객체가 반환될 때까지 대기하기 위한 신호 값

    public ConnectionPool(String url, String id, String passwd, int min, int max, String driver) {
        this.url = url;
        this.id = id;
        this.passwd = passwd;
        this.min = min;
        this.max = max;
        this.driver = driver;
        loadDriver();
        // 사용할 드라이버를 로딩
        init();
        // 최초 5개의 Connection 객체를 생성한다
    }

    public void loadDriver() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection makeConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, id, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    // 초기 값으로 min 개수의 Connection 객체를 생성한다
    public void init() {
        for (int i = 0; i <= min; i++) {
            free.addElement(makeConnection());
        }
    }

    // 사용 가능한 Connection 객체를 반환하는 메소드
    public synchronized Connection getConnection() {

        Connection con = null;

        // 사용 가능한 Connection instance 가 존재 하지 않는다면
        if (isAvaliable()) {

            // max 개수 만큼 Connection 객체를 생성한다.
            con = makeMoreConnection();

            // 사용 가능한 Connection 객체가 존재한다면
        } else {
            con = getFreeConnection();
        }

        // 사용 가능한 Connection 객체가 존재하지 않는다면
        if (con == null) {
            monitor_flag = true;
            try {
                wait();
                // 사용 가능한 객체가 반환될 때 까지 대기 시킨다

                con = getFreeConnection();
                // 사용 가능한 Connection 객체가 반환된면 이를 취득한다

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return con;
    }

    // 사용 가능한 Connection 객체를 반환하는 메소드
    public Connection getFreeConnection() {
        Connection con = (Connection) free.firstElement();
        // Connection 객체 저장소로부터 반환 받고

        transferFreeToOccupied(con);
        // 사용 중인 Connection 객체로 상태를 전이 시킨다.
        return con;
    }

    // 사용 가능한 Connection 객체가 더 이상 존재하지 않을 때
    // 추가적인 Connection 객체를 생성하는 메소드
    public Connection makeMoreConnection() {

        boolean flag = false;

        for (int size = occupied.size(); size < max; size++) {

            // 생성할 수 있는 Connection 객체의 수를 제한한다.
            // 이런 제한된 범위에서 생성할 수 있을 만큼 생성한다.
            free.addElement(makeConnection());

            // 추가적으로  생성된 객체는 사용 가능한 상태로 전이 시킨다
            flag = true;
        }

        Connection con = null;

        if (flag) {
            con = (Connection) free.firstElement();
            flag = false;
        }

        return con;
    }

    // 재 활용하기 위해 Connection 객체를 수거
    public synchronized void releaseConnection(Connection con) {
        transferOccupiedToFree(con);
        // 사용 가능한 상태로 전이시킨 다음
        remove(con);
        // Connection 객체와의 테이타 베이스 사이의 연결을 종료

        // 사용할 Connection 객체를 할당받지 못해 대기 중인 Client에게
        // 사용 가능한 Connection 객체가 생성되었음을 통보한다.
        if (monitor_flag) {
            notify();
            monitor_flag = false;
        }
    }

    // 사용 중이던 Connection 객체를 occupied 로 부터 제거한다.
    // 그렇지 않으면 ouupied 는 무한대로 부피가 커질 것이다.

    public void remove(Connection con) {
        Connection _con;
        int index = 0;
        for (int i = 0; i < occupied.size(); i++) {
            _con = (Connection) occupied.elementAt(i);
            // occupied에서 제거할 Connection 객체를 찾아낸다
            if (con.equals(_con)) {
                index = i;
            }
        }
        close(con);
        occupied.remove(index);
    }

    // Connection 객체와 연관된 모든 연결을 종료 시킨다.
    // 재활용 할 수 있도록 만들어 놓아야 한다.
    public void close(Connection con) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 사용 가능한 Connection 객체를 사용 중인 상태로 전이 시킴
    public void transferFreeToOccupied(Connection con) {

        free.remove(0);
        // free로부터 Connection 객체를 제거하고

        occupied.addElement(con);
        // 사용 중으로 상태를 전이 시킨다.
    }

    // 사용 중이었던 Connection 객체를 사용 가능한 상태로 전이 시킴
    public void transferOccupiedToFree(Connection con) {
        free.addElement(con);
    }

    // 사용 가능한 Connection 객체가 존재하는지를 확인
    public boolean isAvaliable() {
        boolean flag = false;
        if (free.isEmpty()) {
            // 가용한 Connection 객체가 존재하지 않음
            flag = true;
        } else {
            // 가용한 Connection 객체가 존재
            flag = false;
        }
        return flag;
    }
}
