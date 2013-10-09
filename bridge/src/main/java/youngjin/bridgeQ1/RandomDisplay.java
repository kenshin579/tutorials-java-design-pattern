package youngjin.bridgeQ1;

/**
 * 램던 횟수를 표시한다.
 */
public class RandomDisplay extends Display {
    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }

    /**
     * 부모 클래스에 기능이 추가된 메서드
     *
     * @param times
     */
    public void randomDisplay(int times) {       // 0 이상 times 미만인 경우에만 랜덤으로 표시함
        int randomNum = (int) (Math.random() * 5);
        open();
        if (0 < randomNum && randomNum < times) {
            for (int i = 0; i < randomNum; i++) {
                print();
            }
        }

        close();
    }
}

