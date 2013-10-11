package freelec.bridge;

/**
 * implementor 클래스
 * abstraction 클래스에 정의된 기능을 구현하도록 하는 인터페이스
 */
public interface BankIF {

    public void deposit(String id, int howmuch)
            throws InvalidTransactionException, IDNotFoundException;

    public void withdraw(String id, int howmuch)
            throws InvalidTransactionException, IDNotFoundException;

}
