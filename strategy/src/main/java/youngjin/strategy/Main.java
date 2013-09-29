package youngjin.strategy;

/**
 * 전략의 종류
 * 1. WiningStrategy: 이기면 다음에도 같은 손을 내미는 알고리즘
 * 2. ProbStrategy:직전에 냈던 손에서 다음 낼 손을 확률적으로 계산하여 손을 내미는 알고리즘
 */
public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Main randomseed1 randomseed2");
            System.out.println("Example: java Main 314 15");
            System.exit(0);
        }
        int seed1 = Integer.parseInt(args[0]);
        int seed2 = Integer.parseInt(args[1]);
        Player player1 = new Player("두리", new WinningStrategy(seed1));
        Player player2 = new Player("하나", new ProbStrategy(seed2));

        for (int i = 0; i < 5; i++) {
            System.out.format("Game.#%d -> ", i);
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner:" + player1);
                player1.win();
                player2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Winner:" + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }
        System.out.println();
        System.out.println("Total result:");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }
}
