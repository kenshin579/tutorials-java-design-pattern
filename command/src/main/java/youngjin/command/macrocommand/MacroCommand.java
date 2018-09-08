package youngjin.command.macrocommand;

import java.util.Iterator;
import java.util.Stack;

/**
 * MacroCommand 클래스는 복수의 명령을 모은 명령을 나타냄
 */
public class MacroCommand implements Command {
    // 명령의 집합
    private Stack commands = new Stack();

    // 실행
    public void execute() {
        Iterator it = commands.iterator();
        while (it.hasNext()) {
            ((Command) it.next()).execute();
        }
    }

    // 추가
    public void append(Command cmd) {
        if (cmd != this) {
            commands.push(cmd);
        }
    }

    // 최후의 명령(마지막 명령어)을 삭제
    public void undo() {
        if (!commands.empty()) {
            commands.pop();
        }
    }

    // 전부 삭제
    public void clear() {
        commands.clear();
    }
}
