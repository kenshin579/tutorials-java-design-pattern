package freelec.command;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Command 인터페이스를 두어서 조건절을 사용하지 않고도 같은 인터페이스로 각각 다른 기능을 수행할 수 있다.
 */
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
        text = new TextArea();
        frame = new Frame("NotePad");
        file = new Menu("File");

        _new = new NewMenuItem("New", text);
        open = new OpenMenuItem("Open", frame);
        save = new SaveMenuItem("Save", frame);
        saveas = new SaveAsMenuItem("Save as", frame);
        exit = new ExitMenuItem("Exit");
        bar = new MenuBar();

        file.add(_new);
        file.add(open);
        file.add(save);
        file.add(saveas);
        file.add(exit);
        bar.add(file);


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
        // 이벤트 객체는 모두 Command 인터페이스를 상속받은 것들이므로 로 형 변환 (Class Type Casting)될 수 있다.
        Command com = (Command) e.getSource();
        // Command 인터페이스를 구현한 객체는 execute() 메서드를 구현해야 한다.
        com.execute();
    }

    public static void main(String args[]) {
        new NotePad();
    }

}	
