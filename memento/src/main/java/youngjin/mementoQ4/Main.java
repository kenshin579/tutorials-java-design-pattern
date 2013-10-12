package youngjin.mementoQ4;


import youngjin.mementoQ4.game.Gamer;
import youngjin.mementoQ4.game.Memento;

/**
 * Caretaker(관리인)의 역할: Main 클래스
 * - 어느 시점에서 스냅샷을 찍을지 결정하고, 언제 undo 할지를 결정하는 Memento 역할을 지정함
 * - Caretaker는 넓은 인터페이스 API만 사용 가능함
 * <p/>
 * Originator(작성자)의 역할: Gamer 클래스
 * - Memento을 만드는 일과 제공된 Memento 역할을 사용해서 자신의 상태를 원래 상테로 돌리는 일을 수행함
 * - Originator는 좁은 인터페이스 사용 가능함
 * <p/>
 * Memento(기념품)의 역할
 * - Originator 역할의 내부 정보를 가지고 있지만, 그 정보를 누구에게도 공개하지 않는다.
 * - 두 종류의 인터페이스 (Memento 클래스 참조)
 */
public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);               // 최초의 소지금은 100
        Memento memento = gamer.createMemento();    // 최초의 상태를 저장해 둔다

        for (int i = 0; i < 10; i++) {
            System.out.println("==== " + i);        // 개수 표시
            System.out.println("현상:" + gamer);     // 현재의 주인공의 상태 표시

            gamer.bet();    // 게임을 진행시킨다

            System.out.println("소지금은" + gamer.getMoney() + "원이 되었습니다.");

            // Memento의 취급 결정
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("    (많이 증가했으므로 현재의 상태를 저장하자)");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("    (많이 감소했으므로 이전의 상태로 복원하자)");
                gamer.restoreMemento(memento);
            }

            // 시간 기다림
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("");
        }
    }
}


