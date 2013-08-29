package youngjin.simplesingleton;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start.");
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        if (obj1 == obj2) {
            System.out.println("obj1과 obj2는 같은 인스턴스입니다.");
        } else {
            System.out.println("obj1과 obj2는 같은 인스턴스가 아닙니다.");
        }
        System.out.println("End.");

        Vector test = new Vector(1, 1);
        test.addElement(new Integer(1));
//        test.addElement(new Integer(2));
//        test.addElement(new Integer(3));
        for (Object obj : test) {
            System.out.println("obj: " + obj);
        }
    }

}