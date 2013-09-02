package freelec.command;

import java.awt.*;

public class NewMenuItem extends MenuItem implements Command {

    private TextArea text;

    /*
    NewMenuItem 클래스의 객체는 TextArea 클래스 객체와 연관되어 있음.
    중개자가 없으므로 연관된 클래스의 변화가 발생하면 관계된 크래스의 변화는 필수가 되는 이슈가 있음.
     */
    public NewMenuItem(String s, TextArea text) {
        super(s);
        this.text = text;
    }

    // TextArea 를 초기화 한다
    public void execute() {
        text.setText(null);
    }

}
