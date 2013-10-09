package freelec.nobridge;

public class AdvancedBank extends Bank {

    public AdvancedBank(BankIF bank) {
        super(bank);
    }

    public void transfer(String from, String to, int howmuch)
            throws InvalidTransactionException, IDNotFoundException {
        bank.withdraw(from, howmuch);
        bank.deposit(to, howmuch);
    }

};
