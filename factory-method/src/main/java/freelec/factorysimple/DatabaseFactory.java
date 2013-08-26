package freelec.factorysimple;

/**
 * Database Type의 인스턴스 생성을 담당함
 */
public interface DatabaseFactory {
    public Database getDatabase(String type);
}
