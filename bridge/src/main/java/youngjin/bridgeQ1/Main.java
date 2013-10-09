package youngjin.bridgeQ1;

/**
 * 기능의 클래스 계층(SuperClass + SubClass): Display, CountDisplay
 * 구현의 클래스 계층(AbstractClass + ConcreteClass): DisplayImpl, DisplayImpl
 * Q: Bridge 역할을 하는 코드는 어느 부분에 있나?
 * - Display.java 참조
 */
public class Main {
    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello, Korea."));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World."));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."));

        RandomDisplay d4 = new RandomDisplay(new StringDisplayImpl("Hello, Random."));

        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
        d4.randomDisplay(5);
    }
}
