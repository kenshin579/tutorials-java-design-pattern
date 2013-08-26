package freelec.statictest;

public class StaticOrder {
    static int counter = 1;

    static {
        counter++;
        System.out.println("static initializer : " + counter + " th");
    }

    public static void main(String[] args) {
        counter++;
        System.out.println("static method : " + counter + " th");
    }
}
