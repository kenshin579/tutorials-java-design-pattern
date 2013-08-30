package freelec.command;

import java.awt.*;

public class ExitMenuItem extends MenuItem implements Command {

    public ExitMenuItem(String s) {
        super(s);
    }

    // 메모장을 종료한다
    public void execute() {
        System.exit(0);
    }

}
