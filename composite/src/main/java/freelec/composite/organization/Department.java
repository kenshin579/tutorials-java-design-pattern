package freelec.composite.organization;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Vector;

public class Department extends Organ {

    // 부서가 포함하고 있는 하부 구조를 담는 벡터
    private Vector organs;

    public Department() {
    }

    public Department(String title) {
        this.title = title;
        organs = new Vector();
        // 부서는 하부 구조로서 가질 수 있다
        flag = true;
    }

    // 부서의 하부 구조를 이름으로 찾아주는 메소드
    public Organ getChild(String title) throws NoSuchElementException {

        Organ organ = null;
        Enumeration _enum = elements();

        // 어떠한 하부 구조도 갖고 있지 않다면
        if (_enum == null) {
            // 예외 사항을 발생시킨다
            throw new NoSuchElementException();
        }

        while (_enum.hasMoreElements()) {

            Organ _organ = (Organ) _enum.nextElement();

            if (title.equals(_organ.getTitle())) {
                organ = _organ;
            }
        }

        return organ;

    }

    // 부서에 하부 구조를 포함하는 메소드
    public void add(Organ organ) throws InvalidAdditionException {

        // 부서가 만약 하부 구조를 포함할 수 없다면

        if (!isNode()) {
            // 예외 사항을 발생시킨다
            throw new InvalidAdditionException();
        }

        // 부서가 하부 구조를 포함할 수 있다면 벡터에 하부 구조를 포함
        organs.addElement(organ);

    }

    // 부서에서 하부 구조를 제거하는 메소드
    public void remove(Organ organ) throws NoSuchElementException {

        boolean _flag = organs.removeElement(organ);

        // 부서가 만약 하부 구조를 포함할 수 없다면
        if (!_flag) {

            // 예외 사항을 발생시킨다
            throw new NoSuchElementException();
        }

    }

    // 하부 구조를 포함하고 있는지에 대한 값을 반환하는 메소드
    public boolean isNode() {
        return flag;
    }

    // 부서명을 반환하는 메소드
    public String getTitle() {
        return title;
    }

    // 부서가 포함하고 있는 하부 구조를 열거형(Enumeration)으로 반환하는 메소드
    public Enumeration elements() {
        return organs.elements();
    }

    // 부서의 순이익을 반환하는 메소드
    public int getProfit() {
        int total = getInvest() - getLoss();
        return total;
    }

    // 부서의 총 손실액, 하부 구조의 손실액의 합을 계산한다.
    public int getLoss() {

        int total = 0;

        // 먼저 하부 구조를 포함하고 있는지를 검사하고

        if (isNode()) {

            // 하부 구조를 포함한다면, 이 들를 반환하고
            Enumeration _enum = elements();

            while (_enum.hasMoreElements()) {
                // 이들 하부 구조의 손실액을 합한다
                Organ organ = (Organ) _enum.nextElement();
                total += organ.getLoss();
            }
        }

        return total;

    }

    // 부서의 총 투자액, 하부 구조의 투자액의 합을 계산한다.
    public int getInvest() {

        int total = 0;

        // 먼저 하부 구조를 포함하고 있는지를 검사하고

        if (isNode()) {

            // 하부 구조를 포함한다면, 이 들를 반환하고
            Enumeration _enum = elements();

            while (_enum.hasMoreElements()) {
                // 이들 하부 구조의 손실액을 합한다
                Organ organ = (Organ) _enum.nextElement();
                total += organ.getInvest();
            }
        }

        return total;

    }

}

