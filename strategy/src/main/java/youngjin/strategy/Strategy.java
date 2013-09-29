package youngjin.strategy;

/**
 * 가위바위보의 '전략'을 위한 추상 메서드의 집합
 */
public interface Strategy {
    public abstract Hand nextHand();            // 다음에 낼 손을 결정하는 메서드

    // 이겼을 경우 study(true)로 호출하고
    // 졌을 경우 study(false)로 호출함
    public abstract void study(boolean win);    // 직전에 낸 손으로 이겼는지, 졌는지를 학습(기록)하기 위한 메서드

}
