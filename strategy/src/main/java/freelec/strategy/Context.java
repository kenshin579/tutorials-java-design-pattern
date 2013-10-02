package freelec.strategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 */
public class Context implements ActionListener {

    private JButton pButton;
    private JButton rdButton;
    private JButton sButton;

    private JFrame frame;
    private JTable table;

    private Container contentPane;

    private Mediator med;

    private Context() {

        med = Mediator.getInstance();
        frame = new JFrame("Stock invest");
        contentPane = frame.getContentPane();
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );

        // 각 각의 전략에 따른 Button 객체를 생성 (다른 알고리즘을 넘겨줌)
        pButton = new ProfitButton(new StrategyByProfit(), "Profit");
        rdButton = new RDButton(new StrategyByRD(), "R&D");
        sButton = new SaleButton(new StrategyBySale(), "Sale");

        table = new JTable();
        med.setTable(table);            // mediator 중개자가 table을 정렬할 있도록 table 객체를 저장한다.

        JPanel center = new JPanel();
        JPanel south = new JPanel();
        center.add(table);
        south.add(pButton);
        south.add(rdButton);
        south.add(sButton);

        contentPane.add(center);
        contentPane.add(south, BorderLayout.SOUTH);

        frame.setBounds(100, 200, 350, 250);
        frame.setVisible(true);

        pButton.addActionListener(this);
        rdButton.addActionListener(this);
        sButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        // 이벤트 객체는 모두 Command 인터페이스를 상속받은 것들이므로 로 형 변환 (Class Type Casting)될 수 있다.
        // 여기서 받은 cmd는 클릭한 메뉴의 item 객체(ex.Command 인터페이스를 구현한 ProfitButton)이 된다.
        Command cmd = (Command) e.getSource();

        // Command 패턴을 사용하여 조건문을 제거함
        cmd.execute();
    }

    public static void main(String args[]) {
        new Context();
    }

}
