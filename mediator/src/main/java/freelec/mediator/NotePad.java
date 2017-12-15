package freelec.mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Mediator 패턴: 인터페이스를 통하지 않은 의존성의 제거
 * - Command 패턴에서 작성한 MenuItem 컴포넌트들이 가진 모든 UI 컴포넌트와의 연관관계를 제거하고
 * Mediator 클래스와 관계를 갖게끔 함.
 */
public class NotePad implements ActionListener {

    private Menu file;
    private MenuItem _new;
    private MenuItem open;
    private MenuItem save;
    private MenuItem saveas;
    private MenuItem exit;

    private MenuBar bar;

    private MyTextArea text;
    private MyFrame frame;
    private Mediator med;

    public NotePad() {
        med = new Mediator();

        text = new MyTextArea(med, "TextArea");
        frame = new MyFrame(med, "NotePad");

        file = new Menu("File");

        // 새로이 작성한 MenuItem을 사용한다.
        _new = new NewMenuItem(med, "New");
        open = new OpenMenuItem(med, "Open");
        save = new SaveMenuItem(med, "Save");
        saveas = new SaveAsMenuItem(med, "Save as");

        exit = new ExitMenuItem(med, "Exit");
        bar = new MenuBar();

        file.add(_new);
        file.add(open);
        file.add(save);
        file.add(saveas);
        file.add(exit);
        bar.add(file);

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
        Command com = (Command) e.getSource();
        com.execute();
    }

    public static void main(String args[]) {
        new NotePad();
    }

}	
