package freelec.nobridge;

public class InvalidTransactionException extends Exception {

    private String msg;

    public InvalidTransactionException() {
        msg = "Balance is not enough";
    }

    public String toString() {
        return msg;
    }

}
