package freelec.chainofresponsiblity.client;

import javax.swing.*;

public class FundBuilder extends Builder {

    private JPanel panel;
    private JTable table;
    private Fund funds[];
    private String[] columns;
    private Object data[][];

    final static int height = 1028;
    final static int width = 1280;
    final static int _height = 300;
    final static int _width = 500;

    public FundBuilder(Fund funds[]) {

        // 새로이 변경된 주식 시세
        this.funds = funds;

        // 일련 번호를 증가시킴
        count++;

    }

    // table의 column 헤더 이름들
    public void buildColumns() {
        columns = new String[4];
        columns[0] = "Item";
        columns[1] = "Current Price";
        columns[2] = "Commision";
        columns[3] = "Day Commision";
    }

    // table에서 보여줄 data 를
    // 참조되는 주식 가격으로 초기화 한다.
    public void buildContents() {

        Object _data[][] = new Object[funds.length][4];

        for (int i = 0; i < _data.length; i++) {
            _data[i][0] = funds[i].getItem();
            _data[i][1] = new Integer(funds[i].getCurrent());
            _data[i][2] = new Float(funds[i].getCommision());
            _data[i][3] = new Float(funds[i].getDayCommision());
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
        return "Fund " + count + " th";
    }

}
