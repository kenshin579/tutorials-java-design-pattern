package freelec.strategy;

import javax.swing.*;

public class ProfitButton extends JButton implements Command {

    private Mediator med;

    // 투자 전략을 구현한 객체로서
    // 순이익이 많은 회사에 투자하는 전략 객체이다.
    private Strategy strategy;

    public ProfitButton(Strategy strategy, String label) {
        super(label);
        med = Mediator.getInstance();
        this.strategy = strategy;
    }

    // 순이익을 기준으로 하는 투자 전략을 수립하는 메소드
    public void execute() {
        med.setStrategyByProfit(strategy);
    }

}
