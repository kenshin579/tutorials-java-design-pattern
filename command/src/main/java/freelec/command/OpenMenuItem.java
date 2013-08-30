package freelec.command;

import java.awt.*;

public class OpenMenuItem extends MenuItem implements Command {

    private Frame frame;

    public OpenMenuItem(String s, Frame frame) {
        super(s);
        this.frame = frame;
    }

    // OpenDialog 창을 띄운다
    public void execute() {
        FileDialog dialog = new FileDialog(frame, "Open", FileDialog.LOAD);
        dialog.show();
    }

}
