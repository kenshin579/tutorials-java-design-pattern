package freelec.chainofresponsiblity.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Director {

    private Builder builder;
    private JFrame frame;
    private Container contentPane;


    final static int height = 1028;
    final static int width = 1280;
    final static int _height = 300;
    final static int _width = 500;

    boolean flag = false;

    public Director(Builder builder) {

        this.builder = builder;

        // 허거번호를 받는다
        String title = builder.getTitle();

        frame = new JFrame(title);
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        frame = null;
                    }
                }
        );

        contentPane = frame.getContentPane();

        frame.setVisible(true);
        frame.setBounds((width - _width) / 2, (height - _height) / 2, _width, _height);

    }

    public void build() {

        // 건축물의 뼈대를 완성하고
        builder.buildColumns();

        // 건축물의 형태를 완성하고
        builder.buildContents();

        contentPane.removeAll();

        // 건축물의 내부를 작성하다.
        contentPane.add(builder.getTable());

        frame.repaint();

    }

}

