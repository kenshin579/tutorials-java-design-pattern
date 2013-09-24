package freelec.composite.animal.noabstraction;

import freelec.composite.animal.common.Area;
import freelec.composite.animal.common.Location;

/**
 * 단점: Tiger 클래스와 Lion 클래스가 서로의 타입이 같이 않기 때문에 두개의 메서드로 출력하고 있음
 */
public class NoAbstractUsedByClient {

    public void lionList(Lion lions[]) {
        for (int i = 0; i < lions.length; i++) {
            System.out.println("Area : " + lions[i].getArea());
            System.out.println("Location : " + lions[i].getLocation());
            System.out.println("life : " + lions[i].getLife());
            System.out.println("Size : " + lions[i].getSize());
        }
    }

    public void tigerList(Tiger tigers[]) {
        for (int i = 0; i < tigers.length; i++) {
            System.out.println("Area : " + tigers[i].getArea());
            System.out.println("Location : " + tigers[i].getLocation());
            System.out.println("life : " + tigers[i].getLife());
            System.out.println("Size : " + tigers[i].getSize());
        }
    }

    public static void main(String[] args) {
        NoAbstractUsedByClient usedByClient = new NoAbstractUsedByClient();

        int max = 3;
        Lion[] lions = new Lion[max];
        Tiger[] tigers = new Tiger[max];

        lions[0] = new Lion(new Area("Seoul"), new Location("Korea"), 10, 10);
        lions[1] = new Lion(new Area("America"), new Location("Ohio"), 5, 6);
        lions[2] = new Lion(new Area("Iraq"), new Location("Erbil"), 3, 8);

        tigers[0] = new Tiger(new Area("Seoul"), new Location("Korea"), 10, 9);
        tigers[1] = new Tiger(new Area("Tokyo"), new Location("Japan"), 8, 9);
        tigers[2] = new Tiger(new Area("South America"), new Location("Brazil"), 3, 9);

        usedByClient.lionList(lions);
        usedByClient.tigerList(tigers);
    }
}
