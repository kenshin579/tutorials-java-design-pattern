package freelec.noobserver.server;

public interface ObjectPoolIF {

    // 어떤 테이타 베이스를 사용할 지 문자열의 값으로 결정한다.
    public ObjectPool getObjectPool(String db);
}
