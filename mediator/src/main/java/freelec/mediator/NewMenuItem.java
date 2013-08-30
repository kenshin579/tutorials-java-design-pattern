package freelec.mediator;

import java.awt.*;

// 새로운 문서를 열기 위한 클래스
public class NewMenuItem extends MenuItem implements Command {

    Mediator med;

    public NewMenuItem(Mediator med, String s) {
        super(s);
        this.med = med;
        // 객체 자신을 mediator 에 등록
        med.registNew(this);
    }

    // mediator 의 clean 메소드를 호출
    public void execute() {
        med.clean();
    }

}
