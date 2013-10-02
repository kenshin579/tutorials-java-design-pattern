package freelec.strategy;

import javax.swing.table.AbstractTableModel;

// Table 이 테이타를 이용하여 표를 만들기 위해 필요한 메소드에 정의되어 있다
// AbstractTableModel 클래스는 이러한 기본적인 메소드들이 구현되어 있다.
// EventListener 관리와 TableModelEvent 생성하고 이를 listener 에게 전파

public class MyTableModel extends AbstractTableModel {

    private String columnNames[] = new String[]{"Name", "Property", "Sale", "Profit", "RD"};
    private Object rowData[][];
    private Stock stocks[];


    // TableModel을 생성하면서 Table을 만드는데 필요한 테이타를 초기화 한다.
    public MyTableModel(Stock stocks[]) {
        this.stocks = stocks;
    }

    // 명시된 순번의 column 헤더 타이틀
    @Override
    public String getColumnName(int col) {
        System.out.println(columnNames[col].toString());
        return columnNames[col].toString();
    }

    // Table 의 row 수를 반환하는 메소드
    public int getRowCount() {
        return stocks.length;
    }

    // Table의 컬럼 수를 반환하는 메소드
    public int getColumnCount() {
        System.out.println(columnNames.length);
        return columnNames.length;
    }

    // 명시된 행, 열에 해당하는 테이타를 반환
    public Object getValueAt(int row, int col) {
        //return rowData[row][col];
        //(String name, int property, int sale, int profit, int rd){
        Stock stock = stocks[row];
        String value = null;
        if (col == 0) {
            value = stock.getName();
        } else if (col == 1) {
            value = String.valueOf(stock.getProperty());
        } else if (col == 2) {
            value = String.valueOf(stock.getSale());
        } else if (col == 3) {
            value = String.valueOf(stock.getProfit());
        } else if (col == 4) {
            value = String.valueOf(stock.getRd());
        }

        return value;
    }

    // table 의 각 cell 에 대한 편집 여부를 설정
    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }

}
