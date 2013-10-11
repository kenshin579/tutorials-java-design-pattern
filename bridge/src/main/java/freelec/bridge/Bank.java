package freelec.bridge;

/**
 * Abstration 클래스로서 기본 기능만이 선언되어 있음
 */
public class Bank {

    // bridge 역할을 하는 객체
    protected BankIF bank;

    public Bank(BankIF bank) {
        this.bank = bank;
    }

    public void deposit(String id, int howmuch)
            throws InvalidTransactionException, IDNotFoundException {
        // bridge에게 처리를 위임함
        bank.deposit(id, howmuch);
    }

    public void withdraw(String id, int howmuch)
            throws InvalidTransactionException, IDNotFoundException {
        // bridge에게 처리를 위임함
        bank.withdraw(id, howmuch);
    }

}


