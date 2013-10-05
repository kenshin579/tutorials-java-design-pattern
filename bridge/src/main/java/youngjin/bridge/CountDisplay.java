package youngjin.bridge;

public class CountDisplay extends Display {
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int times) {       // times회 반복해서 표시하기
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}

