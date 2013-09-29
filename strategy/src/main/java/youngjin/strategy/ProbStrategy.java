package youngjin.strategy;

import java.util.Random;

/**
 * 다음 손은 언제나 난수로 결정하지만, 과거 승패의 이력을 사용해서 각각의 손을 낼 확률을 바꾸고 있음.
 * - 이 전략은 상대방이 내는 가위바위보의 방법에 일정한 패턴이 있다고 전제한다.
 * - history 필드는 과거의 승패를 반영한 확률계산을 위한 표를 만듬
 * - history 필드의 값이 크면 클수록 과거의 화귤이 높다는 의미이다.
 * <p/>
 * - study 메서드는 nextHand 메서드에서 반환한 손의 승패를 기초로 history 필등의 내용을 갱신함
 * <p/>
 * ㅁ.history [이전에 낸 손][이번에 낸 손]
 * ... history[0][0]: 주먹, 주먹을 자신이 앴을 때의 과거의 승수
 * ... history[0][1]: 주먹, 가위를 자신이 앴을 때의 과거의 승수
 * ... history[0][2]: 주먹, 보를 자신이 앴을 때의 과거의 승수
 * <p/>
 * ex.이전에 주먹을 냈다고 가정함.이 세가지 식의 값을 더해서(getSum) 0부터 그 수까지의 난수를 계산하고 그것을 기초로 다음 손을 결정함
 * 1. history[0][0]=3, history[0][1]=5, history[0][2]=7 이라고 가정한다
 * 2. 주먹, 가위, 보를 낼 비율은 3:5:7로 해서 다음의 손을 결정한다. 0이상 15미만 (15 -> 3+5+7)의 난수값을 얻어서
 * ... 0 이상 3미만이면 주먹
 * ... 3 이상 8(3+5) 미만이면 가위
 * ... 8 이상 15(3+5+7) 미만이면 보
 */
public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0;
    private int currentHandValue = 0;
    private int[][] history = {
            {1, 1, 1,},         // <-- 끝의 1,은 무슨 의미일까요?
            {1, 1, 1,},
            {1, 1, 1,},
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue));
        int handvalue = 0;
        if (bet < history[currentHandValue][0]) {
            handvalue = 0;
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
            handvalue = 1;
        } else {
            handvalue = 2;
        }
        prevHandValue = currentHandValue;
        currentHandValue = handvalue;
        return Hand.getHand(handvalue);
    }

    private int getSum(int hv) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[hv][i];
        }
        return sum;
    }

    public void study(boolean win) {
        if (win) {
            history[prevHandValue][currentHandValue]++;
        } else {
            history[prevHandValue][(currentHandValue + 1) % 3]++;
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }
    }
}
