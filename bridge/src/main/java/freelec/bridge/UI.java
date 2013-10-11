package freelec.bridge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UI implements ActionListener {

    private AdvancedBank bank;

    private JFrame frame;

    private JLabel fromLabel;
    private JLabel toLabel;
    private JLabel accountLabel;

    private JTextField _fromTextField;
    private JTextField _toTextField;
    private JTextField _accountTextField;

    private JButton enterButton;

    public UI() {

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

        fromLabel = new JLabel("From");
        toLabel = new JLabel("To");
        accountLabel = new JLabel("Account");

        _fromTextField = new JTextField();
        _toTextField = new JTextField();
        _accountTextField = new JTextField();

        enterButton = new JButton("Enter");
        enterButton.addActionListener(this);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 2));
        contentPane.add(center);

        center.add(fromLabel);
        center.add(_fromTextField);
        center.add(toLabel);
        center.add(_toTextField);
        center.add(accountLabel);
        center.add(_accountTextField);

        JPanel bottom = new JPanel();
        bottom.add(enterButton);
        contentPane.add(bottom, BorderLayout.SOUTH);

        frame.setBounds((1024 - 250) / 2, (763 - 250) / 2, 250, 250);
        frame.setVisible(true);

    }// constructor

    public void actionPerformed(ActionEvent e) {
        String id_from = _fromTextField.getText().trim();
        String id_to = _toTextField.getText().trim();
        String howmuch = _accountTextField.getText().trim();

        //인출하기
        if (id_from.length() > 0 && howmuch.length() > 0 && id_to.length() == 0) {
            try {
                bank.withdraw(id_from, Integer.parseInt(howmuch));
            } catch (IDNotFoundException err) {
                setDialog(err);
            } catch (InvalidTransactionException err) {
                setDialog(err);
            }
        }

        //예금하기
        if (id_from.length() == 0 && howmuch.length() > 0 && id_to.length() > 0) {
            try {
                bank.deposit(id_to, Integer.parseInt(howmuch));
            } catch (IDNotFoundException err) {
                setDialog(err);
            } catch (InvalidTransactionException err) {
                setDialog(err);
            }
        }

        //이체하기
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
        _fromTextField.setText("");
        _toTextField.setText("");
        _accountTextField.setText("");
    }

    //다이얼로그 띄우기
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
