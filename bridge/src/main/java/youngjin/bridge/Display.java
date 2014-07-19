package youngjin.bridge;

/**
 * 기능의 클래스 계층 (SuperClass)
 * 다리 역할은 하는 부분(내가 어떻게 접근해서 사용할 것인지에 대한 고민)은
 * - 이 클래스에서 ConcreteClass를 자유롭게 사용할 수 있도록 함 (인터페이스를 통해서)
 */
public class Display {
    private DisplayImpl impl;           // 다리 역할하는 부분 (위임)

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    /**
     * 위임: impl 피들에는 구현되는 인스턴스가 저장되어 있어서 impl.rawOpen()..라는 식으로 '떠넘기기'를 하고 있다.
     */
    public void open() {
        impl.rawOpen();
    }

    public void print() {
        impl.rawPrint();
    }

    public void close() {
        impl.rawClose();
    }

    public final void display() {
        open();
        print();
        close();
    }
}
