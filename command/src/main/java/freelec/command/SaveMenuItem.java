package freelec.command;

import java.awt.*;

public class SaveMenuItem extends MenuItem implements Command {

    private Frame frame;

    public SaveMenuItem(String s, Frame frame) {
        super(s);
        this.frame = frame;
    }

    // SaveDialog 창을 띄운다
    public void execute() {
        FileDialog dialog = new FileDialog(frame, "Save", FileDialog.SAVE);
        dialog.show();
    }

}
