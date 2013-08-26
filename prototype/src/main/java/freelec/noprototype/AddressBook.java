package freelec.noprototype;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 문제점:
 * - 정렬 방식이 변경될 때마다 DB에 접속하여 다시 정보를 얻어온다.
 *  (같은 내용을 포함하는 객체를 필요한 경우에 따라서 계속 만들어냄)
 */
public class AddressBook implements ActionListener {

    private Frame frame;
    private Panel south;
    private List list;
    private Button age, name, tel;

    private ExpensiveDataBase edb;

    // 정렬 방식을 구분하기 위한 코드 값
    private int _default = 0, _age = 1, _name = 2, _tel = 3;

    private Address addresses[];

    public AddressBook(String str) {

        frame = new Frame(str);
        south = new Panel();
        south.setLayout(new GridLayout(1, 3));

        list = new List();

        age = new Button("Age");
        name = new Button("Name");
        tel = new Button("tel");

        age.addActionListener(this);
        name.addActionListener(this);
        tel.addActionListener(this);

        // 버튼을 아래에 있는 Panel에 추가함
        south.add(age);
        south.add(name);
        south.add(tel);

        // 전체 frame에 리스트와 button panel를 추가함
        frame.add(list);
        frame.add(south, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setBounds((1280 - 150) / 2, (1024 - 200) / 2, 150, 200);
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );

        // 테이타 베이스 객체 생성
        edb = new ExpensiveDataBase("127.0.0.1");
        // 최초 입력된 순서로서 회원 정보를 정렬한다. 이 후
        addresses = edb.getAllAddresses(_default);

        show();

    }

    // 원하는 정렬 방식에 따라 반환되는 객체를 달리한다.
    public void actionPerformed(ActionEvent e) {

        Button but = (Button) e.getSource();

        // 나이 순
        if (but == age) {
            addresses = edb.getAllAddresses(_age);

            // 이름 순
        } else if (but == name) {
            addresses = edb.getAllAddresses(_name);

            // 전화 번호 수
        } else if (but == tel) {
            addresses = edb.getAllAddresses(_tel);
        }

        show();

    }


    public void show() {
        list.removeAll();

        for (int i = 0; i < addresses.length; i++) {

            Address addr = addresses[i];

            String ssn = addr.getSsn();
            String name = addr.getName();
            String tel = addr.getTel();
            String address = addr.getAddress();
            int gender = addr.getGender();
            String _gender = null;

            if (gender == 1) {
                _gender = "M";
            } else {
                _gender = "F";
            }

            list.add(ssn + " " + name + "\t " + tel + " " + address + " " + _gender);
        }

    }

    public static void main(String args[]) {
        new AddressBook("Address Book");
    }

}
