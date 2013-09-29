package youngjin.strategy;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private Random random;
    private boolean won = false;
    private Hand prevHand;

    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    public Hand nextHand() {
        if (!won) {
            prevHand = Hand.getHand(random.nextInt(3)); // 졌으면 기록해둔다.
        }
        return prevHand;  // 그전에 이겼으면 그냥 return 함
    }

    public void study(boolean win) {
        won = win;
    }
}
