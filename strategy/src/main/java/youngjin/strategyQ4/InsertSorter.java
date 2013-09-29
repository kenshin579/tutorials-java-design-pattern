package youngjin.strategyQ4;

public class InsertSorter implements Sorter {
    @Override
    public void sort(Comparable[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < i; j++) {
                if (data[j].compareTo(data[i]) > 0) { // data[i]가 적으면
                    Comparable temp = data[j];
                    data[j] = data[i];
                    data[i] = temp;
                }
            }
        }
    }
}
