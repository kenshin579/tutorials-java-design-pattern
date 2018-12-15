package freelec.bridge;

/**
 * 기능이 하나 추가된 subclass
 */
public class AdvancedBank extends Bank {

    public AdvancedBank(BankIF bank) {
        super(bank);
    }

    public void transfer(String from, String to, int howmuch)
            throws InvalidTransactionException, IDNotFoundException {
        bank.withdraw(from, howmuch);
        bank.deposit(to, howmuch);
    }

}
