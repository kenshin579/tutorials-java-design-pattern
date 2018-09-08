package freelec.mediator;

import java.awt.*;

public class Mediator {

    MenuItem _new;
    MenuItem open;
    MenuItem save;
    MenuItem saveas;
    MenuItem exit;
    Frame frame;
    TextArea text;

    // NewMenuItem을 등록하는 메소드
    public void registNew(NewMenuItem menu) {
        _new = menu;
    }

    // OpenMenuItem을 등록하는 메소드
    public void registOpen(OpenMenuItem menu) {
        open = menu;
    }

    // SaveMenuItem을 등록하는 메소드
    public void registSave(SaveMenuItem menu) {
        save = menu;
    }

    // SaveAsMenuItem을 등록하는 메소드
    public void registSaveAs(SaveAsMenuItem menu) {
        saveas = menu;
    }

    // ExitMenuItem을 등록하는 메소드
    public void registExit(ExitMenuItem menu) {
        exit = menu;
    }

    // Frame을 등록하는 메소드
    public void registFrame(MyFrame frame) {
        this.frame = frame;
    }

    // TextArea을 등록하는 메소드
    public void registTextArea(MyTextArea text) {
        this.text = text;
    }

    // NewMenuItem 의 excute 메소드에 의해 호출될 메소드
    public void clean() {
        text.setText(null);
    }

    // OpenMenuItem 의 excute 메소드에 의해 호출될 메소드
    public void open() {
        FileDialog dialog = new FileDialog(frame, "Open", FileDialog.LOAD);
        dialog.show();
    }

    // SaveMenuItem 의 excute 메소드에 의해 호출될 메소드
    public void save() {
        FileDialog dialog = new FileDialog(frame, "Save", FileDialog.SAVE);
        dialog.show();
    }

    // SaveAsMenuItem 의 excute 메소드에 의해 호출될 메소드
    public void saveas() {
        FileDialog dialog = new FileDialog(frame, "Save As", FileDialog.SAVE);
        dialog.show();
    }

    // ExitMenuItem 의 excute 메소드에 의해 호출될 메소드
    public void exit() {
        System.exit(0);
    }

}

