package youngjin.flyweightQ2;

public class Main {
    private static BigString[] bsarray = new BigString[1000];

    private static void testMemory(boolean shared) {
        for (int i = 0; i < bsarray.length; i++) {
            bsarray[i] = new BigString("1234", shared);
        }
        showMemory();
    }

    private static void showMemory() {
        Runtime.getRuntime().gc();
        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("사용 메모리(공유 X) = " + used);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }

        System.out.println("공유 X");
        testMemory(false);

        System.out.println("공유 O");
        testMemory(true);
    }
}
