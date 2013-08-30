package youngjin;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ColleagueTextField extends TextField implements TextListener, Colleague {
    private Mediator mediator;

    public ColleagueTextField(String text, int columns) {   // ����
        super(text, columns);
    }

    public void setMediator(Mediator mediator) {         // Mediator�� ����
        this.mediator = mediator;
    }

    public void setColleagueEnabled(boolean enabled) {   // Mediator���� ��ȿ/��ȿ�� ����
        setEnabled(enabled);
        setBackground(enabled ? Color.white : Color.lightGray);
    }

    public void textValueChanged(TextEvent e) {          // ���ڿ��� ���ϸ� Mediator���� ����
        mediator.colleagueChanged();
    }
}
