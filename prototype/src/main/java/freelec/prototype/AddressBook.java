package freelec.prototype;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddressBook implements ActionListener {

    private Frame frame;
    private Panel south;
    private List list;
    private Button age, name, tel;

    private ExpensiveDataBase e;
    private Data data;

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

        south.add(age);
        south.add(name);
        south.add(tel);

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

        e = new ExpensiveDataBase("127.0.0.1");
        addresses = e.getAllAddresses();

        // 원본이 되는 객체를 생성한다
        data = new SortedByAgeData(addresses);

        show();

    }

    public void actionPerformed(ActionEvent e) {

        Button but = (Button) e.getSource();

        if (but == age) {
            listByAge();
        } else if (but == name) {
            listByName();
        } else if (but == tel) {
            listByTel();
        }

        show();

    }

    // 원형 객체를 복사한다.
    public void listByAge() {
        data = new SortedByAgeData(data);
    }

    public void listByName() {
        data = new SortedByNameData(data);
    }

    public void listByTel() {
        data = new SortedByTelData(data);
    }

    public void show() {

        list.removeAll();

        // 복사된 객체를 정렬 방식에 따라 정렬한다.
        data.sort();

        for (int i = 0; i < data.getSize(); i++) {

            Address add = data.getAddress(i);

            String ssn = add.getSsn();
            String name = add.getName();

            String tel = add.getTel();
            String address = add.getAddress();
            int gender = add.getGender();
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
