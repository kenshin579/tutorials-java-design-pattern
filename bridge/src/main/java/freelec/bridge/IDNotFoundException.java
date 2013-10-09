package freelec.bridge;

public class IDNotFoundException extends Exception {

    private String msg;

    public IDNotFoundException() {
        msg = "ID is not found";
    }

    public String toString() {
        return msg;
    }

}

