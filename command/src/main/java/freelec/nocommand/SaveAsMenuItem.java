package freelec.nocommand;

import java.awt.*;

public class SaveAsMenuItem extends MenuItem implements Command {

    private Frame frame;

    public SaveAsMenuItem(String s, Frame frame) {
        super(s);
        this.frame = frame;
    }

    // SaveAsDialog 창을 띄운다
    public void execute() {
        FileDialog dialog = new FileDialog(frame, "Save As", FileDialog.SAVE);
        dialog.show();
    }

}
