package freelec.strategy;

// 순이익이 많은 순으로 회사를 투자하도록 하는 전략을 구현한 클래스

public class StrategyByProfit implements Strategy {

    final static int CODE = 1;

    public Stock[] invest() {

        Database db = Database.getInstance();

        // 순이익 순으로 정렬된 회사 객체 배열
        Stock stocks[] = db.getAllStocks(CODE);

        return stocks;

    }

};

