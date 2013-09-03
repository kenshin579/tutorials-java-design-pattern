package youngjin.commandQ1.drawer;

import youngjin.commandQ1.macrocommand.Command;

import java.awt.*;

/**
 * 점 그리기 명령어를 나타냄
 */
public class DrawCommand implements Command {
    // 그림 그리기 대상
    protected Drawable drawable;
    // 그림 그리기 위치
    private Point position;

    // 생성자
    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    // 실행
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
