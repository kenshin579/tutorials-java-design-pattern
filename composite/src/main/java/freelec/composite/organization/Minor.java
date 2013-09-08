package freelec.composite.organization;

import java.util.Enumeration;
import java.util.NoSuchElementException;

public class Minor extends Department {

    public Minor(String title, int invest, int loss) {
        this.title = title;
        this.invest = invest;
        this.loss = loss;
        // 더 이상 하부 구조를 가질 수 없음
        // 즉 조직 체계의 최 하부 구조임을 말함
        flag = false;
        ;
    }

    public Organ getChild(String _title) throws NoSuchElementException {

        Organ organ = null;

        if (title.equals(_title)) {
            organ = this;
        }

        return organ;

    }

    // 하부 구조를 추가하는 메소드
    public void add(Organ organ) throws InvalidAdditionException {

        // 그러나 하부 구조를 첨가할 수 없음으로
        // 첨가하려 한다면 예외 사항을 발생시킨다
        throw new InvalidAdditionException();
    }

    // 하부 구조를 제거하는 메소드
    public void remove(Organ organ) throws NoSuchElementException {

        // 그러나 하부 구조를 포함하고 있지 못하므로
        // 제거하려 한다면 예외 사항을 발생시킨다.
        throw new NoSuchElementException();
    }

    public boolean isNode() {
        return flag;
    }

    public String getTitle() {
        return title;
    }

    public Enumeration elements() {
        return null;
    }

    public int getProfit() {
        int total = getInvest() - getLoss();
        return total;
    }

    public int getLoss() {
        return loss;
    }

    public int getInvest() {
        return invest;
    }

}
