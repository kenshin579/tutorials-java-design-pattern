package others.iterator;

import java.util.Arrays;
import java.util.Iterator;

public class IteratorMain {


    public static void main(String[] args) {
        Iterable dataArr = Arrays.asList(1, 2, 3, 4);

        for (Iterator it = dataArr.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }

    }
}
