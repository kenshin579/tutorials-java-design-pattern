package freelec.mediator;

import java.awt.*;

// 문서를 저장하기 위한 클래스
public class SaveMenuItem extends MenuItem implements Command {

    Mediator med;

    public SaveMenuItem(Mediator med, String s) {
        super(s);
        this.med = med;
        // 객체 자신을 mediator 에 등록
        med.registSave(this);
    }

    // mediator 의 save 메소드를 호출
    public void execute() {
        med.save();
    }

}
