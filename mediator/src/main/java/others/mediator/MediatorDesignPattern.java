package others.mediator;

/**
 * 통신 인터페이스
 * 1. Command의 역할:
 * 2. IATCMediator의 역할:
 * <p/>
 * 참고: http://javapapers.com/design-patterns/mediator-design-pattern/
 */
public class MediatorDesignPattern {
    public static void main(String args[]) {

        IATCMediator atcMediator = new ATCMediator();
        Flight sparrow101 = new Flight(atcMediator);
        Runway mainRunway = new Runway(atcMediator);

        atcMediator.registerFlight(sparrow101);
        atcMediator.registerRunway(mainRunway);

        sparrow101.getReady();
        mainRunway.land();
        sparrow101.land();
    }
}