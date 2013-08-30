package youngjin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    // ����
    // Colleague���� ���ϰ�, ��ġ�� �Ŀ� ǥ�ø� �����Ѵ�
    public LoginFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        // ���̾ƿ� �Ŵ��� ����ؼ� 4X2�� �׸��带 �����
        setLayout(new GridLayout(4, 2));
        // Colleague���� ��
        createColleagues();
        // ��ġ
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);
        // ��ȿ/��ȿ�� �ʱ� ����
        colleagueChanged();
        // ǥ��
        pack();
        show();
    }

    // Colleague���� ���Ѵ�
    public void createColleagues() {
        // ��
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");
        // Mediator�� ��Ʈ
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);
        // Listener�� ��Ʈ
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    // Colleage������ ������ Colleage�� ��ȿ/��ȿ�� �����Ѵ� 
    public void colleagueChanged() {
        if (checkGuest.getState()) {                // Guest ���
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else {                        // Login ���
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }

    // textUser �Ǵ� textPass�� ������ �־��
    // �� Colleage�� ��ȿ/��ȿ�� �����Ѵ�
    private void userpassChanged() {
        if (textUser.getText().length() > 0) {
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length() > 0) {
                buttonOk.setColleagueEnabled(true);
            } else {
                buttonOk.setColleagueEnabled(false);
            }
        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
