package freelec.mediator;

import java.awt.*;

// 새로운 문서를 열기 위한 클래스
public class OpenMenuItem extends MenuItem implements Command {

    Mediator med;

    public OpenMenuItem(Mediator med, String s) {
        super(s);
        this.med = med;
        // 객체  자신을 mediator에 등록한다
        med.registOpen(this);
    }

    // mediator 의 open 메소드를 호출
    public void execute() {
        med.open();
    }

}
