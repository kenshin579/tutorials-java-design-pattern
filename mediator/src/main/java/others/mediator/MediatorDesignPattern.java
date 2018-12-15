package others.mediator;

/**
 * 통신 인터페이스
 * 1. Command의 역할:
 * 2. IATCMediator의 역할: Mediator에서 통제를 함
 *    - 공통으로 통제가 되어야 하는 지시 내리는 명령들은 Mediator API로 등록함
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