package youngjin.proxy;

public class PrinterProxy implements Printable {
    private String name;                    // 이름
    private Printer real;                   // 「본인」

    public PrinterProxy() {
    }

    public PrinterProxy(String name) {      // 생성자
        this.name = name;
    }

    @Override
    public synchronized void setPrinterName(String name) {  // 이름의 설정
        if (real != null) {
            real.setPrinterName(name);      // 「본인」에게도 설정한다
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {        // 이름의 설정
        return name;
    }

    /**
     * 실제로 프린터를 실행하는 단계가 되어서야 비로서 실제 Printer 클래스를 생성하고함
     *
     * @param string
     */
    @Override
    public void print(String string) {     // 표시
        realize();
        real.print(string);                 // 위임시킴
    }

    private synchronized void realize() {   // 「본인」을 생성
        if (real == null) {
            real = new Printer(name);
        }
    }
}
