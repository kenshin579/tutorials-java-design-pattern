package youngjin.mediator;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague {
    private Mediator mediator;

    public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) { // 생성자
        super(caption, group, state);
    }

    public void setMediator(Mediator mediator) {           // Mediator을 저장
        this.mediator = mediator;
    }

    public void setColleagueEnabled(boolean enabled) {    // Mediator에서 유효/무효를 지시
        setEnabled(enabled);
    }

    public void itemStateChanged(ItemEvent e) {           // 상태가 바뀌면 Mediator에게 통지
        mediator.colleagueChanged();
    }
}
