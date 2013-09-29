package freelec.strategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

        // 각 각의 전략에 따른 Button 객체를 생성
        pButton = new ProfitButton(new StrategyByProfit(), "Profit");
        rdButton = new RDButton(new StrategyByRD(), "R&D");
        sButton = new SaleButton(new StrategyBySale(), "Sale");

        table = new JTable();
        med.setTable(table);

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
        Command cmd = (Command) e.getSource();
        cmd.execute();
    }

    public static void main(String args[]) {
        new Context();
    }

}
