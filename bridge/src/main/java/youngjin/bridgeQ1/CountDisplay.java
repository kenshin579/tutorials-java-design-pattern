package youngjin.bridgeQ1;

/**
 * SubClass: 기능을 추가하는 클래스
 */
public class CountDisplay extends Display {
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    /**
     * 부모 클래스에 기능이 추가된 메서드
     *
     * @param times
     */
    public void multiDisplay(int times) {       // times회 반복해서 표시하기
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}

