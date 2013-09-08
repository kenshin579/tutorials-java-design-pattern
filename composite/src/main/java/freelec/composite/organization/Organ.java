package freelec.composite.organization;

import java.util.Enumeration;
import java.util.NoSuchElementException;

public abstract class Organ {

    // 조직의 이름
    String title;

    // 하부 구조 포함 여부에 대한 신호 값
    boolean flag;

    // 순이익
    int profit;

    // 손실액
    int loss;

    // 투자액
    int invest;

    // 하부 구조를 이름으로 찾는다
    public abstract Organ getChild(String title)
            throws NoSuchElementException;

    // 하부 구조를 추가하는 메소드
    public abstract void add(Organ oragn)
            throws InvalidAdditionException;

    // 하부 구조를 삭제하는 메소드
    public abstract void remove(Organ organ)
            throws NoSuchElementException;

    // 하부 구조를 포함하고 있는지 여부에 대한 플래그 값
    public abstract boolean isNode();

    // 조직의 이름
    public abstract String getTitle();

    // 조직의 순 이익을 반환하는 메소드
    public abstract int getProfit();

    //조직의 손실액을 반환하는 메소드
    public abstract int getLoss();

    // 조직의 투자액을 반환하는 메소드
    public abstract int getInvest();

    // 하부 구조를 반환하는 메소드
    public abstract Enumeration elements();

}
