package others.iterator;

import java.util.Arrays;
import java.util.List;
import java.util.Observable;

public class Observable1 extends Observable {
    public void say() {

        List dataArr = Arrays.asList(1, 2, 3, 4, 5);

        for (Object i : dataArr) {
            setChanged();
            notifyObservers(i);
        }

    }
}
