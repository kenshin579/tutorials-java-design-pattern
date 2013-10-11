package youngjin.memento;


import youngjin.memento.game.Gamer;
import youngjin.memento.game.Memento;

public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);               // 최초의 소지금은 100
        Memento memento = gamer.createMemento();    // 최초의 상태를 저장해 둔다

        for (int i = 0; i < 10; i++) {
            System.out.println("==== " + i);        // 개수 표시
            System.out.println("현상:" + gamer);    // 현재의 주인공의 상태 표시

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


