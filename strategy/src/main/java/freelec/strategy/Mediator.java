package freelec.strategy;

import javax.swing.*;

public class Mediator {

    private static Mediator med = new Mediator();
    private JTable table;
    private Strategy strategy;
    private Stock stocks[];

    private Mediator() {
    }

    public static Mediator getInstance() {
        return med;
    }

    // 투자 전략에 따른 회사 정렬을 보여주는 메소드
    public void setTableModel() {
        table.setModel(new MyTableModel(stocks));
    }


    public void setTable(JTable table) {
        this.table = table;
    }

    // 순이익에 따른 회사를 정렬시킴
    public void setStrategyByProfit(Strategy strategy) {
        stocks = strategy.invest();
        setTableModel();
    }

    // 연구 개발비 따른 회사를 정렬시킴
    public void setStrategyByRD(Strategy strategy) {
        stocks = strategy.invest();
        setTableModel();
    }

    // 매출액에 따른 회사를 정렬시킴
    public void setStrategyBySale(Strategy strategy) {
        stocks = strategy.invest();
        setTableModel();
    }

}
