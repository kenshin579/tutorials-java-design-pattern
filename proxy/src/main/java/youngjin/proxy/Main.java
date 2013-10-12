package youngjin.proxy;

/**
 * Subject의 역할: Printable 인터페이스
 * - Proxy오 RealSubject 역할을 동일시하기 위해 인터페이스를 정의함
 * <p/>
 * Proxy(대리인)의 역할: PrinterProxy
 * - 자신만으로 처리할 수 없으면 RealSubject 역할에게 처리를 맡긴다.
 * <p/>
 * RealSubject(실제의 주제)의 역할: Printer
 * - 대리인이 감당할 수 없는 일이 발생했을 때 등장하는 것이 '본인'인 RealSubject의 역할
 * - Proxy 클래스와 마찬가지로 Subject의 역할에서 정해져 있는 인터페이스를 구현함
 * <p/>
 * Client(의뢰인)의 역할: Main 클래스
 */
public class Main {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice");
        System.out.println("이름은 현재 " + p.getPrinterName() + "입니다.");

        p.setPrinterName("Bob");
        System.out.println("이름은 현재 " + p.getPrinterName() + "입니다.");
        p.print("Hello, world.");
    }
}
