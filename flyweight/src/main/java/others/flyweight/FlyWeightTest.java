package others.flyweight;

/**
 * 참고: http://ncanis.tistory.com/103
 */
public class FlyWeightTest {
    public static void main(String[] args) {
        PersonFactory fac = new PersonFactory();
        // 1번 일꾼을 가져옵니다. 만약 없으면 새로 생성합니다.
        Person p1 = fac.get(1);
        p1.work();

        // 1번 일꾼에게 다시 일을 시킵니다.
        Person p2 = fac.get(1);
        p2.work();

        // 2번 일꾼을 가져옵니다. 만약 없으면 새로 생성합니다.
        Person p3 = fac.get(2);
        p3.work();

        // 총 몇명의 일꾼을 가지고 있는지 파악합니다.
        System.out.println("총일꾼수 = " + fac.size());
    }

}