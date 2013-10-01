package youngjin.strategyQ4;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        String[] data1 = {
                "Dumpty", "Bowman", "Carroll", "Elfland", "Alice"
        };

        String[] data2 = {
                "Dumpty", "Bowman", "Carroll", "Elfland", "Alice"
        };
        SortAndPrint sort1 = new SortAndPrint(data1, new SelectionSorter());
        SortAndPrint sort2 = new SortAndPrint(data2, new InsertSorter());
        sort1.execute();
        sort2.execute();

    }
}
