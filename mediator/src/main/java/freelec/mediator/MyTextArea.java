package freelec.mediator;

import java.awt.*;

public class MyTextArea extends TextArea {

    Mediator med;

    public MyTextArea(Mediator med, String s) {
        super(s);
        this.med = med;
        // 객체 자신을 mediator에 등록한다.
        med.registTextArea(this);
    }

}
