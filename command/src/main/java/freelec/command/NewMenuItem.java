package freelec.command;

import java.awt.*;

public class NewMenuItem extends MenuItem implements Command {

    private TextArea text;

    public NewMenuItem(String s, TextArea text) {
        super(s);
        this.text = text;
    }

    // TextArea 를 초기화 한다
    public void execute() {
        text.setText(null);
    }

}
