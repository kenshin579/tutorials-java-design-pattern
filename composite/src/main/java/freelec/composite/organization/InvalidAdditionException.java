package freelec.composite.organization;

public class InvalidAdditionException extends Exception {

    public InvalidAdditionException() {
        super();
    }

    public void printStackTrace() {
        System.out.println("-- Invalid Addtion Exception --");
        System.out.println(" Pleas check your organization ");
        super.printStackTrace();
    }

}
