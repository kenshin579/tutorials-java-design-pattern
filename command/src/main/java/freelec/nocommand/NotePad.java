package freelec.nocommand;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NotePad implements ActionListener {
    private Menu file;
    private MenuItem _new;
    private MenuItem open;
    private MenuItem save;
    private MenuItem saveas;
    private MenuItem exit;

    private MenuBar bar;

    private TextArea text;
    private Frame frame;

    public NotePad() {
        file = new Menu("File");
        _new = new MenuItem("New");
        open = new MenuItem("Open");
        save = new MenuItem("Save");
        saveas = new MenuItem("Save as");
        exit = new MenuItem("Exit");
        bar = new MenuBar();

        text = new TextArea();

        file.add(_new);
        file.add(open);
        file.add(save);
        file.add(saveas);
        file.add(exit);
        bar.add(file);

        frame = new Frame("NotePad");
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );

        frame.setMenuBar(bar);
        frame.add(text);
        frame.setBounds((1280 - 200) / 2, (1024 - 150) / 2, 200, 150);
        frame.setVisible(true);

        addListener();
    }

    public void addListener() {
        _new.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        saveas.addActionListener(this);
        exit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        MenuItem item = (MenuItem) e.getSource();
        String str = item.getLabel();

        // 메뉴가 추가될때마다 조건문 수정이 필요함
        if (str.equals("New")) {
            clean();
        } else if (str.equals("Open")) {
            open();
        } else if (str.equals("Save")) {
            save();
        } else if (str.equals("Save as")) {
            saveas();
        } else if (str.equals("Exit")) {
            exit();
        }

    }

    public void clean() {
        text.setText(null);
    }

    public void open() {
        FileDialog dialog = new FileDialog(frame, "Open", FileDialog.LOAD);
        dialog.show();
    }

    public void save() {
        FileDialog dialog = new FileDialog(frame, "Save", FileDialog.SAVE);
        dialog.show();
    }

    public void saveas() {
        FileDialog dialog = new FileDialog(frame, "Save As", FileDialog.SAVE);
        dialog.show();
    }

    public void exit() {
        System.exit(0);
    }

    public static void main(String args[]) {
        new NotePad();
    }

}	
