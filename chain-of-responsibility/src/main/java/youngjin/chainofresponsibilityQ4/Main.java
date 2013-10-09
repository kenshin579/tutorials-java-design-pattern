package youngjin.chainofresponsibilityQ4;

/**
 * Trouble: 발생한 트러블을 나타내는 클래스. 트러불 번호를 가진다.
 * Support: 트러불을 해결하는 추상 클래스
 * NoSupport:트러불을 해결하는 구상 클래스(항상 '처리하지 않는다')
 * LimitSupport:트러불을 해결하는 구상 클래스(지정한 번호 미만의 트러불을 해결)
 * OddSupport: 트러불을 해결하는 구상 클래스(홀수 번호의 트러불을 해결)
 * SpecialSupport: 트러불을 해결하는 구상 클래스(특정 번호의 트러불을 해결)
 */
public class Main {
    public static void main(String[] args) {

        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new SpecialSupport("Charlie", 429);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("Elmo");
        Support fred = new LimitSupport("Fred", 300);

        // 연쇄의 형성
        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);

        // 다양한 트러블 발생
        for (int i = 0; i < 500; i += 33) {
            alice.support(new Trouble(i));
        }
    }
}
