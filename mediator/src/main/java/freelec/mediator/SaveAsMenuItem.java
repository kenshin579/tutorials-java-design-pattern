package freelec.mediator;

import java.awt.*;

// 문서를 다른이름 저장하기 위한 클래스
public class SaveAsMenuItem extends MenuItem implements Command {

    Mediator med;

    public SaveAsMenuItem(Mediator med, String s) {
        super(s);
        this.med = med;
        // 객체 자신을 mediator에 등록한다.
        med.registSaveAs(this);
    }

    // mediator의 saveas 메소드를 호출한다.
    public void execute() {
        med.saveas();
    }

}
