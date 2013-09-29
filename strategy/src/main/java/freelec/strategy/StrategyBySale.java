package freelec.strategy;

// 매출액이 많은 순으로 회사를 투자하도록 하는 전략을 구현한 클래스

public class StrategyBySale implements Strategy {

    final static int CODE = 3;

    public Stock[] invest() {

        Database db = Database.getInstance();

        // 매출액 순으로 정렬된 회사 객체 배열
        Stock stocks[] = db.getAllStocks(CODE);

        return stocks;

    }

};
