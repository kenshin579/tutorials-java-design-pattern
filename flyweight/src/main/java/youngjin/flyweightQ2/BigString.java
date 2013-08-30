package youngjin.flyweightQ2;

/**
 *
 */
public class BigString {
    // 「큰 문자」
    private BigChar[] bigchars;

    // 생성자
    public BigString(String string) {
        bigchars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i)); // <--공유된다.
//            bigchars[i] = new BigChar(string.charAt(i)); // <--공유되지 않는다.

        }
    }

    public BigString(String string, Boolean shared) {
        bigchars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < bigchars.length; i++) {
            if (shared)
                bigchars[i] = factory.getBigChar(string.charAt(i)); // <--공유된다.
            else
                bigchars[i] = new BigChar(string.charAt(i)); // <--공유되지 않는다.

        }
    }

    // 표시
    public void print() {
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i].print();
        }
    }
}
