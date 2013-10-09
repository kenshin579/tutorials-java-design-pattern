package freelec.chainofresponsiblity.client;

import javax.swing.*;

public class ExchangeBuilder extends Builder {

    private JPanel panel;
    private JTable table;
    private Exchange exchanges[];
    private String[] columns;
    private Object data[][];

    final static int height = 1028;
    final static int width = 1280;
    final static int _height = 300;
    final static int _width = 500;

    public ExchangeBuilder(Exchange exchanges[]) {

        // 새로이 변경된 주식 시세
        this.exchanges = exchanges;

        // 일련 번호를 증가시킴
        count++;

    }

    // table의 column 헤더 이름들
    public void buildColumns() {
        columns = new String[4];
        columns[0] = "Item";
        columns[1] = "Buy";
        columns[2] = "Sell";
        columns[3] = "Rate";
    }

    // table에서 보여줄 data를
    // 참조되는 주식 가격으로 초기화 한다.
    public void buildContents() {

        Object _data[][] = new Object[exchanges.length][4];

        for (int i = 0; i < _data.length; i++) {
            _data[i][0] = exchanges[i].getItem();
            _data[i][1] = new Float(exchanges[i].getBuy());
            _data[i][2] = new Float(exchanges[i].getSell());
            _data[i][3] = new Float(exchanges[i].getRate());
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
        return "Exchange " + count + " th";
    }

}
