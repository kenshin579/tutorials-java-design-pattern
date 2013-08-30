package youngjin;

import java.awt.*;

public class ColleagueButton extends Button implements Colleague {
    private Mediator mediator;

    public ColleagueButton(String caption) {
        super(caption);
    }

    public void setMediator(Mediator mediator) {            // Mediator�� ����
        this.mediator = mediator;
    }

    public void setColleagueEnabled(boolean enabled) {      // Mediator���� ��ȿ/��ȿ�� ����
        setEnabled(enabled);
    }
}
