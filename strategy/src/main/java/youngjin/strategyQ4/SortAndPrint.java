package youngjin.strategyQ4;

public class SortAndPrint {
    Comparable[] data;
    Sorter sorter;

    public SortAndPrint(Comparable[] data, Sorter sorter) {
        this.data = data;
        this.sorter = sorter;
    }

    public void execute() {
        System.out.println();

        print("Before -> ");
        sorter.sort(data);      // 여기서 sorting을 함
        print("After -> ");
    }

    public void print(String msg) {
        System.out.print(msg + " ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println("");
    }
}
