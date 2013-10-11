package freelec.bridge;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Concrete implementor
 * 위임 받을 것을 실제 처리하는 클래스
 */
public class BankImpl implements BankIF {

    private Wrapper wrap;
    private int commision = 100;

    public BankImpl() {
        wrap = Wrapper.getInstance();
    }

    public void deposit(String id, int howmuch)
            throws IDNotFoundException, InvalidTransactionException {

        Account account = getAccount(id);
        if (account == null) {
            throw new IDNotFoundException();
        }

        int balance = account.getBalance() + howmuch - commision;
        if (balance < 0) {
            throw new InvalidTransactionException();
        }

        account.setBalance(balance);
        setAccount(account);

    }

    public void withdraw(String id, int howmuch)
            throws InvalidTransactionException, IDNotFoundException {

        Account account = getAccount(id);
        if (account == null) {
            throw new IDNotFoundException();
        }

        int balance = account.getBalance() - howmuch - commision;
        if (balance < 0) {
            throw new InvalidTransactionException();
        }

        account.setBalance(balance);
        setAccount(account);

    }

    public Account getAccount(String id) {
        Account account = null;

        String query = "select * from account where id = ?";
        PreparedStatement pStmt = wrap.getPreparedStatement(query);

        wrap.setParameter(pStmt, 1, id);

        ResultSet rset = wrap.select(pStmt);
        if (wrap.hasNextElements(rset)) {
            try {
                int balance = rset.getInt("balance");
                account = new Account(id, balance);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return account;
    }

    public void setAccount(Account account) {

        String query = "update account set balance = ? where id = ?";
        PreparedStatement pStmt = wrap.getPreparedStatement(query);

        int balance = account.getBalance();
        String id = account.getId();

        wrap.setParameter(pStmt, 1, balance);
        wrap.setParameter(pStmt, 2, id);

        wrap.update(pStmt);
    }

}


