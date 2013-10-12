package freelec.bridge;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test(expected = IDNotFoundException.class)
    public void testIDNotFound예외처리확인() throws Exception {
        String id = "unknownID";
        BankImpl bankimp = new BankImpl();

        bankimp.deposit(id, 500);
    }

    /**
     * dummy 사용자를 만들어서 테스트하는 게 맞을 뜻함.
     * - addUser 메서드 필요
     *
     * @throws Exception
     */
    @Test(expected = InvalidTransactionException.class)
    public void testInvalidTransaction예외처리확인() throws Exception {
        String id = "dummy"; // DB에 존재하는 id
        BankImpl bankimp = new BankImpl();

        bankimp.withdraw(id, 1000000000);
    }

    @Test
    public void test입금확인() throws Exception {
        String id = "dummy";
        int expectedAmount = 99999;
        int commision = 100;

        BankImpl bankimp = new BankImpl();
        AdvancedBank bank = new AdvancedBank(bankimp);

        Account dummyAccount = bankimp.getAccount(id);
        int beforeBalance = bankimp.getAccount(id).getBalance();

        bank.deposit(id, expectedAmount);

        int afterBalance = bankimp.getAccount(id).getBalance();

        // 원상복귀
        dummyAccount.setBalance(beforeBalance);
        bankimp.setAccount(dummyAccount);
        assertEquals(expectedAmount - commision, afterBalance - beforeBalance);
    }

    @Test
    public void test인출확인() throws Exception {
        String id = "dummy";
        int expectedAmount = 99;
        int commision = 100;

        BankImpl bankimp = new BankImpl();
        AdvancedBank bank = new AdvancedBank(bankimp);

        Account dummyAccount = bankimp.getAccount(id);
        int beforeBalance = bankimp.getAccount(id).getBalance();

        bank.withdraw(id, expectedAmount);

        int afterBalance = bankimp.getAccount(id).getBalance();

        // 원상복귀
        dummyAccount.setBalance(beforeBalance);
        bankimp.setAccount(dummyAccount);
        assertEquals(expectedAmount + commision, beforeBalance - afterBalance);
    }

    /**
     * transfer를 할때 commision이 각 계정에서 두번빠지는 부분이 있음.
     * - 실제 은행에서 이체하는 것과는 다르다는 점.
     *
     * @throws Exception
     */
    @Test
    public void test이체확인() throws Exception {
        String fromId = "dummy";
        String toId = "dummy2";

        int expectedAmount = 500;
        int commision = 100;

        BankImpl bankimp = new BankImpl();
        AdvancedBank bank = new AdvancedBank(bankimp);

        Account fromAccount = bankimp.getAccount(fromId);
        Account toAccount = bankimp.getAccount(toId);
        int fromBeforeBalance = fromAccount.getBalance();
        int toBeforeBalance = toAccount.getBalance();
        System.out.println("fromBeforeBalance: " + fromBeforeBalance);
        System.out.println("toBeforeBalance: " + toBeforeBalance);

        bank.transfer(fromId, toId, expectedAmount);

        int fromAfterBalance = bankimp.getAccount(fromId).getBalance();
        int toAfterBalance = bankimp.getAccount(toId).getBalance();
        System.out.println("fromAfterBalance: " + fromAfterBalance);
        System.out.println("toAfterBalance: " + toAfterBalance);

        // 원상복귀
        fromAccount.setBalance(fromBeforeBalance);
        bankimp.setAccount(fromAccount);
        toAccount.setBalance(toBeforeBalance);
        bankimp.setAccount(toAccount);

        assertEquals(expectedAmount + commision, fromBeforeBalance - fromAfterBalance);
        assertEquals(expectedAmount - commision, toAfterBalance - toBeforeBalance);
    }
}
