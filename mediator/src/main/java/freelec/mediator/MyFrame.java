package freelec.mediator;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {

    Mediator med;

    public MyFrame(Mediator med, String s) {
        super(s);
        this.med = med;
        // 객체 자신을 mediator에 등록한다.
        med.registFrame(this);
        addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
    }

}
