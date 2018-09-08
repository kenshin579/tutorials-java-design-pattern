package freelec.mediator;

import java.awt.*;


// 메모장 프로세스를 종료하기 위한 클래스
public class ExitMenuItem extends MenuItem implements Command {

    Mediator med;

    public ExitMenuItem(Mediator med, String s) {
        super(s);
        this.med = med;
        // 객체 자신을 mediator에 등록한다.
        med.registExit(this);
    }

    // mediator의 exit 메소드를 호출
    public void execute() {
        med.exit();
    }

}
