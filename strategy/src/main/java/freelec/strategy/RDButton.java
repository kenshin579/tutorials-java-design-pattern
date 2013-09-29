package freelec.strategy;

import javax.swing.*;

public class RDButton extends JButton implements Command {

    private Mediator med;

    // 투자 전략을 구현한 객체로서
    // 연구 개발비가 많은 회사에 투자하는 전략 객체이다.
    private Strategy strategy;

    public RDButton(Strategy strategy, String label) {
        super(label);
        med = Mediator.getInstance();
        this.strategy = strategy;
    }

    // 연구개발비를 기준으로 하는 투자 전략을 수립하는 메소드
    public void execute() {
        med.setStrategyByRD(strategy);
    }

}
