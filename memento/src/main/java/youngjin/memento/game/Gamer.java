package youngjin.memento.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Gamer {
    private int money;                             // 소지금
    private List fruits = new ArrayList();         // 과일
    private Random random = new Random();          // 난수발생기
    private static String[] fruitsname = {         // 과일 이름의 표
            "사과", "포도", "바나나", "귤",
    };

    public Gamer(int money) {                      // 생성자
        this.money = money;
    }

    public int getMoney() {                         // 현재의 소지금을 얻는다
        return money;
    }

    public void bet() {                             // 내기하다 - 게임의 진행
        int dice = random.nextInt(6) + 1;           // 주사위를 던지다
        if (dice == 1) {                            // 1 - 소지금이 증가한다
            money += 100;
            System.out.println("소지금이 증가했습니다.");
        } else if (dice == 2) {                     // 2 - 소지금이 절반이 된다
            money /= 2;
            System.out.println("소지금이 절반이 되었습니다.");
        } else if (dice == 6) {                     // 6 - 과일을 받는다
            String f = getFruit();
            System.out.println("과일(" + f + ")을 받았습니다.");
            fruits.add(f);
        } else {                                    // 그외 - 변한 것이 없다
            System.out.println("변한 것이 없습니다.");
        }
    }

    public Memento createMemento() {                // 스냅샷을 찍는다
        Memento m = new Memento(money);
        Iterator it = fruits.iterator();
        while (it.hasNext()) {
            String f = (String) it.next();
            if (f.startsWith("맛있는 ")) {         // 과일은 맛있는 것만 보존
                m.addFruit(f);
            }
        }
        return m;
    }

    public void restoreMemento(Memento memento) {   // undo 실행
        this.money = memento.money;
        this.fruits = memento.getFruits();
    }

    public String toString() {                      // 문자열 표현
        return "[money = " + money + ", fruits = " + fruits + "]";
    }

    private String getFruit() {                     // 과일을 1개 얻는다
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "맛있는 ";
        }
        return prefix + fruitsname[random.nextInt(fruitsname.length)];
    }
}



