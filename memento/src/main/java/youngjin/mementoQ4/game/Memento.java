package youngjin.mementoQ4.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Gamer의 상태를 나태나는 클래스
 * <p/>
 * 두 종류의 인터페이스(API) 정의
 * ...wide interface
 * - Object의 상태를 원래의 상태로 돌리기 위해 필요한 정보를 얻을 수 있는 메서드 집합
 * - 이것을 사용하는 것은 Originator(Gamer 클래스)에서 뿐이다.
 * <p/>
 * ...narrow interface
 * - 내부 상태가 외부에 공개되는 것을 방지함.
 */
public class Memento {
    int money;                              // 소지금
    ArrayList fruits;                       // 과일

    /**
     * public이 없으므로 Memento 클래스의 인스턴스는 누구나 만들수 있는 것 아님
     * - 동일한 패키지(game)에 속해 있는 클래스에서만 사용할 수 있음.
     *
     * @param money
     */
    Memento(int money) {                    // 생성자(wide interface)
        this.money = money;
        this.fruits = new ArrayList();
    }

    public int getMoney() {                 // 소지금을 얻는다(narrow interface)
        return money;
    }

    void addFruit(String fruit) {           // 과일을 추가한다(wide interface)
        fruits.add(fruit);
    }

    List getFruits() {                      // 과일을 얻는다(wide interface)
        return (List) fruits.clone();
    }
}
