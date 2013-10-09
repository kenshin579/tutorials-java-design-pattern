package freelec.nobridge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UI implements ActionListener {

    //private Bank bank;
    private AdvancedBank bank;

    private JFrame frame;

    private JLabel from;
    private JLabel to;
    private JLabel account;

    private JTextField _from;
    private JTextField _to;
    private JTextField _account;

    private JButton enter;

    public UI() {

        //bank = new Bank(new BankImpl());
        bank = new AdvancedBank(new BankImpl());

        frame = new JFrame("Banking");
        Container contentPane = frame.getContentPane();

        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );

        from = new JLabel("From");
        to = new JLabel("To");
        account = new JLabel("Account");

        _from = new JTextField();
        _to = new JTextField();
        _account = new JTextField();

        enter = new JButton("Enter");
        enter.addActionListener(this);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 2));
        contentPane.add(center);

        center.add(from);
        center.add(_from);
        center.add(to);
        center.add(_to);
        center.add(account);
        center.add(_account);

        JPanel bottom = new JPanel();
        bottom.add(enter);
        contentPane.add(bottom, BorderLayout.SOUTH);

        frame.setBounds((1024 - 250) / 2, (763 - 250) / 2, 250, 250);
        frame.setVisible(true);

    }// constructor

    public void actionPerformed(ActionEvent e) {
        String id_from = _from.getText().trim();
        String id_to = _to.getText().trim();
        String howmuch = _account.getText().trim();

        if (id_from.length() > 0 && howmuch.length() > 0 && id_to.length() == 0) {
            try {
                bank.withdraw(id_from, Integer.parseInt(howmuch));
            } catch (IDNotFoundException err) {
                setDialog(err);
            } catch (InvalidTransactionException err) {
                setDialog(err);
            }
        }

        if (id_from.length() == 0 && howmuch.length() > 0 && id_to.length() > 0) {
            try {
                bank.deposit(id_to, Integer.parseInt(howmuch));
            } catch (IDNotFoundException err) {
                setDialog(err);
            } catch (InvalidTransactionException err) {
                setDialog(err);
            }
        }

        if (id_from.length() > 0 && howmuch.length() > 0 && id_to.length() > 0) {
            try {
                bank.transfer(id_from, id_to, Integer.parseInt(howmuch));
            } catch (IDNotFoundException err) {
                setDialog(err);
            } catch (InvalidTransactionException err) {
                setDialog(err);
            }
        }

        initTextField();
    }

    public void initTextField() {
        _from.setText("");
        _to.setText("");
        _account.setText("");
    }

    public void setDialog(Exception e) {
        final Dialog d = new Dialog(frame, "Check it out", true);
        d.add(new JLabel(e.toString()));
        d.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        d.dispose();
                    }
                }
        );

        d.setBounds((1023 - 150) / 2, (763 - 80) / 2, 150, 80);
        d.setVisible(true);
    }

    public static void main(String args[]) {
        new UI();
    }

}
