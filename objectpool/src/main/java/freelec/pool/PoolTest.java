package freelec.pool;

import java.sql.Connection;

public class PoolTest extends Thread {
    public PoolTest(String name) {
        super(name);
    }

    /**
     * 실제 Connection 객체를 사용해야 하는 클래스는 이 Singleton으로 구성된 클래스의 다음 메서드
     * 들을 활용해 객체를 취득하고 반환할 뿐 메서드의 구현부와는 관계가 없음.
     * - getConnection(), releaseConnection()
     */
    public void run() {
        ObjectPoolManager pool = ObjectPoolManager.getInstance();
        while (true) {
            Connection con = pool.getConnection();
            System.out.println(getName() + " : " + con);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pool.releaseConnection(con);
        }

    }

    public static void main(String args[]) {

        PoolTest thread[] = new PoolTest[11];

        thread[0] = new PoolTest("cleint 1 th");
        thread[1] = new PoolTest("client 2 th");
        thread[2] = new PoolTest("client 3 th");
        thread[3] = new PoolTest("client 4 th");
        thread[4] = new PoolTest("client 5 th");
        thread[5] = new PoolTest("client 6 th");
        thread[6] = new PoolTest("client 7 th");
        thread[7] = new PoolTest("client 8 th");
        thread[8] = new PoolTest("client 9 th");
        thread[9] = new PoolTest("client 10 th");
        thread[10] = new PoolTest("client 11 th");

        for (int i = 0; i < thread.length; i++) {
            thread[i].start();
        }

    }
}
