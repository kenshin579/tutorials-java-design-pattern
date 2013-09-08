package freelec.composite.animal.abstraction;

import freelec.composite.animal.common.Area;
import freelec.composite.animal.common.Location;

/**
 *
 */
public class AbstractUsedByClient {

    public void catList(Cat cats[]) {
        for (int i = 0; i < cats.length; i++) {
            System.out.println("Area : " + cats[i].getArea());
            System.out.println("Location : " + cats[i].getLocation());
            System.out.println("life : " + cats[i].getLife());
            System.out.println("Size : " + cats[i].getSize());
        }
    }

    public static void main(String[] args) {
        AbstractUsedByClient usedByClient = new AbstractUsedByClient();

        int max = 3;
        Lion[] lions = new Lion[max];
        Tiger[] tigers = new Tiger[max];

        lions[0] = new Lion(new Area("Seoul"), new Location("Korea"), 10, 10);
        lions[1] = new Lion(new Area("America"), new Location("Ohio"), 5, 6);
        lions[2] = new Lion(new Area("Iraq"), new Location("Erbil"), 3, 8);

        tigers[0] = new Tiger(new Area("Seoul"), new Location("Korea"), 10, 9);
        tigers[1] = new Tiger(new Area("Tokyo"), new Location("Japan"), 8, 9);
        tigers[2] = new Tiger(new Area("South America"), new Location("Brazil"), 3, 9);

        usedByClient.catList(lions);
        usedByClient.catList(tigers);
    }
}
