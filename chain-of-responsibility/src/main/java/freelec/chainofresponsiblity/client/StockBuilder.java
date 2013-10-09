package freelec.chainofresponsiblity.client;

import javax.swing.*;

public class StockBuilder extends Builder {

    private JPanel panel;
    private JTable table;
    private Stock stocks[];
    private String[] columns;
    private Object data[][];

    final static int height = 1028;
    final static int width = 1280;
    final static int _height = 300;
    final static int _width = 500;

    public StockBuilder(Stock stocks[]) {

        // 새로이 변경된 주식 시세
        this.stocks = stocks;

        // 일련 번호를 증가시킴
        count++;

    }

    // table의 column 헤더 이름들
    public void buildColumns() {
        columns = new String[4];
        columns[0] = "Item";
        columns[1] = "Current price";
        columns[2] = "Up & Down";
        columns[3] = "Up & Down rate";
    }

    // table에서 보여줄 data 를
    // 참조되는 주식 가격으로 초기화 한다.
    public void buildContents() {

        Object _data[][] = new Object[stocks.length][4];

        for (int i = 0; i < _data.length; i++) {
            _data[i][0] = stocks[i].getItem();
            _data[i][1] = new Integer(stocks[i].getCurrent());
            _data[i][2] = new Float(stocks[i].getUpnDwn());
            _data[i][3] = new Float(stocks[i].getUpnDwnPer());
        }

        data = _data;

    }

    // 참조되는 주식 가격으로 작성된 JTable을 반환할 수 있도록 함
    public JScrollPane getTable() {
        table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);
        return scroll;
    }

    // 타이틀을 반환함
    public String getTitle() {
        return "Stock " + count + " th";
    }

}

