package freelec.composite.organization;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;

public class Organization {

    private Frame frame;
    private List depart;
    private List subdepart;

    private DBWrapper dbWrapper;
    private Organ allOrgans[];

    public Organization() {

        // Wrapper 클래스에 대한 참조
        dbWrapper = new DBWrapper();
        frame = new Frame();

        // 부서를 표현하기 위한 List
        depart = new List();

        // 부서의 하부 구조를 표현하기 위한 List
        subdepart = new List();

        // List에서 Item이 선택이 되면 itemStateChanged 메서드가 호출되도록 listener를 추가함
        MyItemListener me = new MyItemListener();
        depart.addItemListener(me);
        subdepart.addItemListener(me);

        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );

        frame.setLayout(new GridLayout(1, 2));
        frame.add(depart);
        frame.add(subdepart);
        frame.setBounds((1280 - 160) / 2, (1024 - 100) / 2, 160, 100);
        frame.setVisible(true);

    }

    // 테이타 베이스로부터 부서에 대한 정보를 참조
    public void setDepart() {

        allOrgans = dbWrapper.getAllOrgan();

        try {
            allOrgans = dbWrapper.getAllOrgan(allOrgans);
        } catch (InvalidAdditionException e) {
            e.printStackTrace();
        }

        // depart List GUI에 추가함
        for (int i = 0; i < allOrgans.length; i++) {
            depart.add(allOrgans[i].getTitle());
        }

    }

    class MyItemListener implements ItemListener {

        public void itemStateChanged(ItemEvent e) {

            List list = (List) e.getSource();

            // 부서 List가 선택되었으면
            if (list == depart) {

                int index = list.getSelectedIndex();

                // 선택된 부서의 하부 구조를 참조할 수 있도록 한다.
                Organ organ = allOrgans[index];
                Enumeration _enum = organ.elements();

                subdepart.removeAll();

                // 하부 구조의 정보를 List에 보여준다
                while (_enum.hasMoreElements()) {
                    Organ _organ = (Organ) _enum.nextElement();
                    String title = _organ.getTitle();
                    int invest = _organ.getInvest();
                    int loss = _organ.getLoss();
                    int profit = _organ.getProfit();
                    subdepart.add(title + " " + invest + " " + loss + " " + profit);
                }

            }

        }

    }

    public static void main(String args[]) {
        new Organization().setDepart();
    }

}

