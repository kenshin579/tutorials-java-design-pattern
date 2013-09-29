package youngjin.mediator;

/**
 * Colleague는 그냥 Mediator의 구성요소라고 생각하면 됨
 * - Colleague 요소들은 Mediator를 통해서만 통제된다
 */
public class Main {
    static public void main(String args[]) {
        new LoginFrame("Mediator Sample");
    }
}
